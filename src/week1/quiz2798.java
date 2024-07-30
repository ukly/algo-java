package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class quiz2798 {
    private static int N, M;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] cards = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st1.nextToken());
        }
        for (int i = 0; i < cards.length; i++){
            for(int j = i+1; j < cards.length; j++){
                for(int k = j+1; k < cards.length; k++){
                    int sum = cards[i] + cards[j] + cards[k];
                    if(answer < sum && sum <= M) answer = sum;
                }
            }
        }
        System.out.println(answer);
    }
}
