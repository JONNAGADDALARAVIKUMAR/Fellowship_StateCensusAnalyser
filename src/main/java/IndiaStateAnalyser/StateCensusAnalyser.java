package IndiaStateAnalyser;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser { 
	
	
	public int loadStateCensusCsv(String FIle_PATH) {
		int count = 0;
		
		try {
			Iterator<CSVStateCensus> iterator = getIterator(FIle_PATH);	
			
			while(iterator.hasNext()) {
				iterator.next();
				count++;
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	private Iterator<CSVStateCensus> getIterator(String fIle_PATH) {
		Iterator<CSVStateCensus> iterator = null;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(fIle_PATH));
			CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class).build();
			iterator = csvToBean.iterator();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return iterator;
	}
}
