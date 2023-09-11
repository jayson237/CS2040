import java.util.Scanner;

class NumberFun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            double n1 = (double) sc.nextInt();
            double n2 = (double) sc.nextInt();
            double n3 = (double) sc.nextInt();

            if (calc(n1, n2, n3)) {
                result.append("Possible\n");
            } else {
                result.append("Impossible\n");
            }
        }
        System.out.println(result);
        sc.close();
    }

    public static boolean calc(double n1, double n2, double n3) {
        return (n1 + n2 == n3) ||
               (n1 - n2 == n3 || n2 - n1 == n3) ||
               (n1 * n2 == n3) ||
               (n1 / n2 == n3 || n2 / n1 == n3);
    }
}
