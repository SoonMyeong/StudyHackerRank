package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 유토피안 나무의 n기간 뒤 성장된 길이를 측정하는 문제
 * 이 나무는 매 봄마다 기존길이의 2배만큼 성장하며 매 여름마다 1미터씩 성장 한다. (2 cycle)
 * 최초 심을때의 나무 길이는 1미터 이다.
 * ex) cycle=1 일 경우  봄이 먼저이므로 1x2 = 2가 된다.
 * cycle =2 일 경우  봄->여름이므로 기존 cycle 1일때의 나무 길이인 2+1 = 3 이 된다.
 */
public class UtopianTree {
    // Complete the utopianTree function below.
    static int utopianTree(int n) {
        int height = 0;


        //나의 경우 for문을 썼는데 , Discussion 보니까 다들 재귀함수 썼음, 재귀생각 못한건 아니였는데..
        // 공식화 해내는데 시간이 더 걸릴거 같아 직관적인 for문을 사용했었음.
        //하지만 재귀함수를 쓰게 되면 훨씬 더 코드가 심플해진다.
        //앞으로 수학적인 문제인거같으면 내뜻대로 풀되 Discussions 를 참고해봐야 겠다.

        //재귀함수 쓸 경우
        if(n<3){
            return n+1;
        }else if(n%2 ==0){
            return (utopianTree(n-2)*2)+1;
        }else{
            return (utopianTree(n-2)+1)*2;
        }

        //나의 풀이
//        for(int i=0;i<=n; i++){
//            //1. n=0 일 경우(초기값) 1
//            if(i==0){
//                height=1;
//            }
//            //2. 홀수 일경우 봄, 짝수일 경우 가을
//            if(i!=0 && i%2==0){
//                height=height+1;
//            }else if (i!=0 && i%2!=0){
//                height=(height*2);
//            }
//        }
//
//        return height;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = utopianTree(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
