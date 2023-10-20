import java.util.*;

class KattissQuest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("add")) {
                int e = sc.nextInt();
                int g = sc.nextInt();
                if (map.containsKey(e)) {
                    map.get(e).add(g);
                } else {
                    map.put(e, new PriorityQueue<>(Collections.reverseOrder()));
                    map.get(e).add(g);
                }
            } else if (s.equals("query")) {
                int energy = sc.nextInt();
                long totalGold = 0;

                while (map.size() > 0 && energy > 0) {
                    Map.Entry<Integer, PriorityQueue<Integer>> entry = map.floorEntry(energy);

                    if (entry == null) {
                        break;
                    }

                    int key = entry.getKey();
                    int maxGold = entry.getValue().poll();
                    totalGold += maxGold;
                    energy -= key;

                    if (entry.getValue().isEmpty()) {
                        map.remove(key);
                    }
                }
                System.out.println(totalGold);
            }
        }
    }
}