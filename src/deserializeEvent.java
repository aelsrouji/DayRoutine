import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by elsrouay on 11/23/2016.
 */
class deserializeEvent {
    public static void main(String[] args, List<Event> allEvents) {
         //allEvents = null;
        try {
            FileInputStream fileIn = new FileInputStream("C:\\Users\\elsrouay\\IdeaProjects\\DayRoutineApp\\EventStore\\events.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            System.out.println(allEvents.size());

            allEvents = Arrays.asList((Event[]) in.readObject());
            //allEvents = new ArrayList<>(Arrays.asList((Event[])in.readObject()));

            System.out.println("The events you entered are:");
            for (Event e: allEvents) {
                System.out.println("Title: " + e.getTitle());
                System.out.println("Start: " + e.getStartTime());
                System.out.println("End: " + e.getEndTime());
            }
                in.close();
                fileIn.close();

            } catch(IOException i){
            System.out.println("IOException: ");
            i.printStackTrace();
                return;
            } catch(ClassNotFoundException c){
                System.out.println("Event class not found");
                c.printStackTrace();
                return;
            }
            catch (ClassCastException cc)
            {
                System.out.println("Class cast exception: ");
                cc.printStackTrace();
                return;

            }

    }


}
