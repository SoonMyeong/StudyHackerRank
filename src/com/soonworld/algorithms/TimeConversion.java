package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.text.*;

import java.time.format.*;
import java.util.*;
import java.util.regex.*;
import java.time.*;

public class TimeConversion {
    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */

        /**
         * LocalDate : 날짜 표기
         * LocalTime : 시간 표기
         * LocalDateTime : 날짜 시간 모두 표기
         */


        String type = null;
        String spliteTime = null;
        LocalTime lt = null;
        String result =null;

        type=s.substring(s.length()-2);

        spliteTime = s.substring(0,s.length()-2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        lt = LocalTime.parse(spliteTime,formatter);

        // PM 과 AM에 따른 분기 처리
        if(type.equals("PM") && lt.getHour()!=12){
            lt = lt.plusHours(12);
        }else if(type.equals("AM") && lt.getHour()==12){
            lt = lt.minusHours(12);
        }


        if(lt.getSecond()==0){
            return lt.toString()+":00"; // 시간이 00초 일 경우 localtime에서 초를 빼고 출력해서 추가
        }

        return lt.toString();

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String s = scan.nextLine();

        String result = timeConversion("12:00:00AM");
        System.out.println(result);

        //bw.write(result);
        //bw.newLine();

        //bw.close();
    }
}
