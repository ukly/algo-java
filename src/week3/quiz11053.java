package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class quiz11053 {
    private static int n,answer = -1;
    private static int[] seq, memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        seq = new int[n];
        memo = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            seq[i] = Integer.parseInt(st.nextToken());
            memo[i] = 1;
        }
        for(int i=0; i<n; i++){
            dp(i);
        }
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, memo[i]);
        }
        System.out.println(answer);

    }

    private static int dp(int i){
        if(memo[i] == 1){
            for(int j=i-1; j>=0; j--){
                if(seq[j] < seq[i]){
                    memo[i] = Math.max(memo[i], dp(j) + 1);
                }
            }
        }
        return memo[i];
    }
}
