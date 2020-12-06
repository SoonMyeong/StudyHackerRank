package com.soonworld.interview.hashmaps;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * RansomNote와 같은 유형의 문제
 */
public class TwoStrings {
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        String [] str = s1.split("");
        String [] str2 = s2.split("");
        boolean isVal = false;
        String result = "";
        Map<String,Integer> map = new HashMap<>();

        for(String word : str){
            map.merge(word,1,Integer::sum);
        }

        for(String word : str2){
            Integer i = map.get(word);
            if(i!=null && i>=1){
                isVal = true;
                break;
            }
        }

        if(isVal){
            result = "YES";
        }else{
            result = "NO";
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
