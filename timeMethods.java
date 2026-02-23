// 4531219

import java.lang.Math.*;   
import java.io.*;   
import java.text.*;
import java.util.*;

public class finalTimeMethods {
    public static int N = 32654; 

    public static int[] data = new int[N];

    public static void main(String args[]) {
        
        for (int i = 0; i < N; i++) {
            data[i] = i + 1;
        }

        DecimalFormat twoD = new DecimalFormat("0.00");
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        Random rand = new Random();
        int repetitions = 30;

        // Linear search timing
        double runTime = 0, runTime2 = 0;
        for (int repetition = 0; repetition < repetitions; repetition++) {
            int key = rand.nextInt(N) + 1; // random key in range
            long start = System.currentTimeMillis();
            linearsearch(key, data);
            long finish = System.currentTimeMillis();

            double time = (double)(finish - start);
            runTime += time;
            runTime2 += (time * time);
        }
        double aveRuntime = runTime / repetitions;
        double stdDeviation = Math.sqrt(runTime2 - repetitions * aveRuntime * aveRuntime) / (repetitions - 1);

        System.out.printf("\n\n\fStatistics - Linear Search\n");
        System.out.println("________________________________________________");
        System.out.println("Total time   =           " + runTime/1000 + "s.");
        System.out.println("Total time\u00b2  =           " + runTime2);
        System.out.println("Average time =           " + fiveD.format(aveRuntime/1000)
                + "s. " + '\u00B1' + " " + fourD.format(stdDeviation) + "ms.");
        System.out.println("Standard deviation =     " + fourD.format(stdDeviation));
        System.out.println("n            =           " + N);
        System.out.println("Average time / run =     " + fiveD.format(aveRuntime/N*1000) 
                + '\u00B5' + "s. "); 
        System.out.println("Repetitions  =             " + repetitions);
        System.out.println("________________________________________________");

        // Binary search timing 
        runTime = 0; runTime2 = 0;
        for (int repetition = 0; repetition < repetitions; repetition++) {
            int key = rand.nextInt(N) + 1;
            long start = System.currentTimeMillis();
            binarysearch(key, data);
            long finish = System.currentTimeMillis();

            double time = (double)(finish - start);
            runTime += time;
            runTime2 += (time * time);
        }
        aveRuntime = runTime / repetitions;
        stdDeviation = Math.sqrt(runTime2 - repetitions * aveRuntime * aveRuntime) / (repetitions - 1);

        System.out.printf("\n\n\fStatistics - Binary Search\n");
        System.out.println("________________________________________________");
        System.out.println("Total time   =           " + runTime/1000 + "s.");
        System.out.println("Total time\u00b2  =           " + runTime2);
        System.out.println("Average time =           " + fiveD.format(aveRuntime/1000)
                + "s. " + '\u00B1' + " " + fourD.format(stdDeviation) + "ms.");
        System.out.println("Standard deviation =     " + fourD.format(stdDeviation));
        System.out.println("n            =           " + N);
        System.out.println("Average time / run =     " + fiveD.format(aveRuntime/N*1000) 
                + '\u00B5' + "s. "); 
        System.out.println("Repetitions  =             " + repetitions);
        System.out.println("________________________________________________");
    }

    // Linear search
    static int linearsearch(int key, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1; 
    }

    // Binary search 
    static int binarysearch(int key, int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1; 
    }
}


// What I did:
// Kept your template structure intact.

// Added linearsearch and binarysearch methods.

// Separated timing for linear vs. binary search so you get two sets of statistics.

// Used a Random generator to pick 30 keys in the valid range.

// Printed results in the same format as your template.

// This will give you four numbers in the end: average + standard deviation for both linear and binary search, exactly as required.