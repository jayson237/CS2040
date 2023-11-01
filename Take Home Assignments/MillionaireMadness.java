import java.io.*;
import java.util.*;

class MillionaireMadness {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int M = io.getInt();
        int N = io.getInt();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                rowList.add(io.getInt());
            }
            matrix.add(rowList);
        }
        io.println(dijkstra(matrix, M, N));
        io.flush();
    }

    static int dijkstra(ArrayList<ArrayList<Integer>> matrix, int rows, int columns) {
        boolean[] visited = new boolean[rows * columns];
        Comparator<Node> comparator = (x, y) -> x.cost - y.cost;
        PriorityQueue<Node> unvisited = new PriorityQueue<>(comparator);
        unvisited.add(new Node(0,0,0));

        while (!unvisited.isEmpty()) {
            Node current = unvisited.poll();
            int currCell = current.rows * columns + current.columns;
            if (visited[currCell]) continue;
            if (current.columns == columns - 1 && current.rows == rows - 1) return current.cost;
            visited[currCell] = true;

            if (current.rows < rows - 1 && !visited[(current.rows + 1) * columns + current.columns]) {
                int nextRow = current.rows + 1;
                int nextCol = current.columns;
                int nextCost = Math.max(current.cost, matrix.get(nextRow).get(nextCol) - matrix.get(current.rows).get(current.columns));
                unvisited.add(new Node(nextRow, nextCol, nextCost));
            }

            if (current.rows > 0 && !visited[(current.rows - 1) * columns + current.columns]) {
                int nextRow = current.rows - 1;
                int nextCol = current.columns;
                int nextCost = Math.max(current.cost, matrix.get(nextRow).get(nextCol) - matrix.get(current.rows).get(current.columns));
                unvisited.add(new Node(nextRow, nextCol, nextCost));
            }

            if (current.columns < columns - 1 && !visited[current.rows * columns + current.columns + 1]) {
                int nextRow = current.rows;
                int nextCol = current.columns + 1;
                int nextCost = Math.max(current.cost, matrix.get(nextRow).get(nextCol) - matrix.get(current.rows).get(current.columns));
                unvisited.add(new Node(nextRow, nextCol, nextCost));
            }

            if (current.columns > 0 && !visited[current.rows * columns + current.columns - 1]) {
                int nextRow = current.rows;
                int nextCol = current.columns - 1;
                int nextCost = Math.max(current.cost, matrix.get(nextRow).get(nextCol) - matrix.get(current.rows).get(current.columns));
                unvisited.add(new Node(nextRow, nextCol, nextCost));
            }
        }
        return -1;
    }
}

class Node {
    int rows, columns, cost;
    Node (int rows, int columns, int cost) {
        this.rows = rows;
        this.columns = columns;
        this.cost = cost;
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