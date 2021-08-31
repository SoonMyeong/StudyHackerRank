package com.soonworld.interview.backtracking;

import java.util.Scanner;

public class Fibonacci {
    public static int fibonacci(int n) {
        // Complete the function.
        int[] dp = new int[n+1];
        if(n==1) {
            return 1;
        }
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
