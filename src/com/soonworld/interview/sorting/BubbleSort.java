package com.soonworld.interview.sorting;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 * 버블소트 문제. 문제에 답이 있음
 */
public class BubbleSort {
    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int count = 0;

        for(int i=0; i<a.length; i++){
            for(int j=i; j<a.length; j++){
                if(a[i]>a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    count++;
                }
            }
        }
        System.out.println("Array is sorted in "+ count + " swaps.");
        System.out.println("First Element: " +  a[0]);
        System.out.println("Last Element: " + a[a.length-1]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
