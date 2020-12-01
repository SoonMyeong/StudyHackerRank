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
 * 딕샤를 위한 타움의 생일축하 계획
 * 블랙과 화이트 타입을 선물 할 것이며, 블랙과 화이트 가격 및 블랙<->화이트 간 변환 비용을 제공 한다.
 * b - 블랙 , bc - 블랙 타입 가격 , w -화이트 , wc - 화이트 타입 가격 , z - 변환 비용
 * 선물할 블랙타입과 화이트타입의 최소가격을 구하는 문제
 * 참고 : 범위가 0~10^9 까지이다. 무슨말인지 알죠? 시간복잡도 생각해가면서 풀기
 *
 */
class Result {

    /*
     * Complete the 'taumBday' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER b
     *  2. INTEGER w
     *  3. INTEGER bc
     *  4. INTEGER wc
     *  5. INTEGER z
     */

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here
        // 1. bc 와 wc가격이 같을 경우
        //10
        //27984 1402
        //619246 615589 247954

        long result = 0;
        long bLong = (long) b;
        long wLong = (long) w;
        long zLong = (long ) z;
        long bcLong = (long) bc;
        long wcLong = (long) wc;

        //2. bc > wc+z 인 경우
        if(bc > wc+z){
            result= (bLong+wLong)*wcLong + (bLong*zLong);
        }
        //3. wc > bc+z 인 경우
        else if (wc > bc+z){
            result= (bLong+wLong)*bcLong + (wLong*zLong);
        }
        else{
            result= bLong*bcLong + wLong*wcLong;
        }
        System.out.println(result);
        return result;
    }

}
public class TaumAndBday {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        IntStream.range(0, t).forEach(tItr -> {
//            try {
                String[] firstMultipleInput = scanner.nextLine().split(" ");

                int b = Integer.parseInt(firstMultipleInput[0]);

                int w = Integer.parseInt(firstMultipleInput[1]);

                String[] secondMultipleInput = scanner.nextLine().split(" ");

                int bc = Integer.parseInt(secondMultipleInput[0]);

                int wc = Integer.parseInt(secondMultipleInput[1]);

                int z = Integer.parseInt(secondMultipleInput[2]);

                long result = Result.taumBday(b, w, bc, wc, z);

//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
        });

//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
