package AStar;

import java.util.*;

public class aStar {

    /**
     * Node 클래스: 그래프 상의 특정 정점을 나타내는 자료구조.
     * 각 노드는 다음 정보를 가짐:
     * - name: 노드 이름 (문자열)
     * - g: 시작점부터 현재 노드까지의 실제 비용
     * - h: 현재 노드에서 목표 노드까지의 추정 비용(휴리스틱 값)
     * - parent: 경로 재구성을 위해 현재 노드로 오기 직전의 노드(부모 노드)
     *
     * f() = g + h를 통해 우선순위 계산 시 사용한다.
     */
    static class Node {
        final String name;
        final double g; // 시작점에서 현재 노드까지의 비용(G)
        final double h; // 휴리스틱(H): 목표까지의 추정 비용
        final Node parent;

        Node(String name, double g, double h, Node parent) {
            this.name = name;
            this.g = g;
            this.h = h;
            this.parent = parent;
        }

        // f() = g + h: A* 알고리즘에서 우선순위를 결정하는 비용 함수
        double f() {
            return g + h;
        }
    }

    /**
     * Graph 클래스: 노드와 간선으로 이루어진 그래프를 인접 리스트 형태로 관리한다.
     * - adjList: { 노드이름 : 해당 노드로부터 뻗은 간선 목록 } 형태로 저장
     */
    static class Graph {
        private final Map<String, List<Edge>> adjList = new HashMap<>();

        /**
         * 간선 추가 메소드:
         * from 노드에서 to 노드로 가는 간선과 그 가중치(비용)을 추가한다.
         * 방향 그래프로 가정 (일반적으로 A*는 방향 그래프 또는 무방향 그래프 모두 가능)
         */
        void addEdge(String from, String to, double weight) {
            adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(to, weight));
        }

        /**
         * 특정 노드의 인접 노드(간선) 목록을 가져온다.
         * 해당 노드의 자식 노드(다음에 갈 수 있는 노드)와 비용 정보를 반환.
         */
        List<Edge> getNeighbors(String node) {
            return adjList.getOrDefault(node, Collections.emptyList());
        }
    }

    /**
     * Edge 클래스: 노드 간 연결 정보를 저장하는 클래스.
     * - target: 도착 노드 이름
     * - weight: 간선 가중치(비용)
     */
    static class Edge {
        final String target;
        final double weight;

        Edge(String target, double weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    /**
     * A* 알고리즘을 이용하여 start 노드에서 goal 노드까지의 최적(최단) 경로를 찾는 메소드.
     *
     * @param graph      탐색할 그래프
     * @param start      시작 노드 이름
     * @param goal       목표 노드 이름
     * @param heuristics {노드 이름 : 목표까지의 추정 비용(H)}를 담는 맵
     * @return start에서 goal까지의 경로(노드 이름들의 리스트). 경로가 없으면 null 반환.
     *
     * 알고리즘 개요:
     * 1. openSet(우선순위 큐): f값이 최소인 노드부터 탐색한다.
     * 2. gScore: 시작점으로부터 특정 노드까지의 알려진 최소 비용을 관리.
     * 3. closedSet: 이미 탐색을 완료한 노드 집합 (중복 탐색 방지)
     *
     * 과정:
     * - 시작 노드를 openSet에 넣고 gScore를 0으로 설정.
     * - openSet에서 f값이 가장 낮은 노드를 꺼냄 → current 노드
     * - current 노드가 goal이면 경로 재구성 후 반환.
     * - current 노드에 인접한 이웃 노드들(neighbor)을 검사하여 gScore 갱신.
     * - 갱신된 노드는 다시 openSet에 삽입.
     * - openSet이 빌 때까지 반복, goal을 찾지 못하면 null 반환.
     */
    public static List<String> findPath(Graph graph, String start, String goal, Map<String, Double> heuristics) {
        // openSet: 탐색할 노드 목록(우선순위 큐), f값이 작은 노드가 먼저 나온다.
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingDouble(Node::f));

        // gScore: 각 노드까지의 최소 비용을 저장하는 맵. 시작 노드의 비용은 0.
        Map<String, Double> gScore = new HashMap<>();
        // 이미 방문 완료한 노드들을 저장하는 집합
        Set<String> closedSet = new HashSet<>();

        // 시작 노드를 초기화하여 openSet에 추가
        double startHeuristic = heuristics.getOrDefault(start, Double.MAX_VALUE);
        openSet.add(new Node(start, 0, startHeuristic, null));
        gScore.put(start, 0.0);

        // A* 탐색 루프 시작
        while (!openSet.isEmpty()) {
            // f값이 가장 작은 노드를 선택
            Node current = openSet.poll();

            // 만약 목표 노드에 도달했다면 경로 재구성 후 반환
            if (current.name.equals(goal)) {
                return reconstructPath(current);
            }

            // 현재 노드가 이미 처리된 상태라면 넘어간다.
            if (!closedSet.add(current.name)) {
                continue; // 이미 visited 상태면 skip
            }

            // 현재 노드에 인접한 노드들(이웃 노드) 확인
            for (Edge edge : graph.getNeighbors(current.name)) {
                double tentative_g = current.g + edge.weight; // 이웃 노드까지의 새로운 비용
                double bestG = gScore.getOrDefault(edge.target, Double.MAX_VALUE);

                // 새로운 비용이 기존보다 좋다면(gScore 낮다면) 갱신
                if (tentative_g < bestG) {
                    gScore.put(edge.target, tentative_g);
                    double h = heuristics.getOrDefault(edge.target, Double.MAX_VALUE);
                    // 부모를 current로 하여 새 노드 만들기
                    openSet.add(new Node(edge.target, tentative_g, h, current));
                }
            }
        }

        // openSet을 모두 소진해도 goal 노드를 찾지 못한 경우 경로 없음
        return null;
    }

    /**
     * 목표 노드에 도달한 후, 부모 노드를 추적하여 경로를 재구성하는 메소드.
     * 부모 노드를 거슬러 올라가며 start까지 도달한 후, 순서를 뒤집어 경로 반환.
     */
    private static List<String> reconstructPath(Node node) {
        List<String> path = new ArrayList<>();
        for (Node curr = node; curr != null; curr = curr.parent) {
            path.add(curr.name);
        }
        Collections.reverse(path); // 뒤에서부터 추적했으므로 역순 → 올바른 순서로 반전
        return path;
    }

    public static void main(String[] args) {
        // 그래프를 생성하고 간선 정보 추가
        Graph graph = new Graph();
        graph.addEdge("A", "B", 1.5);
        graph.addEdge("A", "C", 2.0);
        graph.addEdge("B", "D", 2.5);
        graph.addEdge("C", "D", 1.0);
        graph.addEdge("B", "E", 1.0);
        graph.addEdge("D", "E", 2.0);
        graph.addEdge("E", "F", 3.0);

        // 휴리스틱(추정 비용) 설정: 각 노드에서 목표(F)까지의 대략적 거리
        Map<String, Double> heuristics = new HashMap<>();
        heuristics.put("A", 4.5);
        heuristics.put("B", 3.0);
        heuristics.put("C", 2.5);
        heuristics.put("D", 2.0);
        heuristics.put("E", 3.0);
        heuristics.put("F", 0.0); // 목표 노드는 H=0

        // 시작점과 목표점
        String start = "A";
        String goal = "F";

        // A* 알고리즘 실행
        List<String> path = findPath(graph, start, goal, heuristics);

        // 결과 출력
        if (path != null) {
            System.out.println("경로: " + path);
        } else {
            System.out.println("경로를 찾을 수 없습니다.");
        }
    }
}