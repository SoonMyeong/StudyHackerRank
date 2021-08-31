package com.soonworld.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class DavisStaircase {

    /*
     * Complete the 'stepPerms' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    public static int stepPerms(int n) {
        // Write your code here
       int[] dp = new int[n+1];

       if(n==1) {
           return 1;
       }
       if(n==2) {
           return 2;
       }
       if(n==3) {
           return 4;
       }

        dp[1] = 1;
        dp[2] =2;
        dp[3] = 4;
       //1,2,3 으로 4를 만드려면 -> 1,1,1,1 | 1,1,2 | 1,2,1 | 1,3 | 2,1,1 | 3,1 | 2,2
       for(int i=4; i<=n; i++) {
           dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
       }

        return dp[n];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, s).forEach(sItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int res = stepPerms(n);
                System.out.println(res);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
    }
}

