package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class quiz9251 {
    private static Integer dp[][];
    private static char arrA[], arrB[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        arrA =  br.readLine().toCharArray();
        arrB = br.readLine().toCharArray();

        dp = new Integer[arrA.length][arrB.length];

        System.out.println(lcs(arrA.length - 1, arrB.length - 1));
        for(int i=0; i<arrA.length; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
    }

    private static int lcs(int i, int j){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != null) return dp[i][j];

        if(arrA[i] == arrB[j]) dp[i][j] = lcs(i-1, j-1) + 1;
        else dp[i][j] = Math.max(lcs(i-1,j), lcs(i,j-1));

        return dp[i][j];
    }
}
