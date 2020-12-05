package com.soonworld.interview.arrays;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 *
 *
 */
public class LeftRotation {
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int r = d%a.length;
        List<Integer> result = new ArrayList<>();
        int [] arr = null;

        //이 방식도 있지만 더 간단한 방법
        // (i+d)%a.length 로직을 사용하면 더 간단함 시간복잡도 면에선 크게 다르지 않으므로 따로 작성은 안함
        for(int i=r; i<a.length; i++){
            result.add(a[i]);
        }
        for(int j=0; j<r; j++){
            result.add(a[j]);
        }

        arr = result.stream().mapToInt(Integer::intValue).toArray();

        return arr;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

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
