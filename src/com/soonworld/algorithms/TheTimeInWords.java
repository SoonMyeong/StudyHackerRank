package com.soonworld.algorithms;

import java.io.*;

public class TheTimeInWords {

    class Result {

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

        public static String timeInWords(int h, int m) {
            // Write your code here
            String[] units = {"zero","one","two","three","four","five","fix","seven","eight","nine"};
            String[] tens = {"ten","eleven","twelve","thirteen","fourteen","sixteen","seventteen","eightteen","nineteen"};
            String twenty = "twenty";
            String quarter = "quarter";
            String half = "half";
            StringBuilder sb = new StringBuilder();

            if(m==0) {
                sb.append(units[h]).append("o' clock");
            }





        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);
    }
}
