import java.io.*;
import java.util.*;

class JoinString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        ArrayList<Node> arr = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            pw.write(br.readLine());
        } else {
            for (int i = 0; i < n; i++) {
                arr.add(new Node(br.readLine()));
            }

            Node original, update;
            int[] s = new int[2];

            for (int i = 0; i < n - 1 ; i++) {
                String operation = br.readLine();
                String[] operations = operation.split(" ");
                s[0] = Integer.parseInt(operations[0]);
                s[1] = Integer.parseInt(operations[1]);

                update = arr.get(s[0] - 1);
                original = arr.get(s[1] - 1);

                if (update.before != null) {
                    update.before.after = original;
                }

                update.after = (update.before == null) ? original : update.after;
                update.before = (original.after != null) ? original.before : original;

            }

            for (update = arr.get(s[0]-1); update.after != null; update = update.after) {
                pw.print(update.word);
            }

            pw.print(update.word);

        }
        pw.flush();
        pw.close();
    }

    public static class Node {
        Node before;
        Node after;
        String word;

        Node (String word) {
            this.after = null;
            this.before = null;
            this.word = word;
        }
    }
}
