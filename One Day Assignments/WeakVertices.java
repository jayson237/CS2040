import java.util.*;

class WeakVertices {

    static HashMap<Integer, List<Integer>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();

        while (vertices != -1) {
            graph = new HashMap<>();
            for (int i = 0; i < vertices; i++) {
                List<Integer> neighbors = new ArrayList<>();
                for (int j = 0; j < vertices; j++) {
                    int x = sc.nextInt();
                    if (x == 1) {
                        neighbors.add(j);
                    }
                }
                graph.put(i, neighbors);
            }

            SortedSet<Integer> weakVertices = new TreeSet<>();

            for (int i = 0; i < vertices; i++) {
                if (isWeakVertex(i)) {
                    weakVertices.add(i);
                }
            }

            for (int vertex : weakVertices) {
                System.out.print(vertex + " ");
            }
            System.out.println();
            vertices = sc.nextInt();
        }
    }

    static boolean isWeakVertex(int vertex) {
        List<Integer> neighbors = graph.get(vertex);
        for (int neighbor : neighbors) {
            for (int neighborNeighbor : graph.get(neighbor)) {
                if (neighborNeighbor != vertex && neighbors.contains(neighborNeighbor)) {
                    return false;
                }
            }
        }
        return true;
    }
}
