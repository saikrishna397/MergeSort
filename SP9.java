/**
 * Sample starter code for SP9.
 *
 * @author
 */

package sxs169430;

import java.util.Random;

public class SP9 {
    public static Random random = new Random();
    public static int numTrials = 100;

    public static void main(String[] args) {
        int n = 10;
        int choice = 1 + random.nextInt(4);
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        }
        if (args.length > 1) {
            choice = Integer.parseInt(args[1]);
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Timer timer = new Timer();
        switch (choice) {
            case 1:
                Shuffle.shuffle(arr);
                numTrials = 1;
                MergeSort.insertionSort(arr);
                for (int i : arr)
                    System.out.print(i + " ");
                break;
            case 2:
                for (int i = 0; i < numTrials; i++) {
                    Shuffle.shuffle(arr);
                    MergeSort.mergeSortTakeOne(arr);
                }
                for (int i : arr)
                    System.out.print(i + " ");
                break;  // etc
            case 3:
                for (int i = 0; i < numTrials; i++) {
                    Shuffle.shuffle(arr);
                    MergeSort.mergeSortTakeTwo(arr);
                }
                for (int i : arr)
                    System.out.print(i + " ");
                break;
            case 4:
                for (int i = 0; i < numTrials; i++) {
                    Shuffle.shuffle(arr);
                    MergeSort.mergeSortTakeThree(arr);
                }
                for (int i : arr)
                    System.out.print(i + " ");
                break;
            default:
                for (int i = 0; i < numTrials; i++) {
                    Shuffle.shuffle(arr);
                    MergeSort.mergeSortTakeOne(arr);
                }
                break;
        }
        timer.end();
        timer.scale(numTrials);

        System.out.println("Choice: " + choice + "\n" + timer);
    }


    /**
     * Timer class for roughly calculating running time of programs
     *
     * @author rbk
     * Usage:  Timer timer = new Timer();
     * timer.start();
     * timer.end();
     * System.out.println(timer);  // output statistics
     */

    public static class Timer {
        long startTime, endTime, elapsedTime, memAvailable, memUsed;
        boolean ready;

        public Timer() {
            startTime = System.currentTimeMillis();
            ready = false;
        }

        public void start() {
            startTime = System.currentTimeMillis();
            ready = false;
        }

        public Timer end() {
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            memAvailable = Runtime.getRuntime().totalMemory();
            memUsed = memAvailable - Runtime.getRuntime().freeMemory();
            ready = true;
            return this;
        }

        public long duration() {
            if (!ready) {
                end();
            }
            return elapsedTime;
        }

        public long memory() {
            if (!ready) {
                end();
            }
            return memUsed;
        }

        public void scale(int num) {
            elapsedTime /= num;
        }

        public String toString() {
            if (!ready) {
                end();
            }
            return "Time: " + elapsedTime + " msec.\n" + "Memory: " + (memUsed / 1048576) + " MB / " + (memAvailable / 1048576) + " MB.";
        }
    }

    /**
     * @author rbk : based on algorithm described in a book
     */


    /* Shuffle the elements of an array arr[from..to] randomly */
    public static class Shuffle {

        public static void shuffle(int[] arr) {
            shuffle(arr, 0, arr.length - 1);
        }

        public static <T> void shuffle(T[] arr) {
            shuffle(arr, 0, arr.length - 1);
        }

        public static void shuffle(int[] arr, int from, int to) {
            int n = to - from + 1;
            for (int i = 1; i < n; i++) {
                int j = random.nextInt(i);
                swap(arr, i + from, j + from);
            }
        }

        public static <T> void shuffle(T[] arr, int from, int to) {
            int n = to - from + 1;
            Random random = new Random();
            for (int i = 1; i < n; i++) {
                int j = random.nextInt(i);
                swap(arr, i + from, j + from);
            }
        }

        static void swap(int[] arr, int x, int y) {
            int tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }

        static <T> void swap(T[] arr, int x, int y) {
            T tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }

        public static <T> void printArray(T[] arr, String message) {
            printArray(arr, 0, arr.length - 1, message);
        }

        public static <T> void printArray(T[] arr, int from, int to, String message) {
            System.out.print(message);
            for (int i = from; i <= to; i++) {
                System.out.print(" " + arr[i]);
            }
            System.out.println();
        }
    }
}
