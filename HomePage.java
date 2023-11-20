
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.*;

import javax.swing.JScrollPane;



public class HomePage extends Page {

	/*
	 * global variables that are used
	 */
	private JFrame frmHomePage;
    private JList<String> taskList;
	private int currentUserID;
	private Schedule[] currentSchedule;

	/**
	 * Create the application.
	 */
	public HomePage(String username, String password) {
		currentUserID = connector.getUserID(username, password);
		currentSchedule = connector.getSchedule(currentUserID);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*
		 * creating the main frame 
		 */
		frmHomePage = new JFrame();
		frmHomePage.getContentPane().setBackground(new Color(192, 192, 192));
		frmHomePage.setBackground(new Color(192, 192, 192));
		frmHomePage.setTitle("Home Page");
		frmHomePage.setBounds(100, 100, 451, 308);
		frmHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomePage.getContentPane().setLayout(null);
		
		/*
		 * creating the label that shows the date
		 */
		JLabel lblLogin = new JLabel("Date");
		lblLogin.setBounds(29, 10, 105, 35);
		lblLogin.setForeground(new Color(0, 0, 0));
		lblLogin.setBackground(new Color(192, 192, 192));
		lblLogin.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		frmHomePage.getContentPane().add(lblLogin);
		
	
		

		/*
		 * creating a scroll pane that show the tasks for the day
		 */
        JScrollPane tasksPanel = new JScrollPane(taskList);
        tasksPanel.setBounds(10, 55, 192, 205);
		frmHomePage.getContentPane().add(tasksPanel);
		tasksPanel.setViewportView(taskList);

;
		/*
		 * creating the add task button.
		 * the add task button takes the user to the create task panel
		 * where the user will be able to create and add a new task
		 */
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
		
		/*
		 * creating the save button
		 * the save button will save the task list to the database
		 */
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
		
		/*
		 * creating the logout button
		 * the logout button will log the user out of
		 * their account and take them to the login page
		 */
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
	 
	/*
	 * sets the homepage visibility to show the page
	 */
    public void setVisible(boolean visible) {
    	frmHomePage.setVisible(visible);

    }

	/**
	 * Method fillTask fills taskList with users tasks
	 */
	public void fillTask() {
		
		// Use currentUserID and connector to access schedules
		LocalDate today = LocalDate.now();
		DayOfWeek day = today.getDayOfWeek();
		switch (day) {
			case SUNDAY:
				System.out.println(currentSchedule[0]);
				break;
		
			case MONDAY:
				System.out.println(currentSchedule[1]);
				break;
			default:
				break;
		}
	}

	/**
	 * Method fill day fills taskTextArea with current day
	 */
	public void fillDay(Schedule schedule) {
		
	}
}