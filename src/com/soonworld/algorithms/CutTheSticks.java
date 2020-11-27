package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * [막대기들 자르기 ]
 * 배열안에 각각의 길이의 막대기들이 들어있다.
 * 막대기들 중 길이가 가장 짧은 막대기들을 배열에서 지우면서 남은 막대기들은 지운 막대기길이만큼 길이를 줄인다.
 * 배열 요소가 모두 없어질 때 까지 반복 하고, 각 반복을 실행 할때마다 남아있는 누적 막대기 개수를 따로 저장해 뒀다가 배열에 담아 리턴한다.
 * 단, 배열 요소의 값들이 모두 같을 경우 위 작업을 할시 0을 리턴 할 것이다.
 * 범위는 1~1000까지, (개수,길이)
 */
public class CutTheSticks {
    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        int i  = 0;
        List<Integer> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int a : arr) list.add(a);

        //Discussions 참고 explain
        // Hint: Sort the array
        //As we traverse the array from left to right, every time we reach a new number,
        //        we can consider that as "cutting the sticks" for the numbers we already traverse.
        //우와, 오름차순 정렬하고 두 요소간에 값이 다르면 그때마다 길이-인덱스값 으로 남은 길이를 계산... O(n)
        /* for (int i = 1; i < array.length; i++) {
             if (array[i] != array[i-1]) {
                System.out.println(array.length - i);
            }
        }*/

        //내 풀이 시간복잡도가.. 최소 O(n^2)..
        while(list.size()>0) {
            //1. 배열 요소 중 최소길이 구하기
            int minLength = 1001;
            for (int stick : list) {
                if (minLength >stick) {
                    minLength = stick;
                }
            }
            System.out.println("size-start"+list.size() + "min:"+minLength);
            //2. 리스트에서 제거 전 길이를 result 배열에 저장
            result.add(list.size());
            //3. 구한 최소길이를 리스트에서 제거
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == minLength) {
                    list.remove(j);
                    j=-1; //list가 remove 시 인덱스 정렬 해주므로 다시 처음부터 순회
                }
            }

            System.out.println("size-end:"+list.size());
            i++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

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
