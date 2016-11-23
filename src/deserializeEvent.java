import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by elsrouay on 11/23/2016.
 */
@SuppressWarnings("DefaultFileTemplate")
class deserializeEvent {
    public static void main(String[] args) {
        Event e = null;
        try {
            FileInputStream fileIn = new FileInputStream("C:\\Users\\elsrouay\\IdeaProjects\\DayRoutine\\Temp\\events.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Event) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Event class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Event...");
        System.out.println("Start: " + e.getStartTime());
        System.out.println("End: " + e.getEndTime());
        System.out.println("Title: " + e.getTitle());

    }
}
