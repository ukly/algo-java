package sssp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class quiz1916 {
    private static int n, m;

    static class Edge implements Comparable<Edge>{
        int index;
        int weight;

        public Edge(int index, int cost){
            this.index = index;
            this.weight = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    private static int[] dijkstra(int n, List<List<Edge>> graph, int start){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(); //우선순위 큐: 탐색할 경로들 추가
        pq.offer(new Edge(start, 0));             //시작지점 세팅

        while (!pq.isEmpty()){                         //더이상 탐색할 경로가 없을 때까지
            Edge current = pq.poll();
            int currentNode = current.index;
            int currentWeight = current.weight;

            if (currentWeight > dist[currentNode]) continue;;  //이번에 확인할 경로의 가중치가 지금까지 계산한

            for(Edge neighbor : graph.get(currentNode)){       //현재 노드의 이웃한 노드들 탐색하기
                int nextNode = neighbor.index;
                int nextWeight = neighbor.weight;

                if (dist[currentNode] + nextWeight < dist[nextNode]){ //새로운 경로가 이전의 경로보다 가중치 낮은 경우 갱신
                    dist[nextNode] = dist[currentNode] + nextWeight;  //다음 노드까지의 거리를 갱신
                    pq.offer(new Edge(nextNode, dist[nextNode]));     //다음 노드를 우선순위 큐에 추가
                }
            }

        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Edge(v, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = dijkstra(n, graph, start);
        System.out.println(dist[end]);
    }
}
