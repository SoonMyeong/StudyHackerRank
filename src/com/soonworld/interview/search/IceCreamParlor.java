package com.soonworld.interview.search;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 * 아이스크림 가게
 * 써니와 조니는 아이스크림 가게에서 아이스크림을 산다.
 * 써니와 조니의 돈은 공유하며 각각 다른 맛을 사야 한다.
 * 아이스크림 가격은 cost 배열로 주며 두번째로 살 아이스크림은 첫번째로 산 아이스크림가격보다 높아야 한다.
 * 또한 두 아이스크림의 가격의 합은 그들이 가지고 잇는돈과 같아야 한다.
 * 위 조건을 만족하는 cost의 인덱스+1 값들을 출력하시오.
 *
 * 최적화를 못해서 Discussion 참고
 */

public class IceCreamParlor {
    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        //코드리뷰가 필요한 이유..
        //money-최대값 인 가격은 최소값이겠지를 생각
        //O(n)으로 해결 가능

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<cost.length; i++){
            int minCost = money-cost[i];
            if(map.containsKey(minCost)){
                System.out.println((map.get(minCost)+1)+" "+(i+1));
            }
            map.put(cost[i],i);
        }



        //타임아웃발생,  시간복잡도가 O(NxMxL) 로 높은건 맞는데..
        //검색을 어떻게 하지
//        int [] copy = cost.clone();
//        Arrays.sort(copy);
//        for(int i=0; i<copy.length-1; i++){
//            for(int j=i+1; j<copy.length; j++){
//                if(copy[i]+copy[j]==money){
//                    int oneId = copy[i];
//                    int twoId = copy[j];
//                    int resultOne = 0;
//                    int resultTwo = 0;
//                    for(int k=0; k<cost.length; k++){
//                        if(resultOne==0 && oneId == cost[k]){
//                            resultOne = k+1;
//                        }else if(resultTwo==0 && twoId ==cost[k]){
//                            resultTwo = k+1;
//                        }
//                    }
//
//                    System.out.println((Math.min(resultOne, resultTwo))+" "+(Math.max(resultOne,resultTwo)));
//                    return;
//                }
//            }
//        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
