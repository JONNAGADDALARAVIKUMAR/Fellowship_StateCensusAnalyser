package IndiaStateAnalyser.IndiaStateAnalyserModified;

public class CSVBuilderFactory {

	public static ICSVBuilder createCSVBuilder() {
		
		return new OpenCSVBuilder();
	}
}
