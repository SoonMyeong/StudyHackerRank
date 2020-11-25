package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 화가난 교수는 지각자의 수 k를 넘길 경우 반 자체를 취소시키려고 한다.
 * 수업시작 보다 일찍온 경우 negative number(음수)로 표현하고, 정시에 온 학생을 0으로 표시, 지각한 학생을 양수로 표현 한다. (배열)
 * 입력받은 값에 따라 수업취소가 YES 인지 NO 인지를 출력하는 문제
 */

public class AngryProfessor {
    // Complete the angryProfessor function below.
    static String angryProfessor(int k, int[] a) {
        int count =0;

        for(int num : a){
            if(num<=0) count++;
        }
        if(k>count){
            return "YES";
        }else{
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }

            String result = angryProfessor(k, a);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
