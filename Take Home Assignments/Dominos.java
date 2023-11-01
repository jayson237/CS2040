import java.io.*;
import java.util.*;

class Dominos {
    static int count;
    static int[][] adjacencyList;
    static boolean[] visited;
    static List<Integer> stack;
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int cases = io.getInt();
        StringBuilder sb = new StringBuilder();
        while (cases > 0) {
            int n = io.getInt();
            int m = io.getInt();
            adjacencyList = new int[n][];
            for (int i = 0; i < n; i++) {
                adjacencyList[i] = new int[0];
            }
            for (int i = 0; i < m; i++) {
                int v1 = io.getInt() - 1;
                int v2 = io.getInt() - 1;
                adjacencyList[v1] = add(adjacencyList[v1], v2);
            }
            sb.append(solve(adjacencyList)).append("\n");
            cases--;
        }
        io.print(sb);
        io.flush();
    }

    static int[] add(int[] arr, int element) {
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[arr.length] = element;
        return newArr;
    }

    static void dfs1(int currentVertex) {
        visited[currentVertex] = true;
        for (int neighbor : adjacencyList[currentVertex]) {
            if (!visited[neighbor]) {
                dfs1(neighbor);
            }
        }
        stack.add(currentVertex);
    }

    static void dfs2(int currentVertex) {
        visited[currentVertex] = true;
        for (int neighbor : adjacencyList[currentVertex]) {
            if (!visited[neighbor]) {
                dfs2(neighbor);
            }
        }
    }

    static int solve(int[][] adjacencyList) {
        stack = new ArrayList<>();
        visited = new boolean[adjacencyList.length];
        for (int i = 0; i < adjacencyList.length; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }
        count = 0;
        visited = new boolean[adjacencyList.length];
        for (int i = stack.size() - 1; i >= 0; i--) {
            int vertex = stack.get(i);
            if (!visited[vertex]) {
                count++;
                dfs2(vertex);
            }
        }
        return count;
    }
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}