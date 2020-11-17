package IndiaStateAnalyser.IndiaStateAnalyserModified;

import org.junit.Assert;
import org.junit.Test;

public class IndiaStateAnalyserTest {
	private static final String FILE_PATH = "C:\\Users\\Admin\\workspace\\IndiaStateAnalyserModified\\src\\main\\resources\\IndiaStateCensusData.csv";
	private static final String WRONG_FILE_PATH = "C:\\Users\\Admin\\workspace\\IndiaAnalyserModified\\src\\main\\resources\\IndiaStateCensusData.csv";
	private static final String FILE_PATH_WRONG_EXTENSION = "C:\\Users\\Admin\\workspace\\IndiaStateAnalyser\\src\\main\\resources\\IndiaStateCensusData.json";
	
	@Test
	public void thisTestCasePasesWhenReturnValueEqualsTonumberOfStates() throws StateCensusException {
		int count = StateCensusAnalyser.loadStateCensusCsv(FILE_PATH);
		Assert.assertEquals(29, count);
	}
	
	@Test
	public void thisTestCasePasesWhenReturnExceptionIsNoSUchFile() {
		try{
			StateCensusAnalyser.loadStateCensusCsv(WRONG_FILE_PATH);
		} catch(StateCensusException e) {
			Assert.assertEquals(StateCensusException.CensusExceptionType.NO_SUCH_FILE, e.type);
		}
	}
	
	@Test
	public void thisTestCasePasesWhenReturnExceptionWhenExtensionIncorrect() {
		try{
			StateCensusAnalyser.loadStateCensusCsv(FILE_PATH_WRONG_EXTENSION);
		} catch(StateCensusException e) {
			Assert.assertEquals(StateCensusException.CensusExceptionType.NO_SUCH_FILE, e.type);
		}
	}
}
