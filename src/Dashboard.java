import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.print.PrinterException;

public class Dashboard extends JFrame {

    // global Variables
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel menuPanel;
    private boolean isMenuPanelVisible = true;
    JLabel menuBtn = new JLabel("");
    JButton btnLogOut = new JButton("Log out");
    private JTable table;

    // main method of this class
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Dashboard frame = new Dashboard();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Dashboard() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/Imeges/user.png")));
        setTitle("AMS by Next_Tech : The Next Technology");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1397, 776);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(39, 58, 56));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel titleLabel = new JLabel("AMS Dashboard");
        titleLabel.setBounds(675, 10, 236, 29);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Cambria", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(titleLabel);

        menuPanel = new JPanel();
        menuPanel.setBounds(-11, 0, 221, 800);
        menuPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        menuPanel.setBackground(new Color(115, 115, 255));
        contentPane.add(menuPanel);
        
        menuBtn.setBounds(220, 10, 30, 29);
        menuBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isMenuPanelVisible = !isMenuPanelVisible;
                updateMenuPanelVisibility();
            }
        });
        menuBtn.setIcon(new ImageIcon(Dashboard.class.getResource("/Imeges/Menu (Custom).png")));
        contentPane.add(menuBtn);
        menuPanel.setLayout(null);

        JButton markAttendanceButton = new JButton("Mark Attendance");
        markAttendanceButton.setIcon(new ImageIcon(Dashboard.class.getResource("/Imeges/check (Custom).png")));
        markAttendanceButton.setBounds(10, 173, 211, 30);
        menuPanel.add(markAttendanceButton);
        markAttendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MarkAttendance().setVisible(true);
                System.out.println("Mark Attendance button pressed");
            }
        });
        markAttendanceButton.setFont(new Font("Cambria", Font.BOLD, 14));

        JButton viewAttendanceButton = new JButton("View Attendance");
        viewAttendanceButton.setIcon(new ImageIcon(Dashboard.class.getResource("/Imeges/eye (Custom).png")));
        viewAttendanceButton.setBounds(10, 213, 211, 30);
        menuPanel.add(viewAttendanceButton);
        viewAttendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("View Attendance button pressed");
            }
        });
        viewAttendanceButton.setFont(new Font("Cambria", Font.BOLD, 14));

        JButton generateReportButton = new JButton("Generate Report");
        generateReportButton.setIcon(new ImageIcon(Dashboard.class.getResource("/Imeges/document (Custom).png")));
        generateReportButton.setBounds(10, 333, 211, 30);
        menuPanel.add(generateReportButton);
        generateReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Generate Report button pressed");
            }
        });
        generateReportButton.setFont(new Font("Cambria", Font.BOLD, 14));

        JButton btnUpdateEmployeeDetails = new JButton("Update Employee Data");
        btnUpdateEmployeeDetails.setIcon(new ImageIcon(Dashboard.class.getResource("/Imeges/updateUser (Custom).png")));
        btnUpdateEmployeeDetails.setBounds(10, 253, 211, 33);
        menuPanel.add(btnUpdateEmployeeDetails);
        btnUpdateEmployeeDetails.setFont(new Font("Cambria", Font.BOLD, 14));

        JButton addEmployeeBtn = new JButton("Add Employee");
        addEmployeeBtn.setIcon(new ImageIcon(Dashboard.class.getResource("/Imeges/user1.png")));
        addEmployeeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddEmployeeScreen().setVisible(true);
                System.out.println("Add Employee button pressed");
            }
        });
        addEmployeeBtn.setBounds(10, 133, 211, 30);
        menuPanel.add(addEmployeeBtn);
        addEmployeeBtn.setFont(new Font("Cambria", Font.BOLD, 14));

        JButton btnDeleteEmployee = new JButton("Delete Employee");
        btnDeleteEmployee.setIcon(new ImageIcon(Dashboard.class.getResource("/Imeges/delete (Custom).png")));
        btnDeleteEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DeleteEmployeeScreen<Object>().setVisible(true);
            }
        });
        btnDeleteEmployee.setFont(new Font("Cambria", Font.BOLD, 14));
        btnDeleteEmployee.setBounds(10, 293, 211, 30);
        menuPanel.add(btnDeleteEmployee);

        JPanel InternalPannel = new JPanel();
        InternalPannel.setBounds(10, 0, 211, 127);
        InternalPannel.setBackground(new Color(3, 3, 80));
        menuPanel.add(InternalPannel);
        InternalPannel.setLayout(null);

        JLabel lblNewLabel = new JLabel("AMS by");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setBounds(10, 10, 86, 30);
        InternalPannel.add(lblNewLabel);

        JLabel createrLogo = new JLabel("");
        createrLogo.setIcon(new ImageIcon(Dashboard.class.getResource("/Imeges/Next_Tech.png")));
        createrLogo.setBounds(10, 39, 201, 78);
        InternalPannel.add(createrLogo);
        btnLogOut.setIcon(new ImageIcon(Dashboard.class.getResource("/Imeges/logout (Custom).png")));


        btnLogOut.setForeground(UIManager.getColor("Button.foreground"));
        btnLogOut.setBackground(new Color(255, 0, 0));
        btnLogOut.setFont(new Font("Cambria", Font.BOLD, 14));
        btnLogOut.setBounds(10, 705, 211, 30);
        menuPanel.add(btnLogOut);

        table = new JTable();
        table.setFillsViewportHeight(true);
        table.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
        table.setBounds(249, 203, 122, -120);
        contentPane.add(table);

        // Create a DefaultTableModel with sample data
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][] {
                        {1, "Jhon@321", "1243"," Jhon","IT Department","31","28","2"},
                },
                new String[] {
                        "Sr. No", "ID", "Emp. Num", "Name", "Department","Total Working Days" ,"Total Attendence / Month", "Total Leaves"
                }
        );
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"Sr. No", "ID", "Emp. Num", "Name", "Department", "Total Working Days", "Total Attendence / Month", "Total Leaves"
        	}
        ) {
        	/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
        		false, false, false, false, false, false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(41);
        table.getColumnModel().getColumn(1).setPreferredWidth(52);
        table.getColumnModel().getColumn(2).setPreferredWidth(59);

        // Create a JScrollPane and set the table as its view component
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(220, 66, 1153, 609);
        contentPane.add(scrollPane);

        JButton btnPrint = new JButton("Print");
        btnPrint.setIcon(new ImageIcon(Dashboard.class.getResource("/Imeges/printer (Custom).png")));
        btnPrint.setFont(new Font("Cambria", Font.BOLD, 14));
        btnPrint.setBounds(435, 685, 148, 30);
        contentPane.add(btnPrint);

        JButton btnSaveAsPdf = new JButton("Save As PDF");
        btnSaveAsPdf.setIcon(new ImageIcon(Dashboard.class.getResource("/Imeges/down (Custom).png")));
        btnSaveAsPdf.setFont(new Font("Cambria", Font.BOLD, 14));
        btnSaveAsPdf.setBounds(603, 685, 148, 30);
        contentPane.add(btnSaveAsPdf);

        // ActionListener for printing the table
        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	 boolean complete = table.print(); // Print the table
                     if (complete) {
                         JOptionPane.showMessageDialog(null, "Printing successful", "Print", JOptionPane.INFORMATION_MESSAGE);
                     } else {
                         JOptionPane.showMessageDialog(null, "Printing cancelled", "Print", JOptionPane.WARNING_MESSAGE);
                     }
                } catch (PrinterException ex) {
                	ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Printing error: " + ex.getMessage(), "Print", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Update the visibility of the menu panel based on the initial state
        updateMenuPanelVisibility();
    }

    private void updateMenuPanelVisibility() {
        if (isMenuPanelVisible) {
            menuPanel.setBounds(-11, 0, 221, 800);
            menuBtn.setBounds(220, 10, 30, 29);
        } else {
            menuPanel.setBounds(-221, 0, 221, 800);
            menuBtn.setBounds(10, 10, 30, 29);
        }
    }
}
