import java.awt.EventQueue;


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



public class LoginPage {

	private JFrame frmLoginPage;
	private JPasswordField passwordField;
	private JTextField UserNameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


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
		frmLoginPage = new JFrame();
		frmLoginPage.getContentPane().setBackground(new Color(192, 192, 192));
		frmLoginPage.setBackground(new Color(192, 192, 192));
		frmLoginPage.setTitle("Login Page");
		frmLoginPage.setBounds(100, 100, 450, 300);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(182, 139, 130, 20);
		frmLoginPage.getContentPane().add(passwordField);
		
		UserNameField = new JTextField();
		UserNameField.setBounds(182, 88, 130, 20);
		frmLoginPage.getContentPane().add(UserNameField);
		UserNameField.setColumns(10);
		
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
			}
		});
		btnLogin.setBounds(185, 228, 85, 25);
		frmLoginPage.getContentPane().add(btnLogin);
		
		/*
		 * Sign up button to send user to a sign up page.
		 * The user will be taken to the "sign up" panel
		 */
		JButton signUpBtn = new JButton("Sign up");
		signUpBtn.setBounds(10, 228, 125, 25);
		frmLoginPage.getContentPane().add(signUpBtn);
	}
}
