package edu.miracosta.cs113.change;

import java.util.ArrayList;
import java.util.List;

/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */
public class ChangeCalculatorRecursive extends ChangeCalculator {

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    public static List<String> calculateRecursive(int cents) {
        // TODO:
        // Implement a recursive solution following the given documentation.
        List<String> combinations = new ArrayList<>();

        calculateRecursive(cents, 0, 0, 0, 0, combinations);

        return combinations;
    }

    private static void calculateRecursive(int remaining, int quarters, int dimes, int nickels,
                                           int pennies, List<String> combinations) {

        if (remaining == 0) {
            String combination = quarters + "q " +  dimes + "d " + nickels + "n " + pennies + "p ";
            if  (!combinations.contains(combination)) {
                combinations.add(combination);
            }

        }

        if (remaining >= 25) {
            calculateRecursive(remaining - 25, quarters + 1, dimes, nickels, pennies, combinations);
        }
        if (remaining >= 10) {
            calculateRecursive(remaining - 10, quarters, dimes + 1, nickels, pennies, combinations);
        }
        if (remaining >= 5) {
            calculateRecursive(remaining - 5, quarters, dimes, nickels + 1, pennies, combinations);
        }
        if (remaining >= 1) {
            calculateRecursive(remaining - 1, quarters, dimes, nickels, pennies + 1, combinations);
        }


    }
}

