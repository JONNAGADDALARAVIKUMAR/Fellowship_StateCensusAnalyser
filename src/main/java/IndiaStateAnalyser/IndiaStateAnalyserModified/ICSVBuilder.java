package IndiaStateAnalyser.IndiaStateAnalyserModified;

import java.io.IOException;
import java.util.Iterator;

public interface ICSVBuilder {
	public <E> Iterator<E> getIterator(String FILE_PATH, Class<E> localClass) throws StateCensusException, IOException;
}
