import java.util.*;

public class FloydWarshallDemo {
  private static int[][] p, D;
  private static int V, E, INF = 1000000000; // the best value for INF on current computer system is 1B, do not put 2B as 2B+2B = 4B is greater than 2^31-1 and thus overflow

  private static void printMatrix(int[][] m) {
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++)
        System.out.printf("%10d ", m[i][j]);
      System.out.printf("\n");
    }
    System.out.println("=====================================================================");
  }

  private static void print_path(int i, int j) {
    if (i != j && !(i == p[i][j] && D[i][j] == INF)) // if using direct edge i.e i == p[i][j] need to check D[i][j] to make sure
                                                     // not INF since p[i][j] is initialized to i regardless if there is an edge
                                                     // between i and j or not.
      print_path(i, p[i][j]);
    System.out.printf("%9d ", j);
  }
  
  public static void main(String[] args) {
    int i, j, k, u, v, w;

    // Note: We do not use I/O for this demo

    // the "memory friendly" version, O(V^2) space complexity, dropping dimension 'k'
    // V = 5; E = 9;
    D = new int[][] { {  0,   2,   1, INF,   3}, // the graph as shown in lecture
                      {INF,   0, INF,   4, INF},
                      {INF,   1,   0, INF,   1},
                      {  1, INF,   3,   0,   5},
                      {INF, INF, INF, INF,   0} };
    
    System.out.println("The default O(V^3) Floyd Warshall's algorithm");
    for (k = 0; k < V; k++) {
      printMatrix(D); // display the content of matrix D step by step
      for (i = 0; i < V; i++)
        for (j = 0; j < V; j++)
          D[i][j] = Math.min(D[i][j], D[i][k]+D[k][j]); // note: this implementation can have subtle bug if D[i][k] or D[k][j] is a large negative value
          //D[i][j] = Math.min(D[i][j], (D[i][k]==INF || D[k][j]==INF) ? INF : D[i][k]+D[k][j]); // but we rarely use this safer version as it has larger constant factor, test this on the commented matrix D above
    }
    printMatrix(D);
    
    System.out.println("Variant 1, print path");
    V = 5; E = 9;
    D = new int[][] { {  0,   2,   1, INF,   3}, // the graph as shown in lecture
                      {INF,   0, INF,   4, INF},
                      {INF,   1,   0, INF,   1},
                      {  1, INF,   3,   0,   5},
                      {INF, INF, INF, INF,   0} };
    p = new int[V][V]; // you need this predecessor matrix
    for (i = 0; i < V; i++)
      for (j = 0; j < V; j++)
        p[i][j] = i; // initialize p[i][j] with i for all pairs i and j

    for (k = 0; k < V; k++)
      for (i = 0; i < V; i++)
        for (j = 0; j < V; j++)
          if (D[i][k]+D[k][j] < D[i][j]) { // you need to use explicit if statement
            D[i][j] = D[i][k]+D[k][j];
            p[i][j] = p[k][j]; // so that you can record this new predecessor value
          }
    printMatrix(D);
    printMatrix(p);
    System.out.print("SP from 3 to 4: ");
    print_path(3,4);
    System.out.println();
    System.out.println("=====================================================================");

    System.out.println("Variant 2, Warshall's algorithm for Transitive Closure problem");
    V = 5; E = 9;
    D = new int[][] { {0, 1, 1, 0, 1}, // the graph as shown in lecture, but the weight is 0/1
                      {0, 0, 0, 1, 0},
                      {0, 1, 0, 0, 1},
                      {1, 0, 1, 0, 1},
                      {0, 0, 0, 0, 0} };

    printMatrix(D); // before
    for (k = 0; k < V; k++)
      for (i = 0; i < V; i++)
        for (j = 0; j < V; j++)
          D[i][j] = D[i][j] | (D[i][k] & D[k][j]); // bit manipulation :O
    printMatrix(D); // after, this is the transitive closure matrix, if D[i][j] = 1, we know that there is a path from vertex i to vertex j, directly (via an edge) OR INDIRECTLY (via a path)


	System.out.println("Variant 3, Minimax (change min to max and max to min for Maximin) Path Problem");
    V = 5; E = 9;
    D = new int[][] { {  0,   2,   1, INF,   3}, // the graph as shown in lecture
                      {INF,   0, INF,   4, INF},
                      {INF,   1,   0, INF,   1},
                      {  1, INF,   3,   0,   5},
                      {INF, INF, INF, INF,   0} };

    printMatrix(D);
    for (k = 0; k < V; k++)
      for (i = 0; i < V; i++)
        for (j = 0; j < V; j++)
          D[i][j] = Math.min(D[i][j], Math.max(D[i][k], D[k][j])); // wow...
    printMatrix(D);


    System.out.println("Variant 4, Detecting any (including negative) cycle");
    V = 5; E = 9;
    D = new int[][] { {INF,   2,   1, INF,   3}, // the graph as shown in lecture, notice that we change D[i][i] from 0 to INF...
                      {INF, INF, INF,   4, INF},
                      {INF,   1, INF, INF,   1},
                      {  1, INF,   3, INF,   5},
                      {INF, INF, INF, INF, INF} };

    printMatrix(D);
    for (k = 0; k < V; k++)
      for (i = 0; i < V; i++)
        for (j = 0; j < V; j++)
          D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
    printMatrix(D); // now check if any of the entry in the main diagonal is no longer INF, if yes, we have a cycle
                    // if any of the entry in the main diagonal is negative, we have a negative cycle
  }
}
