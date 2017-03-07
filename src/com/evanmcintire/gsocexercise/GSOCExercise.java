package com.evanmcintire.gsocexercise;

import java.util.Scanner;

public class GSOCExercise {
    public static void main(String[] args) {
        runningMedian();

    }

    /**
     * Test driver for the Queue
     * Reads in an int for the amount of commands
     * Then, reads that many commands and either puts or pops with each command
     */
    public static void queueInput() {
        //Init our scanner, and read how many values we need to read
        Scanner scan = new Scanner(System.in);
        int inputAmount = scan.nextInt();
        scan.nextLine();

        Queue<Integer> queue = new Queue<Integer>();
        String line = "";

        /* Processes all our commands
         * If there's more than 1 int on a line, we add the second to the queue
         * Otherwise, we pop the head and print it
         */
        for(int i = 0; i < inputAmount; i++) {
            line = scan.nextLine();
            String[] vals = line.split(" ");
            if(vals.length == 2) {
                queue.put(Integer.parseInt(vals[1]));
            } else {
                System.out.println(queue.pop());
            }
        }
    }

    /**
     * Test driver and code for "Running median"
     * Finds the median of a sorted set, either the middle element or
     * the average of the middle two elements.
     *
     * It should be noted that a TreeSet would be a cleaner solution for this,
     * but in the spirit of the exercise, an array is used.
     */
    public static void runningMedian() {
        Scanner scan = new Scanner(System.in);
        int inputAmount = scan.nextInt();

        int[] data = new int[0];

        scan.nextLine();

        /*
         * Read and process all the requested data
         */
        for(int i = 0; i < inputAmount; i++) {
            data = insertSorted(data, scan.nextInt());
            scan.nextLine();
            /*
            * Prints the "running median" of the data set
            */
            if(data.length % 2 == 0) {
                System.out.println((data[data.length / 2]
                                 + data[(data.length / 2) - 1])/2f);
            } else {
                System.out.println((float)data[(data.length / 2)]);
            }
        }

    }

    /**
     * Inserts an element into an array, growing the size by one.
     * The array is sorted in ascending order.
     *
     * @param arr The array to be inserted into
     * @param val The value to be inserted
     * @return Array with the new element in it
     */
    private static int[] insertSorted(int[] arr, int val) {
        /*
         * If the array is of length 0, just simply return an array with just val
         */
        if(arr.length == 0) {
            return new int[] { val };
        }

        int newArr[] = new int[arr.length + 1];
        boolean inserted = false;

        /*
         * Loop through, if we find a place to insert the new value we do.
         * Otherwise, just copy data
         */
        for(int i = 0; i < arr.length; i++) {
            if(val <= arr[i] && !inserted) {
                newArr[i] = val;
                newArr[i + 1] = arr[i];
                inserted = true;
            } else {
                newArr[i + (inserted ? 1 : 0)] = arr[i];
            }
        }

        /*
         * Handle the last element of the new array
         */
        if(!inserted) {
            newArr[arr.length] = val;
        } else {
            newArr[arr.length] = arr[arr.length - 1];
        }

        return newArr;
    }
}