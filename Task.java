
// Task newTask = new Task(newTaskName, startHour, startMin, endHour, endMin, amPm, days);

import java.io.Serializable;

public class Task implements Serializable {

    private boolean notNull = false;
    private String name;
    private int startHour;
    private int startMin;
    private int endHour;
    private int endMin;
    private String amPm;
    private boolean[] days = new boolean[7];

    /**
     * Default constructor
     */
    public Task(){}

    /**
     * Constructor that takes in parameters to completely fill a valid task
     */
    public Task(String name, int startHour, int startMin, int endHour, int endMin, String amPm, boolean[] days) {
        this.name = name;
        this.startHour = startHour;
        this.startMin = startMin;
        this.endHour = endHour;
        this.endMin = endMin;
        this.amPm = amPm;
        this.days = days;
    }

    /**
     * Method notNull returns true if the task is an actual task, or false if it's a placeholder
     */
    public boolean notNull() {
        return notNull;
    }
    
    /**
     * Getters and Setters
     */
    public void setNull(boolean isNull){
        if (isNull) {
            notNull = false;
        } else {
            notNull = true;
        }
    }

    public int getStart() {
        return -1;
    }

    public int getEnd() {
        return -1;
    }

    public boolean[] getDays() {
        return days;
    }
}