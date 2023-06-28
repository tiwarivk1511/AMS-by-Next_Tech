import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class DeleteEmployeeScreen<Border> extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField employeeIdField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteEmployeeScreen frame = new DeleteEmployeeScreen();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DeleteEmployeeScreen() {
    	//Frame design
    	setResizable(false);
    	setUndecorated(true);
        setTitle("Delete Employee");
        setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteEmployeeScreen.class.getResource("/Imeges/user.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setBounds(250,200, 355, 162);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(39, 58, 56));
        contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel closeBtn = new JLabel("");
        closeBtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
        	}
        });
        closeBtn.setIcon(new ImageIcon(MarkAttendance.class.getResource("/Imeges/close (Custom).png")));
        closeBtn.setBounds(321, 0, 30, 30);
        contentPane.add(closeBtn);
        
        JLabel minimizeBtn = new JLabel("");
        minimizeBtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	setState(Frame.ICONIFIED);
        	}
        });
        minimizeBtn.setIcon(new ImageIcon(MarkAttendance.class.getResource("/Imeges/minus (Custom).png")));
        minimizeBtn.setBounds(286, 0, 30, 30);
        contentPane.add(minimizeBtn);
        
        //Title of the Screen
        JLabel titleLabel = new JLabel("Delete Employee");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(87, 10, 175, 30);
        contentPane.add(titleLabel);

        //Add Employee Label & TextField
        JLabel employeeIdLabel = new JLabel("Employee ID:");
        employeeIdLabel.setForeground(Color.WHITE);
        employeeIdLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        employeeIdLabel.setBounds(21, 50, 100, 20);
        contentPane.add(employeeIdLabel);

        employeeIdField = new JTextField();
        employeeIdField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        employeeIdField.setBounds(116, 50, 200, 20);
        contentPane.add(employeeIdField);
        employeeIdField.setColumns(10);
        
        //Delete Button
        JButton deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Cambria", Font.BOLD, 14));
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String employeeId = employeeIdField.getText();

                if (employeeId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Employee ID is empty. Please provide the detail.",
                            "Empty Field", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Perform delete action
                    // Add your delete logic here
                    // ...
                    // After successful delete, you can show a success message or navigate to another screen
                    JOptionPane.showMessageDialog(null, "Employee deleted successfully!", "Delete Employee",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false); // Hide the DeleteEmployeeScreen
                }
            }
        });
        deleteButton.setBounds(52, 94, 100, 25);
        contentPane.add(deleteButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Cambria", Font.BOLD, 14));
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide the DeleteEmployeeScreen
                dispose();
                new LoginScreen().setVisible(true);
            }
        });
        cancelButton.setBounds(179, 94, 100, 25);
        contentPane.add(cancelButton);
    }
}
