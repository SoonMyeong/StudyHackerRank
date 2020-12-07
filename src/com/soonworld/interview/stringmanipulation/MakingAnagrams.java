package com.soonworld.interview.stringmanipulation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 * 애나그램 만들기
 * 두개의 스트링을 입력받아, 각각의 스트링에서 몇개의 문자를 지워야 애나그램이 되는지 구하는 문제
 *
 */

public class MakingAnagrams {
    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int count = 0;
        char [] aString = a.toCharArray();
        char [] bString = b.toCharArray();

        for(int i=0; i<aString.length; i++){
            for(int j=0; j<bString.length; j++){
                if(aString[i]==bString[j]){
                    count++;
                    bString[j] = '0';
                    break;
                }
            }
        }

        return aString.length+bString.length - 2*(count);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
