package com.soonworld.dayofcode;
import java.io.*;
import java.util.*;
class Node3{
    int data;
    Node3 next;
    Node3(int d){
        data=d;
        next=null;
    }

}

public class MoreLinkedLists {

    public static Node3 removeDuplicates(Node3 head) {
        //Write your code here
        Node3 node = head;
        while(node.next!=null) {
            if (node.data==node.next.data) {
                node.next = node.next.next; //이미 리스트에 가지고 있으면 next에  하나 건너뛰어 넣기
            } else {
                node = node.next;
            }
        }
        return head;
    }

    public static  Node3 insert(Node3 head,int data)
    {
        Node3 p=new Node3(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node3 start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node3 head)
    {
        Node3 start=head;
        while(start!=null)
        {
            System.out.print(start.data+" ");
            start=start.next;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Node3 head=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=insert(head,ele);
        }
        head=removeDuplicates(head);
        display(head);

    }
}
