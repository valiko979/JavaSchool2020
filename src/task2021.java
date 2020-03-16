
import java.util.Scanner;

public class task2021 {

    private static int maxNum(int[] intArray) {
        int maxInt = intArray[0];
        for (int index = 1; index < intArray.length; index++) {
            if (intArray[index] > maxInt)
                maxInt = intArray[index];
        }
        return maxInt;
    }

    private static void delMax(int[] intArray, int maxInt) {
        for (int index = 0; index < intArray.length; index++) {
            if (intArray[index] == maxInt)
                intArray[index]=intArray[index]/2;
        }
    }

    private static void printArray(int[] intArray) {
        for (int i : intArray) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] ints = new int[count];
        for (int i = 0; i < count; i++) {
            ints[i] = scanner.nextInt();
        }
        int maxInt;
        for (int i = 0; i < 2; i++) {
            maxInt=maxNum(ints);
            delMax(ints,maxInt);
        }
        printArray(ints);
    }


}
