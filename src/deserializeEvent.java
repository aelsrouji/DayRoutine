import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by elsrouay on 11/23/2016.
 */
class deserializeEvent {
    public static void main(String[] args, List<Event> allEvents) {
         //allEvents = null;
        try {
            FileInputStream fileIn = new FileInputStream("C:\\Users\\ayman\\IdeaProjects\\DayRoutineApp\\EventStore\\events.ser");
            ObjectInputStream in;
            for (Event e : allEvents) {
                in = new ObjectInputStream(fileIn);
                e = (Event) in.readObject();
                System.out.println("The event you entered is:");
                System.out.println("Title: " + e.getTitle());
                System.out.println("Start: " + e.getStartTime());
                System.out.println("End: " + e.getEndTime());
                in.close();
            }

                fileIn.close();
            } catch(IOException i){
                i.printStackTrace();
                return;
            } catch(ClassNotFoundException c){
                System.out.println("Event class not found");
                c.printStackTrace();
                return;
            }

    }


}
