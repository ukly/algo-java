package boj.bfs.boj16928;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[101];
        Arrays.fill(visited, false);

        List<List<Integer>> laddersAndSnakes = new ArrayList<>();
        for(int i=0; i<n+m; i++){
            List<Integer> temp = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            temp.add(Integer.parseInt(st.nextToken()));
            temp.add(Integer.parseInt(st.nextToken()));

            laddersAndSnakes.add(temp);
        }
        laddersAndSnakes.sort((a, b) -> a.get(0) - b.get(0));

        Queue<Node> q = new LinkedList<>();
        Node start = new Node(1,0);

        q.offer(start);

        while(!q.isEmpty()){
            Node node = q.poll();
            if(visited[node.idx]) continue;
            else             visited[node.idx] = true;

            //도착 조건: 현재 위치가 94이상이면 다음번에 도착
            if(node.idx >= 94) {
                System.out.println(node.level+1);
                break;
            }

            //사다리 혹은 뱀이 있으면 이동
            //주의: 사다리나 뱀 위치에 도착하면 무조건 타야함
            for(List<Integer> move : laddersAndSnakes){
                if (node.idx < move.get(0) && move.get(0) <= node.idx + 6) {
                    Node next = new Node(move.get(1), node.level+1);
                    visited[move.get(0)] = true;
                    q.offer(next);
                }
                else if (node.idx + 6 < move.get(0)) break;
            }

            //사다리나 뱀을 통하지 않고 최대한 이동할 수 있는 거리로 이동
            for(int i=6; i>0; i--){
                if(!visited[node.idx+i]){
                    Node next = new Node(node.idx+i, node.level+1);
                    q.offer(next);
                    break;
                }
            }
        }
    }

    static class Node{
        int idx;
        int level;

        public Node(int idx, int level){
            this.idx = idx;
            this.level = level;
        }
    }
}
