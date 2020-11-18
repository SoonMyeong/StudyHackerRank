package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BreakingTheRecords {
    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        //시즌 간 최저점수와 최고점수 갱신 시 count
        int highest = scores[0];
        int lowest = scores[0];
        int highcount = 0;
        int lowcount =0;
        int []result = new int[2];

        for(int i=1; i<scores.length; i++){
            //최고점수 갱신 시
            if(highest<scores[i]){
                highest = scores[i];
                highcount++;
            }
            //최저점수 갱신 시
            else if(lowest>scores[i]) {
                lowest = scores[i];
                lowcount++;
            }
        }

        result[0] = highcount;
        result[1] = lowcount;

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
