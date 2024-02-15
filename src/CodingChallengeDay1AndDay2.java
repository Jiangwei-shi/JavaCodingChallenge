import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CodingChallengeDay1AndDay2 {
    static String[] taskLists = new String[5];
    public static String[] getRepeatedTasks(){
        HashSet<String> set = new HashSet<>();
        ArrayList<String> repeatedList = new ArrayList<>();
        for (String s : taskLists) {
            if (set.contains(s)) {
                repeatedList.add(s);
            } else {
                set.add(s);
            }
        }
        String[] result = new String[repeatedList.size()];
        return repeatedList.toArray(result);
    }
    public static Boolean addTask(String string){
        for (int i = 0; i < taskLists.length; i++) {
            if(taskLists[i]==null){
                taskLists[i] = string;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("please input your name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        while (true){
            System.out.println("Welcome "+name+"! And Here is the menu");
            System.out.println("1. Adding task");
            System.out.println("2. See all the tasks in increasing order");
            System.out.println("3. See all the tasks in decreasing order");
            System.out.println("4. See repeated tasks");
            System.out.println("5. update the task");
            System.out.println("6. delete the task");
            System.out.println("7. search a task");
            System.out.println("0. exit");
            System.out.println("Select your choice with Number");
            String Choice = scanner.nextLine();
            switch(Choice){
                case "1":
                    System.out.println("please enter the task name:");
                    String taskName = scanner.nextLine();
                    Boolean addTask = addTask(taskName);
                    if(addTask){
                        System.out.println("Success!");
                    }else {
                        System.out.println("Sorry the list is full!");
                    }
                    break;
                case "2":
                    for (int i = 0; i < taskLists.length; i++) {
                        System.out.println((i+1)+". "+taskLists[i]);
                    }
                    break;
                case "3":
                    for (int i = taskLists.length-1; i >= 0; i--) {
                        System.out.println((taskLists.length-i)+". "+taskLists[i]);
                    }
                    break;
                case "4":
                    System.out.println(Arrays.toString(getRepeatedTasks()));
                    break;
                case "5":
                    System.out.println("please enter the task you want update(number):");
                    int updateIndex = Integer.parseInt(scanner.nextLine());
                    System.out.println("please input the new task:");
                    String updateInformation = scanner.nextLine();
                    taskLists[updateIndex-1] = updateInformation;
                    System.out.println("Success!");
                    break;
                case "6":
                    System.out.println("please enter the task you want delete(number):");
                    int deleteIndex = Integer.parseInt(scanner.nextLine());
                    taskLists[deleteIndex-1] = null;
                    System.out.println("Success!");
                    break;
                case "7":
                    System.out.println("please enter the task you want search(number):");
                    int searchIndex = Integer.parseInt(scanner.nextLine());
                    System.out.println(taskLists[searchIndex-1]);
                    break;
                case "0":
                    scanner.close();
                    return;
                default:
                    System.out.println("Only can select 0~7");
                    break;
            }
        }
    }
}
