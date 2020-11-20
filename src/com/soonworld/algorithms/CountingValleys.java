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

public class CountingValleys {
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here

        //초기값 설정
        String[] arr = new String[steps];
        int count = 0;
        int result = 0;
        boolean isDown = false;
        boolean isValley = false;


        arr = path.split("");

        //1. count가 -2보다 작아진 후 부터 0이 되는 순간이 valley 1개 임

        for(String str : arr){
            if(str.equals("U")){
                count++;
            }else{
                count--;
            }

            if(count <=-2){
                isDown=true;
            }

            if(isDown && count==0){
                result++;
                isDown=false;
            }
        }
        System.out.println("result : " +result);
        return result;


    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int steps = Integer.parseInt(bufferedReader.readLine().trim());
//
//        String path = bufferedReader.readLine();

        int result = countingValleys(8, "UDDDUDUU");

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
