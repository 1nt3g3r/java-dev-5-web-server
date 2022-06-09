import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringJoiner;

public class Files {
    public static String getFileByPath(String path) throws FileNotFoundException {
        if (path.equals("/")) {
            return readHtmlFile("index.html");
        } else {
            return readHtmlFile(path.substring(1));
        }
    }

    public static String readHtmlFile(String filename) throws FileNotFoundException {
        File file = new File("web/" + filename);

        StringJoiner result = new StringJoiner("\n");

        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        }

        return result.toString();
    }
}
