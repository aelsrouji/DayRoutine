/**
 * Created by Sumatra Group on 11/29/2016.
 */

        import java.util.Scanner;
        import java.io.FileNotFoundException;
        import java.lang.SecurityException;
        import java.util.Formatter;
        import java.util.FormatterClosedException;
        import java.util.NoSuchElementException;

         public class CreateTextFile{
    private static Formatter output;

         public static void main(String[] args,Event e)
         {
         openFile();
         addRecords(e);
         closeFile();
         }

         // open file clients.txt
         public static void openFile()
         {
         try
         {
             output = new Formatter("C:\\Users\\elsrouay\\IdeaProjects\\DayRoutineApp\\EventStore\\events.txt");
         }
         catch (SecurityException securityException)
         {
         System.err.println("Write permission denied. Terminating.");
         System.exit(1); // terminate the program
         }
         catch (FileNotFoundException fileNotFoundException)
         {
         System.err.println("Error opening file. Terminating.");
         System.exit(1); // terminate the program
         }
         }

        // add records to file
         public static void addRecords(Event e) {
             Scanner input = new Scanner(System.in);

             System.out.println("Enter Type, description if special, start timne and end time. Enter end-of-file indicator to end input.");

             while (input.hasNext()) {
                 try {
                     output.format("%s %s %s %s%n",input.next(), input.next(), input.next(), input.next());
                     System.out.println("You added a new record!");
                 }
                 catch (FormatterClosedException formatterClosedException) {
                     System.err.println("Error writing to file. Terminating.");
                     break;
                 } catch (NoSuchElementException elementException) {
                     System.err.println("Invalid input. Please try again.");
                     input.nextLine(); // discard input so user can try again
                 }

             }}

    public static void closeFile() {
        if (output != null) {
            output.close();
        }
    }


}