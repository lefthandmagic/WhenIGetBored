import java.util.Comparator;

/**
 * Custom comparator which does the primary sort using the
 * string lengths, and then does a lexicographic sort if
 * the strings are equal
 * 
 * @author praveen
 *
 */
public class TextAnalyzerComparator implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {
		if(str1.length() < str2.length()) {
			return -1;
		} else if( str1.length() > str2.length()) {
			return 1;
		} else {
			return str1.compareTo(str2);
		}
	}

}
