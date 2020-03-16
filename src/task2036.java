
import java.util.Scanner;

public class task2036 {
    private static boolean containsLetter(char[] letters, char c) {
        for (char letter : letters) {
            if (letter == c) return true;

        }
        return false;
    }

    private static boolean notBadWord(String word) {
        char[] charArray = word.toCharArray();
        char[] letters = {'a', 'e', 'i', 'o', 'u', 'y'};
        int badLength = 0;
        for (char c : charArray) {
            if (containsLetter(letters, c)) {
                badLength++;
            } else badLength = 0;
            if (badLength >= 3) return false;
        }
        return true;
    }

    private static void printArray(String[] stringArray) {
        for (String s : stringArray) {
            if (notBadWord(s)) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] words = new String[count];
        for (int i = 0; i < count; i++) {
            words[i] = scanner.next();
        }

        printArray(words);
    }


}
