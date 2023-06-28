import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> loginAsComboBox;
    private JLabel showPasswordLabel; // Member variable to reference the "Show Password" label
    private boolean isPasswordVisible = false;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase"; // Add the link of your Database
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginScreen frame = new LoginScreen();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LoginScreen() {
    	setResizable(false);
        // Set the frame properties
        setTitle("User Login");
        setIconImage(Toolkit.getDefaultToolkit().getImage(LoginScreen.class.getResource("/Imeges/user.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 250, 774, 361);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(39, 58, 56));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Label for the title
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Cambria", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(280, 10, 125, 29);
        contentPane.add(titleLabel);

        // Label and text field for the username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        usernameLabel.setBounds(327, 77, 78, 30);
        contentPane.add(usernameLabel);
        usernameField = new JTextField();
        usernameField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        usernameField.setBounds(406, 78, 221, 29);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        // Label and password field for the password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        passwordLabel.setBounds(327, 119, 78, 30);
        contentPane.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        passwordField.setBounds(406, 120, 221, 29);
        contentPane.add(passwordField);

        // Label for "Show Password"
        showPasswordLabel = new JLabel("Show Password");
        showPasswordLabel.setForeground(Color.WHITE);
        showPasswordLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        showPasswordLabel.setBounds(641, 120, 98, 29);
        showPasswordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isPasswordVisible = !isPasswordVisible;
                showPassword();
            }
        });
        contentPane.add(showPasswordLabel);

        // Label for "Login as"
        JLabel loginAsLabel = new JLabel("Login as:");
        loginAsLabel.setForeground(Color.WHITE);
        loginAsLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        loginAsLabel.setBounds(327, 160, 78, 28);
        contentPane.add(loginAsLabel);

        // ComboBox for "Login as" options
        loginAsComboBox = new JComboBox<String>();
        loginAsComboBox.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        loginAsComboBox.setBounds(406, 159, 221, 29);
        loginAsComboBox.addItem("Admin");
        loginAsComboBox.addItem("User");
        contentPane.add(loginAsComboBox);

        // Button for login
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword());
                String loginAs = loginAsComboBox.getSelectedItem().toString();

                // Validate the entered username and password
                boolean isValidLogin = validateLogin(username, password, loginAs);
                if (isValidLogin) {
                    System.out.println("Login successful");
                    Dashboard dashbord = new Dashboard();
                    dashbord.setVisible(true);
                    dispose();
                } else {
                    System.out.println("Invalid username or password");
                }
            }
        });
        loginButton.setFont(new Font("Cambria", Font.BOLD, 14));
        loginButton.setBounds(375, 244, 89, 23);
        contentPane.add(loginButton);

        // Button for signup
        JButton signupButton = new JButton("Sign Up");
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SignupScreen().setVisible(true);
            }
        });
        signupButton.setFont(new Font("Cambria", Font.BOLD, 12));
        signupButton.setBounds(511, 244, 89, 23);
        contentPane.add(signupButton);

        // Label for forgot password
        JLabel forgetPasswordLabel = new JLabel("Forgot Password?");
        forgetPasswordLabel.setForeground(Color.WHITE);
        forgetPasswordLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        forgetPasswordLabel.setBounds(528, 197, 112, 23);
        forgetPasswordLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                ForgetPasswordScreen forgetPasswordScreen = new ForgetPasswordScreen();
                forgetPasswordScreen.setVisible(true);
            }
        });
        contentPane.add(forgetPasswordLabel);

        // Label for displaying lock icon
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(LoginScreen.class.getResource("/Imeges/lock.jpg")));
        lblNewLabel.setBounds(10, 49, 293, 200);
        contentPane.add(lblNewLabel);

        // Button for exit
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitButton.setFont(new Font("Cambria", Font.BOLD, 12));
        exitButton.setBounds(444, 284, 89, 23);
        contentPane.add(exitButton);
    }

    private void showPassword() {
        if (isPasswordVisible) {
            passwordField.setEchoChar((char) 0); // Show password characters
            showPasswordLabel.setText("Hide Password"); // Change label text
        } else {
            passwordField.setEchoChar('\u2022'); // Hide password characters
            showPasswordLabel.setText("Show Password"); // Change label text
        }
    }

    private boolean validateLogin(String username, String password, String loginAs) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish the database connection
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Prepare the SQL statement
            String query = "SELECT * FROM users WHERE username = ? AND password = ? AND role = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, loginAs);

            // Execute the query
            resultSet = statement.executeQuery();

            // Check if the result set has any rows
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Close the database resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
