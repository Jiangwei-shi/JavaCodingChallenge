package Day3;
//this is Dao class. Include addTask,updateTask,deleteTask,searchTask,updateAssignedTo and getTasks methods
public class Dao {
    private final static Task[] taskLists = new Task[5];

    public Boolean addTask(Task task) {
        for (int i = 0; i < taskLists.length; i++) {
            if(taskLists[i]==null){
                taskLists[i] = task;
                return true;
            }
        }
        return false;
    }

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

    public boolean deleteTask(int taskId) {
        if(taskId>=0 && taskId<taskLists.length){
            taskLists[taskId]=null;
            return true;
        }
        return false;
    }

    public Task searchTask(int taskId) {
        if(taskId>=0 && taskId<taskLists.length) {
            return taskLists[taskId];
        }
        return null;
    }

    public boolean updateAssignedTo(int taskId, String assignedTo) {
        for (Task task : taskLists) {
            if (task.getTaskId() == taskId) {
                task.setAssignedTo(assignedTo);
                return true;
            }
        }
        return false;
    }

    public Task[] getTasks() {
        return taskLists;
    }
}
