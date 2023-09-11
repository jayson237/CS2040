import java.util.Scanner;

class Twostones {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int stones = sc.nextInt();
        sc.close();
        
        System.out.println(stones % 2 != 0 ? "Alice" : "Bob");
    }
}