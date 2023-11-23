import java.util.*;
import java.io.*;

public class PrimDemo {
  public static ArrayList < ArrayList < IntegerPair > > AdjList;
  public static ArrayList < Boolean > taken;
  public static PriorityQueue < IntegerPair > pq;

  public static void process(int vtx) {
    System.out.println(">> At vertex " + vtx);
    taken.set(vtx, true);
    for (int j = 0; j < AdjList.get(vtx).size(); j++) {
      IntegerPair v = AdjList.get(vtx).get(j);
      if (!taken.get(v.first())) {
        pq.offer(new IntegerPair(v.second(), v.first()));  // we sort by weight then by adjacent vertex
        System.out.println(">> Inserting (" + v.second() + ", " + v.first() + ") to priority queue");
      }
      else
        System.out.println(">> Ignoring (" + v.second() + ", " + v.first() + ")");
    }
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception {
    /*
    // Sample graph shown in lecture
    5 7
    1 2 4
    1 3 4
    2 3 2
    1 4 6
    3 4 8
    1 5 6
    4 5 9
    */

    Scanner sc = new Scanner(System.in);
    int V = sc.nextInt(), E = sc.nextInt();
    AdjList = new ArrayList < ArrayList < IntegerPair > >();

    for (int i = 0; i < V; i++) {
      ArrayList < IntegerPair > Neighbor = new ArrayList < IntegerPair >(); // create vector of Integer pair 
      AdjList.add(Neighbor); // store blank vector first
    }
    
    for (int i = 0; i < E; i++) { // store graph information in Adjacency List
      // we decrease index by 1 to change input to 0-based indexing
      int u = sc.nextInt() - 1, v = sc.nextInt() - 1, w = sc.nextInt();
      AdjList.get(u).add(new IntegerPair(v, w)); // bi-directional
      AdjList.get(v).add(new IntegerPair(u, w));
    }

    taken = new ArrayList < Boolean >(); 
    taken.addAll(Collections.nCopies(V, false));
    pq = new PriorityQueue < IntegerPair > ();
    // take any vertex of the graph, for simplicity, vertex 0, to be included in the MST
    process(0);
    int mst_cost = 0;
    
    while (!pq.isEmpty()) { // we will do this until all V vertices are taken (or E = V-1 edges are taken)
      IntegerPair front = pq.poll();

      if (!taken.get(front.second())) { // we have not connected this vertex yet
        mst_cost += front.first(); // add the weight of this edge
        System.out.println("Adding edge: (" + front.first() + ", " + front.second() + "), MST cost now = " + mst_cost);
        process(front.second());
      }
      else // this vertex has been connected before via some other tree branch
        System.out.println("Ignoring edge: (" + front.first() + ", " + front.second() + "), MST cost now = " + mst_cost);
    }
    
    System.out.printf("Final MST cost %d\n", mst_cost);
  }
}

class IntegerPair implements Comparable<IntegerPair> {
  public Integer _first, _second;

  public IntegerPair(Integer f, Integer s) {
    _first = f;
    _second = s;
  }

  public int compareTo(IntegerPair o) {
    if (!this.first().equals(o.first()))
      return this.first() - o.first();
    else
      return this.second() - o.second();
  }

  Integer first() { return _first; }

  Integer second() { return _second; }
}
