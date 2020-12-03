package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 *   입력받은 단어를 기준으로 현재 문자보다 사전식으로 바로 한단계 큰 단어로 리턴하는 문제
 *  - 반드시 원래의 단어보다는 높아야 한다.
 *  - 원래 단어보다 높게 사전식으로 나열하되 그 중 가장 작은 값이어야 한다.
 *  ex) abcd를 입력받으면 사전식으로 바로 한단계 높은 abdc 리턴
 *
 *  으... Discussion 참고했더니 Next lexicographical permutation algorithm 이런게 있었음..
 *  참고자료 : https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 *  한글로 설명을 덧붙여 보자면,
 *  1. 배열의 오른쪽 끝(end)에서 부터 인덱스 2개의 값들을 비교해가면서  end-1<end 인 시점을 찾아 낸다.
 *  2. 찾아낸 시점의 end-1을 피벗으로 잡는다.(알고리즘 값을 구하기 위한 초기 비교값)
 *  3. 배열의 오른쪽 끝에서 부터 순회 하면서 피벗값 보다 큰 값을 발견 시 그 값과 피벗값의 자리를 바꾼다.
 *  4. 기존 피벗자리 다음값부터 역순으로 저장 한다.
 */
public class BiggerIsGreater {
    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        String [] str = w.split("");
        StringBuilder result = new StringBuilder();

        int i = str.length-1;
        //pivot 위치 찾기
        while(i>0 && str[i].charAt(0)<=str[i-1].charAt(0)){
            i--;
        }
        if(i<=0) return "no answer";

        int j= str.length-1;
        while(str[j].charAt(0)<=str[i-1].charAt(0)){
            j--;
        }

        //pivot과 자리바꿈
        String temp = str[j];
        str[j] = str[i-1];
        str[i-1] = temp;

        //pivot 다음부터 역순 저장
        j = str.length-1;
        while(i<j){
            temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }

        for(String s : str){
            result.append(s);
        }
        System.out.println(result.toString());

        return result.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
