package com.evanmcintire.gsocexercise;

import java.util.Scanner;

public class GSOCExercise {
    public static void main(String[] args) {


    }

    /**
     * Test driver for the Queue
     * Reads in an int for the amount of commands
     * Then, reads that many commands and either puts or pops with each command
     */
    public static void QueueInput() {
        //Init our scanner, and read how many values we need to read
        Scanner scan = new Scanner(System.in);
        int inputAmount = scan.nextInt();
        scan.nextLine();

        Queue<Integer> queue = new Queue<T>();
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
}