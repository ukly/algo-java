package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class quiz30802 {
    private static int N, T, P;
    private static int countT, answerT;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stN = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stN.nextToken());

        int[] S = new int[6];

        StringTokenizer stS = new StringTokenizer(br.readLine());
        for(int i = 0; i<6; i++){
            S[i] = Integer.parseInt(stS.nextToken());
        }

        StringTokenizer stTP = new StringTokenizer(br.readLine());
        T = Integer.parseInt(stTP.nextToken());
        P = Integer.parseInt(stTP.nextToken());

        for(int i = 0; i<6; i++){
            countT = S[i] / T;

            if(S[i] % T != 0){
                countT += 1;
            }

            answerT += countT;
        }
        System.out.println(answerT);
        System.out.println(N/P + " " + N%P);
    }
}
