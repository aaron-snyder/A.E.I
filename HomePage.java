
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

	/**
	 * Fields
	 */
	private int currentUserID;
	private Schedule[] currentSchedule;

	/*
	 * global variables that are used
	 */
	private JFrame frmHomePage;
    private JList<String> taskList;
	
	/**
	 * Homepage constructor for userID and schedule passed
	 */
	public HomePage(int userID, Schedule[] schedule) {
		currentUserID = userID;
		currentSchedule = schedule;
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
		JButton btnAddTask = new JButton("Add Task");
		btnAddTask.addActionListener(homePage);
		btnAddTask.setBounds(270, 55, 117, 21);
		frmHomePage.getContentPane().add(btnAddTask);
		




		/*
		 * creating the save button
		 * the save button will save the task list to the database ********************************************************************************
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
		btnLogout.addActionListener(homePage);
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
		
		// Determine the day of the week to display schedule for current day
		LocalDate today = LocalDate.now();
		DayOfWeek day = today.getDayOfWeek();
		switch (day) {
			case SUNDAY:
				System.out.println(currentSchedule[0]);

				break;
		
			case MONDAY:
				System.out.println(currentSchedule[1]);
				break;

			case TUESDAY:
				System.out.println(currentSchedule[2]);
				break;
		
			case WEDNESDAY:
				System.out.println(currentSchedule[3]);
				break;

				case THURSDAY:
				System.out.println(currentSchedule[4]);
				break;
		
			case FRIDAY:
				System.out.println(currentSchedule[5]);
				break;

			case SATURDAY:
				System.out.println(currentSchedule[6]);
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

	/**
	 * Method displayAddTaskPage opens the AddTask page
	 */
	public void displayAddTaskPage() {
		CreateTask AddTaskFrame = new CreateTask(currentUserID, currentSchedule);
        AddTaskFrame.setVisible(true);
        frmHomePage.dispose();
	}

	/**
	 * Method closeProgram, saves users info and closes the program
	 */
	public void closeProgram() {

		// THIS SHOULD BE WHAT THE SAVE BUTTON DOES
		// AND THE SAVE BUTTON SHOULD SAVE ALL THE USERS DATA TO THE DATABASE
		// Close the program
		System.exit(0);
	}

	/**
     * Listener for home page.
     */
    ActionListener homePage = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Obtain button pressed in form of string.
            String action = e.getActionCommand();

            // Switch to catch which button was pressed and perform appropriate functions.
            switch (action) {

                case "Add Task":
                    displayAddTaskPage();
                    break;

                case "Save and Logout":
                    closeProgram();
                }
            }
        };	
}