import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    public int x;
    public int y;
    public int dist;

    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}

class Graph {
    int n;
    int m;
    public int[][] time;
    int[] dx = { 0, 0, 1, -1 };
    int[] dy = { 1, -1, 0, 0 };

    public Graph() {
        ;
    }

    public void getInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        time = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                time[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    public ArrayList<Node> neighbors(int i, int j) {
        ArrayList<Node> result = new ArrayList<Node>();
        // 四周的点

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < n && y >= 0 && y < m) {
                result.add(new Node(x, y, time[x][y]));
            }
        }
        return result;
    }

}

public class Main {
    public static void main(String[] args) {
        // echo java version
        Graph g = new Graph();
        g.getInput();
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(0, 0, g.time[0][0]));
        Node cur;
        int i, j, dist;
        boolean[][] vis = new boolean[g.n][g.m];
        int[][] min_dis = new int[g.n][g.m];
        while (!pq.isEmpty()) {
            cur = pq.poll();
            i = cur.x;
            j = cur.y;
            dist = cur.dist;
            if (vis[i][j])
                continue;
            else {
                vis[i][j] = true;
                min_dis[i][j] = dist;
                for (Node n : g.neighbors(i, j)) {
                    n.dist += dist;
                    pq.add(n);
                }
            }

        }
        int max = 0;
        for (int[] row : min_dis) {
            for (int d : row) {
                if (d > max)
                    max = d;
            }
        }
        System.out.println(max);
    }
}
