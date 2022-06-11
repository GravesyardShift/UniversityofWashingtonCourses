// Nicholas Graves, CSE 142
// Assignment #5 Guessing Game
// Plays a guessing game with the user with a random number. 

import java.util.*;

public class GuessingGame {
   // Sets the maximum bound with a class constant
   public static final int MAXIMUM = 100;
   public static void main(String args[]) {
      Scanner console = new Scanner (System.in);
      Random rand = new Random();
      intro();
      int games = 1;
      int bestGuess = 1000000;  
      int totalGuesses = playGame(console, rand);
      bestGuess = Math.min(bestGuess, totalGuesses);
      boolean ask = askAgain(console);
      // Initiates the loop of playing the game
      while (ask) {
         games++;
         int guesses = playGame(console, rand);
         ask = askAgain(console);
//         bestGuess = Math.min(bestGuess, guesses);
         totalGuesses = totalGuesses + guesses;
      }    
      printResults(totalGuesses, games, bestGuess);
   }
   // Prints out the haiku
   public static void intro () {
      System.out.println("This is a fun game.");
      System.out.println("It took hours to complete.");
      System.out.println("I hope you like it.");
      System.out.println();
   }
   // Initiates the game with the user
   public static int playGame (Scanner console, Random rand) {
      int number = rand.nextInt(MAXIMUM) + 1;
      int guesses = 1;
      System.out.println("I'm thinking of a number between 1 and " + MAXIMUM + ". . .");
      System.out.print("Your guess? ");
      int guess = console.nextInt();
      while (guess != number) {  
         if (guess > number) {
            guesses++;
            System.out.println("It's lower.");
            System.out.print("Your guess? ");
            guess = console.nextInt();
         } else if (guess < number) {
            guesses++;
            System.out.println("It's higher.");
            System.out.print("Your guess? ");
            guess = console.nextInt();
         } else {
            guesses++;
         }
      }
      // Prints out congratulatory statement for 1 guess
      if (guesses == 1) {
         System.out.println("You got it right in 1 guess!");
      } else {
         System.out.println("You got it right in " + guesses + " guesses!");
      }
      return guesses;
      }
   // Asks the user if they want to play another game
   public static boolean askAgain (Scanner console) {
      System.out.print("Do you want to play again? ");
      String word = console.next();
      String response = word.toLowerCase();
      response = response.substring(0, 1);
      System.out.println();
      if (response.equals("y")) {
         return true;
      } else {
         return false;
      }
   }
   // Prints the overall results from all the games
   public static void printResults(int totalGuesses, int games, int bestGuess) {
      double guesses = totalGuesses;
      double gains = games;
      double percentage = guesses / gains;
      System.out.println("Overall results: ");
      System.out.println("Total games   = " + games);
      System.out.println("Total guesses = " + totalGuesses);
      System.out.printf("Guesses/game  = %.1f \n", percentage);
      System.out.println("Best game     = " + bestGuess);
   }
}
