package com.soonworld.interview.hashmaps;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Ransom Note 만들기
 * 잡지에 있는 단어를 가지고 Ransom Note를 만들려고 한다.
 * 잡지에 적혀있는 단어와 note에 적힌 단어를 입력 받아
 * note에 적힌 단어 모두가 잡지에 속해있으며 중복 사용하지 않을 시  Yes, 아니면 No를 출력 하는 문제
 */
public class RansomNote {
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        Map<String,Integer> magazineMap = new HashMap<>();
        boolean isVal = true;
        for(String word : magazine){
            magazineMap.merge(word, 1, Integer::sum); //java8에 나온..merge..
        }

        for(String word : note){
            Integer i = magazineMap.get(word);

            if(i!=null && i>0){
                magazineMap.put(word,i-1);
            }else{
                isVal = false;
            }
        }

        if(!isVal){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
