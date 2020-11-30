package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 *  배열에서 같은 값의 요소만 남기려 할 때
 *  지워야 하는 최소한의 요소 개수 구하기
 *
 */
public class EqualizeTheArray {
    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        //배열안에서 가장 많이 있는 같은 값의 개수를 구한 뒤 전체개수에서 빼면 됨
        int [] ary = new int[101]; //1~100까지의 값
        int max = 0;
        for(int i=0; i<arr.length; i++){
            ary[arr[i]]+=1;
        }
        for(int j=0; j<ary.length; j++){
            if(max<ary[j]) max = ary[j];
        }

        return arr.length - max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
