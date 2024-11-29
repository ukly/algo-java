package week4;

import java.io.*;
import java.util.*;

public class quiz10216 {
    private static int t, n, answer;
    private static int[][] circles;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            circles = new int[n][3];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // 초기화
            }

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                circles[i][0] = Integer.parseInt(st.nextToken()); // x 좌표
                circles[i][1] = Integer.parseInt(st.nextToken()); // y 좌표
                circles[i][2] = Integer.parseInt(st.nextToken()); // 반지름
            }

            // Union-Find로 원 연결
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (isConnected(circles[i], circles[j])) {
                        union(i, j);
                    }
                }
            }

            // 연결 요소 개수 카운트
            answer = 0;
            for (int i = 0; i < n; i++) {
                if (find(i) == i) answer++;
            }

            System.out.println(answer);
        }
    }

    // 두 원이 연결되었는지 확인
    private static boolean isConnected(int[] circle1, int[] circle2) {
        int dx = circle1[0] - circle2[0];
        int dy = circle1[1] - circle2[1];
        int distanceSquared = dx * dx + dy * dy;
        int radiusSum = circle1[2] + circle2[2];
        return distanceSquared <= radiusSum * radiusSum;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}