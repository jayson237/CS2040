import java.io.*;
import java.util.*;

class Islands {
    static char[][] matrix;
    static int[][] visited;
    static int rows;
    static int cols;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        while (io.hasMoreTokens()) {
            rows = io.getInt();
            cols = io.getInt();
            matrix = new char[rows][cols];
            visited = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                String grids = io.getWord();
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = grids.charAt(j);
                    visited[i][j] = 0;
                }
            }
            int islands = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (visited[i][j] == 0 && matrix[i][j] == 'L') {
                        islands += 1;
                        dfs(i, j);
                    }
                }
            }
            io.println(islands);
        }
        io.flush();
    }

    static void dfs(int currentRow, int currentCol) {
        if (visited[currentRow][currentCol] == 1 || matrix[currentRow][currentCol] == 'W') return;
        visited[currentRow][currentCol] = 1;

        if (currentRow - 1 >= 0) {
            dfs(currentRow - 1, currentCol);
        }

        if (currentRow + 1 < rows) {
            dfs(currentRow + 1, currentCol);
        }

        if (currentCol - 1 >= 0) {
            dfs(currentRow, currentCol - 1);
        }

        if (currentCol + 1 < cols) {
            dfs(currentRow, currentCol + 1);
        }
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