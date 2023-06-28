import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddEmployeeScreen extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField nameField;
    private JTextField contactNumberField;
    private JTextField emailField;
    private JTextField genderField;
    private JTextField jobField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel pictureLabel;
    private JTextField ContactField;
    private JTextField DepartmentField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddEmployeeScreen frame = new AddEmployeeScreen();
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
    public AddEmployeeScreen() {
    	setResizable(false);
        setTitle("User Signup");
        setUndecorated(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(AddEmployeeScreen.class.getResource("/Imeges/user.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 847, 534);
        
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
        closeBtn.setBounds(810, 0, 30, 30);
        contentPane.add(closeBtn);
        
        JLabel minimizeBtn = new JLabel("");
        minimizeBtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	setState(Frame.ICONIFIED);
        	}
        });
        minimizeBtn.setIcon(new ImageIcon(MarkAttendance.class.getResource("/Imeges/minus (Custom).png")));
        minimizeBtn.setBounds(780, 0, 30, 30);
        contentPane.add(minimizeBtn);

        // Label for the title
        JLabel titleLabel = new JLabel("Add Employee");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 27));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(330, 10, 177, 37);
        contentPane.add(titleLabel);

        // Label and text field for the name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        nameLabel.setBounds(430, 65, 56, 19);
        contentPane.add(nameLabel);
        nameField = new JTextField();
        nameField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        nameField.setBounds(496, 64, 325, 20);
        contentPane.add(nameField);
        nameField.setColumns(10);

        // Label and text field for the contact number
        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setForeground(Color.WHITE);
        contactLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        contactLabel.setBounds(367, 94, 119, 19);
        contentPane.add(contactLabel);
        contactNumberField = new JTextField();
        contactNumberField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        contactNumberField.setBounds(496, 94, 325, 20);
        contentPane.add(contactNumberField);
        contactNumberField.setColumns(10);

        // Label and text field for the email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        emailLabel.setBounds(430, 123, 56, 19);
        contentPane.add(emailLabel);
        emailField = new JTextField();
        emailField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        emailField.setBounds(496, 123, 325, 20);
        contentPane.add(emailField);
        emailField.setColumns(10);

        // Label and text field for the gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        genderLabel.setBounds(430, 186, 56, 19);
        contentPane.add(genderLabel);
        genderField = new JTextField();
        genderField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        genderField.setBounds(496, 185, 325, 20);
        contentPane.add(genderField);
        genderField.setColumns(10);

        // Label and text field for the job designation
        JLabel jobLabel = new JLabel("Job Designation:");
        jobLabel.setForeground(Color.WHITE);
        jobLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        jobLabel.setBounds(367, 254, 119, 19);
        contentPane.add(jobLabel);
        jobField = new JTextField();
        jobField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        jobField.setBounds(496, 253, 325, 20);
        contentPane.add(jobField);
        jobField.setColumns(10);

        // Label and text field for the username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        usernameLabel.setBounds(408, 382, 74, 19);
        contentPane.add(usernameLabel);
        usernameField = new JTextField();
        usernameField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        usernameField.setBounds(496, 381, 325, 20);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        // Label and password field for the password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        passwordLabel.setBounds(408, 412, 74, 19);
        contentPane.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        passwordField.setBounds(496, 411, 325, 20);
        contentPane.add(passwordField);
        passwordField.setColumns(10);

       

        // Button for cancel
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
  
            }
        });
        cancelButton.setFont(new Font("Cambria", Font.BOLD, 14));
        cancelButton.setBounds(532, 486, 89, 23);
        contentPane.add(cancelButton);

        // Label and button for uploading photo
        JLabel photoLabel = new JLabel("Upload Photo:");
        photoLabel.setForeground(Color.WHITE);
        photoLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        photoLabel.setBounds(377, 441, 105, 19);
        contentPane.add(photoLabel);
        JButton uploadButton = new JButton("Upload");
        uploadButton.setFont(new Font("Cambria", Font.BOLD, 12));
        uploadButton.setBounds(496, 440, 89, 23);
        contentPane.add(uploadButton);

        // Label for displaying the selected picture
        pictureLabel = new JLabel("");
        pictureLabel.setIcon(new ImageIcon(AddEmployeeScreen.class.getResource("/Imeges/ProfilePic.png")));
        pictureLabel.setBounds(55, 77, 250, 269);
        contentPane.add(pictureLabel);

        // Text area for address
        JTextArea addressArea = new JTextArea();
        addressArea.setBounds(496, 283, 325, 88);
        contentPane.add(addressArea);
        
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setForeground(Color.WHITE);
        lblAddress.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        lblAddress.setBounds(419, 283, 67, 19);
        contentPane.add(lblAddress);
        
        JLabel lblContactNo = new JLabel("Contact No.:");
        lblContactNo.setForeground(Color.WHITE);
        lblContactNo.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        lblContactNo.setBounds(397, 156, 89, 19);
        contentPane.add(lblContactNo);
        
        ContactField = new JTextField();
        ContactField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        ContactField.setColumns(10);
        ContactField.setBounds(496, 156, 325, 20);
        contentPane.add(ContactField);

        // ActionListener for the upload button
        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
                fileChooser.setFileFilter(filter);

                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    // Scale the image to fit the pictureLabel
                    Image scaledImage = imageIcon.getImage().getScaledInstance(pictureLabel.getWidth(), pictureLabel.getHeight(), Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(scaledImage);
                    pictureLabel.setIcon(imageIcon);
                }
            }
        });
        
        
        // Button for signup
        JButton signupButton = new JButton("Add Employee");
        signupButton.setFont(new Font("Cambria", Font.BOLD, 14));
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 // Check if any field is empty
                StringBuilder emptyFields = new StringBuilder();

                if (nameField.getText().isEmpty()) {
                    emptyFields.append("Name");
                }
                if (contactNumberField.getText().isEmpty()) {
                    if (emptyFields.length() > 0) {
                        emptyFields.append(", ");
                    }
                    emptyFields.append("Contact Number");
                }
                if (emailField.getText().isEmpty()) {
                    if (emptyFields.length() > 0) {
                        emptyFields.append(", ");
                    }
                    emptyFields.append("Email");
                }
                if (genderField.getText().isEmpty()) {
                    if (emptyFields.length() > 0) {
                        emptyFields.append(", ");
                    }
                    emptyFields.append("Gender");
                }
                
                
				if (addressArea.getText().isEmpty()) {
                    if (emptyFields.length() > 0) {
                        emptyFields.append(", ");
                    }
                    emptyFields.append("Address");
                }
                if (jobField.getText().isEmpty()) {
                    if (emptyFields.length() > 0) {
                        emptyFields.append(", ");
                    }
                    emptyFields.append("Job Designation");
                }
                if (usernameField.getText().isEmpty()) {
                    if (emptyFields.length() > 0) {
                        emptyFields.append(", ");
                    }
                    emptyFields.append("Username");
                }
                if (passwordField.getPassword().length == 0) {
                    if (emptyFields.length() > 0) {
                        emptyFields.append(", ");
                    }
                    emptyFields.append("Password");
                }

                if (emptyFields.length() > 0) {
                    String errorMessage = emptyFields.toString() + " is empty. Please provide the detail.";
                    JOptionPane.showMessageDialog(null, errorMessage, "Empty Fields", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Perform signup action
                    // Add your signup logic here
                    // ...
                    // After successful signup, you can close the signup screen or navigate to another screen
                    dispose(); // Close the AddEmployeeScreen
                }
            }
        });
        
        signupButton.setBounds(355, 486, 143, 23);
        contentPane.add(signupButton);
        
        JLabel lblDepartment = new JLabel("Department:");
        lblDepartment.setForeground(Color.WHITE);
        lblDepartment.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        lblDepartment.setBounds(391, 216, 95, 19);
        contentPane.add(lblDepartment);
        
        DepartmentField = new JTextField();
        DepartmentField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        DepartmentField.setColumns(10);
        DepartmentField.setBounds(496, 215, 325, 20);
        contentPane.add(DepartmentField);
    }
}
