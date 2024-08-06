import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static int n, m;
    static List<List<Node>> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        System.out.println(dijkstra(1));
    }

    static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.index;
            int currentCost = current.cost;

            if (currentCost > dist[currentNode]) continue;

            for (Node neighbor : graph.get(currentNode)) {
                int newCost = currentCost + neighbor.cost;
                if (newCost < dist[neighbor.index]) {
                    dist[neighbor.index] = newCost;
                    pq.offer(new Node(neighbor.index, newCost));
                }
            }
        }

        return dist[n];
    }
}
