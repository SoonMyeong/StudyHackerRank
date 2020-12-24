package com.soonworld.interview.dp;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 배열의 인접하지 않는 부분집합의 합들 중 가장 큰 값을 출력 하는 문제
 * [ex]
 * 5
 * 3 7 4 6 5
 * -> [3,4,5] , [3,4] , [3,6] , [3,5] , [7,6] , [7,5] , [4,5] 중 가장 큰값 [7,6] = 13
 *
 * 기존 대로 했더니 안된다...
 * 푸는 방법은 이렇다.
 * dp로 값을 구해내기 위해 해당 인덱스까지의 인접하지 않은 요소들의 최대값을 저장해 나간다.
 *
 *
 *
 */
public class MaxArraySum {
    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        if(arr.length ==0) return 0;
        arr[0] = Math.max(0,arr[0]); // 빈 집합도 포함되기 때문에 최대값은 음수가 나올 수 없다.
        if(arr.length == 1) return arr[0];
        arr[1] = Math.max(arr[0],arr[1]);

        for(int i=2; i<arr.length; i++){
            arr[i] = Math.max(arr[i-1], arr[i-2]+arr[i]);
        }
        return arr[arr.length-1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);
        System.out.println(res);
//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}
