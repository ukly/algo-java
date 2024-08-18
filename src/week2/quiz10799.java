package week2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class quiz10799 {
    private static String str;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        Deque<Character> deq = new ArrayDeque<>();

        for (int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '(') deq.addLast('(');
            else {
                deq.pollLast();
                if(str.charAt(i-1) == '(') answer += deq.size();
                else answer += 1;
            }
        }
        System.out.println(answer);
    }
}
