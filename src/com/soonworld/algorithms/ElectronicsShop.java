package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/**
 * 전자 상점에서의 구매
 * ex) b = 60
 * keyboards = [40,50,60]
 * drives = [5,8,12]
 *  내 돈 60을 가지고 살 수 있는 가장 비싼 금액은 50+8인 58이 된다.
 *  결국, 키보드와 드라이브의 합이 내가 가지고 있는 돈과 가장 가까운 값을 찾아내면 됨
 *
 */

public class ElectronicsShop {
    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        List<Integer> arr = new ArrayList<>();

         // 1. 이중포문을 돌린다.
            for(int i : keyboards) {
                for(int j: drives){
                    // 2. a+b를 했을 때 이 가격이 내가 가진 값보다 크면 안넣는다.
                    if(i+j<=b){
                        // 2-1. 내돈 (b) -(a+b) 값을 리스트에 넣는다.
                        arr.add(b-(i+j));
                    }
                }
            }
            //size가 0일 땐 살 수 있는 금액이 안된다는것. -1 리턴
            if(arr.size()==0){
                return -1;
            }
             // 3. 마지막에 그 리스트를 순회하면서 최소값을 뽑는다.
            int mininum = arr.get(0);
            for(int min : arr){
                if(mininum>min) mininum =min;
            }
            System.out.println(mininum);
            // 4. 마지막에 리턴할 때는 b-최소값을 을 print한다.
            return (b-mininum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] bnm = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//        int b = Integer.parseInt(bnm[0]);
//
//        int n = Integer.parseInt(bnm[1]);
//
//        int m = Integer.parseInt(bnm[2]);
//
//        int[] keyboards = new int[n];
//
//        String[] keyboardsItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
//            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
//            keyboards[keyboardsItr] = keyboardsItem;
//        }
//
//        int[] drives = new int[m];
//
//        String[] drivesItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
//            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
//            drives[drivesItr] = drivesItem;
//        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int[] keyboards ={3,1};
        int[] drives = {5,2,8};

        int moneySpent = getMoneySpent(keyboards, drives, 10);

//        bufferedWriter.write(String.valueOf(moneySpent));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
