package com.soonworld.dayofcode;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RegEx {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        List<String> arr = new ArrayList<>();

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];

            String[] email = emailID.split("@");

            if(email[1].equals("gmail.com")){
                arr.add(firstName);
            }
        }
        arr.sort(Comparator.comparing(o1 -> o1));
        for(String result : arr){
            System.out.println(result);
        }

        scanner.close();
    }
}
