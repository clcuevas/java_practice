import java.io.*;
import java.util.*;
import org.apache.commons.io.*;

public class CompareDir {
  public CompareDir(File dir1, File dir2) throws IOException {
    File[] fileList1 = dir1.listFiles();
    File[] fileList2 = dir2.listFiles();

    Arrays.sort(fileList1);
    Arrays.sort(fileList2);

    needsBackup(fileList1, fileList2);
  }

  // Does the dir need backup?
  private Boolean needsBackup(File[] list1, File[] list2) throws IOException {
    // If the length of both dirs are not the same,
    // then this means something has changed and it
    // does require a backup
    if (list1.length != list2.length) {
      System.out.println("A backup is required");
      return true;
    } else {
      // Lets make sure the contents of the file are the same
      return fileContentsMatch(list1, list2);
    }
  }

  // This assumes that the length of each dir is the same
  private Boolean fileContentsMatch(File[] list1, File[] list2) throws IOException {
    Boolean needsBackup = false;

    for (int i = 0; i < list1.length; i++) {
      for (int j = 0; j < list2.length; j++) {
        if (!FileUtils.contentEquals(list1[i], list2[j])) {
          needsBackup = true;
        }
      }
    }

    return needsBackup;
  }

  // Test code here
  public static void main(String[] args) throws IOException {
    File dir1 = new File("C:\\directory\\to\\compare\\main");
    File dir2 = new File("C:\\directory\\to\\compare\\backup");

    CompareDir compare = new CompareDir(dir1, dir2);
    System.out.println(compare);
  }
}
