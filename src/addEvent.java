import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        cmbType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // lblMessage.setText(cmbType.getSelectedItem().toString());
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(txtDescription.getText());
                System.out.println(chkSpecial.isSelected());

                if (chkSpecial.isSelected()== true && txtDescription.getText().trim().equals(""))
                {
                    System.out.println("Please add description for this special event, it is selected");
                    return;
                }

                Event event = new Event();
                SpecialEvent specialEvent = new SpecialEvent();

                if (chkSpecial.isSelected()) {
                    DefaultTableModel mdl = new DefaultTableModel();
                    String header[] = new String[]{"Event", "From", "To"};
                    mdl.setColumnIdentifiers(header);
                    tblEvents.setModel(mdl);
                    mdl.addRow(new Object[]{cmbType.getSelectedItem().toString(), cmbFrom.getSelectedItem(), cmbTo.getSelectedItem()});

                    event.setTitle(cmbType.getSelectedItem().toString());
                    event.setStartTime(cmbFrom.getSelectedItem().toString());
                    event.setEndTime(cmbTo.getSelectedItem().toString());
                    serializeEvent.main(null,event);
                } else {
                    SpecialEvent specialevent = new SpecialEvent();
                    specialevent.setStartTime(cmbFrom.getSelectedItem().toString());
                    specialevent.setEndTime(cmbTo.getSelectedItem().toString());
                    specialevent.setTitle(cmbType.getSelectedItem().toString());
                    specialevent.setEventDescription(txtDescription.getText());
                    serializeEvent.main(null, specialevent);
                }

            }

        });

        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deserializeEvent.main(null);
            }
        });
    }


    public static void main(String[] args) {
    try {
        CreateTextFile.main(null);

            ReadTextFile.main(null);

        JFrame frame = new JFrame("addEvent");
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
