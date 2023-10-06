import java.util.*;

class Comformity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> h = new HashMap<>();
        int max = 0;
        int frosh = 0;

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                list.add(sc.nextInt());
            }
            list.sort(Comparator.comparingInt(x -> x));
            String s = list.get(0).toString() + list.get(1).toString() + list.get(2).toString() + list.get(3).toString() + list.get(4).toString();
            int count = h.getOrDefault(s, 0);
            h.put(s, count + 1);
            max = (max < h.get(s)) ? h.get(s) : max;
        }

        Iterator iterator = h.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry)iterator.next();
            if ((int)pair.getValue() == max) {
                frosh += max;
            }
        }
        System.out.println(frosh);
        sc.close();
    }
}