import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class CreateTask {

	/**
	 * Fields
	 */
	private int currentUserID;
	private Schedule[] currentSchedule;


	/**
	 * Creating global variables
	 */
	private JFrame frmCreateTask;
	private JTextField taskField;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    
    // Variables that will hold the different hours and mins that the user can check
	private JComboBox<String> hourBoxStart = new JComboBox<>();
	private JComboBox<String> minBoxEnd = new JComboBox<>();
	private JComboBox<String> hourBoxEnd = new JComboBox<>();
	private JComboBox<String> minBoxStart = new JComboBox<>();
	
	// Variables for the AM and PM check boxes
	private JCheckBox chckbxAm = new JCheckBox("AM");
	private JCheckBox chckbxPm = new JCheckBox("PM");
	
	// Variables for the Sunday-Saturday check boxes
	private JCheckBox chckbxSun = new JCheckBox("Sun");
	private JCheckBox chckbxMon = new JCheckBox("Mon");
	private JCheckBox chckbxTue = new JCheckBox("Tue");
	private JCheckBox chckbxWed = new JCheckBox("Wed");
	private JCheckBox chckbxThur = new JCheckBox("Thur");
	private JCheckBox chckbxFri = new JCheckBox("Fri");
	private JCheckBox chckbxSat = new JCheckBox("Sat");
	
	private final JLabel lblStart = new JLabel("Start:");
	private final JLabel lblEnd = new JLabel("End:");
	


	public CreateTask(int userID, Schedule[] schedule) {
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
		frmCreateTask = new JFrame();
		frmCreateTask.getContentPane().setBackground(new Color(192, 192, 192));
		frmCreateTask.setBounds(100, 100, 450, 300);
		frmCreateTask.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateTask.getContentPane().setLayout(null);
		
		/*
		 * creating the input panel
		 */
		JPanel inputPanel = new JPanel();
		inputPanel.setBounds(10, 10, 416, 31);
		frmCreateTask.getContentPane().add(inputPanel);
		
		/*
		 * Jlabel for "task:"
		 */
		JLabel lblTask = new JLabel("Task:");
		inputPanel.add(lblTask);
		
		/*
		 * creating a new task field
		 */
		taskField = new JTextField();
		taskField.setColumns(20);
		inputPanel.add(taskField);
		
		/*
		 * creating the add task button
		 * this button will save all the information 
		 * that the user chose and add it
		 */
		JButton btnAddTask = new JButton("Add Task");
		inputPanel.add(btnAddTask);
		
        // ActionListener for the "Add Task" button
        btnAddTask.addActionListener(addTaskPage);
		
        // List to display tasks
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
		
        /*
         * Scroll pane for the task list
         * this pane should show the formatted task that the user added
         */
        JScrollPane scrollPane = new JScrollPane(taskList);
		scrollPane.setBounds(10, 110, 192, 140);
		frmCreateTask.getContentPane().add(scrollPane);
		scrollPane.setViewportView(taskList);
		
		JLabel lblNewLabel = new JLabel("Day:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 62, 37, 20);
		frmCreateTask.getContentPane().add(lblNewLabel);
		
		/*
		 * adding the different check boxes to the frame
		 */
		chckbxSun.setBounds(53, 64, 51, 21);
		frmCreateTask.getContentPane().add(chckbxSun);
		
		chckbxMon.setBounds(106, 64, 51, 21);
		frmCreateTask.getContentPane().add(chckbxMon);
		
		chckbxTue.setBounds(159, 64, 51, 21);
		frmCreateTask.getContentPane().add(chckbxTue);
		
		chckbxWed.setBounds(212, 64, 51, 21);
		frmCreateTask.getContentPane().add(chckbxWed);

		chckbxThur.setBounds(265, 64, 51, 21);
		frmCreateTask.getContentPane().add(chckbxThur);
		
		chckbxFri.setBounds(318, 64, 51, 21);
		frmCreateTask.getContentPane().add(chckbxFri);
		
		chckbxSat.setBounds(371, 64, 51, 21);
		frmCreateTask.getContentPane().add(chckbxSat);
		
		
		chckbxAm.setBounds(208, 190, 51, 21);
		frmCreateTask.getContentPane().add(chckbxAm);
		
		chckbxPm.setBounds(208, 213, 51, 21);
		frmCreateTask.getContentPane().add(chckbxPm);
		
		/*
		 * creating a label for "Time:"
		 */
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTime.setBounds(212, 106, 51, 20);
		frmCreateTask.getContentPane().add(lblTime);
		

		/*
		 * an array to store each hour that will be in the hourbox check box
		 * this can also be an integer instead of a string
		 */
		String[] hour = {"1","2","3","4","5","6","7","8","9","10","11","12"};

		/*
		 * adds the different hours the user can chose to the check box
		 */
		hourBoxStart.setMaximumRowCount(12);
		hourBoxStart.setBounds(265, 127, 51, 21);
		frmCreateTask.getContentPane().add(hourBoxStart);
		
		// Populate the hourBox with hours from 1 to 12
		for (int i = 0; i <= 11; i++) {
		    hourBoxStart.addItem(hour[i]);
		    hourBoxEnd.addItem(hour[i]);
		}
		
		/*
		 * an array to store each min incriment that will be in the minbox check box
		 * this can also be an integer instead fo a string
		 */
		String[] min = {"00", "15", "30", "45"};
		

		/*
		 * adds the different mins the user can choose to the check box
		 */
		minBoxEnd.setMaximumRowCount(3);
		minBoxEnd.setBounds(326, 157, 51, 21);
		frmCreateTask.getContentPane().add(minBoxEnd);
		
		// Populate the hourBox with hours from 1 to 12
		for (int i = 0; i <= 3; i++) {
			minBoxStart.addItem(min[i]);
		    minBoxEnd.addItem(min[i]);
		}
		

		/*
		 * creating jlabels for hour and min
		 */
		JLabel lblHour = new JLabel("Hour");
		lblHour.setHorizontalAlignment(SwingConstants.CENTER);
		lblHour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHour.setBounds(265, 106, 51, 20);
		frmCreateTask.getContentPane().add(lblHour);
		
		JLabel lblMin = new JLabel("Min");
		lblMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMin.setBounds(326, 106, 51, 20);
		frmCreateTask.getContentPane().add(lblMin);
		
		/*
		 * back button to take the user back to the 
		 * Homepage panel
		 */
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(351, 230, 70, 20);
		frmCreateTask.getContentPane().add(btnBack);
		hourBoxEnd.setMaximumRowCount(12);
		hourBoxEnd.setBounds(265, 157, 51, 21);
		
		frmCreateTask.getContentPane().add(hourBoxEnd);
		minBoxStart.setMaximumRowCount(12);
		minBoxStart.setBounds(326, 127, 51, 21);
		
		frmCreateTask.getContentPane().add(minBoxStart);
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStart.setBounds(212, 131, 51, 20);
		
		frmCreateTask.getContentPane().add(lblStart);
		lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnd.setBounds(212, 158, 51, 20);
		
		frmCreateTask.getContentPane().add(lblEnd);
		btnBack.addActionListener(addTaskPage);
	}

    /*
     * sets the visibilty of the create task frame
     */
    public void setVisible(boolean visible) {
        frmCreateTask.setVisible(visible);
    }

	public void displayNewTaskSuccessMessage() {
		JOptionPane.showMessageDialog(frmCreateTask, "Task created successfully!", "Success", JOptionPane.PLAIN_MESSAGE);
	}

	public void displayNewTaskErrorMessage() {
		JOptionPane.showMessageDialog(frmCreateTask, "You already have tasks in that time slot!", "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Method to display Home Page again
	 */
	public void displayHomePage(){
		HomePage homePage = new HomePage(currentUserID, currentSchedule);
        homePage.setVisible(true);
        frmCreateTask.dispose();
	}

	/**
	 * Method to check if the task is valid with weeks schedule
	 */
	public boolean checkTask(Task task){
		for (int index = 0; index < 6; index++) {
			if (task.getDays()[index] && !currentSchedule[index].checkTime(task.getStart(), task.getEnd())) {
				return false;
			}
		}
		return true;
    }

	/**
     * Listener for addTask page.
     */
    ActionListener addTaskPage = new ActionListener() {
         @Override
        public void actionPerformed(ActionEvent e) {

            /**
             * JCheckBox sunCheckBox, monCheckBox, tueCheckBox, wedCheckBox, thuCheckBox, friCheckBox, satCheckBox, amCheckBox, pmCheckBox;
             */
            // Obtain all info from input fields to create new task.
            String newTaskName = taskField.getText();
            int startHour = hourBoxStart.getSelectedIndex();
            int startMin = minBoxEnd.getSelectedIndex();
            int endHour = hourBoxEnd.getSelectedIndex();
            int endMin = minBoxEnd.getSelectedIndex();
            String amPm;
            boolean[] days = new boolean[7];
            Arrays.fill(days, false);

            if (chckbxPm.isSelected()) {
                amPm = "pm";
            } else {
                amPm = "am";
            }

            // Check each check box, if selected, set corresponding day to true
            if (chckbxSun.isSelected()) {
                days[0] = true;
            }

            if (chckbxMon.isSelected()) {
                days[1] = true;
            }

            if (chckbxTue.isSelected()) {
                days[2] = true;
            }

            if (chckbxWed.isSelected()) {
                days[3] = true;
            }
                
            if (chckbxThur.isSelected()) {
               days[4] = true;
            }

            if (chckbxFri.isSelected()) {
                days[5] = true;
            }

            if (chckbxSat.isSelected()) {
                days[6] = true;
            }

            // Create new task.
            Task newTask = new Task(newTaskName, startHour, startMin, endHour, endMin, amPm, days);

            // Check if new task is compatible, if true, add to schedule, else display error message.
			if (checkTask(newTask)) {
				for (int index = 0; index < 6; index++) {
					if (newTask.getDays()[index] && currentSchedule[index].checkTime(newTask.getStart(), newTask.getEnd())) {
						
					}
				}
				displayNewTaskSuccessMessage();
			} else {
				displayNewTaskErrorMessage();
			}
    	}
	};
}