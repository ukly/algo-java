package week2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class quiz17413 {
    private static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        Deque<Character> deq = new ArrayDeque<>();
        s = br.readLine();
        boolean flag = false;

        for(int i=0; i<s.length(); i++){
            if (s.charAt(i) == '<') {
                while(!deq.isEmpty()) bw.write(deq.pollLast());
                flag = true;
                deq.addLast(s.charAt(i));
            }
            else if (s.charAt(i) == '>') {
                deq.addLast(s.charAt(i));
                while(!deq.isEmpty()) bw.write(deq.pollFirst());
                flag = false;
            } else if (flag) {
                deq.addLast(s.charAt(i));
            } else {
                if(s.charAt(i) == ' ') {
                    while(!deq.isEmpty()) bw.write(deq.pollLast());
                    bw.write(' ');
                } else {
                    deq.addLast(s.charAt(i));
                }
            }
        }
        while(!deq.isEmpty()) bw.write(deq.pollLast());

        bw.flush();
    }
}
