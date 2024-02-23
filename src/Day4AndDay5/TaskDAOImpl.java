package Day4AndDay5;

import Day3.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
//this is TaskDAO Interface impl class
public class TaskDAOImpl implements TaskDAO{
    Task[] taskLists = new Task[5];
    @Override
    public Boolean addTask(Task task) {
        for (int i = 0; i < taskLists.length; i++) {
            if(taskLists[i]==null){
                taskLists[i] = task;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateTask(int taskId, String newTitle, String newText) {
        for (Task task : taskLists) {
            if (task.getTaskId() == taskId) {
                task.setTaskTitle(newTitle);
                task.setTaskText(newText);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteTask(int taskId) {
        if(taskId>=0 && taskId<taskLists.length){
            taskLists[taskId]=null;
            return true;
        }
        return false;
    }

    @Override
    public Task searchTask(int taskId) {
        if(taskId>=0 && taskId<taskLists.length) {
            return taskLists[taskId];
        }
        return null;
    }

    @Override
    public boolean updateAssignedTo(int taskId, String assignedTo) {
        for (Task task : taskLists) {
            if (task.getTaskId() == taskId) {
                task.setAssignedTo(assignedTo);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateCompletionDate(int taskId, String completionDate) {
        for (Task task : taskLists) {
            if (task.getTaskId() == taskId) {
                task.setCompletionData(completionDate);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateTaskAsCompleted(int taskId) {
        for (Task task : taskLists) {
            if (task.getTaskId() == taskId) {
                task.setIsCompleted(true);
                return true;
            }
        }
        return false;
    }

    @Override
    public Task[] getAllTheCompletedTasks() {
        ArrayList<Task> completedTasks = new ArrayList<>();
        for (Task task : taskLists){
            if (task.getIsCompleted()){
                completedTasks.add(task);
            }
        }
        Task[] result = new Task[completedTasks.size()];
        completedTasks.toArray(result);
        return result;
    }

    @Override
    public Task[] getTasksByIncreaseCompletionData() {
        Arrays.sort(taskLists, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                LocalDate date1 = LocalDate.parse(o1.getCompletionData());
                LocalDate date2 = LocalDate.parse(o2.getCompletionData());
                return date1.compareTo(date2);
            }
        });
        return taskLists;
    }

    @Override
    public ArrayList<Task> getTasksToUser(String userName) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task taskList : taskLists) {
            if (taskList!=null && Objects.equals(taskList.getAssignedTo(), userName)) {
                tasks.add(taskList);
            }
        }
        int size = tasks.size();
        Task[] result = new Task[size];
        tasks.toArray(result);
        return tasks;
    }
}
