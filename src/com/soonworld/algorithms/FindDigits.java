package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;


/**
 * 숫자 n을 입력받아 숫자를 1의자리로 쪼갠 뒤  쪼갠값들 중 숫자n을 나눴을 때 나머지가 0인 값들의 합 리턴
 * ex) 12
 * -> 1,2 로 쪼갤 수 있으며 각각의 숫자로 12를 나눴을 때 나머지는 0 이므로 합인 2 리턴
 */
public class FindDigits {
    // Complete the findDigits function below.
    static int findDigits(int n) {
        String[] temp = String.valueOf(n).split("");
        List<Integer> digits = new ArrayList<>();
        int count = 0;

        for(String num : temp){
            digits.add(Integer.parseInt(num));
        }

        digits.stream().distinct().collect(Collectors.toList());

        for(int digit : digits){
            if(digit!=0 && n%digit==0) count++;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);
            System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
