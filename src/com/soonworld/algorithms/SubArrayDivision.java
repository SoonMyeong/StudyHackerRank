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

//릴리는 론의 생일의 월(m)과 일(d)을 가지고 초콜렛을 쪼개려 한다.
// m개의 인덱스의 합이 d가 되는 경우의 수를 구하라는 문제
// 이중포문으로 끝날거 같아서 생각하는데 시간이 좀 걸렸던 문제!
// Discussion 참고 해본 결과 Stream 함수를 이용시 쉽게 해결...
// SAMPLE INPUT
// 5
// 1 2 1 3 2
// 3 2

// SAMPLE OUTPUT
// 2

public class SubArrayDivision {
    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        int sum = 0;

        // Arrays.stream을 이용한 한결 짧아진 코드
//        int [] list = new int[s.size()];
//        for(int i=0; i<s.size(); i++) list[i] = s.get(i);
//
//        for(int j=0; j<s.size()-m; j++){
//            if(Arrays.stream(list, j,j+m).sum()==d){
//                count++;
//            }
//        }


        //내 풀이
        for(int i=0; i<=s.size()-m; i++){
            for(int j=i; j<=i+m-1; j++){
                sum+= s.get(j);
            }
            if(sum==d) count++;

            sum=0;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
