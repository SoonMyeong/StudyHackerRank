package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 * 영어 암호화 시키기
 * 입력받은 영문장의 길이를 측정 한 뒤
 * 길이의 제곱근값이 몇과 몇 사이에 존재하는지 확인 뒤
 * 작은값을 열, 큰값을 행으로 나열 한다.
 * 그 뒤 나열한 값들에 대해 열기준으로 출력.(다음 열로 넘어갈 때마다 공백 추가)
 * - 소문자만 가능하며 길이는 81자까지
 * ex) haveaniceday
 * L  = 12  이며 루트12는 3과 4사이 값
 * rows = 3 , columns = 4
 * have
 * anic
 * eday
 *
 * 여기서 열기준으로 출력 시  hae and via ecy  (결과)
 */
public class Encryption {
    // Complete the encryption function below.
    static String encryption(String s) {
        StringBuilder result = new StringBuilder();
        String [] str = s.split("");
        int sqrt = (int) Math.sqrt(str.length);
        int start = 0;
        int end = 0;
        if(sqrt*(sqrt+1)>str.length && sqrt*sqrt != str.length){
            start = sqrt;
            end = sqrt+1;
        }else if (sqrt*sqrt == str.length){
            start = sqrt;
            end = sqrt;
        }else{
            start = sqrt+1;
            end = sqrt+1;
        }
        String[][] afterStr = new String[start][end];
        int k=0;

        for (int i = 0; i < start; i++) {
            for (int j = 0; j < end; j++) {
                if(k<str.length){
                    afterStr[i][j] = str[k];
                    k++;
                }else{
                    afterStr[i][j] = "";
                }
            }
        }

        for(int i=0; i<end; i++){
            for(int j=0; j<start; j++){
                result.append(afterStr[j][i]);
            }
            result.append(" ");
        }
        System.out.println(result.toString());
        return result.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
