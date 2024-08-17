package week2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class quiz1158 {
    private static int n, k, count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Deque<Integer> deq1 = new ArrayDeque<>();
        Deque<Integer> deq2 = new ArrayDeque<>();
        ArrayList<Integer> yosephus = new ArrayList<>();
        String answer = "<";

        for(int i=0; i<n; i++) deq2.addLast(i+1);

        while(!deq1.isEmpty() || !deq2.isEmpty()){
            while(!deq2.isEmpty()) {
                if (count % k == 0) yosephus.add(deq2.pollFirst());
                else deq1.addLast(deq2.pollFirst());
                count++;
            }
            while(!deq1.isEmpty()) {
                if (count % k == 0) yosephus.add(deq1.pollFirst());
                else deq2.addLast(deq1.pollFirst());
                count++;
            }
        }

        for(int i=0; i<n; i++) {
            if(i == n-1) answer += "" + yosephus.get(i) + ">";
            else answer += "" + yosephus.get(i) + ", ";
        }
        bw.write(answer);
        bw.flush();
    }
}
