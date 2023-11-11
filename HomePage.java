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
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.Scrollbar;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JSlider;
import java.awt.ScrollPane;
import java.awt.Point;



public class HomePage {

	private JFrame frmHomePage;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmHomePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHomePage = new JFrame();
		frmHomePage.getContentPane().setBackground(new Color(192, 192, 192));
		frmHomePage.setBackground(new Color(192, 192, 192));
		frmHomePage.setTitle("Home Page");
		frmHomePage.setBounds(100, 100, 672, 495);
		frmHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomePage.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Date");
		lblLogin.setBounds(29, 10, 105, 35);
		lblLogin.setForeground(new Color(0, 0, 0));
		lblLogin.setBackground(new Color(192, 192, 192));
		lblLogin.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		frmHomePage.getContentPane().add(lblLogin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 187, 181);
		frmHomePage.getContentPane().add(scrollPane);
		
	
		
		JPanel panel = new JPanel();
		panel.setBounds(262, 44, 200, 179);
		frmHomePage.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		
		textField = new JTextField();
		textField.setBounds(67, 10, 87, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(67, 39, 87, 19);
		panel.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(67, 97, 87, 19);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(67, 126, 87, 19);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(67, 155, 87, 19);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(67, 184, 87, 19);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(67, 213, 87, 19);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(67, 242, 87, 19);
		panel.add(textField_8);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(12, 13, 45, 13);
		panel.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(67, 68, 87, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		

	}
}
