// Nicholas Graves, CSE 142 BA
// 27 Feb. 2016
// Assignment #7 DNA
// Takes an input file of a dna sequence and prints statistics about it to an output file

import java.io.*;
import java.util.*;
import java.awt.*;

public class DNA {
   public static final int CODON_MINIMUM = 5;
   public static final double CGMASS = 30.0;
   public static final int UNIQUE = 4;
   public static final int CODON_NUCLEO = 3;
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(System.in);
      Scanner output = new Scanner(System.in);
      prompt();
      String fileUse = userInput(input);
      File f = new File(fileUse);
      Scanner readFile = new Scanner(f);
      String outputFile = userOutput(output);
      PrintStream out = new PrintStream(new File(outputFile));
      while (readFile.hasNextLine()) {
         String sequence = identifiers(readFile, out);
         int[] junkToo = counts(sequence, out);
         double totalMass = calculateTMass(junkToo);
         double combinedProtein = percentage(totalMass, junkToo, out);
         String noDashCodon = codonList(sequence);
         String[] list = printCodon(noDashCodon, out);
         protein(noDashCodon, combinedProtein, out);
         out.println();
      }
   }
   
   // Prints out the prompt informing the user
   public static void prompt() {
      System.out.println("This program reports information about DNA");
      System.out.println("nucleotide sequences that may encode proteins.");
   }
   
   // Records the user response for the input file
   public static String userInput(Scanner input) {
      System.out.print("Input file name? ");
      String inputResponse = input.nextLine();
      return inputResponse;
   }
   
   // Records the user response for the output file
   public static String userOutput(Scanner output) {
      System.out.print("Output file name? ");
      String outputResponse = output.nextLine();
      return outputResponse;
   }
   
   // Reads and prints out the region name and nucleotide sequence
   public static String identifiers(Scanner readFile, PrintStream out) {
      String regionName = readFile.nextLine();
      out.println("Region Name: " + regionName);
      String nucleo = readFile.nextLine();
      String upperNucleo = nucleo.toUpperCase();
      out.println("Nucleotides: " + upperNucleo);
      return upperNucleo;
   }
   
   // Counts the amount of a,c,g,t's in the given sequence
   public static int[] counts(String sequence, PrintStream out) {
      int[] nucCounts = new int[4];
      int[] nucCountsJunk = new int[5];
      int junk = 0;
      for (int i = 0; i < sequence.length(); i++) {
         char letter = sequence.charAt(i);
         if (letter == 'A') {
            nucCounts[0]++;
            nucCountsJunk[0]++;
         } else if (letter == 'C') {
            nucCounts[1]++;
            nucCountsJunk[1]++;
         } else if (letter == 'G') {
            nucCounts[2]++;
            nucCountsJunk[2]++;
         } else if (letter == 'T') {
            nucCounts[3]++;
            nucCountsJunk[3]++;
         } else {
            nucCountsJunk[4]++;
         }
      }
      out.println("Nuc. Counts: " + Arrays.toString(nucCounts));
      return nucCountsJunk;
   }
   
   // calculates the total mass including the junk
   public static double calculateTMass(int[] junkToo) {
      double adenine = junkToo[0] * 135.128;
      double cytosine = junkToo[1] * 111.103;
      double guanine = junkToo[2] * 151.128;
      double thymine = junkToo[3] * 125.107;
      double junk = junkToo[4] * 100;
      double massFinal = adenine + cytosine + guanine + thymine + junk;
      return massFinal;
   }
   
   // Calculates the nucleotide and total mass percentages
   public static double percentage(double totalMass, int[] junkToo, PrintStream out) {
      double[] percentages = new double[4];
      percentages[0] = Math.round((junkToo[0] * 135.128 / totalMass) * 1000.0) / 10.0;
      percentages[1] = Math.round((junkToo[1] * 111.103 / totalMass) * 1000.0) / 10.0;
      percentages[2] = Math.round((junkToo[2] * 151.128 / totalMass) * 1000.0) / 10.0;
      percentages[3] = Math.round((junkToo[3] * 125.107 / totalMass) * 1000.0) / 10.0;
      totalMass = Math.round(totalMass * 10.0) / 10.0;
      out.println("Total Mass%: " + Arrays.toString(percentages) + " of " + totalMass);
      double proteinPercentage = percentages[1] + percentages[2];
      return proteinPercentage;
   }
   
   // Reprints the sequence of nucleotides without the dashes
   public static String codonList(String sequence) {
      String noDashes = "";
      for (int i = 0; i < sequence.length(); i++) {
         char nucleotide = sequence.charAt(i);
         if (nucleotide != '-') {
            noDashes += nucleotide;
         }
      }
      return noDashes;
   }
   
   // sorts and prints out the codons list
   public static String[] printCodon(String noDashCodon, PrintStream out)
         throws FileNotFoundException {
      String[] splitCodons = new String[noDashCodon.length() / 3];
      for (int i = 0; i < noDashCodon.length(); i++) {
         splitCodons[i / 3] = "";
      }
      for (int i = 0; i < noDashCodon.length(); i++) {
         char letter = noDashCodon.charAt(i);
         splitCodons[i / 3] += letter;
      }
      out.println("Codons List: " + Arrays.toString(splitCodons));
      return splitCodons;
   }
   
   // Checks whether a codon list is a protein
   public static void protein(String noDashCodon, double combinedProtein, PrintStream out) {
      out.print("Is Protein?: ");
      if (noDashCodon.startsWith("ATG")) {
         if (noDashCodon.endsWith("TAA") || noDashCodon.endsWith("TAG") || 
               noDashCodon.endsWith("TGA")) {
            if (noDashCodon.length() >= 15) {
               if (combinedProtein >= 30.0) {
                  out.println("YES");
               } else {
                  notAProtein(out);
               }
            } else {
               notAProtein(out);
            }   
         } else {
            notAProtein(out);
         }
      } else {
         notAProtein(out);
      }
   }
   
   // Prints out no for nonproteins
   public static void notAProtein(PrintStream out) {
      out.println("NO");
   }
}