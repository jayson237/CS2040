// Barebones Union-Find Disjoint Sets implementation, 
// using both path compression and union by rank heuristics

import java.util.*;

class UnionFind {                                              
  public int[] p;
  public int[] rank;

  public UnionFind(int N) {
    p = new int[N];
    rank = new int[N];
    for (int i = 0; i < N; i++) {
      p[i] = i;
      rank[i] = 0;
    }
  }

  public int findSet(int i) { 
    if (p[i] == i) return i;
    else {
      p[i] = findSet(p[i]);
      return p[i]; 
    } 
  }

  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

  public void unionSet(int i, int j) { 
    if (!isSameSet(i, j)) { 
      int x = findSet(i), y = findSet(j);
      // rank is used to keep the tree short
      if (rank[x] > rank[y]) 
      	p[y] = x;
      else { 
      	p[x] = y;
        if (rank[x] == rank[y]) 
          rank[y] = rank[y]+1; 
      } 
    } 
  }
}

public class UnionFindDemo {
  public static void main(String[] args) {
    UnionFind disjointSet = new UnionFind(5); // create 5 sets {0},{1},{2},{3},{4} 

    disjointSet.unionSet(0,2); // union set containing 0 and set containing 2 if 0 and 2 are not already in the same set
    disjointSet.unionSet(3,4); // union set containing 3 and set containing 4 if 3 and 4 are not already in the same set
    System.out.println("Representative item of set containing 3 is "+disjointSet.findSet(3)); // representative item of set containing 3 is 4
    if (disjointSet.isSameSet(0,1)) // 0 and 1 is not in the same set
      System.out.println("0 and 1 are in the same set");
    else
      System.out.println("0 and 1 are not in the same set");
  }
}
