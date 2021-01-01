package com.soonworld.interview.stackandqueue;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * 큐 구현
 * 입력받는 쿼리 번호에 따라 작업 후 print되는 값을 출력 하시오.
 * 1. enqueue element x
 * 2. dequeue element
 * 3. prunt element (큐에 있는 첫번째로 출력 될 데이터)
 *
 */

class MyQueue<T>{
    private Queue<Integer> queue = new LinkedList<>();

    void enqueue(int num){
        Integer n = num;
        queue.add(n);
    }
    void dequeue(){
        queue.poll();
    }
    Integer peek(){
        return queue.peek();
    }
}
public class ATableOfTwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
