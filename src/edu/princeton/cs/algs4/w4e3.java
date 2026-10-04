package edu.princeton.cs.algs4;

import java.util.Scanner;

public class w4e3 {

    public static void insertIntoSorted(int[] arr) {
        int n = arr.length;
        int target = arr[n - 1]; // Phần tử cuối cùng cần chèn
        int i = n - 2;

        // Dịch chuyển các phần tử lớn hơn target sang phải
        while (i >= 0 && arr[i] > target) {
            arr[i + 1] = arr[i];
            printArray(arr); // In trạng thái sau mỗi bước dịch
            i--;
        }

        // Đặt target vào ô trống
        arr[i + 1] = target;
        printArray(arr); // In trạng thái hoàn chỉnh
    }

    public static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        insertIntoSorted(arr);
    }
}
