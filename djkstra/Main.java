import java.util.ArrayList;
import java.util.PriorityQueue;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Edge {
    public int to;
    public int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Graph {
    public ArrayList<ArrayList<Edge>> edges;

    public Graph(int n) {
        edges = new ArrayList<ArrayList<Edge>>(n + 1);
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<Edge>());
        }
    }

    public void addEdge(int from, int to, int weight) {
        edges.get(from).add(new Edge(to, weight));
    }

    public ArrayList<Edge> neighbors(int u) {
        return edges.get(u);
    }
}

class Node implements Comparable<Node> {
    public int u;
    public int dist;

    public Node(int u, int dist) {
        this.u = u;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = buf.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        int x, y, z;
        Graph g = new Graph(n);
        for (int i = 0; i < m; i++) {
            params = buf.readLine().split(" ");
            x = Integer.parseInt(params[0]);
            y = Integer.parseInt(params[1]);
            z = Integer.parseInt(params[2]);
            g.addEdge(x, y, z);
        }
        buf.close();

        boolean[] vis = new boolean[n + 1];

        int[] dis = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        Node cur = new Node(1, 0);
        pq.add(cur);
        while (!pq.isEmpty()) {
            cur = pq.poll();
            if (vis[cur.u])
                continue;
            else if (cur.u == n) {
                System.out.println(cur.dist);
                return;
            } else {
                dis[cur.u] = cur.dist;
                vis[cur.u] = true;
                for (Edge e : g.neighbors(cur.u)) {
                    if (!vis[e.to]) {
                        pq.add(new Node(e.to, cur.dist + e.weight));
                    }
                }
            }
        }
        System.out.println(-1);
        return;
    }
}