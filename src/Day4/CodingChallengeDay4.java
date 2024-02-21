package Day4;

import Day3.Task;
import Day6.InvalidClientException;
import Day6.InvalidVisitorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
// is a menu of Register and login. CRUD task.the main class just hold menu.
// All the CRUD operations happen in task dao class, and Register and login happened in user class.
public class CodingChallengeDay4 {
    public static void main(String[] args) throws InvalidClientException, InvalidVisitorException, InvalidClientException, InvalidVisitorException {
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        int taskID;
        String taskTitle;
        String taskText;
        String assignedTo;
        UserDAOImpl userDAO = new UserDAOImpl();
        TaskDAOImpl taskDAO = new TaskDAOImpl();
        boolean isLoginIn = false;
        User newUser = null;

        //this is Register and login part
        while (!isLoginIn) {
            System.out.println("1. Register as a new user");
            System.out.println("2. login in");
            System.out.println("0. exit");
            System.out.println("Select your choice with Number(0~2)");
            String Choice = scanner.nextLine();
            switch (Choice) {
                case "1":
                    System.out.println("please enter the username:");
                    username = scanner.nextLine();
                    System.out.println("please enter the password:");
                    password = scanner.nextLine();
                    System.out.println("Select type of user:");
                    System.out.println("1. Client");
                    System.out.println("2. Visitor");
                    System.out.println("Enter your choice(1 or 2): ");
                    int userType = Integer.parseInt(scanner.nextLine());

                    switch (userType) {
                        case 1:
                            try {
                                newUser = new Client(username, password);
                                userDAO.addUser(newUser);
                                System.out.println("Registration successful with username: " + username);
                            }catch (InvalidClientException e){
                                System.out.println("this should be handle error Client user name start with Client_ ");
                            }
                            break;
                        case 2:
                            try {
                                newUser = new Visitor(username, password);
                                userDAO.addUser(newUser);
                                System.out.println("Registration successful with username: " + username);
                            }catch (InvalidVisitorException e){
                                System.out.println("this should be handle error Visitor user name start with Visitor_ ");
                            }
                            break;
                        default:
                            System.out.println("Invalid user type. Registration failed.");
                            return;
                    }
                    break;
                case "2":
                    System.out.println("please enter the username:");
                    username = scanner.nextLine();
                    System.out.println("please enter the password:");
                    password = scanner.nextLine();
                    if(userDAO.loginInUser(username,password)){
                        System.out.println("success!");
                        isLoginIn = true;
                    }else {
                        System.out.println("Invalid username. Registration first.");
                    }
                    break;
                case "0":
                    scanner.close();
                    return;
                default:
                    System.out.println("Only can select 0~2");
                    break;
            }
        }
       //this is task CRUD operations part
        while (true){
            if(userDAO.isClient()){
                System.out.println("welcome Client! Here is menu");
                System.out.println("1. Add a task");
                System.out.println("2. update a task");
                System.out.println("3. delete a task");
                System.out.println("4. search a task");
                System.out.println("5. reAssignee the task to another user");
                System.out.println("6. List of tasks");
                System.out.println("0. exit");
                System.out.println("Select your choice with Number(0~6)");
                int Choice = Integer.parseInt(scanner.nextLine());
                switch(Choice){
                case 1:
                    System.out.println("please enter the task title:");
                    taskTitle = scanner.nextLine();
                    System.out.println("please enter the task text:");
                    taskText = scanner.nextLine();
                    System.out.println("please enter the task assignedTo:");
                    assignedTo = scanner.nextLine();
                    Task task = new Task(taskTitle,taskText,assignedTo);
                    if(taskDAO.addTask(task)){
                        System.out.println("success!");
                    }else {
                        System.out.println("Sorry the ToDo list reach max Capacity.");
                    }
                    break;
                case 2:
                    System.out.println("please enter the task ID:");
                    taskID = Integer.parseInt(scanner.nextLine());
                    System.out.println("please enter the task Title:");
                    taskTitle = scanner.nextLine();
                    System.out.println("please enter the task Text:");
                    taskText = scanner.nextLine();
                    if(taskDAO.updateTask(taskID,taskTitle,taskText)){
                        System.out.println("success!");
                    }else {
                        System.out.println("Sorry no such task.");
                    }
                    break;
                case 3:
                    System.out.println("please enter the task ID:");
                    taskID = Integer.parseInt(scanner.nextLine())-1;
                    if(taskDAO.deleteTask(taskID)){
                        System.out.println("success!");
                    }else {
                        System.out.println("Sorry no such task.");
                    }
                    break;
                case 4:
                    System.out.println("please enter the task ID:");
                    taskID = Integer.parseInt(scanner.nextLine())-1;
                    if(taskDAO.searchTask(taskID)!=null){
                        System.out.println("Here is Day3.Task: "+taskDAO.searchTask(taskID));
                    }else {
                        System.out.println("Sorry no such task.");
                    }
                    break;
                case 5:
                    System.out.println("please enter the task ID:");
                    taskID = Integer.parseInt(scanner.nextLine());
                    System.out.println("please enter the task assigned to:");
                    assignedTo = scanner.nextLine();
                    if(taskDAO.updateAssignedTo(taskID,assignedTo)){
                        System.out.println("success!");
                    }else {
                        System.out.println("Sorry no such task.");
                    }
                    break;
                case 6:
                    System.out.println(Arrays.toString(taskDAO.getTasks()));
                    break;
                case 0:
                    scanner.close();
                    return;
                default:
                    System.out.println("Only can select 0~6");
                    break;
            }
            }else {
                System.out.println("welcome visitor! Here is menu");
                System.out.println("1. Check tasks assigned to me");
                System.out.println("0. exit");
                System.out.println("Select your choice with Number(0~1)");
                int userSelect = Integer.parseInt(scanner.nextLine());
                switch (userSelect) {
                    case 1:
                        String loginUserUsername = userDAO.getLoginUser().getUsername();
                        ArrayList<Task> tasksToUser = taskDAO.getTasksToUser(loginUserUsername);
                        if(tasksToUser.isEmpty()){
                            System.out.println("Sorry! no such task fund!");
                        }else {
                            System.out.println(tasksToUser);
                        }
                        break;
                    case 0:
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid user type. Registration failed.");
                        return;
                }
            }
        }
    }
}
