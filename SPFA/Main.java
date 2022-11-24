import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.io.BufferedReader;

class Edge {
    int to, cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

class Graph {
    ArrayList<ArrayList<Edge>> edges;
    int n;

    public Graph(int n) {
        this.n = n;
        edges = new ArrayList<ArrayList<Edge>>(n + 1);
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<Edge>());
        }
    }

    public void addEdge(int x, int y, int z) {
        edges.get(x).add(new Edge(y, z));
    }

    public ArrayList<Edge> neighbors(int x) {
        return edges.get(x);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        int n = Integer.parseInt(row[0]);
        int m = Integer.parseInt(row[1]);
        int x, y, z;
        Graph g = new Graph(n);
        for (int i = 0; i < m; i++) {
            row = br.readLine().split(" ");
            x = Integer.parseInt(row[0]);
            y = Integer.parseInt(row[1]);
            z = Integer.parseInt(row[2]);
            g.addEdge(x, y, z);
        }
        int[] dist = new int[n + 1]; // distance to index
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(1);
        while (!pq.isEmpty()) {
            int u = pq.poll();
            for (Edge e : g.neighbors(u)) {
                if (dist[e.to] > dist[u] + e.cost) {
                    dist[e.to] = dist[u] + e.cost;
                    pq.add(e.to);
                }
            }
        }
        if (dist[n] == Integer.MAX_VALUE) {
            System.out.println("impossible");
        } else {
            System.out.println(dist[n]);
        }

    }
}