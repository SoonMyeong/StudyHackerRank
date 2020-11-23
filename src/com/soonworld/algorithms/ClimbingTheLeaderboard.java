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


/*
 * 타임아웃 ㅠㅠ 시간복잡도 여기서 어떻게 더 줄일지 모르겠다..
 * 모르겠다.. discussion 참고 한 문제
 * 기존 풀이( O(n^2) ) 에서 discussion 참고 후 -> O(n+m)
 */
public class ClimbingTheLeaderboard {
    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> temp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        //boolean isNext =false;

         temp=ranked.stream()
                 .distinct()
                 .collect(toList());
        int i = temp.size()-1; //rank 리스트의 마지막 인덱스 값

        /**
         * 확실하게 짚고 넘어가기 위한 부연 설명
         *
         * 1 . List player를 순회시키는데, List rank를 뒤에서부터 순회 한다.
         * (List rank를 오름차순 정렬하고 하려해봤는데 랭킹뽑으려고 하는 순간 머리가 꼬이기 시작했었음)
         * 2. 플레이어의 점수가 랭크된 점수보다 작아졌을 때 비로소 플레이어 점수가 랭크되는 순간이다.
         * 따라서 이 때(2번)의 i값이 랭크점수 순회중 만난 최초의 플레이어 점수보다 높아지는 위치가 된다.
         * 그러므로 이 위치의 다음자리가 비교하는 플레이어의 점수가 랭크되는 위치가 되겠다. i+1
         * 하지만 인덱스는 0부터 시작하기때문에 저장할땐 +1을 더 해주어 i+2로 해준다.
         * 3. while문을 통과했을 때  i가 0보다 작아 통과한 경우는 1등을 한 경우가 된다. 인덱스0보다 큰거니까
         *  따라서  i가 0보다 작은 지 for문 끝나기 전 체크 필요
         */
        for(int score : player){
            while(i>=0){
                if(score>=temp.get(i)){
                    i--;
                }else{
                    result.add(i+2); //인덱스는 0부터시작하니까 +1 , 스코어가 랭크된점수보다 낮으므로 한 등수 밀려서 +1 따라서 총 +2
                    break;
                }
            }
            if(i<0) result.add(1);   //1위
        }



        //-----------------------기존 O(n^2) 풀이.. ---------------------------------------

        //2. 배열 순회 하며 범위 찾은인덱스 +1 (내림차순이므로)
        // 2-1. 양 끝 값보다 크거나 작을 경우 케이스 따로 분리
        // 이중루프로 계산 시 TIME OUT
//        for(int score : player){
//                for(int i=0; i<temp.size(); i++){
//                    if(!isNext) {
//                        if (score >= temp.get(i)) {
//                            if(i==0){
//                                result.add(1);
//                            }else {
//                                result.add((i+1)); //인덱스는 0부터 시작하므로
//                            }
//                            isNext = true;
//                        }else if(score<=temp.get(temp.size()-1)){ //가장 작은 케이스
//                            if(score==temp.get(temp.size()-1)){ //가장 작은 값과 같은 경우
//                                result.add(temp.size());
//                            }else{
//                                result.add(temp.size()+1);
//                            }
//                            isNext=true;
//                        }
//                    }
//                }
//                isNext=false;
//        }
        result.forEach(System.out::println);
        return result;
    }
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());

        List<Integer> ranked = new ArrayList<>();
        ranked.add(100); ranked.add(90);  ranked.add(90);  ranked.add(80);  ranked.add(75);  ranked.add(60);
        List<Integer> player = new ArrayList<>();
        player.add(50); player.add(65); player.add(77); player.add(90); player.add(102);

        List<Integer> result = climbingLeaderboard(ranked, player);

//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
