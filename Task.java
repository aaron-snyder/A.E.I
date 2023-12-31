
// Task newTask = new Task(newTaskName, startHour, startMin, endHour, endMin, amPm, days);

import java.io.Serializable;

public class Task implements Serializable {

    private boolean notNull = false;
    private String name = "";
    private int startHour;
    private int startMin;
    private int endHour;
    private int endMin;
    private String amPmStart;
    private String amPmEnd;
    private boolean[] days = new boolean[7];

    /**
     * Default constructor
     */
    public Task(){}


    /**
     * Constructor that takes in parameters to completely fill a valid task
     */
    public Task(String name, int startHour, int startMin, int endHour, int endMin, String amPmStart, String amPmEnd, boolean[] days) {
        this.name = name;
        this.startHour = startHour;
        this.startMin = startMin;
        this.endHour = endHour;
        this.endMin = endMin;
        this.amPmStart = amPmStart;
        this.amPmEnd = amPmEnd;
        this.days = days;
        this.notNull = true;
    }


    /**
     * Equals method **************** Todo
     */
    public boolean sameTask(Task task) {
        return this.name.equals(task.getName());
    }


    /**
     * Method notNull returns true if the task is an actual task, or false if it's a placeholder
     */
    public boolean notNull() {
        return notNull;
    }
    

    /**
     * Setter for null
     * @param isNull
     */
    public void setNull(boolean isNull){
        if (isNull) {
            notNull = false;
        } else {
            notNull = true;
        }
    }


    /**
     * Getter for name
     * @return name of task
     */
    public String getName(){
        return name;
    }


    /**
     * Setter for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Getter for amPmStart
     * @return start amPm 
     */
    public String getAmPmStart() {
        return amPmStart;
    }


    /**
     * Setter for amPmStart
     * @param amPmStart
     */
    public void setAmPmStart(String amPmStart) {
        this.amPmStart = amPmStart;
    }


    /**
     * Getter for amPmEnd
     * @return end amPm
     */
    public String getAmPmEnd() {
        return amPmEnd;
    }


    /**
     * Setter for amPmEnd
     * @param amPmEnd
     */
    public void setAmPmEnd(String amPmEnd) {
        this.amPmEnd = amPmEnd;
    }


    /**
     * Getter for startTime, returns formatted start time (10:30 is 1030, 5:40 is 1740 etc...)
     * @return formatted startTime
     */
    public int getStart() {

        int time = startHour * 100 + startMin;

        if (amPmStart.equals("pm")) {
            time += 1200;
        }

        return time;
    }


    /**
     * Setter for startHour
     * @param startHour
     */
    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }


    /**
     * Setter for startMin
     * @param startMin
     */
    public void setStartMin(int startMin) {
        this.startMin = startMin;
    }


    /**
     * Getter for endTime, returns formatted end time (10:30 is 1030, 5:40 is 1740 etc...)
     * @return formatted endTime
     */
    public int getEnd() {

        int time = endHour * 100 + endMin;

        if (amPmEnd.equals("pm")) {
            time += 1200;
        }

        return time;
    }


    /**
     * Setter for startHour
     * @param endHour
     */
    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }


    /**
     * Setter for startMin
     * @param endMin
     */
    public void setEndMin(int endMin) {
        this.endMin = endMin;
    }


    /**
     * Getter for days
     * @return array of what days the task occurs on
     */
    public boolean[] getDays() {
        return days;
    }


    /**
     * Setter for days
     * @param days
     */
    public void setDays(boolean[] days) {
        this.days = days;
    }


    /**
     * toString() method
     */
    public String toString(){
        String startMinString = (startMin == 0 ? "00" : "" + startMin);
        String endMinString = (endMin == 0 ? "00" : "" + endMin);
        
        return name + " from " + startHour + ":" + startMinString + amPmStart + " to " + endHour + ":" + endMinString + amPmEnd;
    }
}