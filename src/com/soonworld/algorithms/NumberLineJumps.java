package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 캥거루 2마리가 일정한 속도로 뛰는데 두 캥거루가 같은 지점으로 동시에 뛸 경우 YES 아니면 NO
 *
 *  x1 : 캥거루 1 시작 지점
 *  v1 : 캥거루 1 의 한번 점프당 이동거리
 *  x2 : 캥거루 2 시작 지점
 *  v2 : 캥거루 2의 한번 점프당 이동거리
 *
 * Constraints
 * 0 <= x1 < x2 <= 10000
 * 1 <= v1 <= 10000
 * 1 <= v2 <= 10000
 *
 * Sample Input 0
 *  0 3 2 1
 *  Sample Output 0
 *  YES
 *
 *  Sample Input 1
 *  0 2 5 3
 *  Sample Output 1
 *  NO
 */

public class NumberLineJumps {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        String result = "NO";
        //x2>x1 일 경우 항상 v1>v2 여야 한다. 아닐 경우 NO
        //x1>x2 일 경우 항상 v2>v1 여야 한다. 아닐 경우 NO
        if((x2>x1 && v1>v2) || (x1>x2 && v2>v1)){
            //x1+v1*n == x2+v2*n 일 경우 YES 안되면 NO
            //n 의 max는 10,000
            for(int i=1; i<=10000; i++){
                if(x1+(v1*i) == x2+(v2*i))
                    result = "YES";
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
