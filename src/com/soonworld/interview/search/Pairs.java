package com.soonworld.interview.search;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 페어값 찾기
 * 배열 arr, 지정값 k 를 받아 배열안에서 두 요소의 차이가 k인 쌍이 몇 쌍인지 찾는 문제
 * ex ) 5 k=2
 *      arr={1 5 3 4 2}
 * result = 3 ( [5,3] , [4,2] , [3,1] )
 *
 * 역시나 최적화가 어렵다.. Discussion 참고
 */

public class Pairs {
    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        //1. 무조건 k값 보다 큰 값에서 작은 값을 빼야 k값이 나올 수 있음
        // 1.1 k값보다 큰 값들의 차가 k일 수 있음

        //Search에 대한 팁은 hashMap or hashSet에 넣어 두고 찾으려는 값이 있는지 여부를 검색! 하는것이 팁이다.
        //이중루프만 생각하면 O(n^2)으로 해결되는걸 아래처럼 O(n)에 해결 가능..
        // IceCreamParlor 와 비슷한 문제
        int counter = 0;
        Set<Integer> value = new HashSet<Integer>();
        for(int i : arr){
            value.add(i);
        }
        for(int i : value){
            if(value.contains(i + k)){
                ++counter;
            }
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
