import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samatra on 2016-11-26.
 */

public class addEvent {

    private JComboBox cmbType;
    private JPanel panel1;
    private JLabel lblMessage;
    private JButton btnAdd;
    private JComboBox cmbFrom;
    private JComboBox cmbTo;
    private  JTable tblEvents;
    private JButton btnDisplay;
    private JCheckBox chkSpecial;
    private JTextField txtDescription;


    public addEvent() {

        final List<Event> myEvents= new ArrayList<Event>();
        final DefaultTableModel mdl = new DefaultTableModel();

        cmbType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblMessage.setText(cmbType.getSelectedItem().toString() + " is selectd!");
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println(txtDescription.getText());
                if (chkSpecial.isSelected() && txtDescription.getText().trim().equals(""))
                {
                    System.out.println("Please add description for this special event, it is selected");
                    lblMessage.setText("Please add description for this special event.");
                    return;
                }
                else   {lblMessage.setText("");};

                if (cmbFrom.getSelectedIndex() >= cmbTo.getSelectedIndex())
                {
                    lblMessage.setText("Start time cannot be more than or equal to end time, please check start and end time.");
                    return;
                }
                else   {lblMessage.setText("");};


                Event event = new Event();
                SpecialEvent specialEvent = new SpecialEvent();

                if (chkSpecial.isSelected()) {
                    String header[] = new String[]{"Title","Description", "From", "To"};
                    mdl.setColumnIdentifiers(header);
                    tblEvents.setModel(mdl);
                    mdl.addRow(new Object[]{cmbType.getSelectedItem().toString(), cmbFrom.getSelectedItem(), cmbTo.getSelectedItem()});

                    event.setTitle(cmbType.getSelectedItem().toString());
                    event.setStartTime(cmbFrom.getSelectedItem().toString());
                    event.setEndTime(cmbTo.getSelectedItem().toString());

                    myEvents.add(event);  //adding event object to myEvents array
                    serializeEvent.main(null,myEvents);

                    //CreateTextFile.main(null,event); //to be completed
                } else {
                    String header[] = new String[]{"Title", "-", "From", "To"};
                    mdl.setColumnIdentifiers(header);
                    tblEvents.setModel(mdl);
                    mdl.addRow(new Object[]{cmbType.getSelectedItem().toString(), txtDescription.getText(), cmbFrom.getSelectedItem(), cmbTo.getSelectedItem()});

                    SpecialEvent specialevent = new SpecialEvent();
                    specialevent.setStartTime(cmbFrom.getSelectedItem().toString());
                    specialevent.setEventDescription("NA");
                    specialevent.setEndTime(cmbTo.getSelectedItem().toString());
                    specialevent.setTitle(cmbType.getSelectedItem().toString());
                    myEvents.add(specialevent);
                    serializeEvent.main(null, myEvents);

                    //CreateTextFile.main(null,specialevent); //to be completed
                }      } });


        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deserializeEvent.main(null,myEvents); //this uses deserliazeEvent
                lblMessage.setText(Integer.toString(myEvents.size()) + " events were added.");

                ReadTextFile.main(null); // using events.txt file to read events as an alternative to .ser file in EventStore folder
            }        });
        }

    public static void main(String[] args) {
    try {
        JFrame frame = new JFrame("Day Routine");
        frame.setContentPane(new addEvent().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    catch (Exception ex)
    {
        System.out.println(ex.getStackTrace());

    }
    }

}
