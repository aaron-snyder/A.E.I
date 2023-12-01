# A.E.I
User Guide
1. Introduction:
For this project the user can create an account, login and create a task to add to their to do list. This project is meant to help people that have a busy schedule keep track of their day to day tasks.

2. Installation:
Before running the main program the user needs to have MySQL Workbench installed onto their computer. This is where the database is located and where most of the user information will be stored. 
There is a file called database_script.sql that needs to be ran inside of the MySQL Workbench program. This will create a clone of the database used inside of the source code. 
The user will also need to set the file path for the mysql-connector-j-8.0.33.jar so the java files can connect to the database. 

3. Usage:
The user will need to create an account to gain access to the main page. 
After they complete the create account form they will need to login where they will then be redirected to the main GUI. 
The main page will display the current day's schedule(this will be blank for first time users or for users that haven’t added a task to the current day of the week). 
On the main page the user has the option to press three buttons: The add task button, save button, and logout button. 
The add task button will redirect to the final page where the user can set a name for the tasks as well as an end and start time. 
The times go from 12 am- 12 am and they have 45 minute intervals. 
After all fields have been filled out the user will click the add task button and the task will be stored into a temporary storage array. 
When the user goes back to the main page they can click the save button to save their schedule into the database or the logout button to forfeit any changes made. 

4. Features:
Feature 1: Create an account. 
Feature 2: Saving tasks to a database.
Feature 3: Select specific days and time blocks for task.
Feature 4: View task for the current day.


5. Troubleshooting:
If the database is not connecting make sure the URL, Username, and Password match the same credentials you set during the MySQL installation. 
Make sure to run the database_srcipt.sql file in MySQL if you are running into a database or table not found error. 
Usernames have to be unique and are case sensitive, so if you cannot create an account make sure to change the username and try again.
If you are sure the username you are using to create an account is unique make sure that the password and confirm password field match.
If you cannot login make sure you have created an account first and if you are still running into issues make sure the Username and password match when you first created an account.
If you cannot add a task make sure all fields are completely and correctly filled out before clicking the add task button.
If the main screen is not displaying information you may not have any tasks added to the current day.
