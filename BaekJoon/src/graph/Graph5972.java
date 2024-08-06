package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph5972 {

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
    static int[] predecessor;

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

        // Run Dijkstra's algorithm
        dijkstra(1);

        // Output the shortest path from 1 to n
        System.out.println("Shortest path cost: " + dist[n]);

        // Print the shortest path
        System.out.print("Path: ");
        printPath(1, n);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[n + 1];
        predecessor = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);
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
                    predecessor[neighbor.index] = currentNode;
                    pq.offer(new Node(neighbor.index, newCost));
                }
            }
        }
    }

    static void printPath(int start, int end) {
        if (start == end) {
            System.out.print(start + " ");
            return;
        }
        if (predecessor[end] == -1) {
            System.out.println("No path exists");
            return;
        }
        printPath(start, predecessor[end]);
        System.out.print(end + " ");
    }
}
