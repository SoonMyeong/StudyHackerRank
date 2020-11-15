package com.soonworld.algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long sum1= 0;
        long sum2= 0;
        int temp= 0;

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i]<arr[j]){
                    temp= arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for(int i=0; i<arr.length-1; i++){
            sum1+=arr[i];
        }
        for(int i=1; i<arr.length; i++){
            sum2+=arr[i];
        }
        System.out.println(sum1+ " " + sum2);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }

}
