package com.soonworld.interview.greedy;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 *  욕심 많은 플로리스트 - 문제 자체를 이해하는데 오래걸림;
 *  플로리스트는 손님들에게 처음 구매하는 꽃에 대해서는 (0+1)xoriginal price인 원래 가격에 파는데,
 *  이 손님이 아무 꽃이나 한 송이 더 사게되면 (1+1)xoriginal price 인 가격에 꽃을 판매 한다.
 *  (현재 구매 개수+1) -- 많이 살수록 돈을 더 많이 부여하다니..
 *  손님들 k명은 n개의 꽃들을 모두 구매한다고 가정할 때 가장 합리적인 가격은 얼마 인지 구하는 문제
 *
 */
public class GreedyFlorist {
    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c); //오름차순 진행
        int min = 0;
        int count =0;
        int val = 1;

        //가독성 면에선 괜찮다고 생각함..
        //1. 손님 수와 꽃의 리스트 개수가 같을 땐 꽃 가격의 합을 모두 더하면 된다. (각자 한송이 씩만 사면 되니까)
        if(k==c.length){
            for(int price : c){
                min += price;
            }
        }else if(k<c.length){ //2. 손님 수 보다 꽃의 리스트 개수가 더 많을 경우엔 꽃 리스트(가격 오름차순 기준)끝에서 부터 구매를 한다.
            for(int i=c.length-1; i>=0; i--){
                count++;
                if(count<=k){
                    min += val * c[i];
                }else{
                    count = 1;
                    val++;
                    min += val * c[i];
                }
            }
        }else{ //3. 꽃의 리스트 개수 보다 손님 수가 더 많을 경우엔 꽃 리스트(가격 오름차순 기준)처음에서 부터 구매를 한다.
            for(int i=0; i<k; i++){
                count++;
                if(count<=c.length) {
                    min += val * c[i];
                }else{
                    count = 1;
                    val++;
                    min += val * c[i];
                }
            }
        }

        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        System.out.println(minimumCost);

//        bufferedWriter.write(String.valueOf(minimumCost));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
