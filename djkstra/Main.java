import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

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
    public Graph (int n){
        edges = new ArrayList<ArrayList<Edge>>(n);
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Edge>());
        }
    }
    public void addEdge(int from, int to, int weight) {
        edges.get(from).add(new Edge(to, weight));
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x, y, z;
        Graph g = new Graph(n);
        for (int i = 0; i < m; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            g.addEdge(x, y, z);
        }
        sc.close();

        

    }
}