package edu.princeton.cs.algs4;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt(); // Đọc số lượng truy vấn

        Stack<Integer> stackIn = new Stack<>();
        Stack<Integer> stackOut = new Stack<>();

        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();

            if (type == 1) {
                // Enqueue: Thêm phần tử x vào hàng đợi
                int x = scanner.nextInt();
                stackIn.push(x);
            }
            else if (type == 2) {
                // Dequeue: Xóa phần tử ở đầu hàng đợi
                shiftStacks(stackIn, stackOut);
                stackOut.pop();
            }
            else if (type == 3) {
                // Print: In phần tử ở đầu hàng đợi
                shiftStacks(stackIn, stackOut);
                System.out.println(stackOut.peek());
            }
        }
        scanner.close();
    }

    // Hàm hỗ trợ trút dữ liệu từ stackIn sang stackOut
    private static void shiftStacks(Stack<Integer> stackIn, Stack<Integer> stackOut) {
        // Chỉ trút khi stackOut đã trống hoàn toàn
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}