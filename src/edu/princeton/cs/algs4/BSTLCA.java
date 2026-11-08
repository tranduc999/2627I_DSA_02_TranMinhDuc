package edu.princeton.cs.algs4;

import java.util.Scanner;

public class BSTLCA {


    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data) root.left = insert(root.left, data);
        else if (data > root.data) root.right = insert(root.right, data);
        return root;
    }

    public static Node lca(Node root, int v1, int v2) {
        if (root == null) return null;
        if (v1 < root.data && v2 < root.data) return lca(root.left, v1, v2);
        if (v1 > root.data && v2 > root.data) return lca(root.right, v1, v2);
        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();

        Node ans = lca(root, v1, v2);
        if (ans != null) {
            System.out.println(ans.data);
        }
    }
}