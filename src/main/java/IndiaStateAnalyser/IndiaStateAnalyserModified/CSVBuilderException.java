package IndiaStateAnalyser.IndiaStateAnalyserModified;

public class CSVBuilderException extends Exception{
	public enum CSVBuilderExceptionType {
        UNABLE_TO_PARSE,NO_SUCH_FILE
    }
 
	public CSVBuilderExceptionType type;

	public CSVBuilderException(CSVBuilderExceptionType type, String message) {
		super(message);
		this.type = type;
	}
}
