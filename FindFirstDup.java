/*
*   This class finds the first duplicate character it finds in a String.
*   It will only look for alphabetical characters in a String (i.e. digits,
*   symbols, and white spaces will be removed).
*/
public class FindFirstDuplicate {
  private String firstDup;

  public String findFirstDuplicate(String string) {
    // The replaceAll regex is responsible for removing any
    // non-alphabetical characters in the string (i.e. this
    // includes symbols, digits, and white spaces)
    String[] temp = string.toLowerCase().replaceAll("[^a-zA-Z]", "").split("");

    for (int i = 0; i < temp.length; i++) {
      int nextElement = i + 1;

      if (temp[i].equals(temp[nextElement])) {
        firstDup = temp[i];
        System.out.println("The first duplicate char found is: " + firstDup);
        return firstDup;
      }
    }

    System.out.println("No duplicates were found in the String");
    // If we find nothing, then return an empty string;
    return "";
  }

  // Test code here
  public static void main(String[] args) {
    // Create an instance of our class
    FindFirstDuplicate i = new FindFirstDuplicate();

    i.findFirstDuplicate("Hello World!"); // should return l
  }
}
