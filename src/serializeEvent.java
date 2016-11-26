/**
 * Created by elsrouay on 11/23/2016.
 */

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class serializeEvent {

    public static void main(String[] args) {

        try {

            DateFormat sdf = new SimpleDateFormat("hh:mm");
            Event e = new Event();
            e.setTitle("Test 1");
            String strtTime, endTime;
            //strtTime = sdf.format("10:10");
            //endTime = sdf.format("11:00");

            e.setStartTime("10:00");
            e.setEndTime("11:00");


            FileOutputStream fileOut =
                    new FileOutputStream("C:\\Users\\elsrouay\\IdeaProjects\\DayRoutine\\Temp\\events.ser");

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

