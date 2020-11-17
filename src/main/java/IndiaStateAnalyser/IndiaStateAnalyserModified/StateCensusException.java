package IndiaStateAnalyser.IndiaStateAnalyserModified;

public class StateCensusException extends Exception{
	
	enum CensusExceptionType {
		NO_SUCH_FILE,IO_EXCEPTION
	}
	
	CensusExceptionType type;
	
	public StateCensusException() {
		
	}
	
	public StateCensusException(CensusExceptionType type, String exceptionMessage) {
		super(exceptionMessage);
		this.type = type;
	}
}
