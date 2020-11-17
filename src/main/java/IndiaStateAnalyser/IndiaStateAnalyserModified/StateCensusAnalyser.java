package IndiaStateAnalyser.IndiaStateAnalyserModified;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser { 
	
	
	public static int loadStateCensusCsv(String FIle_PATH) throws StateCensusException {
		int count = 0;
		
		try {
			Iterator<CSVStateCensus> iterator = getIterator(FIle_PATH);	
			
			while(iterator.hasNext()) {
				iterator.next();
				count++;
			}			
		} catch(IOException e) {
			throw new StateCensusException(StateCensusException.CensusExceptionType.IO_EXCEPTION, "No");
		}
		return count;
	}
	
	private static Iterator<CSVStateCensus> getIterator(String fIle_PATH) throws IOException, StateCensusException { //Loads Iterator And Returns
		Iterator<CSVStateCensus> iterator;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(fIle_PATH));
			CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class).build();
			iterator = csvToBean.iterator();
			return iterator;
		} catch(NoSuchFileException e) {
			throw new StateCensusException(StateCensusException.CensusExceptionType.NO_SUCH_FILE, "No");
		}
	}
}
