package edu.princeton.cs.algs4;

public class NaturalMerge {

    // Hàm gộp (merge) tương tự thuật toán Mergesort tiêu chuẩn
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // Sao chép dữ liệu sang mảng phụ aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // Gộp lại vào mảng gốc a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }

    /**
     * Sắp xếp mảng sử dụng Natural Mergesort
     */
    public static void sort(Comparable[] a) {
        int n = a.length;
        if (n < 2) return;

        Comparable[] aux = new Comparable[n];

        while (true) {
            int lo = 0;
            int mergeCount = 0; // Đếm số lần gộp trong một vòng quét

            while (lo < n) {
                // 1. Tìm điểm kết thúc của "run" thứ nhất
                int mid = lo;
                while (mid < n - 1 && !less(a[mid + 1], a[mid])) {
                    mid++;
                }

                // Nếu "run" đầu tiên đã kéo dài đến cuối mảng, không còn "run" thứ hai để gộp
                if (mid == n - 1) {
                    break;
                }

                // 2. Tìm điểm kết thúc của "run" thứ hai
                int hi = mid + 1;
                while (hi < n - 1 && !less(a[hi + 1], a[hi])) {
                    hi++;
                }

                // 3. Gộp 2 "runs" liền kề
                merge(a, aux, lo, mid, hi);
                mergeCount++;

                // Di chuyển con trỏ sang phần chưa xử lý của mảng
                lo = hi + 1;
            }

            // Mảng đã được sắp xếp hoàn toàn nếu không có phép gộp nào diễn ra trong vòng quét
            if (mergeCount == 0) {
                break;
            }
        }
    }

    // Hàm so sánh
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        // Khởi tạo mảng có chứa các chuỗi đã sắp xếp tự nhiên (ví dụ: 1, 5, 7 và 2, 3, 6)
        Integer[] a = {1, 5, 7, 2, 3, 6, 9, 4, 8};

        System.out.println("Trước khi sắp xếp: " + java.util.Arrays.toString(a));
        sort(a);
        System.out.println("Sau khi sắp xếp:   " + java.util.Arrays.toString(a));
    }
}