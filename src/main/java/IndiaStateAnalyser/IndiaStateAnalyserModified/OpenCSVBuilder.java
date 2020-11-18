package IndiaStateAnalyser.IndiaStateAnalyserModified;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder<E> implements ICSVBuilder {
		
		public <E> Iterator<E> getIterator(String FILE_PATH, Class<E> localClass) throws IOException, StateCensusException { //Loads Iterator And Returns
			Iterator<E> iterator;
			try {
				
				FileType.checkFileType(FILE_PATH);
				ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
				Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
				CsvToBean<E> csvToBean = new CsvToBeanBuilder<E>(reader).withType(localClass).build();
				return csvToBean.iterator();	
			} catch(NoSuchFileException e) {
				throw new StateCensusException(StateCensusException.CensusExceptionType.NO_SUCH_FILE, "File Not Found");
			}
			catch(RuntimeException e) {
				throw new StateCensusException(StateCensusException.CensusExceptionType.HEADER_INVALID, "Wrong Header");
			}
		}

		public <E> Iterator<E> ICSVBuilder(String FILE_PATH, Class<E> localClass) throws StateCensusException {
			// TODO Auto-generated method stub
			return null;
		}
}
