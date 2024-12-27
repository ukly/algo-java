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
        //2차원 배열 바깥부분으로 안넘어가게
        if(i < 0 || j < 0) return 0;
        //이미 계산했는지 중복처리
        if(dp[i][j] != null) return dp[i][j];

        //만약 같다면 대각 이동
        if(arrA[i] == arrB[j]) dp[i][j] = lcs(i-1, j-1) + 1;
        //같지 않으면 좌측이나 위로 탐색중에 최댓값
        else dp[i][j] = Math.max(lcs(i-1,j), lcs(i,j-1));

        return dp[i][j];
    }
}
