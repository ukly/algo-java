package boj.bfs.boj14502;

import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, answer = -1, walls = 0;
    private static int[][] lab;
    private static List<Virus> viruses;
    private static int[] moveX = {1, -1, 0, 0}, moveY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][m];

        viruses = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++){
                int partition = Integer.parseInt(st.nextToken());
                if (partition == 2) viruses.add(new Virus(j, i));
                else if (partition == 1) walls++;
                lab[i][j] = partition;
            }
        }

        makeWall(0);

        System.out.println(answer);
    }

    private static void makeWall(int wallCount){
        if(wallCount == 3){
            bfs();
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(lab[i][j] == 0){
                    lab[i][j] = 1;
                    makeWall(wallCount + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    private static void bfs(){
        boolean[][] isInfected = new boolean[n][m];
        Deque<Virus> queue = new ArrayDeque<>();

        for(Virus virus : viruses){
            queue.offerLast(virus);
        }

        while(!queue.isEmpty()){
            Virus poll = queue.pollFirst();
            int x = poll.x;
            int y = poll.y;
            if(isInfected[y][x]) continue;
            isInfected[y][x] = true;
            for(int i=0; i<4; i++){
                int nx = x + moveX[i];
                int ny = y + moveY[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && lab[ny][nx] == 0){
                    queue.add(new Virus(nx, ny));
                }
            }
        }
        int area = safeZone(isInfected);
        if(area > answer) answer = area;
    }

    private static int safeZone(boolean[][] isInfected){
        int area = n*m - walls - 3;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isInfected[i][j]) area--;
            }
        }
        return area;
    }


    public static class Virus{
        int x;
        int y;
        public Virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}