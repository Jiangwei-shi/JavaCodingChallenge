package Day7Assignment3;

import java.util.Scanner;

public class HandlingException {
    public static void main(String[] args) {
        System.out.println("please enter an integer value to represent the size of Array");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        int[] array = new int[length];
        System.out.println("please enter "+length+" numbers, use space to split them");
        String string = scanner.nextLine();
        String[] elements = string.split(" ");
        try {
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(elements[i]);
            }
            int sum = 0;
            for (int j : array) {
                sum = sum + j;
            }
            System.out.println(sum);
        } catch (NumberFormatException e){
            System.out.println("Sorry you can only input numbers");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("you have at least enter "+length+" numbers");
        }
    }
}
