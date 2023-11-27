
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.List;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.*;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;



public class HomePage extends Page {

	/**
	 * Fields
	 */
	private int currentUserID;
	private Schedule[] currentSchedule = new Schedule[7];

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


		for (int i = 0; i <= 2445; i += 15) {
			System.out.println("time=" + i + ", task=" + schedule[1].schedule.get(i).toString());

			String check = Integer.toString(i);
            if (check.contains("45")) {
                i += 40;
            }
		}
		

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
		 * the save button will save the task list to the database 
		 */
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(homePage);
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

		fillTask();
	}
	 
	/*
	 * sets the homepage visibility to show the page
	 */
    public void setVisible(boolean visible) {
    	frmHomePage.setVisible(visible);

    }

	/**
	 * getFormattedTaskList method takes in index for day and formats that days schedule appropriately
	 */
	public ArrayList<String> getFormattedTaskList(int day) {
		System.out.println("In getFormattedTaskList (" + day + ")");
		ArrayList<String> returnList = new ArrayList<>();
		Task position = new Task();
		Task currentTask = new Task();
		for (int time = 0; time <= 2445; time += 15) {
			//System.out.println("In for loop Time = " + time);
			position = currentSchedule[day].getTaskAt(time);
			if (!position.sameTask(currentTask) && position.notNull()) {
				System.out.println("Return list adding: " + position.toString());
				returnList.add(position.toString());
			}
			currentTask = position;

			String check = Integer.toString(time);
			if (check.contains("45")) {
				time += 40;
			}
		}

		System.out.println("Exited for loop");
		
		for (String s : returnList) {
			System.out.print("in formattedTaskList loop ");
			System.out.println(s);
		}
		return returnList;
	}

	/**
	 * Method fillTask fills taskList with users tasks
	 */
	public void fillTask() {

		System.out.println("Entered fillTask()");

		DefaultListModel<String> listModel = new DefaultListModel<>();
		JScrollPane tasksPanel = new JScrollPane();
		// Determine the day of the week to display schedule for current day
		LocalDate today = LocalDate.now();
		DayOfWeek day = today.getDayOfWeek();
		ArrayList<String> test = new ArrayList<>();
		
		switch (day) {
			case SUNDAY:
				test = getFormattedTaskList(0);
				break;
		
			case MONDAY:
				test = getFormattedTaskList(1);
				break;

			case TUESDAY:
				test = getFormattedTaskList(2);
				break;
		
			case WEDNESDAY:
				test = getFormattedTaskList(3);
				break;

			case THURSDAY:
				test = getFormattedTaskList(4);
				break;
		
			case FRIDAY:
				test = getFormattedTaskList(5);
				break;

			case SATURDAY:
				test = getFormattedTaskList(6);
				break;

			default:
				System.out.println("Default case reached in fillTask()");
				break;
		}

		for (String s : test) {
			System.out.println(s);
			listModel.addElement(s);
		}
		listModel.addElement("Test");

		taskList = new JList<>(listModel);
		taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tasksPanel = new JScrollPane(taskList);
		tasksPanel.setBounds(10, 55, 192, 205);
		frmHomePage.getContentPane().add(tasksPanel);
		tasksPanel.setViewportView(taskList);

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
	 * Method save, updates database with users current schedule info
	 */
	public void save() {

	}

	/**
	 * Method closeProgram, saves users info and closes the program
	 */
	public void closeProgram() {

		LoginPage LoginPageFrame = new LoginPage();
        LoginPageFrame.setVisible(true);
        frmHomePage.dispose();
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

                case "Save":
					save();
                    break;

				case "Logout":
					closeProgram();
					break;
                }
            }
        };	
}