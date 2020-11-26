package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 존왓슨이 셜록에게 하는 배열 테스트
 * 한 로테이션이 있을 때 마다 배열 맨 끝에 있는 숫자를 맨 앞으로 옮기고 남은 숫자들을 오른쪽으로 한칸씩 땡김
 * n : 배열 인덱스 개수
 * k : 로테이션 수
 * q : 로테이션 후 리턴받을 배열 인덱스 개수
 * ex) n= 3 k=2 q= 3
 *      1 2 3 -->배열
 *      0 --> a[0] 값은 무엇인지
 *      1 --> a[1] 값은 무엇인지
 *      2 --> a[2] 값은 무엇인지
 */
public class CircularArrayRotation {
    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
   //     int [] result = new int[queries.length];

        //Discussions 참고 후
        //못 풀만했다;
        // (i+k)%a.length 식을 세워야 해결 할수 있음..
        // 근데 또 이해 안될 식도 아님..
        //k%a.length 까지 생각했는데 여기서 (i+k)를 하게 되면 k만큼씩 오른쪽으로 밀리게 되고 a길이를 초과하면 앞으로 당겨진다..
        int arr[] = new int[a.length];

        for(int i=0 ; i<a.length ; i++)
            arr[(i+k)%a.length] = a[i];

        for(int i=0 ; i<queries.length ; i++)
            queries[i] = arr[queries[i]];



        //써클 로테이션 로직
        //중첩 포문쓸 시 TIMEOUT 발생 (그럴줄 알았다.. 범위가 너무큼)
        // k의 범위를 k%a.length 값으로만 순회 시 테스트케이스 4개빼고 통과
        //남은 4개를 위해 좀 더 복잡도를 줄여보자 -> 실패
//        for(int j=0; j<k%a.length; j++) {
//            //1. 배열 마지막 값을 다른 곳에 저장
//            int finalNum = a[a.length - 1];
//            //2. 배열 인덱스들 오른쪽으로 한칸씩 이동
//            for (int i =a.length-1; i>0; i--) {
//                a[i] = a[i-1];
//            }
//            System.out.println("a[1] :" + a[1] +", a[2] :" + a[2]);
//            //3. 다른곳에 저장한 배열 마지막 값을 a[0]로 변경
//            a[0] = finalNum;
//        }
//
//        for(int n=0; n<queries.length; n++){
//            result[n] = a[queries[n]];
//        }

        return queries;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nkq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkq[0]);

        int k = Integer.parseInt(nkq[1]);

        int q = Integer.parseInt(nkq[2]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] queries = new int[q];

        for (int i = 0; i < q; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = circularArrayRotation(a, k, queries);

        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
                System.out.println(result[i]);
//            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
        }

//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
