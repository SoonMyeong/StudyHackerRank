package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 도서관 연체료 계산
 * 기간내에 반납 -> 0원
 * 같은 년, 월 이지만 일이 늦은 경우 -> 15x연체일
 * 같은 년이지만 월이 늦은 경우 -> 500x연체달
 * 년이 늦은 경우 -> 10,000 지불해!!!!
 * ex) 기간이 2017년 1월31일이건 2017년 12월31일이건 간에 1년뒤인 2018년에 반납하면 년이 바뀐거니까 10,000 지불하시오!!
 */
public class LibraryFine {
    // Complete the libraryFine function below.
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        //d1 m1 y1 --> 반납 한 날짜 ||  d2 m2 y2 기한 날짜
        int fine = 0;
        //case 0. 기간내에 반납
        if(y2>y1 || y2==y1 && m2>m1 || y2==y1 && m2==m1 && d2>=d1){
            fine= 0;
        }
        //case 1. 일 늦은 경우
        else if(y2==y1 && m1==m2 && d1>d2){
            fine= 15*(d1-d2);
        }
        //case 2. 월 늦은 경우
        else if(y2==y1 && m1>m2){
            fine= 500*(m1-m2);
        }
        //case 3. 년 늦은 경우
        else if(y1>y2){
            fine = 10000;
        }
        return fine;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] d1M1Y1 = scanner.nextLine().split(" ");

        int d1 = Integer.parseInt(d1M1Y1[0]);

        int m1 = Integer.parseInt(d1M1Y1[1]);

        int y1 = Integer.parseInt(d1M1Y1[2]);

        String[] d2M2Y2 = scanner.nextLine().split(" ");

        int d2 = Integer.parseInt(d2M2Y2[0]);

        int m2 = Integer.parseInt(d2M2Y2[1]);

        int y2 = Integer.parseInt(d2M2Y2[2]);

        int result = libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
