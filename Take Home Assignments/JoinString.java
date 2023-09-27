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

            Node originalString, updateString;
            int[] s = new int[2];

            for (int i = 0; i < n - 1 ; i++) {
                String operation = br.readLine();
                String[] operations = operation.split(" ");
                s[0] = Integer.parseInt(operations[0]);
                s[1] = Integer.parseInt(operations[1]);

                updateString = arr.get(s[0] - 1);
                originalString = arr.get(s[1] - 1);

                if (updateString.previous != null) {
                    updateString.previous.next = originalString;
                }

                updateString.next = (updateString.previous == null) ? originalString : updateString.next;
                updateString.previous = (originalString.next != null) ? originalString.previous : originalString;

            }

            for (updateString = arr.get(s[0]-1); updateString.next != null; updateString = updateString.next) {
                pw.print(updateString.word);
            }

            pw.print(updateString.word);

        }
        pw.flush();
        pw.close();
    }

    public static class Node {
        Node previous;
        Node next;
        String word;

        Node (String word) {
            this.next = null;
            this.previous = null;
            this.word = word;
        }
    }
}
