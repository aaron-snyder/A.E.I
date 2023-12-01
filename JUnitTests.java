import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class JUnitTests {

    DatabaseConnector connector = new DatabaseConnector();

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    CreateAccount createAccount = new CreateAccount();
    CreateTask createTask = new CreateTask();
    Task task = new Task();
    
    @Test
    public void testCheckNewAccount() {
        connector.createUser("TestUser", "TestUserPassword");
        char[] placeHoldPassword = new char[3];
        placeHoldPassword[0] = 'a';
        placeHoldPassword[1] = 'a';
        placeHoldPassword[2] = 'a';
        assertEquals(true, createAccount.checkNewAccount("TestUser1", placeHoldPassword, placeHoldPassword));
    }

    @Test
    public void testSameTask() {
        Task task1 = new Task();
        Task task2 = task1;
        Task task3 = new Task();
        task3.setName("Not task1");

        assertEquals(true, task1.sameTask(task2));
        assertEquals(false, task1.sameTask(task3));
    }

    @Test
    public void testNullTask() {
        Task nullTask = new Task();
        assertEquals(false, nullTask.notNull());
        nullTask.setNull(false);
        assertEquals(true, nullTask.notNull());
    }

    @Test
    public void testGetSetName() {
        Task testTask = new Task();
        testTask.setName("FirstName");
        assertEquals("FirstName", testTask.getName());

    }

    @Test
    public void testStartEndTimes() {
        Task timeTask = new Task();
        timeTask.setStartHour(4);
        timeTask.setStartMin(30);
        timeTask.setAmPmStart("am");
        timeTask.setAmPmEnd("pm");
        timeTask.setEndHour(5);
        timeTask.setEndMin(30);
        assertEquals(430, timeTask.getStart());
        assertEquals(1730, timeTask.getEnd());
    }

    @Test
    public void testGetSetDays() {
        Task daysTask = new Task();
        boolean[] days = {true, true, false, false, true, true, false};
        daysTask.setDays(days);
        assertEquals(days, daysTask.getDays());
    }
}