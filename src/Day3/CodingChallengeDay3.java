package Day3;

import java.util.*;

public class CodingChallengeDay3 {
    //is a menu of CRUD task.the main class just hold menu. All the CRUD operations happen in dao class
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
            System.out.println("Select your choice with Number(0~6)");
            String Choice = scanner.nextLine();
            switch(Choice){
                case "1":
                    System.out.println("please enter the task title:");
                    taskTitle = scanner.nextLine();
                    System.out.println("please enter the task text:");
                    taskText = scanner.nextLine();
                    System.out.println("please enter the task assignedTo:");
                    assignedTo = scanner.nextLine();
                    Task task = new Task(taskTitle,taskText,assignedTo,"1.1",false);
                    if(dao.addTask(task)){
                        System.out.println("success!");
                    }else {
                        System.out.println("Sorry the ToDo list reach max Capacity.");
                    }
                    break;
                case "2":
                    System.out.println("please enter the task ID:");
                    taskID = Integer.parseInt(scanner.nextLine());
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
                        System.out.println("Here is Day3.Task: "+dao.searchTask(taskID));
                    }else {
                        System.out.println("Sorry no such task.");
                    }
                    break;
                case "5":
                    System.out.println("please enter the task ID:");
                    taskID = Integer.parseInt(scanner.nextLine());
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
                    System.out.println("Only can select 0~6");
                    break;
            }
        }
    }
}
