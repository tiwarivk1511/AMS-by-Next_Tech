import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.Icon;
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
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


public class SignupScreen extends JFrame {

    
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

	protected AbstractButton addressArea;

	protected File emptyFields;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignupScreen frame = new SignupScreen();
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
    public SignupScreen() {
    	setResizable(false);
        setTitle("User Signup");
        setUndecorated(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(SignupScreen.class.getResource("/Imeges/user.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 855, 521);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(39, 58, 56));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Label for the title
        JLabel titleLabel = new JLabel("Signup");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 27));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(382, 10, 125, 37);
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
        genderLabel.setBounds(430, 154, 56, 19);
        contentPane.add(genderLabel);
        genderField = new JTextField();
        genderField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        genderField.setBounds(496, 153, 325, 20);
        contentPane.add(genderField);
        genderField.setColumns(10);

        // Label and text field for the job designation
        JLabel jobLabel = new JLabel("Job Designation:");
        jobLabel.setForeground(Color.WHITE);
        jobLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        jobLabel.setBounds(367, 191, 119, 19);
        contentPane.add(jobLabel);
        jobField = new JTextField();
        jobField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        jobField.setBounds(496, 190, 325, 20);
        contentPane.add(jobField);
        jobField.setColumns(10);

        // Label and text field for the username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        usernameLabel.setBounds(408, 319, 74, 19);
        contentPane.add(usernameLabel);
        usernameField = new JTextField();
        usernameField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        usernameField.setBounds(496, 318, 325, 20);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        // Label and password field for the password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        passwordLabel.setBounds(408, 349, 74, 19);
        contentPane.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        passwordField.setBounds(496, 348, 325, 20);
        contentPane.add(passwordField);
        passwordField.setColumns(10);

        // Button for signup
        JButton signupButton = new JButton("Sign Up");
        signupButton.setFont(new Font("Cambria", Font.BOLD, 14));
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Check if any field is empty
                if (nameField.getText().isEmpty() || contactNumberField.getText().isEmpty() || emailField.getText().isEmpty()
                        || genderField.getText().isEmpty() || jobField.getText().isEmpty() || usernameField.getText().isEmpty()
                        || passwordField.getPassword().length == 0 || addressArea.getText().isEmpty()) {
                    // Display error message if any field is empty
                	
                    JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Empty Fields", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Perform signup action
                    try {
                        // Establish a connection to the database
                        String url = "jdbc:mysql://localhost:3306/mydatabase";
                        String username = "your-username";
                        String password = "your-password";
                        Connection connection = DriverManager.getConnection(url, username, password);

                        // Prepare the SQL statement for inserting employee data
                        String insertQuery = "INSERT INTO employees (name, contact_number, email, gender, address, job_designation, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement statement = connection.prepareStatement(insertQuery);
                        statement.setString(1, nameField.getText());
                        statement.setString(2, contactNumberField.getText());
                        statement.setString(3, emailField.getText());
                        statement.setString(4, genderField.getText());
                        statement.setString(5, addressArea.getText());
                        statement.setString(6, jobField.getText());
                        statement.setString(7, usernameField.getText());
                        statement.setString(8, new String(passwordField.getPassword()));

                        // Execute the insert statement
                        int rowsInserted = statement.executeUpdate();

                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(null, "Employee added successfully!");
                            dispose(); // Close the AddEmployeeScreen
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to add employee.", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        // Close the database connection and statement
                        statement.close();
                        connection.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "An error occurred while connecting to the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
                    }
                    dispose(); // Close the SignupScreen
                }
            }
        });

        signupButton.setBounds(497, 441, 89, 23);
        contentPane.add(signupButton);

        // Button for cancel
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginScreen().setVisible(true);
            }
        });
        cancelButton.setFont(new Font("Cambria", Font.BOLD, 14));
        cancelButton.setBounds(614, 441, 89, 23);
        contentPane.add(cancelButton);

        // Label and button for uploading photo
        JLabel photoLabel = new JLabel("Upload Photo:");
        photoLabel.setForeground(Color.WHITE);
        photoLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        photoLabel.setBounds(382, 378, 105, 19);
        contentPane.add(photoLabel);
        JButton uploadButton = new JButton("Upload");
        uploadButton.setFont(new Font("Cambria", Font.BOLD, 12));
        uploadButton.setBounds(496, 378, 89, 23);
        contentPane.add(uploadButton);

        // Label for displaying the selected picture
        pictureLabel = new JLabel("");
        pictureLabel.setIcon(new ImageIcon(SignupScreen.class.getResource("/Imeges/ProfilePic.png")));
        pictureLabel.setBounds(55, 77, 250, 260);
        contentPane.add(pictureLabel);

        // Text area for address
        JTextArea addressArea = new JTextArea();
        addressArea.setBounds(496, 220, 325, 88);
        contentPane.add(addressArea);
        
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setForeground(Color.WHITE);
        lblAddress.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        lblAddress.setBounds(419, 220, 67, 19);
        contentPane.add(lblAddress);

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
    }
}
