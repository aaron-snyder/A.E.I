import javax.swing.*;
import java.awt.event.*;

public class Listeners {

    /**
     * Main method, contains all listeners
     * Each page has its own listener, parses command and calls methods accordingly
     * Merge listeners with main file when group meets
     */
    public static void main(String[] args) {

        /**
         * Temporary instantiations for buttons and boxes so error messages aren't thrown.
         */
        // Login page:
        JButton loginButton, goToSignUpButton;
        JTextField usernameTextField, passwordTextField;

        // Signup page:
        JButton createAccountButton;
        JTextField createUsernameTextField, createPasswordTextField, checkPasswordTextField;

        // Home page:
        JButton calendarButton, addNewTaskButton, saveAndLogoutButton;

        // AddTask page:
        JTextField newTaskTextField, startHourTextField, startMinuteTextField, endHourTextField, endMinuteTextField;
        JCheckBox sunCheckBox, monCheckBox, tueCheckBox, wedCheckBox, thuCheckBox, friCheckBox, satCheckBox, amCheckBox, pmCheckBox;

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

        

        

        /**
         * Listener for addTask page.
         */
        ActionListener addTaskPage = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /**
                 *
                    JCheckBox sunCheckBox, monCheckBox, tueCheckBox, wedCheckBox, thuCheckBox, friCheckBox, satCheckBox, amCheckBox, pmCheckBox;
                 */
                // Obtain all info from input fields to create new task.
                String newTaskName = newTaskTextField.getText();
                int startHour = startHourTextField.getText();
                int startMin = startMinuteTextField.getText();
                int endHour = endHourTextField.getText();
                int endMin = endMinuteTextField.getText();
                String amPm;
                boolean[] days = new boolean[7];
                Arrays.fill(days, false);

                if (amCheckBox.isSelected()) {
                    amPm = "am";
                } else {
                    amPm = "pm";
                }

                // TRY TO FIND MORE EFFICIENT WAY TO DO THIS!
                if (sunCheckBox.isSelected()) {
                    days[0] = true;
                }

                if (monCheckBox.isSelected()) {
                    days[1] = true;
                }

                if (tueCheckBox.isSelected()) {
                    days[2] = true;
                }

                if (wedCheckBox.isSelected()) {
                    days[3] = true;
                }
                
                if (thuCheckBox.isSelected()) {
                    days[4] = true;
                }

                if (friCheckBox.isSelected()) {
                    days[5] = true;
                }

                if (satCheckBox.isSelected()) {
                    days[6] = true;
                }

                // Create new task.
                Task newTask = new Task(newTaskName, startHour, startMin, endHour, endMin, amPm, days);

                // Check if new task is compatible, if true, add to schedule, else display error message.
                if (checkNewTask(newTask)) {
                    schedule.addTask(newTask);
                    displayNewTaskSuccesMessage();
                } else {
                    displayNewTaskErrorMessage();
                }
            }
        };
    }
}