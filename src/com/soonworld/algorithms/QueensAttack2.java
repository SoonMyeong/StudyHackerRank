package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 *  [체스] 장애물이 있을 때 퀸이 이동할 수 있는 위치의 총 합 구하는 문제
 *   퀸은 알다시피 상하좌우,대각선 이동이 가능하다.
 *   하지만 장애물에 있을 시 장애물 뒤로는 접근이 안된다고 한다.
 *   n(체스보드 사이즈 (nxn)과 k(장애물) 의 가능한 범위가 10^5 까지라는게 이 문제의 관건이다.
 *   Discussions 참고 한 문제
 *
 */

public class QueensAttack2 {
    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        //범위가 크므로 for문 하나로 끝내야 한다.
        // queen의 좌표에 의한 각 영역의 합을 구해놓고 장애물위치를 하나씩 두면서 각 영역의 합을 다시 구한다 ;

        int topSpan = n-r_q; //한쪽이 n-값
        int botomSpan =r_q-1;
        int rightSpan =n-c_q; //한쪽이 n-값
        int leftSpan =c_q-1;
        int blSpan = Math.min(c_q,r_q) -1; //bottom Left
        int brSpan =Math.min(r_q-1 , n-c_q); //bottom Right
        int tlSpan =Math.min(n-r_q, Math.abs(1-c_q)); // top Left
        int trSpan =n - Math.max(c_q,r_q); // top Right

        //다음에 다시 풀어보자..

        for(int i=0; i<k; i++){

        }

        return 0;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
