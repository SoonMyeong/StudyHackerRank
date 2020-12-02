package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 컨테이너 안에 있는 볼 바꿔서 정렬하기
 * 예를들어 2x2 배열이 주어질 때
 *      type      0  1
 *               ----
 *  container 0 | 1  1
 *  container 1 | 1  1
 *
 *  라고 한다면 행은 container가 되고 열에 있는 숫자가 볼의 종류이며 값이 볼의 종류가 들어있는 개수가 된다.
 *  위 예에서는 container0 에는 0- 1개 , 1-1개 가 들어있고
 *  container1 에는 0 -1개 , 1-1개가 들어있다.
 *  각 컨테이너의 1과 0을 교체 할 경우 컨테이너는  한 종류의 공으로 통일 된다.
 *  컨테이너와 타입과 공의 개수가 주어질 때, 컨테이너끼리 공을 교환해서 공이 한 종류로 통일이 되는지 여부를 파악하는 문제
 *  ---------------------
 *  Discussions 참고하여 해결
 *  이 문제의 핵심은 컨테이너 별 공의 개수와 타입별 공의개수가 같아야 한다는걸 인지 해야 하는 것이다.
 *  또한 container 0에는 공 0으로만 이루어져야 하고 , container 1에는 공 1로만 이뤄져야 한다.. (예제가 좀 불친절했다.)
 */


public class OrganizingContainersOfBalls {
    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        String result = "Possible";
        int n = container.length;
        int [] containersCount = new int[n];
        int [] typeBallCount = new int[n];

        //1. 컨테이너 별 공의 개수와 타입별 공의 개수 구하기
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                containersCount[i] += container[i][j];
                typeBallCount[j] += container[i][j];
            }
        }

        //2. 컨테이너의 공의 개수와 타입별 공의 개수가 같을 경우 교환
        for(int i=0; i<n; i++){
            int j=0;
            for(j=i; j<n; j++){
                if(containersCount[j]==typeBallCount[j]){
                    int temp = typeBallCount[j];
                    typeBallCount[j] = typeBallCount[i];
                    typeBallCount[i] = temp;
                    break;
                }
            }
            if(j==n){
                result = "Impossible";
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);
            System.out.println(result);
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
