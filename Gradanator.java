// Nicholas Graves, CSE 142
// Assignment #4 Gradanator
// Prints out a course grade from a student's homework and 2 exam scores using user inputs

import java.util.*;

public class Gradanator {
   // Class constant for the value of sections in the overall weighted score
   public static final int SMULTIPLIER = 5;
   public static void main(String[] args) {
      Scanner console = new Scanner (System.in);
      prompt();
      double totalScore = askExams(console);
      double wScore = askHomework(console);
      printResults(wScore, totalScore);
   }
   // Prints out the intro prompt
   public static void prompt() {
      System.out.println("This program reads exam/homework scores");
      System.out.print("and reports your overall course grade.");
      System.out.println();
   }
   // Asks questions about the midterm score and compiles it for later
   public static double askExams(Scanner console) {
      double examScore = 0;
      double totalScore = 0;
      // Calculates both the midterm and final exam scores
      for (int i = 1; i <= 2; i++) {
         if (i == 1) {
            System.out.println("Midterm:");
         } else {
            System.out.println("Final:");
         }
         System.out.print("Weight (0-100)? ");
         int weight = console.nextInt();
         System.out.print("Score earned? ");
         int score = console.nextInt();
         System.out.print("Were scores shifted (1=yes, 2=no)? ");
         int shift = console.nextInt();
         int shiftscore = 0;
         if (shift <= 1) {
            System.out.print("Shift amount? ");
            shiftscore = console.nextInt();
         }
         score = score + shiftscore;
         // Caps the score earned at 100
         if (score > 100) {
            score = 100;
         }
         examScore = (score / 100.0) * weight;
         System.out.println("Total points = " + score + " / 100");
         System.out.printf("Weighted score = %.1f / " + weight, examScore);
         for (int j = 1; j <= 2; j++) {
            System.out.println();
         }
         totalScore = totalScore + examScore;
      }
      // Consists of both the midterm and final weighted scores
      return totalScore;
   }
   
   // Computes and prints out the homework grade
   public static double askHomework(Scanner console) {
      int result = 0;
      int maxFinal = 0;
      System.out.println("Homework:");
      System.out.print("Weight(0-100)? ");
      double weight = console.nextDouble();
      System.out.print("Number of assignments? ");
      int assignments = console.nextInt();
      for (int i = 1; i <= assignments; i++) {
         System.out.print("Assignment " + i  + " score and Max? ");
         int score = console.nextInt();
         int max = console.nextInt();
         result = result + score;
         maxFinal = maxFinal + max;
      }
      System.out.print("How many sections did you attend? ");
      int sections = console.nextInt();
      int sectionsFinal = sections * SMULTIPLIER;
      int total = result + sectionsFinal;
      int points = maxFinal + 30;
      System.out.println("Section points = " + sectionsFinal + " / 30");
      System.out.println("Total points = " + total + " / " + points);
      double totals = total;
      double wScore = (totals / points) * weight;
      System.out.printf("Weighted score = %.1f / " + weight, wScore);
      for (int i = 1; i <= 2; i++) {
         System.out.println();
      }
      // Returns the weighted homework score 
      return wScore;
   }
   
   // Prints the overall result from both exams and the homework
   public static void printResults(double totalScore, double wScore) {
      double percentage = wScore + totalScore;
      System.out.printf("Overall percentage = %.1f \n", percentage);
      System.out.print("Your grade will be at least: ");
      // Prints out the correct statment based on the grade earned
      if (percentage < 60.0) {
         System.out.println("0.0");
         System.out.println("Try again next time!");
      } else if (percentage < 74.99) {
         System.out.println("0.7");
         System.out.println("Work a bit harder.");
      } else if (percentage < 84.99) {
         System.out.println("2.0");
         System.out.println("That's a decent score.");
      } else {
         System.out.println("3.0");
         System.out.println("Great work!");
      }
   }
}
