import java.io.*;
import java.util.*;

 class Coconut {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = str.split(" ");
        int s = Integer.parseInt(strArr[0]);
        int n = Integer.parseInt(strArr[1]);

        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            players.add(new Player(i + 1, "Folded"));
        }

        while (players.size() > 1) {
            for (int i = 0; i < s - 1; i++) {
                players.add(players.get(0));
                players.remove(0);
            }

            Player cur = players.get(0);
            players.remove(0);
            int player = cur.playerNum;

            if (cur.handState.equals("Folded")) {
                players.add(0, new  Player(player, "Fist"));
                players.add(0, new Player(player, "Fist"));
            }

            else if (cur.handState.equals("Fist")) {
                players.add(new Player(player, "Palm"));
            }

        }

        pw.print(players.get(0).playerNum);
        pw.flush();
    }

     static class Player {
         Integer playerNum;
         String handState;

         Player (int playerNum, String handState) {
             this.playerNum = playerNum;
             this.handState = handState;
         }

     }
}
