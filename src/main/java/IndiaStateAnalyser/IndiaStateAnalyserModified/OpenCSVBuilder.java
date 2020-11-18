package IndiaStateAnalyser.IndiaStateAnalyserModified;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import org.apache.commons.io.FilenameUtils;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder {
		
		public static <E> Iterator<E> getIterator(String FILE_PATH, Class<E> localClass) throws IOException, StateCensusException { //Loads Iterator And Returns
			Iterator<E> iterator;
			try {
				String extension = FilenameUtils.getExtension(FILE_PATH);
				if(!extension.contains("csv"))
					throw new StateCensusException(StateCensusException.CensusExceptionType.EXTENSION_INVALID, "Extension Miss match");
				Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
				CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(localClass).build();
				iterator = csvToBean.iterator();
				return iterator;
			} catch(NoSuchFileException e) {
				throw new StateCensusException(StateCensusException.CensusExceptionType.NO_SUCH_FILE, "File Not Found");
			}
			catch(RuntimeException e) {
				throw new StateCensusException(StateCensusException.CensusExceptionType.HEADER_INVALID, "Wrong Header");
			}
		}
}
