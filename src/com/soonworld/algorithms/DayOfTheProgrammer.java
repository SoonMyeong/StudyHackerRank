package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.time.*;
import java.time.format.*;

/**
 * Marie 가 개발한 타임머신을 타고 1700 to 2700 년도 + 256일 후의 러시아를 방문 하려 한다.
 * 1700~1917년도엔  Julian calendar 를 썼으며  이후엔  Gregorian calendar 를 썼다. (윤년 존재 이후인듯)
  * 1700~1917년도엔 2월은 29일까지 있고,  1918년 초과로는 윤년이 아니면 2월은 28일까지 존재
 *  1918년의 경우는 2월이 14일까지임 --> 하드코딩
 * 윤년 : 4,400으로 나눌때 나머지 0
 */
public class DayOfTheProgrammer {
    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        //공통. 1월1일로 매핑 후 (256, 윤년일 경우 256-1)일 더한 뒤 dd.MM.yyyy 형식으로 저장 후 리턴
        //LocalDate의 경우 윤년 알아서 체킹하여 계산 해줌
        //1. 1919년 이하 인지 체크
        String result = "";
        LocalDate localDate = LocalDate.of(year,1,1);

        if(year>=1917) {
            if(year==1918) {
                result= "26.09.1918"; //14일이 짧으므로 +14 하여  12+14= 26일이 나옴 !
                return result;
            }
            //2. 윤년인지 체크
            if(localDate.isLeapYear()){ // or (y%4==0&&y%100!=0) && y%400==0
                result = localDate.plusDays(255).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

            }else {
                result = localDate.plusDays(255).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            }
        }else{
            if((year%4==0)) {
                result = localDate.plusDays(254).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            }else{
                result = localDate.plusDays(255).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            }
        }
        return result;

    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(1918);
        System.out.println("result :" + result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
