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

public class StateCensusAnalyser { 
	
	
	public static int loadStateCensusCsv(String FILE_PATH) throws StateCensusException {
		int count = 0;
		
		try {
			Iterator<CSVStateCensus> iterator = getIterator(FILE_PATH);	
			
			while(iterator.hasNext()) {
				iterator.next();
				count++;
			}	
			return count;
		}catch(RuntimeException e) {
			throw new StateCensusException(StateCensusException.CensusExceptionType.DELIMITER_EXCEPTION, "Delimiter Issue");
		} catch(IOException e) {
			throw new StateCensusException(StateCensusException.CensusExceptionType.IO_EXCEPTION, "IO Exception");
		}
	}
	
	private static Iterator<CSVStateCensus> getIterator(String FILE_PATH) throws IOException, StateCensusException { //Loads Iterator And Returns
		Iterator<CSVStateCensus> iterator;
		try {
			String extension = FilenameUtils.getExtension(FILE_PATH);
			if(!extension.contains("csv"))
				throw new StateCensusException(StateCensusException.CensusExceptionType.EXTENSION_INVALID, "Extension Miss match");
			Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
			CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class).build();
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
