package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * BigInteger를 이용한 펙토리얼 계산
 *
 */

public class ExtraLongFactorials {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        System.out.println(Factorial(n));
    }

    static BigInteger Factorial(int n){
        BigInteger num = new BigInteger(String.valueOf(n));
        if(n==1){
            return num;
        }else{
            return num.multiply(Factorial(n-1));
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
