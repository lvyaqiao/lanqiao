import java.util.Scanner;

class DisjoinSet {
    public int[] father;

    public DisjoinSet(int n) {
        father = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
    }

    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }

    public void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            father[fx] = fy;
        }
    }

    public int count() {
        int cnt = 0;
        for (int i = 1; i < father.length; i++) {
            if (father[i] == i) {
                cnt++;
            }
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        DisjoinSet ds = new DisjoinSet(m * n);
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ds.union(a, b);
        }
        System.out.println(ds.count());
    }
}