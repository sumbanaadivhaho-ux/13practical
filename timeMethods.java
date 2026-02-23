// Code is stored as 13template.java
import java.lang.Math.*;   
import java.io.*;   
import java.text.*;
import java.util.*;

public class timeMethods{
public static int N = 32654;

public static int[] data = new int[N];

public static void main(String args[]){

   for (int i = 0; i < N; i++) {
      data[i] = i + 1;
   }

DecimalFormat twoD = new DecimalFormat("0.00");
DecimalFormat fourD = new DecimalFormat("0.0000");
DecimalFormat fiveD = new DecimalFormat("0.00000");

Random rand = new Random();
int repetitions = 30;

long start, finish;
double runTime = 0, runTime2 = 0, time;
double totalTime = 0.0;
int n = N;
int repetition;

// linear timing
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
   double stdDeviation = Math.sqrt(runTime2 - repetitions*aveRuntime*aveRuntime)/(repetitions-1);

   System.out.printf("\n\n\fStatistics\n");
   System.out.println("________________________________________________");
   System.out.println("Total time   =           " + runTime/1000 + "s.");
   System.out.println("Total time\u00b2  =           " + runTime2);
   System.out.println("Average time =           " + fiveD.format(aveRuntime/1000)
                     + "s. " + '\u00B1' + " " + fourD.format(stdDeviation) + "ms.");
   System.out.println("Standard deviation =     " + fourD.format(stdDeviation));
   System.out.println("n            =           " + n);
   System.out.println("Average time / run =     " + fiveD.format(aveRuntime/n*1000) 
                     + '\u00B5' + "s. "); 

   System.out.println("Repetitions  =             " + repetitions);
   System.out.println("________________________________________________");
   System.out.println();
   System.out.println(); 

   //  Binary search timing 
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

   // --- Linear search ---
    static int linearsearch(int key, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1; // not found
    }

    // --- Binary search ---
    static int binarysearch(int key, int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1; // not found
    }
}
   


static void oneofyourMethods(int n, 
                       yourMethodParameter1,
                       yourMethodParameter2, . . . ) {
// The declarations and body of your method / s   
// The final statement of this code.} }