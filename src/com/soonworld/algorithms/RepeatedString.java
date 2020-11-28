package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 *  릴라가 가지고 있는 문자열을 반복하여  길이가 n이 되도록 반복해서 나타냈을 때
 *  그 문자열에 있는 a의 개수는 몇개인지 리턴하는 문제
 *
 */

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        String [] str = s.split("");
        long strCount = 0; //str의 a 개수
        long modCount = 0; // 나머지값에서의 a개수
        long div = 0;
        long mod = 0;

        //1. str 배열에서 a의 개수를 구한다.
        for(String string : str){
            if(string.equals("a")) strCount++;
        }
        //2. n을 str.length로 나눈 몫과 나머지를 구한다.
        div = n / str.length;
        mod = n % str.length;
        //3. a 개수 x몫 + 인덱스 0부터 나머지인덱스-1 까지의 a의 개수 의 합
        for(int i=0; i<mod; i++){
            if(str[i].equals("a")) modCount++;
        }

        return div*strCount + modCount;

    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
