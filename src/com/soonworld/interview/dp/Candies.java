package com.soonworld.interview.dp;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 * 앨리스의 캔디 나누기
 * 앨리스는 유치원 아이들에게 사탕을 나눠 주려 한다.
 * 아이들은 인접하여 앉아 있는데  그 아이에게 1개의 사탕을 줬을때 다음번의 아이가 스코어가 더 높을 시 그 이상의 사탕을 줘야 한다.
 * 예를들어 arr = {4,6,4,5,6,2}순으로 아이가 앉아 있을 때
 * 최소한으로 사탕을 주는 방법은 {1,2,1,2,3,1}이 된다.
 * 4보다 5가 크므로 2개를 준것이고, 5보다 6이 크므로 3개를 준것이다. 마지막엔 다시 숫자가 작아지므로 최소값인 1개를 준다.
 *
 *
 * dp 문제는 정말 어렵다; 많은 문제를 접해 봐야 생각해 낼 수 있는 유형이다
 * Discussion 참고
 */
public class Candies {
    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        long count=0;
        int[] candies = new int[arr.length];
        for(int i=0;i<candies.length;i++){
            candies[i] = 1;
        }
        for(int i=0;i<arr.length-1;i++){
            if((arr[i+1] > arr[i]) && !(candies[i] < candies[i+1]))
                candies[i+1] = candies[i] + 1; //일단 인접한 요소중 다음 인덱스값이 더 클 경우 +1 해서 더해준다.
        }
        //ex) 4,6,4,5,6,2  일 경우
        // candies = {1,2,1,2,3,1}
        for(int i=arr.length-1;i>0;i--){  //반대로도 해야된다는 것에 대해 생각을 못했었다.
            if((arr[i] < arr[i-1]) && !(candies[i-1] > candies[i])) //candeis 배열을 활용해 case2번에 대한 해결책이 나온다.. 아하..
            {
                candies[i-1] = candies[i] + 1;
            }
        }
        for(int i=0;i<candies.length;i++)
            count += candies[i];
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}
