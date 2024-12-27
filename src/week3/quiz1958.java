package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class quiz1958 {
    private static char a[], b[], c[];
    private static Integer dp[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        c = br.readLine().toCharArray();

        dp = new Integer[a.length][b.length][c.length];
        System.out.println(lcs3(a.length-1, b.length-1, c.length-1));

    }

    private static int lcs3(int i, int j, int k){
        if(i < 0 || j < 0 || k < 0) return 0;
        if(dp[i][j][k] != null) return dp[i][j][k];

        if(a[i] == b[j] && b[j] == c[k]) dp[i][j][k] = lcs3(i-1, j-1, k-1) + 1;
        else dp[i][j][k] = Math.max(Math.max(lcs3(i-1,j,k), lcs3(i,j-1,k)), lcs3(i,j,k-1));

        return dp[i][j][k];
    }
}
