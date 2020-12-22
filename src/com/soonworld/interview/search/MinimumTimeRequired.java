package com.soonworld.interview.search;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 * 머신을 이용해 상품판매 목표치를 채우기 위한 최소한 걸리는 날은 며칠 걸리는가?
 * machines 배열은 상품을 제공하기위한 고정된 날짜임
 *
 * ex) goal= 10 , machines = {2,3,2}
 * Day Production  Count
 * 2   2 (2짜리2개)              2
 * 3   1  (3짜리 1개)            3
 * 4   2  (2짜리2개)             5
 * 6   3   (모두)                8
 * 8   2   (2짜리 2개)           10
 *
 * 첫번째 입력은 n과 goal
 * 두번째 입력은 n에 대한 machines[i] 값
 * 음....... Discussion 참고
 * 이 문제의 핵심은 검색 범위를 좁혀놓고 검색하는 것이다. (binary search)
 * 목표치까지 최대로 걸릴 수 있는 날과 최소로 걸릴 수 있는 날을 구하고
 * 최대일과 최소일을 더한 뒤 2로나눈 중간날짜를 가지고 하나씩 늘려가며 goal에 도달한다
 *
 * (day / machine 값이 머신으로 날짜까지 만들수 있는 개수)
 */
public class MinimumTimeRequired {
    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long slowest = machines[machines.length-1];
        long fastest = machines[0];
        long minDay = fastest * goal / machines.length;
        long maxDay = slowest * goal / machines.length;
        long result = -1;

        while(minDay < maxDay){
            long midDay = (minDay+maxDay)/2;
            long units = 0;
            for(long machine : machines){
                units += midDay / machine;
            }

            if(units<goal){
                minDay = midDay+1;
            }else{
                result = midDay;
                maxDay = midDay;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        System.out.println(ans);
//        bufferedWriter.write(String.valueOf(ans));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}
