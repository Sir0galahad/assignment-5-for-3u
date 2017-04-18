/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a5;

import java.util.Scanner;

/**
 *
 * @author millc9988
 */
public class A5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int right = 0;
        int wrong = 0;
        int jerk = 0;
        //starting the game
        System.out.println("hello welcome to hangman");
        System.out.println("player one please enter in a word that is 8 letters or less");
        //creating two strings one of which we will hide in the next step
        String word = in.nextLine();
        //creating a new stringbuilder
        StringBuilder nathan = new StringBuilder(word);
        int length = word.length();
        String unhidden = word;
        //replacing the letters in the word with dashes
        for (int i = 0; i < word.length();) {
            nathan.setCharAt(i, '-');
            i++;
        }
        //clearing the screen
        for (int i = 0; i < 25; i++) {
            System.out.println("");
        }
        //telling them off for using a word that is too long
        if (length > 8) {
            System.out.println("Don't be a jerk its not fair to use really long words.");
            jerk++;
        }

        //start of the game
        while ((wrong < 5) && (right < length) && (jerk < 1)) {
            int q = 0;
            // showing the start of the gallows
            if (wrong == 0) {
                System.out.println("----------");
                System.out.println("|        |");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            }
            //showing the word with their current correctly guessed letters and asking for a guess
            System.out.println(nathan);
            System.out.println("Please enter your guess");
            //next letter typed is your guess
            String guess = in.nextLine();
            guess = guess.toLowerCase();
            char gues = guess.charAt(0);
            //comparing guess against each letter in the word and if it correct replace the dash with the letter
            for (int i = 0; i < length;) {
                char letter = unhidden.charAt(i);

                if (gues == letter) {
                    System.out.println("Congrats you guessed one right.");
                    right++;
                    q++;
                    nathan.setCharAt(i, gues);
                }
                i++;
            }

            //updating the gallows with how many they got wrong
            if (q < 1) {
                wrong++;
                System.out.println("Oh no. That isn't right");
                if (wrong == 1) {
                    System.out.println("----------");
                    System.out.println("|        |");
                    System.out.println("|       ( )");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                }
                if (wrong == 2) {
                    System.out.println("----------");
                    System.out.println("|        |");
                    System.out.println("|       ( )");
                    System.out.println("|        |");
                    System.out.println("|");
                    System.out.println("|");
                }
                if (wrong == 3) {
                    System.out.println("----------");
                    System.out.println("|        |");
                    System.out.println("|       ( )");
                    System.out.println("|       \\|/");
                    System.out.println("|");
                    System.out.println("|");
                }
                if (wrong == 4) {
                    System.out.println("----------");
                    System.out.println("|        |");
                    System.out.println("|       ( )");
                    System.out.println("|       \\|/");
                    System.out.println("|        |");
                    System.out.println("|");
                }
                if (wrong == 5) {
                    System.out.println("----------");
                    System.out.println("|        |");
                    System.out.println("|       ( )");
                    System.out.println("|       \\|/");
                    System.out.println("|        |");
                    System.out.println("|       / \\");
                }
            }

        }
        //telling them they won
        if (right == length) {
            System.out.println(nathan);
            System.out.println("Congrats you won!!!!");

            //telling them they lost and telling them what the word was
        } else {
            System.out.println("You lost please reset the program and try again.");
            System.out.println("The word was " + unhidden);
        }

    }
}
