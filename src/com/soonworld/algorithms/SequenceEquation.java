package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 함수 문제
 * p(p(y)) = x
 * x는 1~5사이의 숫자이다.
 * ex) p = {5,2,1,3,4}
 * x = 1일때, p[3]=1 , p[4]=3, 따라서 p[p[4]] = 1;
 * .. x가 1~5일때의 y값들의 배열을 리턴
 */
public class SequenceEquation {

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        int [] y = new int[p.length+1];
        int [] temp = new int[p.length+1];


        //생각을 좀 더 단순화하면 문제가 쉽게 풀린다.( Discussion 참고)
        // ex) p={2,3,1}
        // temp[2] = 1 , temp[3]=2 , temp[1]=3  이렇게 들어가게 된다.
        for(int i=1; i<=p.length; i++){
            temp[p[i]] = i; // p값을 인덱스로 넣는다.
        }

        //마찬가지로 y에 저장 시
        //y[1] = temp[3]값 2 , y[2] = temp[1]값 3 , y[3] = temp[2]값 1 이렇게 들어가게 된다.
        //이 문제의 핵심은 인덱스와 그에 해당하는 값을 역으로 다른 배열에 넣어두는 것이다.
        for(int i=1; i<=p.length; i++){
            y[i] = temp[temp[i]];  //ex) temp[0]은 p[i]가 0인 인덱스값이 된다.
        }




        //[내풀이] 이중루프를 두번이나 썼기 때문에 시간복잡도 측면에서는 매우 비효율적인 코드가 될 수 있다...
        //1. x가 i일때 p 값 다른 배열에 저장
//        for(int i=0; i<p.length; i++){
//            for(int j=0; j<p.length; j++){
//                if(i==p[j]-1){
//                    temp[i] = j+1;
//                }
//            }
//        }
//
//        //2. 다른배열에 p 값과 p 인덱스가 같은 값을 y에 저장
//        for(int k=0; k<temp.length; k++){
//            for(int l=0; l<p.length; l++){
//                if(temp[k]==p[l]){
//                    y[k] = l+1;
//                }
//            }
//        }


        return y;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);

//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
