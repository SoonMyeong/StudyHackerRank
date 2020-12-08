package com.soonworld.interview.greedy;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 *  배열을 입력 받아 배열안에 두 요소를 가지고 만들 수 있는 절대 값 중
 *  가장 작은 값을 골라 내는 문제
 *
 */
public class MinimumAbsolute {
    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        int min = Math.abs(arr[1]-arr[0]);
        //2개의 테스트케이스에 대해 timeout 발생 -->  array를 오름 차순으로 sort 시 루프 한번만 돌리면 됨.
        //ex) 1번쨰요소의 3번째요소의 차이는 1번째요소와 2번째요소의 차이보다 크니까 -->이걸 알아내는게 greedy 탐색법을 이용하는 방법
//        for(int i=0; i<arr.length; i++){
//            for(int j=i+1; j<arr.length; j++){
//                if(Math.abs(arr[i]-arr[j])<min){
//                    min = Math.abs(arr[i]-arr[j]);
//                }
//            }
//        }
        Arrays.sort(arr);

        for(int i=1; i<arr.length-1; i++){
            int num = Math.abs(arr[i+1]-arr[i]);
            if(min>num){
                min = num;
            }
        }

        return min;
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

        int result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
