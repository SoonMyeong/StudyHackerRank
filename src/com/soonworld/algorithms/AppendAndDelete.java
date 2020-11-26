package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * <수행할 수 있는 타입>
 * 1. 영문장 마지막에 소문자를 이어 붙인다
 * 2. 마지막 문자를 지운다. 빈 문자열 일 경우 삭제 시  그대로 빈 값을 가진다.
 * String s와 t를 가지고 s 를 t로 변환하기 위해 정확히 k번 작업하여 s와 t값이 같아지면
 * Yes 리턴 아니면 No 리턴
 * ex) [input]
 *    s= hackerhappy
 *    t= hackerrank
 *     k=9          // , output : Yes
 *    --> 1. s의 happy라는 문자 5개 삭제  2. rank라는 문자 4개 s 문자열 끝에 이어붙이기 => 5+4 이므로 YES
 *
 *   ...아 뭔가 잘 안되네;
 *   Discussion 참고한 문제
 *   케이스를 쪼개긴 쉬워도 조건을 구하는게 쉽지 않다.
 */
public class AppendAndDelete {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        String [] ss = s.split("");
        String [] tt = t.split("");
        //case 1. String s 를 완전히 지우고 t를 추가하는 경우
        if(s.length()+t.length()<=k){
            return "Yes";
        }
        //case 2. String s 를 완전히 지우지 않고 t로 변환 가능 한지 확인
        int i=0;
        for (; i <Math.min(s.length(),t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                break;
            }
        }

        int min = (s.length()-i) + (t.length()-i);  // 최소한 1개는 같고 나머지값 삭제,등록

        if(k>= min && (k-min)%2 ==0){  //(k-min) %2==0인 조건은  작업 k 개수를 맞추기위해 낭비하는 작업은 추가,삭제 2가지이기 때문에 2로 나눈 나머지가 0이여야 한다.
            return "Yes";
        }else{
            return "No";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);
        System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
