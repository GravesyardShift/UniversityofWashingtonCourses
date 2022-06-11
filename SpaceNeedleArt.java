// Nicholas Graves, CSE 142
// Prints out the space needle and base (output at bottom)
// based off class size constant

public class SpaceNeedle {
   public static final int SIZE = 4;
   public static void main(String[] args) {
      needle();
      topHalf();
      bottomHalf();
      needle();
      tower();
      topHalf();
   } 
   // Prints a vertical line of || in between horizontal spaces
   public static void needle() {
      for (int line = 1; line <= SIZE; line++) {
         for (int vert = 1; vert <= 3 * SIZE; vert++) {
            System.out.print(" ");
         }
         System.out.println("||");
      }
   }   
   // Prints out the top window sectiion of the space needle
   public static void topHalf() {
      for (int height = 1; height <= SIZE; height++) {
         for (int spaces = 1; spaces <= -3 * height + 3 * SIZE; spaces++) {
            System.out.print(" ");
         }
         System.out.print("__/");
         for (int windows = 1; windows <= 3 * height - 3; windows++) {
            System.out.print(":");
         }
         System.out.print("||");
         for (int windows = 1; windows <= 3 * height - 3; windows++) {
            System.out.print(":");
         }
         System.out.println("\\__");
      }
      System.out.print("|");
      for (int quotes = 1; quotes <= 6 * SIZE; quotes++) {
         System.out.print("\"");
      }
      System.out.println("|");
   }
   // Prints out the bottom half of the space needle
   public static void bottomHalf() {
      for (int height = 1; height <= SIZE; height++) {
         for (int spaces = 1; spaces <= 2 * height - 2; spaces++) {
            System.out.print(" ");
         }
         System.out.print("\\_");
         for (int hats = 1; hats <= - 2 * height + SIZE * 3 + 1; hats++) {
            System.out.print("/\\");
         }
         System.out.println("_/");
      }
   }
   // Prints out the tower portion of the space needle
   public static void tower() {
      for (int height = 1; height <= SIZE * SIZE; height++) {      
         for (int spaces = 1; spaces <= 2 * SIZE + 1; spaces++) {
            System.out.print(" ");
         }
         System.out.print("|");
         for (int per = 1; per <= SIZE - 2; per++) {
            System.out.print("%");
         }
         System.out.print("||");
         for (int per = 1; per <= SIZE - 2; per++) {
            System.out.print("%");
         }
         System.out.println("|");
      }
   }
}

/*  
            ||
            ||
            ||
            ||
         __/||\__
      __/:::||:::\__
   __/::::::||::::::\__
__/:::::::::||:::::::::\__
|""""""""""""""""""""""""|
\_/\/\/\/\/\/\/\/\/\/\/\_/
  \_/\/\/\/\/\/\/\/\/\_/
    \_/\/\/\/\/\/\/\_/
      \_/\/\/\/\/\_/
            ||
            ||
            ||
            ||
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         __/||\__
      __/:::||:::\__
   __/::::::||::::::\__
__/:::::::::||:::::::::\__
|""""""""""""""""""""""""| */
