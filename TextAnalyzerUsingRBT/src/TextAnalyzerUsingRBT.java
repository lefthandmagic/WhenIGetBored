import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class defines a text analyzer which
 * takes an input file, analyzes it and provides
 * a report on the contents of the file.
 * 
 * Instead of using java collections this uses a custom Red
 * Black tree implementation to insert the keys in a sorted order
 * 
 * @author praveen
 *
 */
public class TextAnalyzerUsingRBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = null;
		String fileName = args[0];
		// create new BST
		RBT redBlackTree = new RBT(new TextAnalyzerComparator());
		 try {
			scanner = new Scanner(new BufferedReader(new FileReader("testfiles/" + fileName)));
			
			while(scanner.hasNext()) {
				String token = scanner.next();
				// insert to BST
				redBlackTree.insert(token);
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Oops, please provide the correct filename");
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}
		 
		// print the BST
		redBlackTree.print();

	}

}
