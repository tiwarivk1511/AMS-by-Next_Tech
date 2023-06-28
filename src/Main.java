import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JProgressBar progressBar;
    private JLabel progressLabel;
    private static int progressValue;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setLocationRelativeTo(null); // Set visibility point in the center
                    frame.setVisible(true);
                    frame.startProgressBar(); // Start the progress bar
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Main() {
    	setTitle("AMS");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Imeges/user.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 552, 511);
        setUndecorated(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(39, 58, 56));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel BanImg = new JLabel("");
        BanImg.setIcon(new ImageIcon(Main.class.getResource("/Imeges/loading.gif")));
        BanImg.setBounds(20, 39, 500, 375);
        contentPane.add(BanImg);

        progressBar = new JProgressBar();
        progressBar.setBounds(10, 446, 520, 18);
        progressBar.setForeground(new Color(128,0,255));
        contentPane.add(progressBar);

        progressLabel = new JLabel("0%");
        progressLabel.setForeground(new Color(0, 191, 255));
        progressLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
        progressLabel.setBounds(243, 411, 135, 25);
        contentPane.add(progressLabel);
        
        JLabel lblNewLabel = new JLabel("  AMS by Next_Tech");
        lblNewLabel.setForeground(new Color(0, 191, 255));
        lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/Imeges/user1.png")));
        lblNewLabel.setBounds(10, 10, 309, 25);
        contentPane.add(lblNewLabel);
    }

    /**
     * Start the progress bar with a separate thread.
     */
    private void startProgressBar() {
        Thread progressThread = new Thread(new Runnable() {
            public void run() {
                try {
                    for (progressValue = 0; progressValue <= 100; progressValue++) {
                        progressBar.setValue(progressValue);
                        progressLabel.setText("Loading "+progressValue + "%");
                        Thread.sleep(50); // Delay to simulate progress
                    }
                    dispose(); // Close the splash screen after progress completes
                    new LoginScreen().setVisible(true); // Starting the Login Screen
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        progressThread.start();
    }
}
