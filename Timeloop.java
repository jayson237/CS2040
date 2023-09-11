import java.util.Scanner;

class Timeloop {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        sc.close();
        
        for (int i = 0; i < time; i++) {
            System.out.println(i+1 + " Abracadabra");
        } 
    }
}