// Nicholas Graves, CSE 142 BA
// 01/17/2016
//
// Prints out a Lambda flag which is commented at the bottom

public class AsciiArt {
   public static void main(String[] args) {
      topBorder();
      tip();
      topBody();
      body();
      bases();
      bottomBorder();
   }
   public static void topBorder() {
      System.out.print(" ");
      for (int line = 1; line <= 69; line++) {
         System.out.print("_");
      }
      System.out.println();
   }
   public static void tip() {
      System.out.print("|");
      for (int spaces = 1; spaces <= 33; spaces++) {
         System.out.print("~");
      }
      System.out.print("/\\");
      for (int spaces = 1; spaces <= 34; spaces++) {
         System.out.print("~");
      }
      System.out.println("|");
   }
   public static void topBody() {
      for (int vert = 1; vert <= 5; vert++) {
         System.out.print("|");
         for (int spaces = 1; spaces <= 33 - vert; spaces++) {
            System.out.print("~");
         }
         System.out.print("/");
         for (int hashtag = 1; hashtag <= 2 * vert; hashtag++) {
            System.out.print("#");
         }
         System.out.print("\\");
         for (int spaces = 1; spaces <= 34 - vert; spaces++) {
            System.out.print("~");
         }
         System.out.println("|");
      }
   }
   public static void body() {
      for (int vert = 1; vert <= 18; vert++) {
         System.out.print("|");
         for (int spaces = 1; spaces <= 28 - vert; spaces++) {
            System.out.print("~");
         }
         System.out.print("/");
         for (int hashes = 1; hashes <=3; hashes++) {
            System.out.print("#");
         }
         System.out.print("/");
         for (int spaces = 1; spaces <= 2 * vert - 2; spaces++) {
            System.out.print("~");
         }
         System.out.print("\\");
         for (int hashess = 1; hashess <= 7; hashess++) {
            System.out.print("#");
         }
         System.out.print("\\");
         for (int spaces = 1; spaces <= 29 - vert; spaces++) {
            System.out.print("~");
         }
         System.out.println("|");
      }
   }
   public static void bases() {
      for (int vert = 1; vert <= 2; vert++) {
         System.out.print("|");
         for (int spaces = 1; spaces <= 5; spaces++) {
            System.out.print("~");
         }
         System.out.print("<");
         for (int hashtags = 1; hashtags <= 12; hashtags++) {
            System.out.print("#");
         }
         System.out.print(">");
         for (int spacess = 1; spacess <= 27; spacess++) {
            System.out.print("~");
         }
         System.out.print("<");
         for (int hashtagss = 1; hashtagss <= 15; hashtagss++) {
            System.out.print("#");
         }
         System.out.print(">");
         for (int spacesss = 1; spacesss <= 6; spacesss++) {
            System.out.print("~");
         }
         System.out.println("|");
      }
   } 
   public static void bottomBorder() {
      System.out.print("|");
      for (int line = 1; line <= 69; line++) {
         System.out.print("_");
      }
      System.out.println("|");
   } 
}

/*
 _____________________________________________________________________
|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/\~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/##\~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/####\~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/######\~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/########\~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~~~~~~~~~~~~/##########\~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~~~~~~~~~~~/###/\#######\~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~~~~~~~~~~/###/~~\#######\~~~~~~~~~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~~~~~~~~~/###/~~~~\#######\~~~~~~~~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~~~~~~~~/###/~~~~~~\#######\~~~~~~~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~~~~~~~/###/~~~~~~~~\#######\~~~~~~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~~~~~~/###/~~~~~~~~~~\#######\~~~~~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~~~~~/###/~~~~~~~~~~~~\#######\~~~~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~~~~/###/~~~~~~~~~~~~~~\#######\~~~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~~~/###/~~~~~~~~~~~~~~~~\#######\~~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~~/###/~~~~~~~~~~~~~~~~~~\#######\~~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~~/###/~~~~~~~~~~~~~~~~~~~~\#######\~~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~~/###/~~~~~~~~~~~~~~~~~~~~~~\#######\~~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~~/###/~~~~~~~~~~~~~~~~~~~~~~~~\#######\~~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~~/###/~~~~~~~~~~~~~~~~~~~~~~~~~~\#######\~~~~~~~~~~~~~~~|
|~~~~~~~~~~~~~/###/~~~~~~~~~~~~~~~~~~~~~~~~~~~~\#######\~~~~~~~~~~~~~~|
|~~~~~~~~~~~~/###/~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\#######\~~~~~~~~~~~~~|
|~~~~~~~~~~~/###/~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\#######\~~~~~~~~~~~~|
|~~~~~~~~~~/###/~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\#######\~~~~~~~~~~~|
|~~~~~<############>~~~~~~~~~~~~~~~~~~~~~~~~~~~<###############>~~~~~~|
|~~~~~<############>~~~~~~~~~~~~~~~~~~~~~~~~~~~<###############>~~~~~~|
|_____________________________________________________________________|

*/