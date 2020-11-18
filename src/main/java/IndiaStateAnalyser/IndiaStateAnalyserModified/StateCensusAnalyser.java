package IndiaStateAnalyser.IndiaStateAnalyserModified;

import java.io.IOException;
import java.util.Iterator;

public class StateCensusAnalyser<E> { 
	static OpenCSVBuilder builder = new OpenCSVBuilder();
	
	public static int loadStateCensusCsv(String FILE_PATH) throws StateCensusException {
		
		try {
			Iterator<CSVStateCensus> iterator = builder.getIterator(FILE_PATH, CSVStateCensus.class);	
			return getCount(iterator);
		}catch(RuntimeException e) {
			throw new StateCensusException(StateCensusException.CensusExceptionType.DELIMITER_EXCEPTION, "Delimiter Issue");
		} catch(IOException e) {
			throw new StateCensusException(StateCensusException.CensusExceptionType.IO_EXCEPTION, "IO Exception");
		}
	}
	
	public static int loadStateCodeCsv(String FILE_PATH) throws StateCensusException {
		
		try {
			Iterator<IndianStateCodes> iterator = builder.getIterator(FILE_PATH, IndianStateCodes.class);	
			return getCount(iterator);	
		} catch(RuntimeException e) {
			throw new StateCensusException(StateCensusException.CensusExceptionType.DELIMITER_EXCEPTION, "Delimiter Issue");
		} catch(IOException e) {
			throw new StateCensusException(StateCensusException.CensusExceptionType.IO_EXCEPTION, "IO Exception");
		}	
	}
	
	private static <E> int getCount(Iterator<E> iterator) {
		int count = 0;
		while(iterator.hasNext()) {
			iterator.next();
			count++;
		}
		return count;
	}
}
