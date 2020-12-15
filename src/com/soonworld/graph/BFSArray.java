package com.soonworld.graph;
import java.util.*;

/**
 *
 * BFS 구현 연습 (인접행렬)
 *  정점, 간선의 개수 및 탐색 시작 번호를 입력 받았을 때
 *  BFS 한 결과를 출력 하기 , 단 입력받는 간선들은 양방향이다.
 *  ------------------------------------------------------
 *  1. 시작 정점을 queue에 집어 넣는다.
 *  2. queue에있는 정점을 빼서 방문한다 (방문배열 인덱스값 true)
 *  3. 정점에 간선(1)을 찾아 인접한 정점들을 queue에 넣는다.
 *  4. queue에 있는 정점을 빼서 방문한다 . ...2~3번 반복
 *  5. 마지막에 queue가 비어있다면 더이상 인접한 정점이 없다는 뜻이므로 모두 방문 완료
 *
 */
public class BFSArray {

    public static void bfs(int v , int [][] arr, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        //시작노드 관련
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            v = queue.poll(); //queue에서 뺀 뒤 따로 저장, 아래에서 간선 체크 위해
            result.add(v);

            for(int i=1; i<=arr.length-1; i++){
                if(arr[v][i]==1 && !visited[i]){ //방문한적 없고 정점의 간선이 존재 하면(1)
                    queue.add(i);
                    visited[i] = true;
                }
            }

        }

        for(Integer n : result){
            System.out.print(n+" ");
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

        bfs(v,array,visited);
    }
}
