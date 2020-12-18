package com.soonworld.graph;
import java.util.*;

/**
 *   DFS 구현 연습 (인접행렬)
 *  정점, 간선의 개수 및 탐색 시작 번호를 입력 받았을 때
 *  DFS 한 결과를 출력 하기 , 단 입력받는 간선들은 양방향이다.
 *
 *  재귀와 스택의 같은 점은 LIFO, 마지막에 들어간게 먼저 나온다.
 *  -------------------------------------------------
 *  [재귀]
 *  1. 시작 정점(1)과 인접한 정점 하나(2)를 방문 한다.
 *  2. 방문한 정점(2)이 인접한 정점이 없을때 까지 계속 방문한다.
 *  3. 인접한 정점(2)이 없을때 다시 돌아와 다음 인접한 정점(3)을 찾는다.
 *  4. 시작 정점과 인접한 정점이 없을 경우 종료
 *
 *  [스택]
 *  1. 시작정점 v 를 스택에 넣는다.
 *  2. 스택 top을 기준으로 인접하며 방문하지 않는 정점을 방문한다.
 *  3. 방문 후 스택에 넣고 break하여 찾은 정점을 기준으로 재탐색 한다.
 *  4. 연결된 간선없고 모든 정점을 방문했을 때 pop으로 탈출 및 종료
 *
 *
 */

public class DFSArray {


    public static void dfsRecursion(int v, int[][] array, boolean[] visited){
        int len = array.length-1;
        visited[v] = true;
        System.out.print(v+" ");

        for(int i=1; i<=len; i++){
            if(array[v][i]==1 && !visited[i]){
                dfsRecursion(i,array,visited);
            }
        }
    }

    public static void dfsStack(int v, int[][]array, boolean[] visited, boolean flag){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(v);
        System.out.print(v+" ");
        visited[v] = true;
        while(!stack.isEmpty()){
            v = stack.peek();
            flag = false;

            for(int i=1; i<array.length; i++){
                if(array[v][i]==1 && !visited[i]){
                    stack.push(i);
                    System.out.print(i+" ");
                    visited[i]=true;
                    flag =true;
                    break;
                }
            }
            if(!flag){
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 간선의 개수
        int v = sc.nextInt(); // 탐색을 시작할 정점의 번호

        boolean visited[] = new boolean[n + 1]; //방문 검사하는 배열[★, 없으면 무한루프에 빠질 수 있음]
        int[][] array = new int[n+1][n+1];

        //입력받는 간선들은 양방향
        for(int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            array[v1][v2] = 1;
            array[v2][v1] = 1;
        }

        dfsRecursion(v,array,visited);
        //dfsStack(v,array,visited,true);
    }
}
