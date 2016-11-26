import javafx.scene.Parent;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * Created by elsrouay on 11/22/2016.
 */

// Edited by Vinicius Ferreira on 26/11/2016.

public class SpecialEvent extends Event{
    private String eventDescription;

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;

    }

    public void buildEventWindow() {
        JFrame eventFrame = new JFrame("Change Events");
        try {

            eventFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // VF: a Grid Layout was defined with 7 rows and 10 columns.

            GridLayout grid = new GridLayout(6, 5, 10, 10);
            eventFrame.setLayout(grid);
            eventFrame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

            // VF: start of row 1
            eventFrame.add(new JLabel("Event Start Day"));
            eventFrame.add(new JLabel("Event Start Month"));
            eventFrame.add(new JLabel("Event Start Year"));
            eventFrame.add(new JLabel("Event Start Hours"));
            eventFrame.add(new JLabel("Event Start Minutes"));

            // VF: start of row 2

            JTextField startDay = new JTextField(2);
            JTextField startMonth = new JTextField(2);
            JTextField startYear = new JTextField(4);
            JTextField startHours = new JTextField(2);
            JTextField startMinutes = new JTextField(2);

            eventFrame.add(startDay);
            eventFrame.add(startMonth);
            eventFrame.add(startYear);
            eventFrame.add(startHours);
            eventFrame.add(startMinutes);

            // VF: start of row 3

            eventFrame.add(new JLabel("Event End Day"));
            eventFrame.add(new JLabel("Event End Month"));
            eventFrame.add(new JLabel("Event End Year"));
            eventFrame.add(new JLabel("Event End Hours"));
            eventFrame.add(new JLabel("Event End Minutes"));

            // VF: start of row 4

            JTextField endDay = new JTextField(2);
            JTextField endMonth = new JTextField(2);
            JTextField endYear = new JTextField(4);
            JTextField endHours = new JTextField(2);
            JTextField endMinutes = new JTextField(2);

            eventFrame.add(endDay);
            eventFrame.add(endMonth);
            eventFrame.add(endYear);
            eventFrame.add(endHours);
            eventFrame.add(endMinutes);

            // VF: start of row 5

            eventFrame.add(new JLabel("Event Description"));
            eventFrame.add(new JLabel("Event Type"));
            eventFrame.add(new JLabel(""));
            eventFrame.add(new JLabel(""));

            JButton confirm = new JButton();
            confirm.setText("Confirm");
            confirm.setBackground(Color.BLUE);
            eventFrame.add(confirm);

            // VF: start of row 6

            JTextField eventDescription = new JTextField(20);
            eventFrame.add(eventDescription);

            JComboBox comboBox = new JComboBox();
            comboBox.addItem("Eat");
            comboBox.addItem("Pray");
            comboBox.addItem("Love");

            eventFrame.add(comboBox);

            eventFrame.add(new JLabel(""));
            eventFrame.add(new JLabel(""));

            JButton cancel = new JButton();
            cancel.setText("Cancel");
            cancel.setBackground(Color.RED);
            eventFrame.add(cancel);

            // VF: end of rows.

            eventFrame.setSize(1000, 500);
            eventFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            eventFrame.setVisible(true);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


