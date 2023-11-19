import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;


public class LoginPage {

	/*
	 * global variables that are used
	 */
	private JFrame frmLoginPage;
	private JPasswordField passwordField;
	private JTextField UserNameField;




	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*
		 * creating the main frame for the Login page
		 */
		frmLoginPage = new JFrame();
		frmLoginPage.getContentPane().setBackground(new Color(192, 192, 192));
		frmLoginPage.setBackground(new Color(192, 192, 192));
		frmLoginPage.setTitle("Login Page");
		frmLoginPage.setBounds(100, 100, 450, 300);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		
		/*
		 * creating the password field for the login frame
		 */
		passwordField = new JPasswordField();
		passwordField.setBounds(182, 139, 130, 20);
		frmLoginPage.getContentPane().add(passwordField);
		
		/*
		 * creating the username field for the login frame
		 */
		UserNameField = new JTextField();
		UserNameField.setBounds(182, 88, 130, 20);
		frmLoginPage.getContentPane().add(UserNameField);
		UserNameField.setColumns(10);
		

		Panel panel = new Panel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(347, 0, 89, 263);
		frmLoginPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		/*
		 * creating the labels on the Login Page panel
		 */
		JLabel lblAei = new JLabel("A.E.I");
		lblAei.setBounds(10, 22, 60, 20);
		lblAei.setHorizontalAlignment(SwingConstants.CENTER);
		lblAei.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		panel.add(lblAei);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(0, 0, 0));
		lblLogin.setBackground(new Color(192, 192, 192));
		lblLogin.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(165, 10, 105, 35);
		frmLoginPage.getContentPane().add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(83, 92, 89, 16);
		frmLoginPage.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		lblPassword.setBounds(83, 143, 89, 16);
		frmLoginPage.getContentPane().add(lblPassword);
		
		/*
		 * Login button to open new panel when a user logs in with
		 * a correct username and password.
		 * The user will be taken to the "home" panel
		 */
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                // Open HomePageFrame
                HomePage HomePageFrame = new HomePage();
                HomePageFrame.setVisible(true);
                frmLoginPage.dispose();
			}
		});
		btnLogin.setBounds(215, 211, 85, 25);
		frmLoginPage.getContentPane().add(btnLogin);
		
		/*
		 * Sign up button to send user to a sign up page.
		 * The user will be taken to the "sign up" panel
		 */
		JButton signUpBtn = new JButton("Create Account");
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                // Open CreateAccountFrame
                CreateAccount createAccountFrame = new CreateAccount();
                createAccountFrame.setVisible(true);
                frmLoginPage.dispose();
			}
		});
		signUpBtn.setBounds(53, 211, 130, 25);
		frmLoginPage.getContentPane().add(signUpBtn);
		
	}
	
	/*
	 * method to make set the visibility of the LoginPage panel
	 */
    public void setVisible(boolean visible) {
    	frmLoginPage.setVisible(visible);
    }
}
