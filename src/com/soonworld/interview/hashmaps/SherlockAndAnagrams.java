package com.soonworld.interview.hashmaps;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 * 애나그램 부분집합 개수 구하기
 *  그냥 모르겠는데--;
 *  Discussion 참고
 *  --> 완전 애나그램 구하는건 아니고.. 순회하면서 부분문자열이 애나그램인지 확인 하는 문제
 *  1. Traverse all possible substrings within string
 *  2. Check if any two substrings of equal length are anagrams
 */


public class SherlockAndAnagrams {
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int start = 0;
        int end = start+1;
        int strLength = s.length();
        int count = 0;

        //ex) rrace
        //r rr arr acrr acerr
        //r ar acr acer
        //a acr ace
        //c ce
        //e 이라서 count 1 -> 순회하면서 똑같은 값 존재 시 count 올라가게하려고 Arrays.sort()를 함 ! 이게 중요
        Map<String,Integer> str = new HashMap<>();
        while(start<strLength){
            char[] c = s.substring(start,end).toCharArray();
            Arrays.sort(c);
            String temp = String.valueOf(c);

            System.out.println(temp);

            if(!str.containsKey(temp)){
                str.put(temp,1);
            }else{
                int freq = str.get(temp);
                count += freq;
                str.put(temp,freq+1);

            }
            end++;

            if(end > strLength){
                start++;
                end = start+1;
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);

//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
