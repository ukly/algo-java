package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class quiz15829 {
    private static int N;
    private static long answer = 0, r = 1;
    private static int modNum = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        String L = st1.nextToken();

        for(int i = 0; i<N; i++){
            int ascii = (int) L.charAt(i);
            ascii -= 96;
            answer += ascii * r;
            r = (r * 31) % modNum;
        }

        System.out.println(answer);
    }
}
