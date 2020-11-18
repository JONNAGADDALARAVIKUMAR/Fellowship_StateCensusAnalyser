package IndiaStateAnalyser.IndiaStateAnalyserModified;

public class CSVBuilderException {
	public enum CSVBuilderExceptionType {
        UNABLE_TO_PARSE
    }
 
	public CSVBuilderExceptionType type;

	public CSVBuilderException(CSVBuilderExceptionType type, String message) {
		super();
		this.type = type;
	}
}
