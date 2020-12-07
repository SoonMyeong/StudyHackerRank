package com.soonworld.dayofcode;
import java.util.*;
import java.io.*;
import java.util.LinkedList;

/**
 * 레벨별 순회 시 큐를 이용 한다.
 *
 */

class Node2{
    Node2 left,right;
    int data;
    Node2(int data){
        this.data=data;
        left=right=null;
    }
}
public class BSTTraversal {
    static Queue<Node2> queue = new LinkedList<>();
    static void levelOrder(Node2 root){
        //Write your code here
        queue.add(root);

        while(!queue.isEmpty()){
            Node2 node = queue.poll();
            System.out.print(node.data + " ");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }

    }

    public static Node2 insert(Node2 root,int data){
        if(root==null){
            return new Node2(data);
        }
        else{
            Node2 cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node2 root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
    }
}
