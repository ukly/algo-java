package week2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class quiz10866 {
    private static int n;
    private static String command, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<String> deq = new ArrayDeque<>();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            command = br.readLine();
            st = new StringTokenizer(command);
            if(st.countTokens() == 2) {
                command = st.nextToken();
                x = st.nextToken();
                if(command.equals("push_back")) deq.addLast(x);
                else deq.addFirst(x);
            } else {
                if(command.equals("pop_front")){
                    if(deq.isEmpty()) bw.write("-1" + '\n');
                    else bw.write(deq.pollFirst() + '\n');
                } else if (command.equals("pop_back")) {
                    if(deq.isEmpty()) bw.write("-1" + '\n');
                    else bw.write(deq.pollLast() + '\n');
                } else if (command.equals("size")) {
                    bw.write(""+deq.size() + '\n');
                } else if (command.equals("empty")) {
                    if(deq.isEmpty()) bw.write("1" + '\n');
                    else bw.write("0" + '\n');
                } else if (command.equals("front")) {
                    if(deq.isEmpty()) bw.write("-1" + '\n');
                    else bw.write(deq.peekFirst() + '\n');
                } else {
                    if(deq.isEmpty()) bw.write("-1" + '\n');
                    else bw.write(deq.peekLast() + '\n');
                }
            }
        }
        bw.flush();
    }
}
