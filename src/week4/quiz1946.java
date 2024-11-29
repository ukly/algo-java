package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quiz1946 {
    private static int t, n, scores[][], maxScore2, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            answer = 0;
            n = Integer.parseInt(br.readLine());
            scores = new int[n][2];

            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                scores[j][0] = Integer.parseInt(st.nextToken());
                scores[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(scores, (a, b) -> {return a[0] - b[0];});

            maxScore2 = scores[0][1];
            for(int j=1; j<n; j++){
                if(maxScore2 < scores[j][1]) answer += 1;
                else if (maxScore2 > scores[j][1]) maxScore2 = scores[j][1];
            }
            System.out.println(n - answer);
        }
    }
}
