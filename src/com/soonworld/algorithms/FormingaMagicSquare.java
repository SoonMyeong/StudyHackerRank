package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class FormingaMagicSquare {
    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {

        int count = 0;
        int resultCount = 0;
        int[][] copy = new int[3][3];
        int[][] result = new int[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                copy[i][j] = s [i][j];
            }
        }


        if(column1(s)!=15) {
            count = 15 - column1(s);
            //case 1
            s[0][0] += count;
            if ((column1(s) == 15 && row1(s) == 15 && diagonal1(s) == 15)) {
                result[0][0] = s[0][0];
            } else {
                s[0][0] -= count;
                s[0][1] += count;
                if ((column1(s) == 15 && row2(s) == 15)) {
                    result[0][1] = s[0][1];
                } else {
                    s[0][1] -= count;
                    s[0][2] += count;
                    if ((column1(s) == 15 && row3(s) == 15)) {
                        result[0][2] = s[0][2];
                    } else {
                        s[0][2] -= count;
                    }
                }
            }
        }

        if(column2(s)!=15) {
            count = 15 - column2(s);

            //case 2
            s[1][0] += count;
            if ((column2(s) == 15 && row1(s) == 15) || (row2(s)==15 && row3(s)==15)) {
                result[1][0] = s[1][0];
            } else {
                s[1][0] -= count;
                s[1][1] += count;
                if ((column2(s) == 15 && row2(s) == 15 && diagonal1(s) == 15 && diagonal2(s) == 15)) {
                    result[1][1] = s[1][1];
                } else {
                    s[1][1] -= count;
                    s[1][2] += count;
                    if ((column2(s) == 15 && row3(s) == 15)) {
                        result[1][2] = s[1][2];
                    } else {
                        s[1][2] -= count;
                    }
                }
            }
        }

        if(column3(s)!=15) {
            count = 15 - column3(s);
            //case 3
            s[2][0] += count;
            if ((column3(s) == 15 && row1(s) == 15 && diagonal2(s) == 15)) {
                result[2][0] = s[2][0];
            } else {
                s[2][0] -= count;
                s[2][1] += count;
                if ((column3(s) == 15 && row2(s) == 15)) {
                    result[2][1] = s[2][1];
                } else {
                    s[2][1] -= count;
                    s[2][2] += count;
                    if ((column3(s) == 15 && row3(s) == 15 && diagonal1(s) == 15)) {
                        result[2][2] = s[2][2];
                    } else {
                        s[0][2] -= count;
                    }
                }
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(s[i][j]);
                if(result[i][j]!=0){
                    resultCount += Math.abs(copy[i][j]-result[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println(resultCount);
        return resultCount;
    }

    static int column1(int[][] s){
        return s[0][0]+s[0][1]+s[0][2];
    }
    static int column2(int[][] s){
        return s[1][0]+s[1][1]+s[1][2];
    }
    static int column3(int[][] s){
        return s[2][0]+s[2][1]+s[2][2];
    }
    static int row1(int[][] s){
        return s[0][0]+s[1][0]+s[2][0];
    }
    static int row2(int[][] s){
        return s[0][1]+s[1][1]+s[2][1];
    }
    static int row3(int[][] s){
        return s[0][2]+s[1][2]+s[2][2];
    }
    static int diagonal1(int[][] s){
        return s[0][0]+s[1][1]+s[2][2];
    }
    static int diagonal2(int[][] s){
        return s[0][2]+s[1][1]+s[2][0];
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
