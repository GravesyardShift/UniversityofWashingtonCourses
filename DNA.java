// Nicholas Graves, CSE 142
// Assignment #7 DNA
// Takes an input file of a dna sequence and prints statistics about it to an output file (output example at bottom)

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

/*
Region Name: cure for cancer protein
Nucleotides: ATGCCACTATGGTAG
Nuc. Counts: [4, 3, 4, 4]
Total Mass%: [27.3, 16.8, 30.6, 25.3] of 1978.8
Codons List: [ATG, CCA, CTA, TGG, TAG]
Is Protein?: YES

Region Name: captain picard hair growth protein
Nucleotides: ATGCCAACATGGATGCCCGATATGGATTGA
Nuc. Counts: [9, 6, 8, 7]
Total Mass%: [30.7, 16.8, 30.5, 22.1] of 3967.5
Codons List: [ATG, CCA, ACA, TGG, ATG, CCC, GAT, ATG, GAT, TGA]
Is Protein?: YES

Region Name: bogus protein
Nucleotides: CCATT-AATGATCA-CAGTT
Nuc. Counts: [6, 4, 2, 6]
Total Mass%: [32.3, 17.7, 12.1, 29.9] of 2508.1
Codons List: [CCA, TTA, ATG, ATC, ACA, GTT]
Is Protein?: NO

Region Name: michael jordan mad hops protein
Nucleotides: ATGAG-ATC-CGTGATGTGGG-AT-CCTA-CT-CATTAA
Nuc. Counts: [9, 6, 8, 10]
Total Mass%: [24.6, 13.5, 24.5, 25.3] of 4942.9
Codons List: [ATG, AGA, TCC, GTG, ATG, TGG, GAT, CCT, ACT, CAT, TAA]
Is Protein?: YES

Region Name: paris hilton phony protein
Nucleotides: ATGC-CAACATGGATGCCCTAAG-ATATGGATTAGTGA
Nuc. Counts: [12, 6, 9, 9]
Total Mass%: [32.6, 13.4, 27.3, 22.6] of 4974.3
Codons List: [ATG, CCA, ACA, TGG, ATG, CCC, TAA, GAT, ATG, GAT, TAG, TGA]
Is Protein?: YES

Region Name: jimi hendrix guitar talent protein
Nucleotides: ATGATAATTAGTTTTAATATCAGA-CTGTAA
Nuc. Counts: [12, 2, 4, 12]
Total Mass%: [40.0, 5.5, 14.9, 37.1] of 4049.5
Codons List: [ATG, ATA, ATT, AGT, TTT, AAT, ATC, AGA, CTG, TAA]
Is Protein?: NO

Region Name: admiral grace murray hopper protein
Nucleotides: ATGC-AATT--GC-----TCGA--------TTAG
Nuc. Counts: [5, 3, 4, 6]
Total Mass%: [17.0, 8.4, 15.2, 18.9] of 3964.1
Codons List: [ATG, CAA, TTG, CTC, GAT, TAG]
Is Protein?: NO

Region Name: tyler durden's brain protein
Nucleotides: ATGATACCTATGAGTAATGTGGACCATATCCAAACTATAGGCATTGTCGGACCAACGATCGATTGGTTATACTGA
Nuc. Counts: [24, 14, 16, 21]
Total Mass%: [32.9, 15.8, 24.6, 26.7] of 9843.8
Codons List: [ATG, ATA, CCT, ATG, AGT, AAT, GTG, GAC, CAT, ATC, CAA, ACT, ATA, GGC, ATT, GTC, GGA, CCA, ACG, ATC, GAT, TGG, TTA, TAC, TGA]
Is Protein?: YES

Region Name: mini me growth hormone
Nucleotides: ATGGGACGCTGA
Nuc. Counts: [3, 2, 5, 2]
Total Mass%: [24.8, 13.6, 46.3, 15.3] of 1633.4
Codons List: [ATG, GGA, CGC, TGA]
Is Protein?: NO

Region Name: Nyan Cat protein
Nucleotides: CAT-CAT-CAT-CAT-CAT-CAT-CAT-CAT-CAT-CAT
Nuc. Counts: [10, 10, 0, 10]
Total Mass%: [29.3, 24.1, 0.0, 27.1] of 4613.4
Codons List: [CAT, CAT, CAT, CAT, CAT, CAT, CAT, CAT, CAT, CAT]
Is Protein?: NO */
