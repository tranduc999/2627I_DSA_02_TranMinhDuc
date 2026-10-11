package edu.princeton.cs.algs4;

import java.util.Random;

public class QuickSortBenchmark {

    public static void sortWithoutShuffle(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sortWithShuffle(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void shuffle(Comparable[] a) {
        Random rand = new Random();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + rand.nextInt(n - i);
            exch(a, i, r);
        }
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable pivot = a[lo];

        while (true) {
            while (less(a[++i], pivot)) if (i == hi) break;
            while (less(pivot, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int N = 5000; // Sử dụng 20,000 phần tử để tránh StackOverflowError
        Integer[] array1 = new Integer[N];

        // Tạo mảng rơi vào trường hợp xấu nhất: ĐÃ SẮP XẾP SẴN
        for (int i = 0; i < N; i++) {
            array1[i] = i;
        }

        // Clone mảng để đảm bảo 2 thuật toán chạy trên cùng một dữ liệu
        Integer[] array2 = array1.clone();

        System.out.println("Đang đo runtime với mảng đã sắp xếp gồm " + N + " phần tử...\n");

        // --- ĐO THỜI GIAN: KHÔNG SHUFFLE ---
        long start1 = System.nanoTime();
        sortWithoutShuffle(array1);
        long end1 = System.nanoTime();
        double time1 = (end1 - start1) / 1_000_000.0; // Đổi từ nanosecond sang millisecond

        // --- ĐO THỜI GIAN: CÓ SHUFFLE ---
        long start2 = System.nanoTime();
        sortWithShuffle(array2);
        long end2 = System.nanoTime();
        double time2 = (end2 - start2) / 1_000_000.0;

        // In kết quả
        System.out.printf("Quick Sort KHÔNG xáo trộn: %10.3f ms%n", time1);
        System.out.printf("Quick Sort CÓ xáo trộn   : %10.3f ms%n", time2);
        System.out.println("Tỷ lệ chênh lệch xấp xỉ  : " + Math.round(time1 / time2) + " lần");
    }
}