package com.soonworld.dayofcode;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 6x6 배열을 주고 만들 수 있는 모래시계 모양들의 합 중 가장 큰 값 리턴
 * 모래시계의 모양은 아래와 같다.
 * a b c
 *   d
 * e f g
 * 조건 : -9<=A[i][j]<=9
 *         0<= i,j <=5
 *
 * 뭔가 로직이 있겠지.. 하는 생각에 고민만 많이 했던 문제
 * 행,렬 하나씩 늘리면서의 합을 구한 뒤 그 합 중 최대값을 구하면 되는문제
 * Discussion 참고하여 키포인트 찾음
 * 이 문제의 키포인트는 3x3 모래시계의 인덱스들을 하나로 생각하고 접근 하면 쉽게 해결 된다. (왜냐? 어차피 배열을 모두 순회할 것이므로)
 */
public class TwoDArrays {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        int max = -63; //최소값 설정 (-9가 7개인 case)
        int sum = 0;

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                sum = arr[i][j]+arr[i][j+1]+arr[i][j+2]
                        +arr[i+1][j+1]
                        +arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];

                if(sum>max){
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
