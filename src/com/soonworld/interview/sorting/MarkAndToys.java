package com.soonworld.interview.sorting;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 *
 * 마크가 장난감을 좋아하는 아들래미에게 장난감을 선물 하려고 한다.
 * 마크가 가진 예산이 k 일 때 k를 가지고 살 수 있는 최대 많은 장난감의 개수는 몇개 인지 구하는 문제
 *
 */
public class MarkAndToys {
    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        //오름차순 분류 한 뒤에 하나씩 더하면서 k보다 값 크거나 작은지 체크
        int sum = 0;
        int count = 0;
        Arrays.sort(prices);

        for(int price : prices){
            sum+=price;
            if(sum>k){
                sum-=price;
                break;
            }
            count++;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
