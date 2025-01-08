package boj.greedy.boj12970;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int max = (n/2) * (n - n/2);
        int[] indexes = new int[n/2 + n%2];
        for(int i=0; i<indexes.length; i++) indexes[i] = n/2 + i;


        if(max < k) bw.write(-1 + "");
        else {
            char[] s = new char[n];
            Arrays.fill(s, 'A');

            int quo = (max-k) / (n/2);
            int res = (max-k) % (n/2);

            for(int j=0; j<quo; j++) indexes[j] = indexes[j] - n/2;
            for(int j=0; j<res; j++) indexes[quo]--;

            for(int idx : indexes){
                s[idx] = 'B';
            }

            for(char c : s) bw.write(c);
        }

        bw.flush();
        bw.close();
    }
}

