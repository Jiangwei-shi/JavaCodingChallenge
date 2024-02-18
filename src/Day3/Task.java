package Day3;
//this is Task class.
public class Task {
    private static int lastTaskId = 0;
    private final int taskId;
    private String taskTitle;
    private String taskText;
    private String assignedTo;
//constructor
    public Task(String taskTitle, String taskText, String assignedTo) {
        this.taskId = ++lastTaskId;
        this.taskTitle = taskTitle;
        this.taskText = taskText;
        this.assignedTo = assignedTo;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getTaskText() {
        return taskText;
    }

    public String getAssignedTo() {
        return assignedTo;
    }
    public void setTaskTitle(String newTitle) {
        this.taskTitle = newTitle;
    }

    public void setTaskText(String newText) {
        this.taskText = newText;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + getTaskId() +
                ", taskTitle='" + getTaskTitle() + '\'' +
                ", taskText='" + getTaskText() + '\'' +
                ", assignedTo='" + getAssignedTo() + '\'' +
                '}';
    }
}
