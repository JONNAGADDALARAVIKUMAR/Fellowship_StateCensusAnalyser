package IndiaStateAnalyser.IndiaStateAnalyserModified;

import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

import javax.swing.filechooser.FileNameExtensionFilter;

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
		} catch(IOException e) {
			throw new StateCensusException(StateCensusException.CensusExceptionType.IO_EXCEPTION, "IO Exception");
		}
		return count;
	}
	
	private static Iterator<CSVStateCensus> getIterator(String FILE_PATH) throws IOException, StateCensusException { //Loads Iterator And Returns
		Iterator<CSVStateCensus> iterator;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
			CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class).build();
			iterator = csvToBean.iterator();
			String extension = FilenameUtils.getExtension(FILE_PATH);
			if(!extension.contains("csv"))
				throw new StateCensusException(StateCensusException.CensusExceptionType.EXTENSION_INVALID, "Extension Miss match");
			return iterator;
		} catch(NoSuchFileException e) {
			throw new StateCensusException(StateCensusException.CensusExceptionType.NO_SUCH_FILE, "");
		}
	}
}
