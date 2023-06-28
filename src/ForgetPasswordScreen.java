import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class ForgetPasswordScreen extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JLabel showPasswordLabel; // Member variable to reference the "Show Password" label
    private boolean isPasswordVisible = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ForgetPasswordScreen frame = new ForgetPasswordScreen();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ForgetPasswordScreen() {
    	setResizable(false);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(ForgetPasswordScreen.class.getResource("/Imeges/user.png")));
        setTitle("Forget Password");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,200, 586, 324);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(39, 58, 56));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel titleLabel = new JLabel("Forget Password");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Cambria", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(195, 10, 210, 29);
        contentPane.add(titleLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        usernameLabel.setBounds(95, 67, 80, 19);
        contentPane.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        usernameField.setBounds(185, 67, 236, 29);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        JLabel passwordLabel = new JLabel("New Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        passwordLabel.setBounds(55, 117, 120, 19);
        contentPane.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        passwordField.setBounds(185, 112, 236, 29);
        contentPane.add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setForeground(Color.WHITE);
        confirmPasswordLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        confirmPasswordLabel.setBounds(30, 167, 145, 19);
        contentPane.add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        confirmPasswordField.setBounds(185, 167, 236, 29);
        contentPane.add(confirmPasswordField);

        JButton resetButton = new JButton("Reset Password");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (password.equals(confirmPassword)) {
                    System.out.println("Username: " + username);
                    System.out.println("New Password: " + password);
                    System.out.println("Password Confirmed");
                } else {
                    System.out.println("Password does not match!");
                }
            }
        });
        resetButton.setFont(new Font("Cambria", Font.BOLD, 14));
        resetButton.setBounds(154, 236, 154, 23);
        contentPane.add(resetButton);

        showPasswordLabel = new JLabel("Show Password");
        showPasswordLabel.setForeground(Color.WHITE);
        showPasswordLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        showPasswordLabel.setBounds(439, 118, 106, 28);
        showPasswordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isPasswordVisible = !isPasswordVisible;
                showPassword();
            }
        });
        contentPane.add(showPasswordLabel);
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new LoginScreen().setVisible(true);
        	}
        });
        backButton.setFont(new Font("Cambria", Font.BOLD, 14));
        backButton.setBounds(346, 236, 89, 23);
        contentPane.add(backButton);

        showPassword(); // Call the showPassword method initially
    }

    private void showPassword() {
        if (isPasswordVisible) {
            passwordField.setEchoChar((char) 0); // Show password characters
            confirmPasswordField.setEchoChar((char) 0);
            showPasswordLabel.setText("Hide Password"); // Change label text
        } else {
            passwordField.setEchoChar('\u2022'); // Hide password characters
            confirmPasswordField.setEchoChar('\u2022');
            showPasswordLabel.setText("Show Password"); // Change label text
        }
    }
}
