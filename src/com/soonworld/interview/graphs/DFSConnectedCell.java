package com.soonworld.interview.graphs;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 * DFS 문제
 * 인접한 범위의 넓이를 구하는 문제
 * FloodFIll 알고리즘을 이용 시 쉽게 해결 가능
 */
public class DFSConnectedCell {

    static boolean[][] visited;
    static int[] dr = {-1,1,0,0}; //up, down, left, right
    static int[] dc = {0,0,-1,1};
    static int count = 0;

    static void dfs(int i, int j, int[][] grid){
        visited[i][j] = true;
        count++;

        for(int k=0; k<4; k++){
            int cr = i+dr[k];
            int cc = j+dc[k];

            if(cr<0 || cr>=grid.length || cc<0 || cc>=grid[0].length){
                continue;
            }

            if(!visited[cr][cc] && grid[cr][cc]==1){
                dfs(cr,cc,grid);
            }
        }

    }
    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
        int sum = 0;
        boolean checkRegion = false;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    count =0;
                    dfs(i,j,grid);
                    if(count>1){
                        if(count==2){
                            sum+=1;
                        }else{
                            sum +=count;
                        }
                    }else if(count==1){
                        checkRegion = true;
                    }
                }
            }
        }
        if(sum==0 && checkRegion){
            sum = 1;
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);
        System.out.println(res);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }

}
