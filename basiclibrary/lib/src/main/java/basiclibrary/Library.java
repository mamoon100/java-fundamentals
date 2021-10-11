/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package basiclibrary;

import java.util.Arrays;

public class Library {

    public static void main(String[] args) {
        System.out.println("Debug your code and test here");

    }

    public static int[] roll(int trails) {
        int[] diceRoll = new int[trails];
        for (int i = 0; i < trails; i++) {
            diceRoll[i] = (int) (Math.random() * 6 + 1);
        }
        return diceRoll;
    }

    public static boolean containsDuplicates(Integer[] arr) {
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (Arrays.asList(temp).contains(arr[i])) {
                return true;
            }
            temp[i] = arr[i];

        }
        return false;
    }

    public static float calculatingAverages(int[] arr) {
        float sum = 0;
        for (float num : arr) {
            sum += num;
        }
        return Math.round((sum / arr.length) * 100.0) / 100.0F; // round to the second decimal
    }

    public static int[] arraysOfArraysAverages(int[][] arr) {
        double min = Double.POSITIVE_INFINITY;
        int[] minArray = new int[arr[0].length];
        for (int[] ints : arr) {
            double avg = calculatingAverages(ints);
            if (avg < min) {
                min = avg;
                minArray = ints;
            }
        }
        return minArray;
    }

}
