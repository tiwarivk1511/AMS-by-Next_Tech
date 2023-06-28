import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;

public class MarkAttendance extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField employeeIdField;
    private JXDatePicker dateChooser; // JXDatePicker instance
    private JComboBox<String> attendanceStatusComboBox; // JComboBox for attendance status
    private JSpinner inTimeSpinner; // JSpinner for in-time
    private JSpinner outTimeSpinner; // JSpinner for out-time

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MarkAttendance frame = new MarkAttendance();
                    frame.setLocationRelativeTo(null); // Set visibility point in the center
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MarkAttendance() {
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(MarkAttendance.class.getResource("/Imeges/user.png")));
        setTitle("Mark Attendance");
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 613, 240);
        contentPane = new JPanel();
        contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        contentPane.setBackground(new Color(39, 58, 56));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEmployeeId = new JLabel("Employee ID:");
        lblEmployeeId.setForeground(new Color(255, 255, 255));
        lblEmployeeId.setFont(new Font("Cambria", Font.PLAIN, 14));
        lblEmployeeId.setBounds(49, 69, 84, 16);
        contentPane.add(lblEmployeeId);

        employeeIdField = new JTextField();
        employeeIdField.setBounds(139, 68, 155, 22);
        contentPane.add(employeeIdField);
        employeeIdField.setColumns(10);

        // Create the JXDatePicker instance and set its bounds
        dateChooser = new JXDatePicker();
        dateChooser.getEditor().setEditable(false);
        dateChooser.setFormats(new String[] {"dd/MM/yyyy"});
        dateChooser.getEditor().setText("DD/MM/YYYY");
        dateChooser.setBounds(139, 97, 155, 25);
        contentPane.add(dateChooser);

        // Create the attendance status JComboBox
        attendanceStatusComboBox = new JComboBox<String>();
        attendanceStatusComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"----- Select -----", "Present", "Absent", "on Leave"}));
        attendanceStatusComboBox.setBounds(139, 127, 155, 25);
        contentPane.add(attendanceStatusComboBox);

        // Create the in-time JSpinner
        inTimeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor inTimeEditor = new JSpinner.DateEditor(inTimeSpinner, "hh:mm a");
        inTimeSpinner.setEditor(inTimeEditor);
        inTimeSpinner.setBounds(396, 71, 155, 25);
        contentPane.add(inTimeSpinner);

        // Create the out-time JSpinner
        outTimeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor outTimeEditor = new JSpinner.DateEditor(outTimeSpinner, "hh:mm a");
        outTimeSpinner.setEditor(outTimeEditor);
        outTimeSpinner.setBounds(396, 101, 155, 25);
        contentPane.add(outTimeSpinner);

        JButton btnMarkAttendance = new JButton("Mark Attendance");
        btnMarkAttendance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                markAttendance();
            }
        });
        btnMarkAttendance.setBounds(139, 181, 140, 25);
        contentPane.add(btnMarkAttendance);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setForeground(new Color(255, 255, 255));
        lblDate.setFont(new Font("Cambria", Font.PLAIN, 14));
        lblDate.setBounds(94, 100, 39, 16);
        contentPane.add(lblDate);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setForeground(new Color(255, 255, 255));
        lblStatus.setFont(new Font("Cambria", Font.PLAIN, 14));
        lblStatus.setBounds(91, 130, 42, 16);
        contentPane.add(lblStatus);

        JLabel lblInTime = new JLabel("In-Time:");
        lblInTime.setForeground(new Color(255, 255, 255));
        lblInTime.setFont(new Font("Cambria", Font.PLAIN, 14));
        lblInTime.setBounds(336, 74, 54, 16);
        contentPane.add(lblInTime);

        JLabel lblOutTime = new JLabel("Out-Time:");
        lblOutTime.setForeground(new Color(255, 255, 255));
        lblOutTime.setFont(new Font("Cambria", Font.PLAIN, 14));
        lblOutTime.setBounds(326, 104, 64, 16);
        contentPane.add(lblOutTime);

        JButton btnUpdateAttendance = new JButton("Update Attendance");
        btnUpdateAttendance.setBounds(290, 181, 155, 25);
        contentPane.add(btnUpdateAttendance);

        JLabel lblNewLabel = new JLabel("Mark Attendance");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel.setBounds(187, 10, 245, 30);
        contentPane.add(lblNewLabel);
        
        JLabel closeBtn = new JLabel("");
        closeBtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
        	}
        });
        closeBtn.setIcon(new ImageIcon(MarkAttendance.class.getResource("/Imeges/close (Custom).png")));
        closeBtn.setBounds(576, 0, 30, 30);
        contentPane.add(closeBtn);
        
        JLabel minimizeBtn = new JLabel("");
        minimizeBtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	setState(Frame.ICONIFIED);
        	}
        });
        minimizeBtn.setIcon(new ImageIcon(MarkAttendance.class.getResource("/Imeges/minus (Custom).png")));
        minimizeBtn.setBounds(548, 0, 30, 30);
        contentPane.add(minimizeBtn);

        // Add action listener to the update attendance button
        btnUpdateAttendance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateAttendance();
            }
        });
    }

    private void markAttendance() {
        String employeeId = employeeIdField.getText();

        // Get the selected date from the JXDatePicker
        Date selectedDate = dateChooser.getDate();

        if (selectedDate == null) {
            JOptionPane.showMessageDialog(this, "Please select a valid date.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the selected attendance status
        String attendanceStatus = (String) attendanceStatusComboBox.getSelectedItem();

        if (attendanceStatus == null) {
            JOptionPane.showMessageDialog(this, "Please select an attendance status.", "Invalid Attendance Status", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the selected in-time
        Date inTime = (Date) inTimeSpinner.getValue();

        // Get the selected out-time
        Date outTime = (Date) outTimeSpinner.getValue();

        // JDBC code to connect to the database and insert the attendance record
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO attendance (employee_id, timestamp, status, in_time, out_time) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, employeeId);
            statement.setTimestamp(2, new java.sql.Timestamp(selectedDate.getTime()));
            statement.setString(3, attendanceStatus);
            statement.setTime(4, new java.sql.Time(inTime.getTime()));
            statement.setTime(5, new java.sql.Time(outTime.getTime()));
            statement.executeUpdate();

            JOptionPane.showMessageDialog(this, "Attendance marked successfully!");
            employeeIdField.setText("");
            attendanceStatusComboBox.setSelectedIndex(0);
            inTimeSpinner.setValue(new Date());
            outTimeSpinner.setValue(new Date());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error marking attendance: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateAttendance() {
        // Implement your logic to update attendance here
        // Retrieve the employee ID, date, and other details from the interface
        // Connect to the database and update the attendance record
        
        employeeIdField.getText();
        dateChooser.getDate();
        attendanceStatusComboBox.getSelectedItem();
        inTimeSpinner.getValue();
        outTimeSpinner.getValue();
        
        // Implement the update logic here
        
        // Display a success message or handle any errors accordingly
    }
}
