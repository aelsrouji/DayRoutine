/**
 * Created by elsrouay on 11/21/2016.
 */
// Edited by Vinicius Ferreira on 24 and 25 November 2016

// VF: importing classes that will be used for the GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable{
    private Date date;
    private String Title;
    private String startTime;
    private String endTime;
    // VF: variables declared in the beginning of development. Might require changes

    // VF: Main method invokes the required methods to make windows show up. May be removed afterwards.

    public static void main(String[] args) {
        buildFrame();
    }

    private static void addSpecialEvent() {
        SpecialEvent specialEvent = new SpecialEvent();
        specialEvent.buildEventWindow();

    }

    // VF: this method builds the GUI frame when invoked.
    private static void buildFrame() {
        JFrame frame = new JFrame("Welcome to Day Routine App");
        try {

            // VF: I did not change anything here, but the menu might prove unnecessary.
            //create menu and menu items
            JMenuBar menuBar = new JMenuBar();
            JMenu menuFile = new JMenu("File");
            JMenuItem menuItemAdd = new JMenuItem("Add Event");
            JMenuItem menuItemPrintEvent = new JMenuItem("Print Event");
            JMenuItem menuItemAddSpecial = new JMenuItem("Add Special Event");
            JMenuItem menuItemExit = new JMenuItem("Exit");

            menuFile.add(menuItemAdd);
            menuFile.add(menuItemPrintEvent);
            menuFile.add(menuItemAddSpecial);
            menuFile.add(menuItemExit);

            // adding action listeners

            menuItemAdd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    serializeEvent.main(null);

                }
            });

            menuItemPrintEvent.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    deserializeEvent.main(null);

                }
            });

            menuItemAdd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    serializeEvent.main(null);
                    System.out.println("Event has been added");
                }
            });

            menuItemExit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            menuItemAddSpecial.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addSpecialEvent();
                    System.out.println("Special event has been added");
                }
            });

            menuBar.add(menuFile);
            // add menu bar to the frame
            frame.setJMenuBar(menuBar);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // VF: A few lines removed here. FlowLayout did not fit the requirements, so switched to GridLayout instead.

            /*
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            */

            // VF: a Grid Layout was defined with 7 rows and 10 columns.
            GridLayout grid = new GridLayout(7, 10);
            frame.setLayout(grid);
            frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

            // VF: Rows 1 and 2 only have text components.

            // VF: start of row 1
            frame.add(new JLabel(""));
            frame.add(new JLabel(""));
            frame.add(new JLabel(""));
            frame.add(new JLabel(""));
            frame.add(new JLabel("Event"));
            frame.add(new JLabel(""));
            frame.add(new JLabel(""));
            frame.add(new JLabel(""));
            frame.add(new JLabel(""));
            frame.add(new JLabel(""));

            // VF: start of row 2
            frame.add(new JLabel(""));
            frame.add(new JLabel("Day"));
            frame.add(new JLabel(""));
            frame.add(new JLabel(""));
            frame.add(new JLabel("Start"));
            frame.add(new JLabel("End"));
            frame.add(new JLabel("Description"));
            frame.add(new JLabel("Type"));
            frame.add(new JLabel(""));
            frame.add(new JLabel(""));

            // VF: start of row 3

            // VF: buttons were added to change the displayed values when pressed. They are not working now.

            JButton minusDay = new JButton();
            minusDay.setText("Minus Day");
            minusDay.setBackground(Color.red);
            frame.add(minusDay);

            // VF: This value should display the date and be changed when buttons "+"/"-" are pressed.

            JLabel dayLabel = new JLabel("22");
            frame.add(dayLabel);

            JButton plusDay = new JButton();
            plusDay.setText("Plus Day");
            plusDay.setBackground(Color.blue);
            frame.add(plusDay);

            frame.add(new JLabel(""));

            // VF: Those are only fillers to mark where the actual information on the events of the day will be
            //  displayed. I am pretty sure those objects will need to be changed, but I will keep as is,
            //  which is enough for a placeholder.

            JLabel startOne = new JLabel("start one");
            frame.add(startOne);

            JLabel endOne = new JLabel("end one");
            frame.add(endOne);

            JLabel descriptionOne = new JLabel("description one");
            frame.add(descriptionOne);

            JLabel typeOne = new JLabel("type one");
            frame.add(typeOne);

            frame.add(new JLabel(""));
            frame.add(new JLabel(""));

            // VF: start of row 4

            frame.add(new JLabel(""));
            frame.add(new JLabel("Month"));
            frame.add(new JLabel(""));
            frame.add(new JLabel(""));

            JLabel startTwo = new JLabel("start two");
            frame.add(startTwo);

            JLabel endTwo = new JLabel("end two");
            frame.add(endTwo);

            JLabel descriptionTwo = new JLabel("description two");
            frame.add(descriptionTwo);

            JLabel typeTwo = new JLabel("type two");
            frame.add(typeTwo);

            frame.add(new JLabel(""));
            frame.add(new JLabel(""));

            // VF: start of row 5

            JButton minusMonth = new JButton();
            minusMonth.setText("Minus Month");
            minusMonth.setBackground(Color.red);
            frame.add(minusMonth);

            JLabel monthLabel = new JLabel("11");
            frame.add(monthLabel);

            JButton plusMonth = new JButton();
            plusMonth.setText("Plus Month");
            plusMonth.setBackground(Color.blue);
            frame.add(plusMonth);

            frame.add(new JLabel(""));

            JLabel startThree = new JLabel("start three");
            frame.add(startThree);

            JLabel endThree = new JLabel("end three");
            frame.add(endThree);

            JLabel descriptionThree = new JLabel("description three");
            frame.add(descriptionThree);

            JLabel typeThree = new JLabel("type three");
            frame.add(typeThree);

            frame.add(new JLabel(""));

            // VF: The Add Event, Edit Event and Remove Event buttons will call other windows. They are not working now.

            JButton addEventButton = new JButton();
            addEventButton.setText("Add Event");
            addEventButton.setBackground(Color.blue);
            frame.add(addEventButton);

            // VF: start of row 6

            frame.add(new JLabel(""));
            frame.add(new JLabel("Year"));
            frame.add(new JLabel(""));
            frame.add(new JLabel(""));

            JLabel startFour = new JLabel("start four");
            frame.add(startFour);

            JLabel endFour = new JLabel("end four");
            frame.add(endFour);

            JLabel descriptionFour = new JLabel("description four");
            frame.add(descriptionFour);

            JLabel typeFour = new JLabel("type four");
            frame.add(typeFour);

            frame.add(new JLabel(""));

            JButton editEventButton = new JButton();
            editEventButton.setText("edit Event");
            editEventButton.setBackground(Color.yellow);
            frame.add(editEventButton);

            // VF: start of row 7

            JButton minusYear = new JButton();
            minusYear.setText("Minus Year");
            minusYear.setBackground(Color.red);
            frame.add(minusYear);

            JLabel yearLabel = new JLabel("2016");
            frame.add(yearLabel);

            JButton plusYear = new JButton();
            plusYear.setText("Plus Year");
            plusYear.setBackground(Color.blue);
            frame.add(plusYear);

            frame.add(new JLabel(""));

            JLabel startFive = new JLabel("start five");
            frame.add(startFive);

            JLabel endFive = new JLabel("end five");
            frame.add(endFive);

            JLabel descriptionFive = new JLabel("description five");
            frame.add(descriptionFive);

            JLabel typeFive = new JLabel("type five");
            frame.add(typeFive);

            frame.add(new JLabel(""));

            JButton removeEventButton = new JButton();
            removeEventButton.setText("Remove Event");
            removeEventButton.setBackground(Color.red);
            frame.add(removeEventButton);

            // VF: end of rows.

            frame.setSize(1000, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void addEvent() {

        try {
            System.out.println("Event added.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void editEvent() {

        try {
            System.out.println("Event has been edited.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteEvent() {
        try {
            System.out.println("Event has been deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getStartTime() {
        return startTime;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}