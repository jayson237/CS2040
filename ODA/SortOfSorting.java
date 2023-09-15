import java.util.*;

class SortOfSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases != 0) {
            ArrayList<String> names = new ArrayList<>();
            for (int i = 0; i < cases; i++) {
                String name = sc.next();
                names.add(name);
            }
            names.sort(new NameComparator());
            names.forEach(System.out::println);
            cases = sc.nextInt();
            if (cases != 0) System.out.println(" ");
        }
        sc.close();
    }

    static class NameComparator implements Comparator<String> {
        public int compare(String o1, String o2) {
            if (o1.charAt(0) > o2.charAt(0)) return 1;
            else if (o1.charAt(0) < o2.charAt(0)) return -1;
            else if (o1.charAt(1) > o2.charAt(1)) return 1;
            else if (o1.charAt(1) < o2.charAt(1)) return -1;
            return 0;
        }
    }
}