package com.soonworld.interview.greedy;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 레나의 운은 몇점인가?
 *  L[i] : 콘테스트가 열릴때 생기는 운의 양이며 레나가 콘테스트에서 이길 시 L[i]만큼 운이 감소하고,
 *         지게 될 경우 L[i]만큼 운이 증가 한다.
 *  T[i] : 중요한 경기임을 표현, 1일경우 중요한 경기, 0일 경우 그렇지 않은 경기 이다.
 *  k : 레나가 겪을 중요한 경기의 개수 -> k개수 만큼 중요한 경기에서 질 수 있다.
 *  예를 들어 콘테스트가 3번 열릴 때, L[i] 값이 {5,1,4} 라면
 *  레나가 모든 콘테스트에서 패배할 시 5+1+4 = 10의 운을 가지게 된다. 여기서 k값이 만약 1이라면 T[i]의 개수가 2일 때,
 *  2번의 중요한 경기 중 한번은 이기게 된다. 여기서 레나는 콘테스트 중 운이 가장 낮은 콘테스트를 골라서 이길 수 있게 되는데
 *  따라서 5+4-1(운 점수 가장낮은 판) 이 되어 최종적으로 8이라는 운을 얻게 된다. //ㅡㅡ;
 *
 */
public class LuckBalance {
    // Complete the luckBalance function below.

    //O(n+m)
    static int luckBalance(int k, int[][] contests) {
        //사전 조건 1. k값과 T[i] 개수가 동일 할 경우 모든 경기를 진다고 생각하고 모든 운을 더한 값이 최대 가질 수 있는 운
        //사전조건 2. k값이 T[i] 개수 보다 작을 경우 T[i] 중 가장 낮은 값만 운의 합산에서 뺀 값이 최대 가질 수 있는 운

        //1. L[i]에 대해서 오름차순, T[i]에 대해서 내림차순 되어 있으면 쉽게 계산 가능
        Arrays.sort(contests, Comparator.comparing(o2->o2[1])); // 1열에 대해 내림 차순
        Arrays.sort(contests,(o1,o2)->{
           if(o1[1]==o2[1]){ //같은 열일 경우
                return Integer.compare(o1[0],o2[0]); //0열에 대해 오름 차순
           }else{
               return Integer.compare(o2[1],o1[1]);
           }
        });

        int sum = 0;
        int count = 0;

        //2. 중요한경기 개수 구하면서 일단 전체 합산
        for(int i=0; i<contests.length; i++){
            if(contests[i][1]==1){
                count++;
            }
            sum+=contests[i][0];
        }
        //3. 전체 합산에서 count-k 만큼 이긴거니까 그만큼 빼기
        for(int i=0; i<count-k; i++){
            sum-= 2*contests[i][0];
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);
        System.out.println("result :"+result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
