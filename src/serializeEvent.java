/**
 * Created by elsrouay on 11/23/2016.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class serializeEvent {

    public static void main(String[] args, Event e) {
        serialize(e);
    }

    private static void serialize(Event e)
    {
        try {

            DateFormat sdf = new SimpleDateFormat("hh:mm");

            FileOutputStream fileOut =
                    new FileOutputStream("C:\\Users\\ayman\\IdeaProjects\\DayRoutine\\Temp\\events.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in events.ser");

    } catch (IOException i) {
        i.printStackTrace();
    }
    }
}

