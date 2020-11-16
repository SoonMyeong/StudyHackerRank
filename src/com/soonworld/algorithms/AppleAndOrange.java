package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 *
 *  sam의 집근처에 사과나무와 오렌지나무가 있는데  각각의 나무에서 떨어진 과일들이 sam 집 영역에 몇개나 들어있는지 찾는 문제
 *
 *  s: 쌤의 집  영역시작 지점
 *  t: 쌤의 집  영역끝 지점
 *  a:  사과나무 지점
 *  b : 오렌지나무 지점
 *  aples : 떨어진 사과나무 지점
 *  oranges : 떨어진 오렌지나무 지점
 */

public class AppleAndOrange {

    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int appleCount = 0;
        int orangeCOunt =0;

        for(int apple : apples){
            if(s<=a + apple && a + apple <= t) appleCount++;
        }
        for(int orange : oranges){
            if(s<= b + orange && b +orange <=t) orangeCOunt++;
        }

        System.out.println(appleCount);
        System.out.println(orangeCOunt);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }
}
