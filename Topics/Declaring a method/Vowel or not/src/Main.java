import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean isVowel(char letter) {
        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        return vowels.contains(Character.toLowerCase(letter));
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}