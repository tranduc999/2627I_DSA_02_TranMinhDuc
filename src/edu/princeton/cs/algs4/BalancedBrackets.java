package edu.princeton.cs.algs4;

public class BalancedBrackets {

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Nếu là dấu mở ngoặc, đưa vào stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // Nếu là dấu đóng ngoặc
            else if (c == ')' || c == ']' || c == '}') {
                // Stack rỗng nghĩa là thiếu dấu mở ngoặc tương ứng
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Kiểm tra xem dấu đóng có khớp với dấu mở trên cùng stack không
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }

        // Nếu stack rỗng thì tất cả các ngoặc đều được đóng đúng cách
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Đọc dữ liệu từ StdIn
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            StdOut.println(s + " - " + isBalanced(s));
        }
    }
}