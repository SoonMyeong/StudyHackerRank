package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 해커랜드의 광고바이러스...
 * 새로운 상품을 런칭할 때 5명의 사람에게 광고를 공유 한다. (default)
 * 5명 중 floor(5/2)명은 좋아요를 눌러준다.
 * 다음날이 될때마다 좋아요를 누른사람x3명만큼 공유하는 사람이 늘어난다.
 * 둘째날의 경우 floor(5/2)x3 =6명이 광고를 공유한다. 받는 좋아요 개수는 floor(6/2) 3개 이다.
 * 셋째날의 경우 floor(6/2)x3 = 9명이 광고를 공유한다. 받는 좋아요 개수는 floor(9/2) 4개이다.
 * ...
 * n번째 날에는 받는 좋아요의 누적개수는 몇개인지 구하는 문제
 */
public class ViralAdvertising {
    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {



        //Discussions에서는 초기값부터 for문에 넣어 계산
        // 참 씸플하네..
      /*  for(int i = 0; i < num; i++){
            people = (int) Math.floor(people/2);
            sum += people;
            people *= 3;
        }*/



        //내 풀이의 경우 초기값은 따로하고 그 이후부터 for문을 들어갔다.
        //좀 더 깔끔해 지려면 person 구한값에서 *3으로 다음 사람수를 측정하고 들어가는게 맞네..
        //1. 초기값 설정
        int init =5;
        //2. 초기값 좋아요 개수 저장
        int count = likeCount(init);
        int person = 0;

        for(int i=2; i<=n; i++){
            if(i==2){
                //3. 다음날 될때의 공유하는사람 계산
                person = likeCount(init)*3;
                count += likeCount(person);
            }else{
                //다음날 될때 공유하는사람 계산
                person = likeCount(person)*3;
                //3-1. 공유하는사람들의 좋아요 개수 계산 및 누적
                count += likeCount(person);
            }
        }
        return count;
    }
    static int likeCount(int person){
        return (int)Math.floor((double)person/2);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
