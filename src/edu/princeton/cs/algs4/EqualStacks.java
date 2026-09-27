package edu.princeton.cs.algs4;

public class EqualStacks {

    public static void main(String[] args) {
        // Đọc số lượng đĩa của 3 chồng
        int n1 = StdIn.readInt();
        int n2 = StdIn.readInt();
        int n3 = StdIn.readInt();

        // Khởi tạo mảng và biến lưu độ cao
        int[] stack1 = new int[n1];
        int h1 = 0;
        for (int i = 0; i < n1; i++) {
            stack1[i] = StdIn.readInt();
            h1 += stack1[i];
        }

        int[] stack2 = new int[n2];
        int h2 = 0;
        for (int i = 0; i < n2; i++) {
            stack2[i] = StdIn.readInt();
            h2 += stack2[i];
        }

        int[] stack3 = new int[n3];
        int h3 = 0;
        for (int i = 0; i < n3; i++) {
            stack3[i] = StdIn.readInt();
            h3 += stack3[i];
        }

        // Dùng 3 con trỏ để đánh dấu đĩa trên cùng hiện tại của mỗi chồng
        int i1 = 0, i2 = 0, i3 = 0;

        // Vòng lặp hạ độ cao cho đến khi 3 chồng bằng nhau
        while (!(h1 == h2 && h2 == h3)) {
            // Tìm chồng cao nhất và trừ đi đĩa trên cùng của nó
            if (h1 >= h2 && h1 >= h3) {
                h1 -= stack1[i1++];
            } else if (h2 >= h1 && h2 >= h3) {
                h2 -= stack2[i2++];
            } else if (h3 >= h1 && h3 >= h2) {
                h3 -= stack3[i3++];
            }
        }

        // In ra độ cao chung lớn nhất
        StdOut.println(h1);
    }
}