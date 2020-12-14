package com.soonworld.interview.search;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 3개 배열에서 뽑아낼 수 있는 부분집합의 개수
 *  a , b , c 가 들어있는 각각의 배열 p,q,r 을 입력 받았을 때 (a는 p소속, b는 q소속 c는 r소속)
 *  나타낼 수 있는 부분집합의 개수는 몇개 인가? (a,b,c 다 들어가는 부분집합) ex) (a,b,c)
 *  단, p<=q && q>=r 조건을 만족해야만 한다.
 *  문제 자체는 씸플하구만
 */

/**
 * Arrays.binaruSearch()
 *  오름차순으로 정렬된 리스트에서만 사용 가능한 단점이 있지만, 속도가 빠르다는 장점이 있다.
 * 배열에서 요소 검색 시 매우 적절, 단 리스트에 없는 숫자일 경우 음수를 붙여 리턴된다.
 *
 */

public class TripleSum {
    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        //어우 Discussion 확인
        //해결방법은 의외로[?] 심플했다. 여기있는 사람들은 다들 뇌가 빠삭한거같음
        //1. 각 배열들을 오름차순 정렬 후 -->정렬 시 set을 사용해 중복을 없애야 한다. [★]
        //2. b를 중점으로 두고 그 안에서 a,c 배열 인덱스값이 b인덱스보다 작거나같은 경우만 +하여
        //3. b인덱스 하나를 늘리기 전 a와 c의 곱 (이건 예상했었음)을 더 해 간다.
        int [] ar = Arrays.stream(a).sorted().distinct().toArray();
        int [] br = Arrays.stream(b).sorted().distinct().toArray();
        int [] cr = Arrays.stream(c).sorted().distinct().toArray();
        long result = 0;

        for(int i=0; i<br.length; i++){
            int aquant = Math.abs(Arrays.binarySearch(ar, br[i]) + 1);   ///여기서의 중첩포문을 피하기위해 복잡도가 더 낮은 이진탐색 사용..이진탐색 메소드있다는거 처음앎;
            int cquant = Math.abs(Arrays.binarySearch(cr, br[i]) + 1);  ///여기서의 중첩포문을 피하기위해 복잡도가 더 낮은 이진탐색 사용..이진탐색 메소드있다는거 처음앎;
            System.out.println(aquant+"," + cquant);
            result += (long)aquant * cquant;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

//        bufferedWriter.write(String.valueOf(ans));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
