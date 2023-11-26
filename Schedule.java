import java.io.Serializable;
import java.util.*;

public class Schedule implements Serializable {

    private HashMap<Integer, Task> schedule = new HashMap<>();

    public Schedule() {
        // Null task to fill default schedule with
        Task nullTask = new Task();

        // For loop to instantiate schedule following [100, 115, 130, 145, 200, 215] format]
        for (int time = 100; time < 2445; time += 15) {
            schedule.put(time, nullTask);
            String check = Integer.toString(time);
            if (check.contains("45")) {
                time += 45;
            }
        }
    }

    /**
     * Method checkTime takes in two times start and end, and checks if the schedule is free between those two times
     */
    public boolean checkTime(int start, int end) {
        for (Map.Entry<Integer, Task> entry : schedule.entrySet()) {
            int key = entry.getKey();
            if (key >= start && key <= end) {
                if (!entry.getValue().notNull()){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method addTask takes in three parameters, start, end and task, fills schedule between start and end with task
     */
    public void addTask(int start, int end, Task task) {
        for (Map.Entry<Integer, Task> entry : schedule.entrySet()) {
            int key = entry.getKey();
            if (key >= start && key <= end) {
                schedule.put(key, task);
            }
        }
    }

}