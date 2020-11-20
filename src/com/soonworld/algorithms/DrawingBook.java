package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class DrawingBook {
    /*
     * Complete the pageCount function below.
     * n 페이지까지 존재하는 책에서 p라는 페이지에 가려고 할 때
     * 1페이지에서 부터 한장씩 넘기는 장 수와  끝페이지에서 한장씩 넘기는 장 수 중
     * minimum 값을 출력 하는 문제
     * 접근 방법에 대해 고민 후 접근 시 어렵지 않다. 다만 조금 헤깔릴 수 있음;
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
        //1. 책이 펼처진 두 페이지를 하나로 관리하기 위한 리스트 생성
        List<int[]> init = new ArrayList<>();
        int count = 0;

        //2. (0,1) (2,3) (4,5) (6,7) ... 이런식으로 리스트에 저장. (문제 책 보여지는 것과 동일)
        for(int i=0; i<=n; i+=2){
            int[] page = new int[2];
            page[0] = i;
            page[1] = i+1;

            init.add(page);
        }

        //3. 찾아야 할 p 값이 어디있는지 순차적으로 돌아가며 확인 p값이 해당 될때 넘긴 책장의 count를 가지고 있는다.
        for(int [] j : init){
            count++;
            if(j[0] == p || j[1] == p){
                break;
            }
        }

        //4. 2쪽을 하나로 관리하는 페이지에서 p값을 찾을떄까지의 넘긴 개수를 뺀 값에 대해
        // 맨 앞장에서 넘겼을때의 count와  맨 뒷장에서 넘겼을떄의 count 값을 비교하여 더 작은 값 리턴.
        if((init.size())-count < (count-1)){
            return (init.size())-count;
        }else{
            return (count-1);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//        int p = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(6, 2);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
