package com.soonworld.dayofcode;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 10진수 -> 2진수 변환 뒤 연속적인 1의 개수를 구하는 문제
 * 이진수로 변환 뒤 0을 기준으로 짜를 시 연속적인 1의 개수씩 배열에 들어가게 됨
 */
public class BinaryNumbers {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        int len = 0;
        String num = Integer.toString(n,2);
        String[] cmpNum = num.split("0");

        for(String str : cmpNum){
            if(len < str.length()) len= str.length();
        }

        System.out.println(len);
    }
}
