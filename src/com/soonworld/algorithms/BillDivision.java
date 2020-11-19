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

public class BillDivision {
    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {
        // 브라이언과 안나의 저녁식사값에 대해 원래의 n빵한 가격과 브라이언이 계산한 가격이
        // 맞는지 확인 및 다를 시 얼마를 안나에게 돌려줘야 하는지
        int sum=0;

        for(int i=0; i<bill.size(); i++){
            if(bill.get(i)!=bill.get(k)){
                sum+=bill.get(i);
            }
        }
        if((sum/2)==b){
            System.out.println("Bon Appetit");
        }else{
            System.out.println(b-(sum/2));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
