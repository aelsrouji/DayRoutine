import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * Created by elsrouay on 11/21/2016.
 */
public class Event {
    Date date;
    String Title;
    private Date startTime;
    private Date endTime;

    public static void main(String[] args) {
        buildFrame();
        addEvent();

    }

    private static void buildFrame() {
        JFrame frame = new JFrame("Welcome to Day Routine App");

        try {
            //create menu and menu items
            JMenuBar menuBar = new JMenuBar();
            JMenu menuFile = new JMenu("File");
            JMenuItem menuItemExit = new JMenuItem("Exit");
            JMenuItem menuItemAdd = new JMenuItem("Add Event");
            menuFile.add(menuItemAdd);
            menuFile.add(menuItemExit);
            menuBar.add(menuFile);
            // add menu bar to the frame
            frame.setJMenuBar(menuBar);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            JLabel label = new JLabel("Day Routine can make your life easier");
            JButton button = new JButton();
            button.setText("Add");
            button.setBackground(Color.CYAN);
            JTextField textFieldEvent = new JTextField(50);
            textFieldEvent.setSize(40, 10);
            panel.add(textFieldEvent);
            panel.add(label);
            panel.add(button);
            panel.add(textFieldEvent);
            //adding the panel to the frame after adding all controls to the panel
            frame.add(panel);

            frame.setSize(500, 500);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);

            addEvent();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void addEvent() {

        try {
            System.out.println("Event added.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    private static void editEvent() {

        try {
            System.out.println("Event has been edited.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    private static void deleteEvent() {
        try {
            System.out.println("Event has been deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }

    public Date getStartTime() {
        return startTime;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

}