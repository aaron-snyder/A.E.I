import java.io.Serializable;
import java.util.*;

public class Schedule implements Serializable {

    public HashMap<Integer, Task> schedule = new HashMap<>();

    public Schedule() {
        // Null task to fill default schedule with
        Task nullTask = new Task();

        // For loop to instantiate schedule following [100, 115, 130, 145, 200, 215.... 2445] format]
        for (int time = 0; time <= 2445; time += 15) {
            schedule.put(time, nullTask);
            String check = Integer.toString(time);
            if (check.contains("45")) {
                time += 40;
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
                if (entry.getValue().notNull()){
                    System.out.println(entry.getValue());
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * Method addTask takes in three parameters, start, end and task, fills schedule between start and end with task
     */
    public void addTask(Task task) {

        System.out.println("addTask(" + task.getName() + "), start=" + task.getStart() + ", end=" + task.getEnd());

        for (int i = task.getStart(); i <= task.getEnd(); i += 15) {
            schedule.put(i, task);
            String check = Integer.toString(i);
			if (check.contains("45")) {
				i += 40;
			}
            System.out.println("Task: " + task.getName() + " Start: " + task.getStart() + " End: " + task.getEnd());
        }
    }

    // Getter for a specific index in the schedule
    public Task getTaskAt(int index) {
        return schedule.get(index);
    }
}