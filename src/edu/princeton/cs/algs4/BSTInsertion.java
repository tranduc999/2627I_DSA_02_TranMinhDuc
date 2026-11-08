package edu.princeton.cs.algs4;

import java.util.Scanner;

class Node1 {
    int data;
    Node1 left;
    Node1 right;

    Node1(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BSTInsertion {

    // Hàm duyệt cây theo thứ tự trước (Pre-order) để kiểm tra kết quả giống HackerRank
    public static void preOrder(Node1 root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // --- HÀM BẠN CẦN VIẾT CHO BÀI TẬP ---
    public static Node1 insert(Node1 root, int data) {
        if (root == null) {
            return new Node1(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }
    // ------------------------------------

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử rồi nhập các số (ví dụ: 6 rồi 4 2 3 1 7 6):");
        int t = scan.nextInt();
        Node1 root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();

        System.out.print("Kết quả duyệt Pre-order: ");
        preOrder(root);
    }
}