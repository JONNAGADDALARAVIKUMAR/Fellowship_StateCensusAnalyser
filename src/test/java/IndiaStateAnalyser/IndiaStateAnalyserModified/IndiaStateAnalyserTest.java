package IndiaStateAnalyser.IndiaStateAnalyserModified;

import org.junit.Assert;
import org.junit.Test;
import IndiaStateAnalyser.StateCensusAnalyser;

public class IndiaStateAnalyserTest {
	private static final String FILE_PATH = "C:\\Users\\Admin\\workspace\\IndiaStateAnalyserModified\\src\\main\\resources\\IndiaStateCensusData.csv";
	
	@Test
	public void thisTestCasePasesWhenReturnValueEqualsTonumberOfStates() {
		StateCensusAnalyser analyser = new StateCensusAnalyser();
		int count = analyser.loadStateCensusCsv(FILE_PATH);
		Assert.assertEquals(29, count);
	}
}
