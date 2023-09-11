import java.util.Scanner;

class Autori {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.close();

        String[] udin = input.split("-");
        String result = "";
        for (String name: udin) {
            char capital = name.charAt(0);
            result += capital;
        }
        System.out.println(result);
    }
}