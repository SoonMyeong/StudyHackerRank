package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 릴리의 영화보기 좋은 날
 * 숫자들과 나눌 값 k를 입력 받아서
 * |숫자-숫자의역순|%k ==0인 날이 뷰티풀데이가 된다.
 * 입력받은 날들의 범위 중 뷰티풀데이가 몇일인지를 리턴하는 문제
 * ex) 20 23 6
 * -> 20~23일 사이의 뷰티풀데이가 몇일인지 찾기 , k는 6이다.
 * 이 문제의 핵심은 숫자 역순 구하기
 */

public class BeautifulDaysAtTheMovies {
    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int count = 0;

        for(int start=i; start<=j; start++){
            //1. 역순 구하기 123
            int reverse = 0; //reverse값 초기화
            int startNum = start; //startNum값 초기화

            while(startNum!=0){
                reverse= reverse*10 + startNum%10;
                startNum = startNum/10;
            }
            //2. |숫자-역순|%k==0일 경우 count 하기
            if(Math.abs(start-reverse)%k==0) count++;
        }

        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
