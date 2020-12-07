package com.soonworld.interview.arrays;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 * 롤코를 타기위해 줄을 섰는데, 사람들이 뇌물을 주고 순서를 바꿔 뒤죽박죽이 되었다.
 *  뇌물은 바로 앞사람에게만 줄 수 있으며 최대 두명에게 줄 수 있을 때,
 *  원래의 오름차순 배열에서 현재 뒤죽박죽된 배열이 되기까지 몇번의 뇌물을 주었는지 구하는 문제
 *
 *  Discussion 참고 한 문제 [로직정리]
 *  [사전 지식] 배열 끝에서부터 역으로 뇌물을 줬는지 계산한다.
 *  [사전 지식] 원래 알맞는 줄일 경우 배열 요소 값이 순서가 된다.
 *  1. 현재 인덱스값에서 index+1 을 뺏을 때 2보다 클 경우 카오스 상태. (최대 앞사람 두명에게만 뇌물을 줄 수 있다는 조건)
 *  2. 현재 내 위치에서 앞에 두 사람의 인덱스 값이 내 인덱스값 보다 클 경우 내 뒷사람이 앞으로 간 것이므로 뇌물count ++;
 *  [*] for문을 돌리되 현재 내위치에서 앞 두사람을 차례차례 계산하는 로직을 생각 해내기 어려움.
 */

public class NewYearChaos {
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int count = 0;

        for(int i=q.length-1; i>=0; i--){
            if(q[i]-(i+1)>2){
                System.out.println("Too chaotic");
                return;
            }
            for(int j= Math.max(0, q[i]-2); j<i; j++) { // 내 앞사람 두 명
                if (q[j] > q[i]) count++;
            }
        }
        System.out.println(count);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
