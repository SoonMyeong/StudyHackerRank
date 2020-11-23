package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * 이 문제의 핵심 알고리즘
 * LCM , GCM
 * 최소 공배수가 필요한건 알았는데 b 배열의 최대 공약수까지는 생각 못했음
 * Discussions 참고하여 마무리
 */
public class BetweenTwoSets {
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int count = 0;
        int gcd = b.get(0);
        int lcm = a.get(0);

        //1. a 배열의 최소 공배수를 구한다.
        for(int el : a){
            lcm = (lcm*el) / gcd(lcm,el);
        }
        System.out.println("lcm:" + lcm);

        //2. b 배열의 최대 공약수를 구한다.
        for(int el2 : b){
            gcd = gcd(gcd,el2);
        }
        System.out.println("gcd:" + gcd);

        //3. 최소공배수의 곱셈식을 gcd 값보다 작거나 같을 때 까지 반복..
        for(int i=lcm, j=2; i<=gcd; i=lcm*j , j++){
            if(gcd%i==0) count++;
        }

        System.out.println("count :" + count);

        return count;
    }

    //유클리드 호제법
    public static int gcd(int a, int b){
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<>();
        arr.add(2); arr.add(4);
        List<Integer> brr = new ArrayList<>();
        brr.add(16); brr.add(32); brr.add(96);

        int total = getTotalX(arr, brr);
    }
}
