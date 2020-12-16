package com.soonworld.graph;
import java.util.*;

/**
 *    BFS 를 이용한 최단거리 구하기
 *   인접한 정점에 경우 0으로 표시하고 인접하지 않는 정점에 경우 1로 표시
 *   시작지점은 0,0 이다. 골인지점은 마지막 인덱스인 arr[n-1][m-1]
 *   골인지점까지의 최단거리가 나온다.
 *
 */

class Node{
    int row;
    int col;
    int depth;
    public Node(int row, int col, int depth){
        this.row = row;
        this.col = col;
        this.depth = depth;
    }
}

public class BFSShortestPath {

    static int n = 0;
    static int m = 0;
    static int[][] arr;
    static boolean[][] visited;

    public static void bfs(int row, int col){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row,col,1));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            visited[node.row][node.col] = true;

            if(visited[n-1][m-1]){
                System.out.println("거리 :" + node.depth);
                break;
            }
            System.out.println("row:" + node.row + "," + "col :" + node.col);

            //up
            if(node.row-1 >=0 && node.row-1<n && arr[node.row-1][node.col]==0 && !visited[node.row-1][node.col]){
                queue.add(new Node(node.row-1,node.col,node.depth+1));
            }
            //down
            if(node.row+1 >=0 && node.row+1<n && arr[node.row+1][node.col]==0 && !visited[node.row+1][node.col]){
                queue.add(new Node(node.row+1,node.col,node.depth+1));
            }
            //left
            if(node.col-1 >=0 && node.col-1<m && arr[node.row][node.col-1]==0 && !visited[node.row][node.col-1]){
                queue.add(new Node(node.row,node.col-1,node.depth+1));
            }
            //right;
            if(node.col+1 >=0 && node.col+1<m && arr[node.row][node.col+1]==0 && !visited[node.row][node.col+1]){
                queue.add(new Node(node.row,node.col+1,node.depth+1));
            }
        }
    }

    public static void main(String[] args) {
        arr = new int[][]{{0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 0, 1}, {0, 1, 0, 1, 0, 0}, {0, 0, 0, 1, 0, 0}};
        n = arr.length;
        m = arr[0].length;

        visited = new boolean[n][m];

        bfs(0,0);
    }
}
