import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<File> fileList = new ArrayList<>();
        searchFile(new File("C:\\test"), fileList); // specify the file path

        System.out.println("Input KWs:");
        Scanner console_scanner = new Scanner(System.in);
        String keyword = console_scanner.nextLine();
        boolean is_found;

        for (File file : fileList) {
            Scanner file_scanner = new Scanner(file);
            is_found = false;
            while (file_scanner.hasNextLine()) {
                String string = file_scanner.nextLine();
                String[] words_arr = string.split(" ");
                for (int i = 0; i < words_arr.length; i++) {
                    if (keyword.equals(words_arr[i])) {
                        is_found = true;
                    }
                }
            }
            if (is_found) {
                System.out.println("File " + file.getName() + " contain keyword");
            } else {
                System.out.println("File" + file.getName() + " doesn't contain keyword");
            }
      //      System.out.println(file.getAbsolutePath());
        }

    }

    private static void searchFile(File rootFile, List<File> fileList) {
        if (rootFile.isDirectory()) {
            System.out.println("searching at:" + rootFile.getAbsolutePath());
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        searchFile(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".txt")) { // specify the file format
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }

    {
    }
}
