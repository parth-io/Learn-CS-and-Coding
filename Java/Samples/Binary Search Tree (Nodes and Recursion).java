import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*Input a few numbers in descending order, as the print statements are only for the left subtree.
*/

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
        System.out.println(this);
    }
}
class Solution{

    public static Node insert(Node root,int data){
        if(root==null){
            System.out.println("END OF IF: We are at step root == null with " + data);
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                System.out.println("We got shunted to the root.left");
                cur=insert(root.left,data);
                root.left=cur;
                System.out.println("The value of cur is " + cur);
                System.out.println("We are at step root.left = cur with " + data);
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
                System.out.println("We are at step root.right = cur " + data);
            }
            System.out.println("END OF ELSE: The value of root is " + root);
            return root;
        }
    }
	 public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            System.out.println("We are at this number: " + data);
            root=insert(root,data);
        }
    }
}
