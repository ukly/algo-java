package boj.bruteForce.boj14500;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m, board[][], answer = -1;
    static int[] moveX = {0, 1, 0}, moveY = {1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                List<Block> blocks = new ArrayList<>();
                blocks.add(new Block(j,i));
                visited[i][j] = true;
                tetromino(1, blocks, visited);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    private static void tetromino(int length, List<Block> blocks, boolean[][] visited){
        if(length == 4){
            int sum = 0;
            for(Block block : blocks){
                sum += board[block.y][block.x];
            }
            if(sum > answer) {
                answer = sum;
            }
        } else {
            for(int i = 0; i<blocks.size(); i++){
                Block block = blocks.get(i);
                for(int j=0; j<3; j++){
                    int nx = block.x + moveX[j];
                    int ny = block.y + moveY[j];
                    if(nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[ny][nx]){
                        blocks.add(new Block(nx, ny));
                        visited[ny][nx] = true;
                        tetromino(length+1, blocks, visited);
                        visited[ny][nx] = false;
                        blocks.remove(length);
                    }
                }
            }
        }

    }

    public static class Block{
        int x;
        int y;

        public Block(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

