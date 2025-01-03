package boj.bfs.boj12886;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int sum = a+b+c;
        int answer = 0;

        Queue<List<Integer>> q = new LinkedList<>();
        boolean[][] visited = new boolean[1501][1501];


        if((a+b+c)%3 == 0) {
            if(a==b && b==c) answer = 1;
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(a);
                temp.add(b);
                temp.add(c);
                q.offer(temp);

                while(!q.isEmpty()){
                    List<Integer> stones = q.poll();
                    Collections.sort(stones);

                    //정답 체크
                    if (stones.get(0).equals(stones.get(1)) && stones.get(1).equals(stones.get(2))) {
                        answer = 1;
                        break;
                    }

                    for (int i = 0; i < 3; i++) {
                        int x = stones.get(i);
                        int y = stones.get((i + 1) % 3); // 다음 그룹
                        int z = stones.get((i + 2) % 3); // 나머지 그룹

                        if (x != y) {
                            int nextX, nextY;
                            if (x > y) {
                                nextX = x - y;
                                nextY = y * 2;
                            } else {
                                nextX = x * 2;
                                nextY = y - x;
                            }

                            // 방문 여부 체크
                            if (!visited[nextX][nextY]) {
                                visited[nextX][nextY] = true; // 방문 처리
                                visited[nextY][nextX] = true;
                                temp = new ArrayList<>();
                                temp.add(nextX);
                                temp.add(nextY);
                                temp.add(z);
                                q.offer(temp); // 큐에 추가
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
