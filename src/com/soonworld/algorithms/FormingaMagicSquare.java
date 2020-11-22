package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 * tesecase 1~10번에 대해 다 에러가 나서 Discussion 참고 한 문제
 * 이 문제를 해결 하기 위해선 3x3에서 나올 수 있는 모든 마방진(매직스퀘어)을 배열로 가지고 있고
 * 그 배열들을 순회하면서 입력받은 값들의 차들 중 최소값을 뽑아 낼 수 밖에 없는 문제.
 *  3x3 에서는 매직스퀘어가 8가지가 존재한다는 사실을 알고 있었더라면 조금은 쉽게 풀 수 있는 문제!
 *  가장 상단 댓글을 다신 분의 내용을 보니 이 문제가 코딩테스트에 나온다면 3x3로 만들 수 있는 모든 마방진 리스트를 조회할 수 있도록 해주는게 맞을거 같다는 내용이 있다.
 *  난 포인트 많이 얻고 싶으니까(골드 가고싶은 실버의 마음..) 어떻게든 풀어야되므로 discussion 참고하여 문제를 해결했다.
 *  그냥 한마디로 논란의 문제임
 */

public class FormingaMagicSquare {
    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int [][][] magic_mat = { //8,3,3
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
        };

        int min=81; // 9x9 (사용자가 9 9개 입력하는게 최대값)

        for(int i=0; i<8; i++){
            int count =0;
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    count += Math.abs(s[j][k]-magic_mat[i][j][k]);
                }
            }
            if(min>count){
                min=count;
            }
        }

        return min;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = {{4,8,2},{4,5,7},{6,1,6}};

//        for (int i = 0; i < 3; i++) {
//            String[] sRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 3; j++) {
//                int sItem = Integer.parseInt(sRowItems[j]);
//                s[i][j] = sItem;
//            }
//        }

        int result = formingMagicSquare(s);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
