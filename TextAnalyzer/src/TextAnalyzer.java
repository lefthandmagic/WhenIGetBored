import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * This class defines a text analyzer which
 * takes an input file, analyzes it and provides
 * a report on the contents of the file.
 * 
 * @author praveen
 *
 */
public class TextAnalyzer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = null;
		String fileName = args[0];
		Map<String, Integer> tokenToCountMap = new TreeMap<String, Integer>(new TextAnalyzerComparator());
		 try {
			scanner = new Scanner(new BufferedReader(new FileReader("testfiles/" + fileName)));
			
			while(scanner.hasNext()) {
				String token = scanner.next();
				
				// if the token previously exists, update the count and re-insert
				if(tokenToCountMap.containsKey(token)) {
					Integer currentCount = tokenToCountMap.get(token);
					tokenToCountMap.put(token, ++currentCount);
				} else {
					// if the token isn't present, add it with a count 1
					tokenToCountMap.put(token, 1);
				}
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Oops, please provide the correct filename");
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}
		 
		printTextAnalyzerReport(tokenToCountMap);

	}

	/**
	 * This helper method is used to print out the final report
	 * 
	 * @param tokenToCountMap
	 */
	private static void printTextAnalyzerReport(
			Map<String, Integer> tokenToCountMap) {
		
		// iterate over the tree map and print the report
		for(Map.Entry<String, Integer> tokenToCountEntry : tokenToCountMap.entrySet()) {
			System.out.println(tokenToCountEntry.getValue() + " " + tokenToCountEntry.getKey());
		}
		
	}

}
