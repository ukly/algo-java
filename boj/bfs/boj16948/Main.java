package boj.bfs.boj16948;

import java.util.*;
import java.io.*;

public class Main {
    private static int n, r1, r2, c1, c2;
    private static int[][] board;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        Queue<Record> queue = new LinkedList<>();
        Record start = new Record(r1, c1, 0);
        queue.offer(start);

        int answer = bfs(queue);

        System.out.println(answer);
    }

    private static int bfs(Queue<Record> queue){
        int answer = -1;

        while(!queue.isEmpty()){
            Record q = queue.poll();
            int r = q.r;
            int c = q.c;

            if(visited[r][c]) continue;
            else              visited[r][c] = true;

            if(r == r2 && c == c2) return q.moveCount;

            if(r >= 2 && c >= 1 && !visited[r-2][c-1]){
                Record next = new Record(r-2, c-1, q.moveCount+1);
                queue.offer(next);
            }
            if(r >= 2 && c < n-1 && !visited[r-2][c+1]){
                Record next = new Record(r-2, c+1, q.moveCount+1);
                queue.offer(next);
            }
            if(c >= 2 && !visited[r][c-2]){
                Record next = new Record(r, c-2, q.moveCount+1);
                queue.offer(next);
            }
            if(c < n-2 && !visited[r][c+2]){
                Record next = new Record(r, c+2, q.moveCount+1);
                queue.offer(next);
            }
            if(r < n-2 && c >= 1 && !visited[r+2][c-1]){
                Record next = new Record(r+2, c-1, q.moveCount+1);
                queue.offer(next);
            }
            if(r < n-2 && c < n-1 && !visited[r+2][c+1]){
                Record next = new Record(r+2, c+1, q.moveCount+1);
                queue.offer(next);
            }
        }

        return answer;
    }

    public static class Record{
        int r;
        int c;
        int moveCount;

        public Record(int r, int c, int moveCount){
            this.r = r;
            this.c = c;
            this.moveCount = moveCount;
        }
    }
}
