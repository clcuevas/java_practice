/*
*   This class finds the duplicate characters found in a String.
*   It will only look for alphabetical characters in a String
*   (i.e. digits, symbols, and white spaces will be removed).
*/
import java.util.*;

public class FindDuplicates {
  private String[] duplicates;

  public String[] findDuplicates(String string) {
    // The replaceAll regex is responsible for removing any
    // non-alphabetical characters in the string (i.e. this
    // includes symbols, digits, and white spaces)
    String[] temp = string.toLowerCase().replaceAll("[^a-zA-Z]", "").split("");
    List<String> output = new ArrayList<String>();

    for (int i = 0; i < temp.length; i++) {
      int nextElement = i + 1;
      int prevElement = i - 1;

      if (nextElement >= temp.length) {
        break;
      }

      if (temp[i].equals(temp[nextElement])) {
        if (prevElement != i) {
          if (temp[i].equals(temp[prevElement])) {
            continue;
          } else {
            output.add(temp[i]);
          }
        }
      }
    }

    // Convert the ListString to a traditional array for output
    duplicates = new String[output.size()];
    output.toArray(duplicates);

    System.out.println("The duplicate chars found are: " + Arrays.toString(duplicates));
    return duplicates;
  }

  // Test code here
  public static void main(String[] args) {
    // Create an instance of the class FindDuplicates
    FindDuplicates i = new FindDuplicates();
    i.findDuplicates("apple"); // Should return [p]
    i.findDuplicates("fo shizzle my nizzle"); // Should return [z, z]
    i.findDuplicates("BAMM! YES YOU CANNNNNN"); // Should return [m, n]
  }
}
