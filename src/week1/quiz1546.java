package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class quiz1546 {
    private static int N,sum = 0;
    private static double Max, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int[] scores = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            scores[i] = Integer.parseInt(st1.nextToken());
            sum += scores[i];
        }

        Max = findMax(scores);
        answer = sum/Max * 100 / N;
        System.out.println(answer);
    }

    private static int findMax(int[] scores) {
        int max = 0;
        for (int score: scores) {
            if (max < score) max = score;
        }
        return max;
    }
}
