import java.io.*;
import java.util.*;

class HumanCannonBall {

    static double[][] matrix;
    static double[] times;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        double x1 = io.nextDouble();
        double y1 = io.nextDouble();
        double x2 = io.nextDouble();
        double y2 = io.nextDouble();
        int numCannons = io.nextInt();
        matrix = new double[numCannons + 2][numCannons + 2];
        times = new double[numCannons + 2];
        double[][] cannonLocations = new double[numCannons][2];

        for (int i = 0; i < numCannons; i++) {
            cannonLocations[i] = new double[]{io.nextDouble(), io.nextDouble()};
        }
        matrix[0][1] = Math.hypot(Math.abs(x1 - x2), Math.abs(y1 - y2)) / 5;
        matrix[1][0] = matrix[0][1];
        int i = 0;
        while (i < numCannons) {
            double dist = Math.hypot(Math.abs(x1 - cannonLocations[i][0]), Math.abs(y1 - cannonLocations[i][1]));
            matrix[0][i + 2] = dist / 5;
            matrix[i + 2][0] = Math.abs(dist - 50) / 5 + 2;
            i++;
        }

        int j = 0;
        while (j < numCannons) {
            double dist = Math.hypot(Math.abs(x2 - cannonLocations[j][0]), Math.abs(y2 - cannonLocations[j][1]));
            matrix[1][j + 2] = dist / 5;
            matrix[j + 2][1] = Math.abs(dist - 50) / 5 + 2;
            j++;
        }

        int m = 0;
        while (m < numCannons) {
            int n = 1;
            while (n < numCannons) {
                double dist = Math.hypot(Math.abs(cannonLocations[n][0] - cannonLocations[m][0]),
                        Math.abs(cannonLocations[n][1] - cannonLocations[m][1]));
                matrix[m + 2][n + 2] = Math.abs(dist - 50) / 5 + 2;
                matrix[n + 2][m + 2] = matrix[m + 2][n + 2];
                n++;
            }
            m++;
        }

        Arrays.fill(times, Double.MAX_VALUE);
        dijkstra();
        io.println(times[1]);
        io.flush();
    }

    public static void dijkstra() {
        boolean[] visited = new boolean[times.length];
        Comparator<Node> c = Comparator.comparingDouble(x -> x.distance);
        PriorityQueue<Node> pq = new PriorityQueue<>(c);
        pq.add(new Node(0, 0));
        while (!pq.isEmpty()) {
            Node curr = pq.remove();
            if (visited[curr.index]) {
                continue;
            }
            visited[curr.index] = true;
            for (int i = 0; i < times.length; i++) {
                if (i != curr.index && !visited[i] && curr.distance + matrix[curr.index][i] < times[i]) {
                    times[i] = curr.distance + matrix[curr.index][i];
                    pq.add(new Node(i, times[i]));
                }
            }
        }
    }
}

class Node {

    int index;
    double distance;

    public Node(int index, double distance) {
        this.index = index;
        this.distance = distance;
    }

}

class Kattio extends PrintWriter {

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasNext() {
        return peekToken() != null;
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }

    public String next() {
        return nextToken();
    }

    public String nextLine() {
        token = null;
        st = null;
        try {
            return r.readLine();
        } catch (IOException e) {
            return null;
        }
    }

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