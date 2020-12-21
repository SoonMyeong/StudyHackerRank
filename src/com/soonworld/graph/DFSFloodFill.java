package com.soonworld.graph;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/2667 백준 문제 2667번
 *
 *  FloodFill은 BFS로도 구현 가능하다, 하지만 DSF연습을 위해 DFS로 구성 해보는 연습문제
 * 상하좌우에 대한 배열을 두고 하면 소스가 더 씸플해 보여서 이를 채택하여 구성 해봄
 *
 * ex) 7
 * 0110100
 * 0110101
 * 1110101
 * 0000111
 * 0100000
 * 0111110
 * 0111000
 *
 * answer : 7 8 9
 *
 * 핵심 :  1. 좌표값이 0이 아니면서 방문하지 않은 지점에 대하여 탐색
 *        2. DFS의 경우 최초 for문 한번 빠져 나왔다는것은 인접행렬 한 곳을 빠져나온것
 * 기본 개념은 알게되었으나 여러 문제를 접하여 익숙해져야 함. 아니면 분명 또 구현 안될것임
 */
public class DFSFloodFill {
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int count;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};  //상 하 좌 우

    public static int dfs(int r, int c){
        visited[r][c] = true;
        count++;
        for(int i=0; i<4; i++){
            int cr = r+dr[i];
            int cc = c+dc[i];

            if(cr<0 || cr>=n || cc<0 || cc >=n){
                continue;
            }

            if(!visited[cr][cc] && arr[cr][cc]==1) {
                dfs(cr, cc);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==1 && !visited[i][j]) { //필수조건임
                    count = 0; //dfs 재귀 한번 빠져나올때 다른 섬으로 가기위한 초기화
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

        Collections.sort(result);

        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }

        scanner.close();
    }
}
