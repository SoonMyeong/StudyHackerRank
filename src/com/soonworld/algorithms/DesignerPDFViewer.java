package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 문제 이해가 안되서 고민했던 문제; 앞으론 영어문장을 좀 더 세심히 읽어야겠군..
 *  번역기를 돌려 이해한 문제
 *  h 배열에는 a~z까지의 인덱스 별 높이가 들어 있다. 문자 하나의 넓이는 1mm 로 일정 하며
 *  10자리 이하의 문자를 입력받아서 그 문자의 mm^2 을 구하면 된다. (문자총넓이xmax높이)
 *  문자 하나는 1mm이므로 결국 문자의 총 길이 x max 높이 의 결과를 구하면 되는 문제
 */
public class DesignerPDFViewer {
    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        String [] strArr = word.split("");
        int cmp = 0;

        //a를 아스키코드 숫자로 변환시 97이 나오는데, a 인덱스가 0이므로 -97를 해줌
        for(String str : strArr){
            char ch = str.charAt(0);

            if(cmp<h[(int)ch-97]){
                cmp=h[(int)ch-97];
            }
        }
        return cmp*strArr.length;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
