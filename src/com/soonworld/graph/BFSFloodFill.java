package com.soonworld.graph;

import java.util.*;

/**
 *
 *   BFS로 구현해보는 Flood Fill Algorithms
 *   결국 DFS나 BFS나 구현할 수 있으면 Flood Fill 구현 가능.
 *  * ex)
 7
 0 1 1 0 1 0 0
 0 1 1 0 1 0 1
 1 1 1 0 1 0 1
 0 0 0 0 1 1 1
 0 1 0 0 0 0 0
 0 1 1 1 1 1 0
 0 1 1 1 0 0 0
 *  *
 *  * answer : 7 8 9
 *
 */
class Pair{
    Integer row;
    Integer column;

    public Pair(Integer row , Integer column){
        this.row = row;
        this.column = column;
    }
    public Integer getRow(){
        return row;
    }
    public Integer getColumn(){
        return column;
    }
}
public class BFSFloodFill {
    static int[][] arr ;
    static boolean[][] visited;
    static int n;
    static int count;
    static int [] dr ={-1,1,0,0};
    static int [] dc ={0,0,-1,1};

    public static void bfs(int r, int c){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r,c));
        visited[r][c] = true;

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            count++;
            int cr = pair.row;
            int cc = pair.column;

            for(int i=0; i<4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr<0 || nc<0 || nr>=n || nc>=n){
                    continue;
                }

                if(arr[nr][nc]==1 && !visited[nr][nc]){
                    queue.add(new Pair(nr,nc));
                    visited[nr][nc] = true;
                }

            }

        }

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
                if(arr[i][j]==1 && !visited[i][j]){
                    count =0;
                    bfs(i,j);
                    result.add(count);
                }
            }
        }
        System.out.println(result.size());
        for(Integer n : result){
            System.out.println(n);
        }

        scanner.close();
    }
}
