package edu.princeton.cs.algs4;

public class SimpleTextEditor {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        Stack<String> history = new Stack<String>();

        // Đọc tổng số lượng thao tác
        int q = StdIn.readInt();

        for (int i = 0; i < q; i++) {
            int type = StdIn.readInt();

            if (type == 1) {
                // Thao tác 1: Append (Nối chuỗi)
                history.push(text.toString()); // Lưu trạng thái cũ
                String w = StdIn.readString();
                text.append(w);
            }
            else if (type == 2) {
                // Thao tác 2: Delete (Xóa k ký tự cuối)
                history.push(text.toString()); // Lưu trạng thái cũ
                int k = StdIn.readInt();
                text.delete(text.length() - k, text.length());
            }
            else if (type == 3) {
                // Thao tác 3: Print (In ký tự thứ k, 1-indexed)
                int k = StdIn.readInt();
                StdOut.println(text.charAt(k - 1));
            }
            else if (type == 4) {
                // Thao tác 4: Undo (Hoàn tác)
                if (!history.isEmpty()) {
                    // Lấy trạng thái gần nhất ra và ghi đè lại văn bản hiện tại
                    text = new StringBuilder(history.pop());
                }
            }
        }
    }
}