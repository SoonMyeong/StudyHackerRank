package com.soonworld.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 쥐 잡기 게임
 * 고양이1, 고양이2 , 쥐는 같은 직선에 존재하며 시작포인트를 정해 준다.
 * 고양이의 이동속도는 1로 동일하며 쥐는 움직이지 않는다.
 * 고양이1,2가 동시에 쥐가 있는 지점에 도착 할 경우 두 고양이는 서로 싸우게되므로 쥐는 도망 간다. 따라서 쥐를 return
 * 고양이1의 시작 포인트 x
 * 고양이2의 시작포인트 y
 * 쥐의 시작포인트 z
 */
public class CatsAndaMouse {
    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {

        //이동속도는 일정하므로 절대값이 먼 고양이가 쥐에게 더 늦게 도착할 수 밖에 없다..
        return Math.abs(x-z) < Math.abs(y-z) ? "Cat A" : Math.abs(x-z) > Math.abs(y-z) ? "Cat B" :"Mouse C";

        // 내 풀이 ㅡㅡ;
        /*String answer = "";
        boolean escape = false;

        while(!escape){
            //x,y 의 시작포인트가 z일 경우
            if(x==z && y==z){
                answer="Mouse C";
                escape = true;
            }else if (x==z){ //x의 시작포인트가 z일 경우
                answer = "Cat A";
                escape = true;
            }else if(y==z){  //y의 시작포인트가 z일 경우
                answer="Cat B";
                escape = true;
            }else {
                //x ,y 둘다 z보다 클 경우
                if (x > z && y > z) {
                    x--;
                    y--;
                } else if (x > z) { //x만 z보다 클 경우
                    x--;
                    y++;
                } else if (y > z) { //y만 z보다 클 경우
                    x++;
                    y--;
                } else { //x,y 둘다 z보다 작을 경우
                    x++;
                    y++;
                }
            }
        }
        return answer;*/
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
