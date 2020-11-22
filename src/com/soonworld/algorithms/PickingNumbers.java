package com.soonworld.algorithms;
import sun.applet.Main;

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
 * Collections.sort를 하여 접근 시 해결 가능
 * 오름차순 정렬한 뒤 첫번째부터 인덱스차(절대값)가 0 ,1인 경우 까지 리스트에 넣고
 * 다음 인덱스를 시작으로 다시 인덱스 차가 0 ,1 인 경우 새로운 리스트에 다시 넣는 작업 반복 후
 * 리스트들의 리스트 (result)를 순회하면서 사이즈를 비교해가며 가장 길이가 긴 값을 리턴
 *
 */

public class PickingNumbers {
    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        //1. a 리스트 오름차순으로 정렬
        Collections.sort(a);
        List<List<Integer>> result = new LinkedList<>();
        int max = 0;
        int count = 0;
        // 1 3 3 4 5 6
        for(int i=0; i<a.size(); i++){
            List<Integer> num = new ArrayList<>();
            for(int j=i; j<a.size(); j++){
                if(Math.abs(a.get(i)-a.get(j))==0 || Math.abs(a.get(i)-a.get(j))==1){
                    num.add(a.get(j));
                    count=j; // 2. count 값은 결국 인접한 두 인덱스의 차가 0,1 인 마지막 값이 될 것이다.
                }
            }
            result.add(num); // 한번 완성된 리스트는 result에 넣어 준다.
            i=count; //i 의 다음값을 다음 쪼갤 숫자로 정해 준다. +1을 안해주는건 바깥 for문 다시 들어올때  +1 되므로
        }

        for(List<Integer> list : result){
            if(list.size()>max){
                max = list.size(); // 쪼개진 리스트들 중 길이가 가장 긴 값을 저장
            }
        }
        System.out.println(max);
        return max;
    }
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());

        List<Integer> a = new ArrayList<>();
        a.add(4); a.add(6); a.add(5); a.add(3); a.add(3); a.add(1);
        int result = pickingNumbers(a);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
