/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: LinkedBagCSC220JavaDriver
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

//
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
//

package assignment03PartA;

public class LinkedBagCSC220JavaDriver {

    public static void main(String[] args) {
        System.out.println("=== LINKED BAG 220 JAVA ==========================================================");
        System.out.println("[+] Creating a CSC220 LinkedBag...");
        PrimaryDataStructureBagInterface<String> csc220Bag = new LinkedBag<>();
        testAdd(csc220Bag);
        testRemoveAllOccurrences(csc220Bag);
        System.out.println("=== LINKED BAG 220 JAVA ==========================================================");
    }

    private static void displayBag(PrimaryDataStructureBagInterface<String> aBag) {
        System.out.print("[>] The bag now contains " + aBag.getCurrentSize() + " string(s): \t");
        Object[] bagArray = aBag.toArray();
        for (Object bagArray1 : bagArray) {
            System.out.print(bagArray1 + " ");
        }
        System.out.println();
    }

    private static void testRemoveAllOccurrences(PrimaryDataStructureBagInterface<String> aBag) {
        // Removing all occurrences of the given entries from a bag
        System.out.println("[+] Creating... a 2D test array with the below contents: \t");
        String[][] testArray = {
                {"A", "A", "A", "A", "A", "A"},
                {"B", "A", "Bb", "B", "Bb", "B"},
                {"C", "B", "_", "A"},
                {"n", "u", "l", "l"}
        };

        for (String[] row : testArray) {
            System.out.print("\t\t\t\t\t");
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println("");
        }

        aBag.removeAllOccurrences(testArray);
        displayBag(aBag);
    }

    private static void testAdd(PrimaryDataStructureBagInterface<String> aBag) {
        // Adding strings
        String[] contentsOfBag = {
                "A", "_", "_", "G", "Bb", "A", "_", "u", "n",
                "o", "A", "o", "d", "Bb", "A", "A", "l", "l"
        };
        System.out.print("[+] Adding.... these items to the bag: \t");
        for (String entry : contentsOfBag) {
            aBag.add(entry);
            System.out.print(entry + " ");
        }
        System.out.println();

        displayBag(aBag);
    }
}
