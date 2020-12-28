package com.soonworld.interview.stackandqueue;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 괄호 밸런스 맞추기
 * 주어지는 괄호 : {} , [] , ()
 *  여러개의 괄호가 주어질 때 쌍이 맞으면 YES, 아니면 NO 출력
 *
 *  반대값을 스택에 넣으면 해결 가능..!
 */
public class BalancedBrackets {
    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        String[] brackets = s.split("");
        Stack<String> stack = new Stack<>();
        String result = "YES";

        if(brackets.length %2!=0){
            return "NO";
        }else if(brackets[0].equals("}") || brackets[0].equals("]") || brackets[0].equals(")")){
            return "NO";
        }else{
            for (String bracket : brackets) {
                if (bracket.equals("{")) {
                    stack.push("}");
                } else if (bracket.equals("[")) {
                    stack.push("]");
                } else if (bracket.equals("(")) {
                    stack.push(")");
                } else if (stack.isEmpty() || !stack.pop().equals(bracket)) {
                   return "NO";
                }
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);
            System.out.println(result);

//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
