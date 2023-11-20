import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class CreateTask extends Page {

	/*
	 * creating global variables
	 */
	private JFrame frmCreateTask;
	private JTextField taskField;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    
    // variabels that will hold the different hours and mins that the user can check
	private JComboBox<String> hourBox = new JComboBox<>();
	private JComboBox<String> minBox = new JComboBox<String>();
	
	// variables for the am and pm check boxes
	private JCheckBox chckbxAm = new JCheckBox("AM");
	private JCheckBox chckbxPm = new JCheckBox("PM");
	
	// variabes for the sunday-saturday check boxes
	private JCheckBox chckbxNewCheckBox = new JCheckBox("Sun");
	private JCheckBox chckbxMon = new JCheckBox("Mon");
	private JCheckBox chckbxTue = new JCheckBox("Tue");
	private JCheckBox chckbxWed = new JCheckBox("Wed");
	private JCheckBox chckbxThur = new JCheckBox("Thur");
	private JCheckBox chckbxFri = new JCheckBox("Fri");
	private JCheckBox chckbxSat = new JCheckBox("Sat");
	


	public CreateTask() {
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
        btnAddTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
		
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
		chckbxNewCheckBox.setBounds(53, 64, 51, 21);
		frmCreateTask.getContentPane().add(chckbxNewCheckBox);
		
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
		
		
		chckbxAm.setBounds(208, 157, 51, 21);
		frmCreateTask.getContentPane().add(chckbxAm);
		
		chckbxPm.setBounds(208, 180, 51, 21);
		frmCreateTask.getContentPane().add(chckbxPm);
		
		/*
		 * creating a label for "Time:"
		 */
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTime.setBounds(212, 125, 51, 20);
		frmCreateTask.getContentPane().add(lblTime);
		

		/*
		 * an array to store each hour that will be in the hourbox check box
		 * this can also be an integer instead of a string
		 */
		String[] hour = {"1","2","3","4","5","6","7","8","9","10","11","12"};

		/*
		 * adds the different hours the user can chose to the check box
		 */
		hourBox.setMaximumRowCount(12);
		hourBox.setBounds(265, 127, 51, 21);
		frmCreateTask.getContentPane().add(hourBox);
		
		// Populate the hourBox with hours from 1 to 12
		for (int i = 0; i <= 11; i++) {
		    hourBox.addItem(hour[i]);
		}
		
		/*
		 * an array to store each min incriment that will be in the minbox check box
		 * this can also be an integer instead fo a string
		 */
		String[] min = {"00", "15", "30", "45"};
		

		/*
		 * adds the different mins the user can choose to the check box
		 */
		minBox.setMaximumRowCount(3);
		minBox.setBounds(326, 127, 51, 21);
		frmCreateTask.getContentPane().add(minBox);
		
		// Populate the hourBox with hours from 1 to 12
		for (int i = 0; i <= 3; i++) {
		    minBox.addItem(min[i]);
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
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                frmCreateTask.dispose();
			}
		});
		

		
		
	}
	
	/*
	 * method format the task that is going to be added
	 * and adds the task
	 */
    private void addTask() {
        String taskText = taskField.getText();
        if (!taskText.isEmpty()) {
            // Get selected day
            String selectedDay = getSelectedDay();
            
            // Get selected hour
            String selectedHour = (String) hourBox.getSelectedItem();
            
            // Get selected min
            String selectedMin = (String) minBox.getSelectedItem();
            
            // Get selected AM/PM
            String selectedAmPm = getSelectedAmPm();
            
            // Construct the task string
            String taskString = taskText + " - " + selectedDay + ", " + selectedHour + ":" + selectedMin + " " + selectedAmPm;

            // Add the task to the list
            taskListModel.addElement(taskString);

            // Clear the task input field
            taskField.setText("");
        } else {
            JOptionPane.showMessageDialog(frmCreateTask, "Please enter a task.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    /*
     * method to get the day that is checked and return those days
     */
    private String getSelectedDay() {
        String selectedDay = "";
        if (chckbxNewCheckBox.isSelected()) selectedDay += "Sun, ";
        if (chckbxMon.isSelected()) selectedDay += "Mon, ";
        if (chckbxTue.isSelected()) selectedDay += "Tue, ";
        if (chckbxWed.isSelected()) selectedDay += "Wed, ";
        if (chckbxThur.isSelected()) selectedDay += "Thur, ";
        if (chckbxFri.isSelected()) selectedDay += "Fri, ";
        if (chckbxSat.isSelected()) selectedDay += "Sat";

        return selectedDay;
    }

    /*
     * method to return the checked am, pm or both and return them
     */
    private String getSelectedAmPm() {
        if (chckbxAm.isSelected() && chckbxPm.isSelected()) {
            return "AM/PM";
        } else if (chckbxAm.isSelected()) {
            return "AM";
        } else if (chckbxPm.isSelected()) {
            return "PM";
        } else {
            return "";
        }
    }
    
    /*
     * sets the visibilty of the create task frame
     */
    public void setVisible(boolean visible) {
        frmCreateTask.setVisible(visible);
    }

}