package com.soonworld.dayofcode;
import java.io.*;
import java.util.*;

public class RunningTimeAndComplexity {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            boolean prime = true;
            int num = scanner.nextInt();
            if(num==1){
                prime = false;
            }
            int j=2;
            while (j<=Math.sqrt(num)) {  //소수 구하는 알고리즘 중 O(루트N)인 경우는 2부터 해당 숫자의 루트값까지만 계산하면 된다.
                if(num%j==0){
                    prime = false;
                    break;
                }
                j++;
            }
            if(prime){
                System.out.println("Prime");
            }else{
                System.out.println("Not prime");
            }

        }


    }
}
