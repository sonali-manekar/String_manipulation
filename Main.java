import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first string:");
        String str1 = scanner.nextLine();

        System.out.println("Enter the second string:");
        String str2 = scanner.nextLine();

        boolean result = areAnagrams(str1, str2);
        System.out.println(result);

        scanner.close();
    }

    public static boolean areAnagrams(String str1, String str2) {
        // If lengths are different, they can't be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create a map to store character frequencies
        Map<Character, Integer> charCount = new HashMap<>();

        // Count characters in the first string
        for (char c : str1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Decrement counts for characters in the second string
        for (char c : str2.toCharArray()) {
            // If character doesn't exist or count becomes negative, not an anagram
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }

        // If all counts are zero, strings are anagrams
        return true;
    }
}