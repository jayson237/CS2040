import java.io.*;
import java.util.*;

class Nicknames {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        HashMap<String, Integer> freq = new HashMap<>();
        AVL tree = new AVL();

        int a = io.getInt();
        for (int i = 0; i < a; i++) {
            tree.insert(io.getWord());
        }

        int b = io.getInt();
        for (int i = 0; i < b; i++) {
            String nickname = io.getWord();
            if (freq.containsKey(nickname)) {
                io.println(freq.get(nickname));
            } else {
                int matches = tree.getMatches(nickname);
                io.println(matches);
                freq.put(nickname, matches);
            }
        }
        io.flush();
        io.close();
    }
}

class Vertex {
    Vertex parent, left, right;
    String key;
    int height, size;
    Vertex(String key) {
        this.parent = null;
        this.left = null;
        this.right = null;
        this.key = key;
        this.height = 0;
        this.size = 1;
    }
}

class AVL {
    Vertex root;

    AVL() {
        this.root = null;
    }

    int getSize(Vertex v) {
        return (v != null) ? v.size : 0;
    }

    void updateSize(Vertex v) {
        if (v != null) {
            v.size = getSize(v.left) + getSize(v.right) + 1;
        }
    }

    int getHeight(Vertex v) {
        return (v != null) ? v.height : -1;
    }

    void updateHeight(Vertex v) {
        if (v != null) {
            v.height = Math.max(getHeight(v.left), getHeight(v.right)) + 1;
        }
    }

    int getBalanceFactor(Vertex v) {
        return (v != null) ? getHeight(v.left) - getHeight(v.right) : 0;
    }

    Vertex rotateLeft(Vertex v) {
        if (v.right == null) return v;
        Vertex newV = v.right;
        v.right = newV.left;
        if (newV.left != null) newV.left.parent = v;
        newV.parent = v.parent;
        if (v.parent == null) this.root = newV;
        else if (v == v.parent.left) v.parent.left = newV;
        else v.parent.right = newV;
        newV.left = v;
        v.parent = newV;
        newV.size = v.size;
        updateSize(v);
        updateHeight(v);
        updateHeight(newV);
        return newV;
    }

    Vertex rotateRight(Vertex v) {
        if (v.left == null) return v;
        Vertex newV = v.left;
        v.left = newV.right;
        if (newV.right != null) newV.right.parent = v;
        newV.parent = v.parent;
        if (v.parent == null) this.root = newV;
        else if (v == v.parent.right) v.parent.right = newV;
        else v.parent.left = newV;
        newV.right = v;
        v.parent = newV;
        newV.size = v.size;
        updateSize(v);
        updateHeight(v);
        updateHeight(newV);
        return newV;
    }

    Vertex checkRotation(Vertex v) {
        int balanceFactor = getBalanceFactor(v);
        int leftChildBalance = (v.left != null) ? getBalanceFactor(v.left) : 0;
        if (balanceFactor > 1) {
            if (leftChildBalance < 0) v = rotateLeft(v);
            else v = rotateRight(v);
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(v.right) > 0) v = rotateRight(v);
            else v = rotateLeft(v);
        }
        return v;
    }

    void insert(String s) {
        this.root = insert(this.root, s);
    }

    Vertex insert(Vertex v, String s) {
        if (v == null) return new Vertex(s);

        if (s.compareTo(v.key) > 0) {
            v.right = insert(v.right, s);
            v.right.parent = v;
        } else {
            v.left = insert(v.left, s);
            v.left.parent = v;
        }
        updateSize(v);
        updateHeight(v);
        return checkRotation(v);
    }

    Vertex search(Vertex v, String s) {
        if (v == null)  return null;
        if (v.key.startsWith(s)) return v;
        if (s.compareTo(v.key) > 0)  return search(v.right, s);
        return search(v.left, s);
    }

    int checkRight(Vertex v, String query) {
        if (v == null) return 0;
        if (v.key.startsWith(query)) return  getSize(v.left) + 1 + checkRight(v.right, query);
        return checkRight(v.left, query);
    }

    int checkLeft(Vertex v, String query) {
        if (v == null) return 0;
        if (v.key.indexOf(query) == 0) return getSize(v.right) + 1 +  checkLeft(v.left, query);
        return checkLeft(v.right, query);
    }

    int getMatches(String query) {
        Vertex v = search(root, query);
        if (v != null) return checkLeft(v.left, query) + 1 + checkRight(v.right, query);
        return 0;
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





