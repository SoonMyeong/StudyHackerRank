package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 죄수들 중 마지막 사탕을 받을 죄수는 누가 될 것인가
 * 원형테이블에 앉은 죄수들에게 사탕조각을 하나씩 나눠주는데 마지막 사탕은 맛이아주 구린 사탕이다.
 * 이 구린 사탕을 받게될 죄수가 누구인지 찾아 리턴하는 문제
 * ex) 죄수 : 5 , 사탕 : 2 시작의자:1
 *  의자번호 순서대로 사탕을 나눠주므로 2번의자에 앉은 죄수가 마지막 사탕을 받게 된다. 2 리턴
 * 죄수 :7, 사탕 :19, 시작의자 :2
 * 2번의자부터 사탕을 나눠주기 시작-> 2바퀴를돌고 5번째에 앉은 죄수가 마지막 사탕을 받게 된다.
 * 2,3,4,5,6 --> 즉 6번의자에 앉은 죄수가 마지막 사탕을 받게 된다.
 *
 * 경우의수를 다 체킹한거같은데 .. 자꾸 실패해서 Discussion 참고 한 문제
 */
public class SaveThePrisoner {
    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {

        //m개의 사탕을 s번째부터 나눠주기 시작하면 마지막자리는 m+s가 된다.
        //각각에 대해 -1을 하는 것은 사탕과 자리 각각 1부터 시작하기때문에 -1을 해준다. 포함 시  한개 건너뛰고 시작함
        //하지만 m+s가 n을 초과할 경우를 대비해 %n 을 해주어 초과하는 경우를 없애 준다.
        //나머지를 구한 값이  0을 포함할 수 있음 따라서 +1 해주는게 맞다.
        //아 심오했다..
        //for문을 돌렸을 경우 숫자의 범위가 커서 TIME OUT 이 났을 것이다.
        return ((m - 1) + (s - 1)) % n + 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);

            int result = saveThePrisoner(n, m, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
