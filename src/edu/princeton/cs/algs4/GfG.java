package edu.princeton.cs.algs4;

import java.util.*;

// Class to represent Huffman tree node
class Node {

    // frequency
    int data;

    // smallest original index in subtree
    int index;

    // smallest original index in subtree
    Node left, right;

    // Leaf node
    Node(int d, int i) {
        data = d;
        index = i;
        left = right = null;
    }

    // Internal node
    Node(Node l, Node r) {
        data = l.data + r.data;

        // important for tie-break
        index = Math.min(l.index, r.index);
        left = l;
        right = r;
    }
}

// Custom min heap for Node class
class Compare implements Comparator<Node> {
    public int compare(Node a, Node b) {

        // smaller freq first
        if (a.data != b.data)
            return a.data - b.data;

        // when freq are equal
        return a.index - b.index;
    }
}

public class GfG {

    // Function to traverse tree in preorder
    // manner and push the Huffman representation
    // of each character.
    static void preOrder(Node root, ArrayList<String> ans, String curr) {
        if (root == null) return;

        // Leaf node represents a character.
        if (root.left == null && root.right == null) {

            // single character case
            if (curr.equals("")) curr = "0";
            ans.add(curr);
            return;
        }

        preOrder(root.left, ans, curr + '0');
        preOrder(root.right, ans, curr + '1');
    }

    static ArrayList<String> huffmanCodes(String s, int[] freq) {

        int n = s.length();

        // Min heap for Node class.
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());
        for (int i = 0; i < n; i++) {

            // include index
            Node tmp = new Node(freq[i], i);
            pq.add(tmp);
        }

        // single character
        if (n == 1) {
            ArrayList<String> res = new ArrayList<>();
            res.add("0");
            return res;
        }

        // Construct Huffman tree.
        while (pq.size() >= 2) {

            // Left node
            Node l = pq.poll();

            // Right node
            Node r = pq.poll();

            // internal node with freq + index
            Node newNode = new Node(l, r);
            pq.add(newNode);
        }

        Node root = pq.peek();
        ArrayList<String> ans = new ArrayList<>();
        preOrder(root, ans, "");
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcdef";
        int[] freq = {5, 9, 12, 13, 16, 45};
        ArrayList<String> ans = huffmanCodes(s, freq);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}