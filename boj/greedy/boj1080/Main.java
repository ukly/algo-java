package boj.greedy.boj1080;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrixA = new int[n][m];
        int[][] matrixB = new int[n][m];

        for(int i=0; i<n; i++){
            String row = br.readLine();
            for(int j=0; j<m; j++){
                matrixA[i][j] = row.charAt(j)-'0';
            }
        }

        for(int i=0; i<n; i++){
            String row = br.readLine();
            for(int j=0; j<m; j++){
                matrixB[i][j] = row.charAt(j)-'0';
            }
        }



        if(n>=3 && m>= 3){
            for(int i=0; i<=n-3; i++){
                for(int j=0; j<=m-3; j++){
                    //행렬 A와 B의 (i,j)의 값이 다르면 3X3만큼 변환
                    if(matrixA[i][j] != matrixB[i][j]){
                        for(int x=j; x<j+3; x++){
                            for(int y=i; y<i+3; y++){
                                int na = (matrixA[y][x] == 0) ? 1 : 0;
                                matrixA[y][x] = na;
                            }
                        }
                        answer += 1;
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrixA[i][j] != matrixB[i][j]) answer = -1;
            }
        }

        System.out.println(answer);
    }
}
