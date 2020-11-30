package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 *  최대 많은 주제의 갯수와 그 갯수로 만들 수 있는 팀의 개수 구하기
 *  각 문자열은 1과 0으로 구성되어있으며 주제에 대해 알려진 경우 1 그렇지 않은 경우 0
 *
 */
public class ACMICPCTeam {
    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int max = 0;
        int counting = 0;
        int [] result = new int[2];


        for(int i=0; i<topic.length-1; i++){
            for(int j=i+1; j<topic.length; j++ ){
                int count = 0;
                for(int k=0; k<topic[i].length(); k++){
                    //topic에 대한 String 배열로 한번씩 짤라서 계산 시 타임아웃 발생! charAt으로 수정
                    if(topic[i].charAt(k)=='1'|| topic[j].charAt(k)=='1'){ //String 배열로 자르는 cost낭비하지말고 charAt 써서  바로 비교
                        count++;
                    }
                }
                if(max<count){
                    max = count;
                    counting = 1;
                }else if(count==max){
                    counting++;
                }
            }
        }
        result[0] = max;
        result[1] = counting;

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

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
