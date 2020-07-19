//My solution
import java.io.*;
import java.util.*;

class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class Solution
{
        public static Node keepCalling(Node head) {
            if (head.next.next != null){
                    head.next = head.next.next;
                }
                else {
                    head.next = null;
                }
            return head;
        }
        public static Node removeDuplicates(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.next == null) {
                break;
            }
            while (temp.data == temp.next.data) {
                //System.out.println("Removing dupes");
                keepCalling(temp);
                if (temp.next == null) {
                    break;
                }
            }
            temp = temp.next;
        }
        return head;
    }

	 public static  Node insert(Node head,int data)
     {
        Node p=new Node(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
        {
              Node start=head;
              while(start!=null)
              {
                  System.out.print(start.data+" ");
                  start=start.next;
              }
        }
        public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in);
              Node head=null;
              int T=sc.nextInt();
              while(T-->0){
                  int ele=sc.nextInt();
                  head=insert(head,ele);
              }
              head=removeDuplicates(head);
              display(head);

       }
    } 

//Recursive Solution

public static Node removeDuplicates(Node head) {
    if (head == null || head.next == null){
        return head;
    }
    if (head.data == head.next.data){
        head.next = head.next.next;
        removeDuplicates(head);
    }else{
        removeDuplicates(head.next);
    }
    return head;
}

For more solutions, see 
https://www.hackerrank.com/challenges/30-linked-list-deletion/forum
https://www.hackerrank.com/challenges/30-linked-list-deletion/editorial
