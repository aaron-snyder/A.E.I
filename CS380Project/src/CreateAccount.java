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



public class CreateAccount {

	// global varibles for the create account page
	private JFrame frmCreateAccount;
	private JPasswordField passwordConfirmField;
	private JTextField UserNameField;
	private JPasswordField passwordField;


	/**
	 * Create the application.
	 */
	public CreateAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*
		 * creating the main frame for the create account page
		 */
		frmCreateAccount = new JFrame();
		frmCreateAccount.getContentPane().setBackground(new Color(192, 192, 192));
		frmCreateAccount.setBackground(new Color(192, 192, 192));
		frmCreateAccount.setTitle("Create Account Page");
		frmCreateAccount.setBounds(100, 100, 450, 300);
		frmCreateAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateAccount.getContentPane().setLayout(null);
		
		/*
		 * creating the password and username fields
		 */
		passwordConfirmField = new JPasswordField();
		passwordConfirmField.setBounds(182, 159, 130, 20);
		frmCreateAccount.getContentPane().add(passwordConfirmField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(182, 129, 130, 20);
		frmCreateAccount.getContentPane().add(passwordField);
		
		UserNameField = new JTextField();
		UserNameField.setBounds(182, 88, 130, 20);
		frmCreateAccount.getContentPane().add(UserNameField);
		UserNameField.setColumns(10);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(347, 0, 89, 263);
		frmCreateAccount.getContentPane().add(panel);
		panel.setLayout(null);
		
		/*
		 * creating lable to show team name
		 */
		JLabel lblAei = new JLabel("A.E.I");
		lblAei.setBounds(10, 22, 60, 20);
		lblAei.setHorizontalAlignment(SwingConstants.CENTER);
		lblAei.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		panel.add(lblAei);
		
		/*
		 * creating labels
		 */
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setForeground(new Color(0, 0, 0));
		lblCreateAccount.setBackground(new Color(192, 192, 192));
		lblCreateAccount.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.setBounds(83, 10, 229, 35);
		frmCreateAccount.getContentPane().add(lblCreateAccount);
		
		JLabel lblUsername = new JLabel("Enter Username:");
		lblUsername.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setBounds(63, 92, 109, 16);
		frmCreateAccount.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Enter Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		lblPassword.setBounds(63, 133, 109, 16);
		frmCreateAccount.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmPassword.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		lblConfirmPassword.setBounds(56, 163, 116, 16);
		frmCreateAccount.getContentPane().add(lblConfirmPassword);
		
		/*
		 * Sign up button to create the users account
		 * this button should also check the user info and
		 * make sure that there isnt already a user with the username
		 * 
		 * This also takes the user back to the login page
		 */
		JButton createAccountBtn = new JButton("Create Account");
		createAccountBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    // Opens teh login page frame
                LoginPage LoginPageFrame = new LoginPage();
                LoginPageFrame.setVisible(true);
                frmCreateAccount.dispose();
                //prints that the account was created
                System.out.println("Account Created");
			}
		});
		createAccountBtn.setBounds(122, 205, 130, 25);
		frmCreateAccount.getContentPane().add(createAccountBtn);
		
	}
	
	/*
	 * sets the visiblity of the createAccount page
	 */
    public void setVisible(boolean visible) {
        frmCreateAccount.setVisible(visible);
    }
}
