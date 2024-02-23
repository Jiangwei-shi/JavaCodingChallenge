package Day4AndDay5;

import Day3.Task;

import java.util.ArrayList;
//this is TaskDAO Interface
public interface TaskDAO {
    Boolean addTask(Task task);
    boolean updateTask(int taskId, String newTitle, String newText);
    boolean deleteTask(int taskId);
    Task searchTask(int taskId);
    boolean updateAssignedTo(int taskId, String assignedTo);
    boolean updateCompletionDate(int taskId, String completionDate);
    boolean updateTaskAsCompleted(int taskId);
    Task[] getAllTheCompletedTasks();
    Task[] getTasksByIncreaseCompletionData();
    ArrayList<Task> getTasksToUser(String userName);
}
