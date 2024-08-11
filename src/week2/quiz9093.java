package week2;

import java.io.*;
import java.util.Stack;

public class quiz9093 {
    private static int T;
    private static String text;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine() + '\n';
            for (char ch : str.toCharArray()){
                if (ch == ' ' || ch == '\n') {
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(ch);
                }
                else stack.push(ch);
            }
        }
        bw.flush();
    }
}
