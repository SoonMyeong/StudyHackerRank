package com.soonworld.algorithms;

import java.io.*;

public class TheTimeInWords {

    static class Result {

        /*
         * Complete the 'timeInWords' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts following parameters:
         *  1. INTEGER h
         *  2. INTEGER m
         */

        /**
         *
         *  5:00 -> five o'clock
         *  5:01 -> one minute past five
         *  5:10 -> ten minutes past five
         *  5:15 -> quarter past five
         *  5:30 -> half past five
         *  5:40 -> twenty minutes to six
         *  5:45 -> quarter to six
         *  5:47 -> thirteen minutes to six
         *  5:28 -> twenty eight minutes past five
         *
         * @param h
         * @param m
         * @return
         */

        public String timeInWords(int h, int m) {
            // Write your code here
            String[] units = {"zero","one","two","three","four","five","six","seven","eight","nine"
                    ,"ten","eleven","twelve","thirteen","fourteen","quarter","sixteen","seventteen","eightteen","nineteen","twenty"};
            String twenty = "twenty ";
            String quarter = "quarter";
            String half = "half";
            StringBuilder sb = new StringBuilder();

            if(m==0) {
                sb.append(units[h]).append(" o' clock");
            }
            else if(m<10) {
                sb.append(units[m]).append(" minute past ").append(units[h]);
            }
            else if(m<=20) {
                if(m==15) {
                    sb.append(units[m]).append(" past ").append(units[h]);
                }else {
                    sb.append(units[m]).append(" minutes past ").append(units[h]);
                }
            }else if(m<30) {
                sb.append(twenty).append(units[m-20]).append(" minutes past ").append(units[h]);
            }
            else if(m==30) {
                sb.append(half).append(" past ").append(units[h]);
            }
            else if(m<40) {
                sb.append(twenty).append(units[40-m]).append(" minutes to ").append(units[h+1]);
            }
            else if(m<=59) {
                if(h==12){
                    sb.append(units[60-m]).append(" minutes to ").append("one");
                }
                if(m==45) {
                    sb.append(units[60-m]).append(" to ").append(units[h+1]);
                }else {
                    sb.append(units[60-m]).append(" minutes to ").append(units[h+1]);
                }
            }
            return sb.toString();
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Result res = new Result();
        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        System.out.println(res.timeInWords(h, m));
    }
}
