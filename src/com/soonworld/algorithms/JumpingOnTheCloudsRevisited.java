package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 구름 뛰어넘기 게임
 *  플레이시 에너지(e)는 100으로 시작 한다.
 *  뛰어넘기 시작한 구름으로 다시 돌아올 시 게임은 종료 된다.
 *  뛰어넘어야 할 구름들은 배열로 제공 한다. c= {~}
 *  c[i] = 1일 시  천둥구름 , c[i] = 0일 시 일반 적운이며 천둥구름을 밟을 시 에너지가 -2만큼 깎인다.
 *  한번 점프 시 마다 에너지는 -1만큼 깎인다.
 *  시작지점은 c[0]이며  사이즈가 k일 때, (i+k)%n 만큼 점프 한다. --> 이전 CircularArrayRotation 문제에 나왔던 식을 제공해주네, 즉 이 배열은 원형이라는 얘기
 *  배열과 한번 점프시 이동거리 k를 입력 했을 때 게임이 끝났을때의 에너지가 얼마인지 구하는 문제
 *  ex) inout: 8 2
 *             0 0 1 0 0 1 1 0
 *      output: 92
 */
public class JumpingOnTheCloudsRevisited {
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int i =0;

        if(c[0]==1){
            energy -=2;
        }

        while((i+k)%c.length!=0){ //다시 시작지점 c[0]로 올때 까지 무한 반복;
            if(c[(i+k)%c.length]==1){
                energy-=3;
            }else{
                energy-=1;
            }
            i=(i+k)%c.length;
        }
        energy-=1; //while문 나오는 순간이 출발지 도착할때임, 마지막 점프에 대한 에너지 감소

        return energy;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
