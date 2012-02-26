import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class defines a text analyzer which
 * takes an input file, analyzes it and provides
 * a report on the contents of the file.
 * 
 * Instead of using java collections this uses a custom BST 
 * to insert the keys in a sorted order
 * 
 * @author praveen
 *
 */
public class TextAnalyzerUsingBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = null;
		// create new BST
		BST binarySearchTree = new BST(new TextAnalyzerComparator());
		 try {
			scanner = new Scanner(new BufferedReader(new FileReader("testfiles/test1")));
			
			while(scanner.hasNext()) {
				String token = scanner.next();
				// insert to BST
				binarySearchTree.insert(token);
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Oops, please provide the correct filename");
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}
		 
		// print the BST
		binarySearchTree.print();

	}

}
