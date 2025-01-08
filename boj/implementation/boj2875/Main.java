package boj.implementation.boj2875;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        while(k-- > 0){
            if(n/(double)m >= 2.0) n--;
            else         m--;
        }

        System.out.println(Math.min(n/2, m));
    }
}
