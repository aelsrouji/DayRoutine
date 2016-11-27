import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by ayman on 2016-11-26.
 */
public class addEvent {

    private JComboBox cmbType;
    private JPanel panel1;
    private JLabel lblMessage;
    private JButton btnAdd;
    private JComboBox cmbFrom;
    private JComboBox cmbTo;
    private  JTable tblEvents;


    public addEvent() {
        cmbType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // lblMessage.setText(cmbType.getSelectedItem().toString());
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnAdd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            DefaultTableModel mdl = new DefaultTableModel();
                            String header[] = new String[]{"Event", "From", "To"};
                            mdl.setColumnIdentifiers(header);
                            tblEvents.setModel(mdl);
                            mdl.addRow(new Object[] { cmbType.getSelectedItem().toString(), cmbFrom.getSelectedItem(),cmbTo.getSelectedItem() });
                            mdl.addRow(new Object[] { "v2" });
                 /*   String[] myEvent = new String[]{
                     cmbType.getSelectedItem().toString(),
                     cmbFrom.getSelectedItem().toString(),
                     cmbTo.getSelectedItem().toString()}; */

                        }


                        catch (Exception ex)
                        {System.out.println(ex.getMessage());}
                    }
                });
            }


        });
    }


    public static void main(String[] args) {


        JFrame frame = new JFrame("addEvent");
        frame.setContentPane(new addEvent().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }




}
