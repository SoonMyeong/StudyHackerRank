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
 *  이주 하는 새 종류 조사
 *  새( tpye : 1,2,3,4,5) 중 타입 별 몇 마리씩 존재하는지 확인 후 가장 많은 타입(숫자)을 리턴
 *  단, 만약 타입별 수가 동일 할 경우 타입이 가장 낮은 숫자로 리턴
 */
public class MigratoryBirds {
    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
    //1. switch문을 통해 각각의 타입 개수를 int [] ar 에 저장
            int [] ar ={0,0,0,0,0};
            int max = 0;
            int result = 0;
            for(int i : arr){
                switch(i){
                    case 1 : ar[0]+=1; break;
                    case 2 : ar[1]+=1; break;
                    case 3 : ar[2]+=1; break;
                    case 4 : ar[3]+=1; break;
                    case 5 : ar[4]+=1; break;
                }
            }

            //2. ar에서 MAX값 찾기
            for(int i : ar){if(i>max) max = i;}
            //3. ar을 순차적으로 돌면서 MAX값 발견 될 때 먼저 발견 된(가장 낮은 인덱스) 값 리턴
            for(int j=0; j<ar.length; j++){
                if(ar[j]==max) {
                    result=j+1; //인덱스는 0부터 시작하므로
                    break;
                }
            }
            return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
