package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 *  Kaprekar Numbers 구하기
 *  어느 숫자의 제곱값을 두개의 숫자로 쪼갠 뒤 그 두개의 숫자의 합이 기존 값과 동일한 경우 Kaprekar Number가 된다.
 *  범위를 입력받았을 때 범위 내에 있는 Kaprekar Numbers 들을 구하는 문제
 */
public class ModifiedKaprekarNumbers {
    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        List<Integer> result = new ArrayList<>();
        for(int i =p; i<=q; i++){
            String [] nums = String.valueOf((long)i*i).split("");
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();

            if(i==1){ //1인 경우
                result.add(1);
            }else if(i>3){
                for(int j=0; j<nums.length/2; j++) a.append(nums[j]);
                for(int k=nums.length/2; k<nums.length; k++) b.append(nums[k]);

                if(a.length()>=1 && b.length()>=1 &&
                        Integer.parseInt(a.toString()) + Integer.parseInt(b.toString()) == i) {
                    result.add(i);
                }
            }
        }
        if(result.isEmpty()){
            System.out.print("INVALID RANGE");
        }else{
            result.forEach(x->{
                System.out.print(x+" ");
            });
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
