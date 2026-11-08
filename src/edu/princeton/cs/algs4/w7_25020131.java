package edu.princeton.cs.algs4;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class w7_25020131 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();

        // Khai báo 2 hàng đợi ưu tiên theo gợi ý đề bài (bổ sung Generic <Integer>)
        Queue<Integer> maxPQ = new PriorityQueue<>(N / 2 + 1, Collections.reverseOrder());
        Queue<Integer> minPQ = new PriorityQueue<>(N / 2 + 1);

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();

            // Bước 1: Thêm số mới vào hàng đợi phù hợp
            if (maxPQ.isEmpty() || x <= maxPQ.peek()) {
                maxPQ.add(x);
            } else {
                minPQ.add(x);
            }

            // Bước 2: Cân bằng kích thước sao cho:
            // maxPQ.size() == minPQ.size() hoặc maxPQ.size() == minPQ.size() + 1
            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.add(maxPQ.poll());
            } else if (minPQ.size() > maxPQ.size()) {
                maxPQ.add(minPQ.poll());
            }

            // Bước 3: Tìm và in ra trung vị hiện tại với 1 chữ số thập phân
            double median;
            if (maxPQ.size() > minPQ.size()) {
                median = (double) maxPQ.peek();
            } else {
                median = (maxPQ.peek() + minPQ.peek()) / 2.0;
            }

            System.out.printf("%.1f\n", median);
        }

        scanner.close();
    }
}