package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 *  구름 건너기 게임
 * c라는 배열이 주어지는데 인덱스 들 중 값이 1인 것은 번개구름이므로
 * 번개구름은 반드시 피하고 배열의 끝 지점에 도착 해야 한다.
 * 점프는 1 또는 2로 할 수 있으며
 * 번개구름을 피하고 배열의 끝 지점에 도달 할 최단 점프 횟수는 몇번 인지 리턴 하는 문제
 * (항상 마지막 지점까지 갈 수있도록 구름이 배치 된다고 한다)
 */
public class JumpingOnTheClouds {
    static int jumpingOnClouds(int[] c) {
        int count = 0;
        int i=0;

        while(i<c.length-2){
            //1.현재위치+1 번째 값이 1일 경우 두칸 점프
            if(c[i+1]==1 && c[i+2]==0){
                i+=2;
                count++;
            }
            //2.현재위치+2 번째 값이 1일 경우 한칸 점프
            else if(c[i+1]==0 && c[i+2]==1){
                i++;
                count++;
            }
            //3.현재위치 +1,+2 번째 값 모두 0일 경우
            else if(c[i+1]==0 && c[i+2]==0){
                i+=2;
                count++;
            }
            System.out.println(i);
        }

        if(i!=c.length-1){
            count++; //마지막 지점에 가기 위한 마지막 점프
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0};

//        String[] cItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int cItem = Integer.parseInt(cItems[i]);
//            c[i] = cItem;
//        }


        int result = jumpingOnClouds(c);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

//        scanner.close();
    }
}
