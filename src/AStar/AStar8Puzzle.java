package AStar;

import java.util.*;

public class AStar8Puzzle {

    // 상태에서 맨해튼 거리 휴리스틱을 계산
    // goal 상태는 일반적으로 "123456780" (0이 빈칸)
    public static int manhattanDistance(String state, String goal) {
        int dist = 0;
        for (char c = '1'; c <= '8'; c++) {
            int posState = state.indexOf(c);
            int posGoal = goal.indexOf(c);

            int x1 = posState / 3, y1 = posState % 3;
            int x2 = posGoal / 3, y2 = posGoal % 3;

            dist += Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }
        return dist;
    }

    // 현재 상태에서 가능한 다음 상태(빈칸 이동)를 생성
    public static List<Node> getNeighbors(Node current, String goal) {
        List<Node> neighbors = new ArrayList<>();
        String state = current.state;
        int zeroPos = state.indexOf('0');
        int x = zeroPos / 3;
        int y = zeroPos % 3;

        int[][] directions = { {-1,0}, {1,0}, {0,-1}, {0,1} };
        char[] moveChars = {'U','D','L','R'}; // 방향 표시용

        for (int i = 0; i < directions.length; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];
            if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                int newPos = nx * 3 + ny;
                char[] arr = state.toCharArray();
                // 0과 newPos의 타일 교환
                char temp = arr[newPos];
                arr[newPos] = arr[zeroPos];
                arr[zeroPos] = temp;

                String newState = new String(arr);
                int newG = current.g + 1;
                int newH = manhattanDistance(newState, goal);
                Node neighbor = new Node(newState, newG, newH, current, moveChars[i]);
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }

    // 경로 재구성
    public static List<Character> reconstructPath(Node node) {
        List<Character> path = new ArrayList<>();
        Node current = node;
        while (current.parent != null) {
            path.add(current.move);
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }

    public static List<Character> aStar(String start, String goal) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(a -> a.f()));
        Map<String, Integer> gScore = new HashMap<>();
        Map<String, Node> bestNode = new HashMap<>();

        Node startNode = new Node(start, 0, manhattanDistance(start, goal), null, ' ');
        openSet.offer(startNode);
        gScore.put(start, 0);
        bestNode.put(start, startNode);

        Set<String> closedSet = new HashSet<>();

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.state.equals(goal)) {
                return reconstructPath(current);
            }

            if (closedSet.contains(current.state)) continue;
            closedSet.add(current.state);

            for (Node neighbor : getNeighbors(current, goal)) {
                if (closedSet.contains(neighbor.state)) continue;

                int tentativeG = current.g + 1;
                int knownG = gScore.getOrDefault(neighbor.state, Integer.MAX_VALUE);

                if (tentativeG < knownG) {
                    gScore.put(neighbor.state, tentativeG);
                    bestNode.put(neighbor.state, neighbor);
                    openSet.offer(neighbor);
                }
            }
        }

        // 목표 상태에 도달 불가
        return null;
    }

    static class Node {
        String state;
        int g; // 시작점부터 현재까지 비용
        int h; // 휴리스틱
        Node parent;
        char move; // 부모->현재로 오기 위한 이동 ('U','D','L','R')

        Node(String state, int g, int h, Node parent, char move) {
            this.state = state;
            this.g = g;
            this.h = h;
            this.parent = parent;
            this.move = move;
        }

        int f() {
            return g + h;
        }
    }

    public static void main(String[] args) {
        // 초기 상태 예:
        // 1 4 2
        // 7 8 3
        // 5 6 0
        String start = "142783560";

        // 목표 상태:
        // 1 2 3
        // 4 5 6
        // 7 8 0
        String goal = "123456780";

        List<Character> result = aStar(start, goal);
        if (result != null) {
            System.out.println("해결 가능! 이동 횟수: " + result.size());
            System.out.println("이동 순서: " + result);
        } else {
            System.out.println("해결 불가능한 퍼즐 상태입니다.");
        }
    }
}
