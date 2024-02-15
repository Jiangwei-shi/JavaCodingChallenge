import java.util.*;

class Task {
    private static int lastTaskId = 0;
    private final int taskId;
    private String taskTitle;
    private String taskText;
    private String assignedTo;

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
                "taskId=" + taskId +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskText='" + taskText + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                '}';
    }
}

class Dao {
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


public class CodingChallengeDay3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dao dao = new Dao();
        int taskID;
        String taskTitle;
        String taskText;
        String assignedTo;
        while (true){
            System.out.println("1. Add a task");
            System.out.println("2. update a task");
            System.out.println("3. delete a task");
            System.out.println("4. search a task");
            System.out.println("5. reAssignee the task to another user");
            System.out.println("6. List of tasks");
            System.out.println("0. exit");
            System.out.println("Select your choice with Number");
            String Choice = scanner.nextLine();
            switch(Choice){
                case "1":
                    System.out.println("please enter the task title:");
                    taskTitle = scanner.nextLine();
                    System.out.println("please enter the task text:");
                    taskText = scanner.nextLine();
                    System.out.println("please enter the task assignedTo:");
                    assignedTo = scanner.nextLine();
                    Task task = new Task(taskTitle,taskText,assignedTo);
                    if(dao.addTask(task)){
                        System.out.println("success!");
                    }else {
                        System.out.println("Sorry the ToDo list reach max Capacity.");
                    }
                    break;
                case "2":
                    System.out.println("please enter the task ID:");
                    taskID = Integer.parseInt(scanner.nextLine())-1;
                    System.out.println("please enter the task Title:");
                    taskTitle = scanner.nextLine();
                    System.out.println("please enter the task Text:");
                    taskText = scanner.nextLine();
                    if(dao.updateTask(taskID,taskTitle,taskText)){
                        System.out.println("success!");
                    }else {
                        System.out.println("Sorry no such task.");
                    }
                    break;
                case "3":
                    System.out.println("please enter the task ID:");
                    taskID = Integer.parseInt(scanner.nextLine())-1;
                    if(dao.deleteTask(taskID)){
                        System.out.println("success!");
                    }else {
                        System.out.println("Sorry no such task.");
                    }
                    break;
                case "4":
                    System.out.println("please enter the task ID:");
                    taskID = Integer.parseInt(scanner.nextLine())-1;
                    if(dao.searchTask(taskID)!=null){
                        System.out.println("Here is Task: "+dao.searchTask(taskID));
                    }else {
                        System.out.println("Sorry no such task.");
                    }
                    break;
                case "5":
                    System.out.println("please enter the task ID:");
                    taskID = Integer.parseInt(scanner.nextLine())-1;
                    System.out.println("please enter the task assigned to:");
                    assignedTo = scanner.nextLine();
                    if(dao.updateAssignedTo(taskID,assignedTo)){
                        System.out.println("success!");
                    }else {
                        System.out.println("Sorry no such task.");
                    }
                    break;
                case "6":
                    System.out.println(Arrays.toString(dao.getTasks()));
                    break;
                case "0":
                    scanner.close();
                    return;
                default:
                    System.out.println("Only can select 0~5");
                    break;
                final:
            }
        }
    }
}
