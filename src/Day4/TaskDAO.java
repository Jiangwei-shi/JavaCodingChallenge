package Day4;

import Day3.Task;

import java.util.ArrayList;
//this is TaskDAO Interface
public interface TaskDAO {
    Boolean addTask(Task task);
    boolean updateTask(int taskId, String newTitle, String newText);
    boolean deleteTask(int taskId);
    Task searchTask(int taskId);
    boolean updateAssignedTo(int taskId, String assignedTo);
    Task[] getTasks();
    ArrayList<Task> getTasksToUser(String userName);
}
