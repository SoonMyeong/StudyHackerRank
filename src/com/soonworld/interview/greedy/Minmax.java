package com.soonworld.interview.greedy;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Max(숫자그룹) - Min(숫자그룹) 구하기
 * -> 이 문제 읽어도 무슨말인지 도통 감이 안온다 --; Discussions 참고 함
 *  배열을 입력 받은 뒤 배열 안 k개의 요소를 골라 만들 수 있는 (최대값-최소값) 최소값을 구하기
 *  무작정 머리속에 떠오르는데로 분기하기보단 정리를 할 필요성 느낌
 *  ---> 이 문제의 핵심은 정렬된 배열에서의 k개의 요소의 최소값을 구하면 된다.
 *  ---> 정렬된 배열이기때문에 k가 3개이상일 경우더라도 처음과 끝값만 알면 되므로
 *  ---> for문 돌릴 시  i+k-1개에서 i를 빼면 된다. (핵심)
 *
 */
public class Minmax {
    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=0; i< arr.length-k+1; i++){
            min = Math.min(min, arr[i+k-1]-arr[i]);
        }
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
