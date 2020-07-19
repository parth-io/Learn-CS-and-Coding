import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution{
    static int count = 0;

//First try is below:
    public static int getHeight(Node root){
        int count = 0;
        System.out.println("We have begun");
        if (root != null) {
            System.out.println("If root != null");
            int countL = 1;
            int countR = 1;
            if (root.left != null) {
                System.out.println("getHeight(root.left)");
                countL += getHeight(root.left);
                }
            if (root.right != null ) {
                System.out.println("getHeight(root.right)");
                countR += getHeight(root.right);
                }
            if (countL > countR) {
                    count += countL;
                    System.out.println("count is " + count + " after countL " + countL + " while countR is " + countR);
                    return count;
                    }
            else {
                    count += countR;
                    System.out.println("count is " + count + " after countR " + countR + " while countL is " + countL);
                    return count;
                    }
        }
        else {
            return 0;
        }
    }
    
//Second try is below:
	public static int getHeight(Node root){
        Node cur;
        int countL = 0;
        int countR = 0;
        if (root != null) {
            cur = root.left;
            System.out.println("We are at the left subnode");
            if (cur == null) {
            countL = -1;
            System.out.println("Sorry, you reached a null node");
            }
            else if (cur != null) {
            System.out.println("We are entering recursive land for left subnode");
            countL += getHeight(cur);
            System.out.println("We found our way back from the left subnode's clutches with count " + countL);
            countL += 1;
            System.out.println("New value of countL is " + countL);
            }
            cur = root.right;
            if (cur == null) {
            countR = -1;
            }
            else if (cur != null) {
            countR += 1;
            countR += getHeight(cur);
            }
            if (countL > countR) {
                    count += countL;
                    System.out.println("Current count is " + count + " after adding countL " + countL);
                    return count;
                    }
            else {
                    count += countR;
                    System.out.println("Current count is " + count + " after adding countR " + countR);
                    return count;
                    }
        }
        else {
            return -1;
        }
    }

//In the end, after a few hours of head-banging, I peeked at the answer:

    public static int getHeight(Node root){
        if (root == null){
            return -1;
        }
        else{
            return 1 + Math.max( getHeight(root.left), getHeight(root.right) );
        }
    }

//Second viable answer:

    private static int getHeight(Node root){
        int heightLeft = 0;
        int heightRight = 0;

        if (root.left != null) {
            heightLeft = getHeight(root.left) + 1;
        }
        if (root.right != null) {
            heightRight = getHeight(root.right) + 1;
        }
        return (heightLeft > heightRight ? heightLeft : heightRight);
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
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
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root) - 1;
        System.out.println(height);
    }
}
