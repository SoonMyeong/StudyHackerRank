package com.soonworld.dayofcode;
import java.io.*;
import java.util.*;

public class LetsReview {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        List<String> arr = new ArrayList<>(); // 입력받은 스트링 저장소
        List<String[]> result = new ArrayList<>(); //arr에 들어있는 스트링 다 쪼개서 보관하는 저장소
        int n = scanner.nextInt();
        scanner.nextLine();

        for(int i=0; i<n; i++){
            arr.add(scanner.nextLine());
        }

        for(String str : arr){
            result.add(str.split(""));
        }

        //출력
        for(String[] sar : result){
            for(int i=0; i<sar.length; i++){
                if(i%2==0) System.out.print(sar[i]);
            }
            System.out.print(" ");
            for(int j=0; j<sar.length; j++){
                if(j%2!=0) System.out.print(sar[j]);
            }
            System.out.println();
        }



    }
}
