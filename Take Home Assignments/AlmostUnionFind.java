import java.util.*;

class AlmostUnionFind {
    static int[] parent;
    static int[] size;
    static long[] sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        parent = new int[200001];
        size = new int[200001];
        sum = new long[200001];
        int n, m;
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            m = sc.nextInt();
            makeSet(n);
            for (int i = 0; i < m; i++) {
                int cmd = sc.nextInt();
                if (cmd == 1) {
                    int p = sc.nextInt();
                    int q = sc.nextInt();
                    union(p, q);
                } else if (cmd == 2) {
                    int p = sc.nextInt();
                    int q = sc.nextInt();
                    move(p, q);
                } else {
                    int x = sc.nextInt();
                    System.out.println(size[find(x)] + " " + sum[find(x)]);
                }
            }
        }
    }

    static void makeSet(int n) {
        int j = n + 1;
        for (int i = 1; i <= n; i++) {
            parent[i] = j;
            parent[j] = j;
            size[j] = 1;
            sum[j] = i;
            j++;
        }
    }

    static int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }

    static void union(int p, int q) {
        int a = find(p);
        int b = find(q);
        if (a == b) return;
        size[b] += size[a];
        sum[b] += sum[a];
        parent[a] = b;
    }

    static void move(int p, int q) {
        int a = find(p);
        int b = find(q);
        if (a == b) return;
        size[b]++;
        size[a]--;
        sum[b] += p;
        sum[a] -= p;
        parent[p] = b;
    }
}

