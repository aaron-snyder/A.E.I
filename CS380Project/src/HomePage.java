
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;



public class HomePage {

	private JFrame frmHomePage;
    private JList<String> taskList;

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
		frmHomePage.setBounds(100, 100, 451, 308);
		frmHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomePage.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Date");
		lblLogin.setBounds(29, 10, 105, 35);
		lblLogin.setForeground(new Color(0, 0, 0));
		lblLogin.setBackground(new Color(192, 192, 192));
		lblLogin.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		frmHomePage.getContentPane().add(lblLogin);
		
	
		

        JScrollPane tasksPanel = new JScrollPane(taskList);
        tasksPanel.setBounds(10, 55, 192, 205);
		frmHomePage.getContentPane().add(tasksPanel);
		tasksPanel.setViewportView(taskList);

;
		
		JButton btnAddTask = new JButton("Add task");
		btnAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                CreateTask AddTaskFrame = new CreateTask();
                AddTaskFrame.setVisible(true);
                frmHomePage.dispose();
			}
		});
		
		btnAddTask.setBounds(270, 55, 117, 21);
		frmHomePage.getContentPane().add(btnAddTask);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                LoginPage LoginPageFrame = new LoginPage();
                LoginPageFrame.setVisible(true);
                frmHomePage.dispose();
			}
		});
		btnSave.setBounds(270, 100, 117, 21);
		frmHomePage.getContentPane().add(btnSave);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	
		    	// THIS SHOULD BE WHAT THE SAVE BUTTON DOES
		    	// AND THE SAVE BUTTON SHOULD SAVE ALL THE USERS DATA TO THE DATABASE
		        // Close the program
		        System.exit(0);
		    }
		});
		btnLogout.setBounds(270, 144, 117, 21);
		frmHomePage.getContentPane().add(btnLogout);
		

	}
	 
    public void setVisible(boolean visible) {
    	frmHomePage.setVisible(visible);
    }
}
