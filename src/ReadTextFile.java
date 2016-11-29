/**
 * Created by Sumatra on 11/29/2016.
 * This class reads events file
 */

       import java.io.IOException;
       import java.lang.IllegalStateException;
        import java.nio.file.Files;
         import java.nio.file.Path;
         import java.nio.file.Paths;
         import java.util.NoSuchElementException;
         import java.util.Scanner;

public class ReadTextFile {
    private static Scanner input;

    public static void main(String[] args) {
        openFile();
        readRecords();
        closeFile();
    }


    public static void openFile() {

        try {
            input = new Scanner(Paths.get("events.txt"));
        } catch (IOException ioException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }


    // read record from file
    public static void readRecords() {
        System.out.printf("Title", "Description", "From", "To");

        try {
            while (input.hasNext()) // while there is more to read
            {
                System.out.println(input.next() + "--" + input.next() + "--" + input.next() + "--" + input.next());
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file.");
        }
    }


    public static void closeFile() {
        if (input != null) {
            input.close();
        }

    }
}