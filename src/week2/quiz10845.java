package week2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class quiz10845 {
    private static int n;
    private static String command;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        Deque<String> deq = new ArrayDeque<>();


        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            if(command.equals("push")){
                deq.addLast(st.nextToken());
            } else if (command.equals("pop")) {
                if(deq.isEmpty()) bw.write("-1" + '\n');
                else bw.write(deq.poll() + '\n');
            } else if (command.equals("size")) {
                bw.write(Integer.toString(deq.size()) + '\n');
            } else if (command.equals("empty")) {
                if (deq.isEmpty()) bw.write("1" + '\n');
                else bw.write("0" + '\n');
            } else if (command.equals("front")) {
                if (deq.isEmpty()) bw.write("-1" + '\n');
                else bw.write(deq.peekFirst() + '\n');
            } else {
                if (deq.isEmpty()) bw.write("-1" + '\n');
                else bw.write(deq.peekLast() + '\n');
            }
        }
        bw.flush();
    }
}
