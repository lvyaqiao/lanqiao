import java.util.Scanner;

class DisjoinSet {
    public int[] origin;
    public int[] clusmax = new int[1000005];

    // 为0表示已经是这一类的最大
    public DisjoinSet(int[] arr) {
        origin = arr;
    }

    public int query(int n) {
        int result = clusmax[n];
        if (result == 0) {
            // is clusmax
            clusmax[n] = n + 1;
            return n;
        } else {
            clusmax[n] = query(clusmax[n]);
            return clusmax[n];
        }
    }

    public void solution() {
        int query;
        for (int i = 0; i < origin.length; i++) {
            query = query(origin[i]);
            origin[i] = query;
        }

        for (int i = 0; i < origin.length; i++) {
            System.out.print(origin[i] + " ");
        }

    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        DisjoinSet s = new DisjoinSet(arr);
        s.solution();

    }
}
