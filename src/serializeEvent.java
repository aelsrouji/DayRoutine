/**
 * Created by elsrouay on 11/23/2016.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class serializeEvent {

    public static void main(String[] args) {

        try {
            Event e = new Event();
            e.setTitle("Test 1");
            FileOutputStream fileOut =
                    new FileOutputStream("C:\\Users\\elsrouay\\IdeaProjects\\DayRoutine\\Temp\\events.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in events.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}

