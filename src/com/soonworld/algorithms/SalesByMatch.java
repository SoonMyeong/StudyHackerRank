package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 옷가게에서 일하는 알렉스는 양말를 팔기 위해 양말 짝을 맞춰놔야 한다.
 * 배열을 받아서  짝이 맞는 양말의 종류가 몇 종류 인지 계산하여 리턴 한다.
 */
public class SalesByMatch {
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int count = 0;
        int[] arr = new int[101];

        for(int i : ar){
            arr[i]+=1;
        }

        for(int j=1; j<arr.length; j++){
            if(arr[j]!=0){
                count+= (arr[j]/2);
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
