package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static String randomString () {
        Random random = new Random();
        // Create 8 character long array.
        char[] ch = new char[8];

        // Create letters by length of array (8)
        for (int i = 0; i < ch.length; i++) {
            int ranNum = random.nextInt(25) + 97;
            ch[i] = ((char)(ranNum));
        }

        // Create a String using the 8 characters.
        return new String(ch);
    }

    public static void isWordPossible (String randomWord, String userWord) {
        // Create array to count how many times each letter appears.
        int[] randomWordCounter = new int[8];
        for (int i = 0; i <= randomWord.length() - 1; i++) {
            int counter = 0;
            for (int x = 0; x <= randomWord.length() - 1; x++) {
                if (randomWord.toLowerCase().charAt(i) == randomWord.toLowerCase().charAt(x)) {
                    counter++;
                    randomWordCounter[i] = counter;
                }
            }
        }

        int[] userWordCounter = new int[userWord.length()];
        for (int i = 0; i <= userWord.length() -1; i++) {
            int counter = 0;
            for (int x = 0; x <= userWord.length() -1; x++) {
                if (userWord.charAt(i) == userWord.charAt(x)) {
                    counter ++;
                    userWordCounter[i] = counter;
                }
            }
        }

        // Check if the letter is used more than allowed, using for loop.
        for (int i = 0; i <= userWord.length() -1; i++) {
            int eligalChar = 1;
            for (int x = 0; x <= randomWord.length() -1; x++) {
                if (userWord.charAt(i) == randomWord.charAt(x)) {
                    eligalChar = 0;
                    if (userWordCounter[i] > randomWordCounter[x]) {
                        System.err.println("Word is not possible, you used a letter too many times!");
                        return;
                    }
                }
            }
            if (eligalChar == 1) {
                System.err.println("You used a letter not included in the ones you were given!");
                return;
            }
        }
        System.out.println("Your word: " + userWord + " is possible to make!");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your letters are: ");
        String word = randomString(); // Get random String of 8 letters
        System.out.println(word);
        System.out.print("Create a word by only using letters only one time\nType word: ");
        String userWord = scanner.next();
        isWordPossible(word, userWord);
    }
}