package com.soonworld.interview.stackandqueue;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * 목표 지점(goal)까지 가기 위해 몇번의 도약을 해야 하는가?
 *  . 은 한칸이 아닌 여러칸 이동 가능, but X표시는 막힌 곳
 *  3
 * .X.
 * .X.
 * ...
 * 0 0 0 2
 * answer : 3  (0,0)-> (2,0) -> (2,2) -> (0,2)
 *
 * 진짜 미쳤다 BFS 변형.. 참고 소스 이해하는데도 시간걸림; 이게 71퍼라고? 말이 안됨
 */
class Pair{
    int row;
    int column;

    public Pair(int row , int column){
        this.row = row;
        this.column = column;
    }
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
}
public class CastleOnTheGrid {

    static boolean [][] visited;
    static int [][] arr;
    static int [] dr = {-1,1,0,0};
    static int [] dc ={0,0,-1,1};
    static int count = 0;

    static int bfs(int row, int col, int goalX, int goalY, int size){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row,col));
        visited[row][col] = true;

        while(!queue.isEmpty()){
            int sz = queue.size();
            while(sz-- >0) { ///핵심 로직, 큐 사이즈를 가지고 한턴(가장 자리까지 가는경우, edge자리 까지 가게되면 큐는 비게 될 것이다.)
                Pair pair = queue.poll();
                int cr = pair.row;
                int cc = pair.column;

                for (int i = 0; i < 4; i++) {
                    int nr = cr + dr[i];
                    int nc = cc + dc[i];

                    while (nr >= 0 && nr < arr.length && nc >= 0 && nc < arr.length && arr[nr][nc] == 0) { //nr과 nc의 범위 안 이면서 X가 아닐 경우 (이동범위 내)
                        if (nr == goalX && nc == goalY) {
                            return count + 1;
                        }
                        if (!visited[nr][nc]) {
                            visited[nr][nc] = true;
                            queue.add(new Pair(nr, nc));
                        }
                        //이동범위를 넘어갈 때 까지 한쪽방향을 계속 더해 나간다. 매우 중요
                        nr += dr[i];
                        nc += dc[i];
                    }
                }
            }
            count++;
        }
        return -1;
    }

    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        arr = new int[grid.length][grid.length];
        visited = new boolean[grid.length][grid.length];

        for(int i=0; i<grid.length; i++){
            String [] items = grid[i].split("");
            for(int j=0; j<items.length; j++){
                if(items[j].equals("X")){
                    arr[i][j] = 1;
                }
            }
        }

       return bfs(startX,startY,goalX,goalY,arr.length);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}
