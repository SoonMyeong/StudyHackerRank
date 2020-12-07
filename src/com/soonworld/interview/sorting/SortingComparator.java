package com.soonworld.interview.sorting;
import java.util.*;

/**
 *  정렬 문제 (Comparable and Comparator)
 *  점수에 따라 내림 차순 하고, 점수가 같을 시 알파벳 순서로 오름차순 하는 문제
 *
 */

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        if(a.score==b.score){
            return b.name.compareTo(a.name); //사전 비교
        }else{
            return Integer.compare(b.score,a.score); //그 외 내림차순
        }
    }
}

public class SortingComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
