import java.util.Scanner;
import java.util.ArrayList;

class Pot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> total = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int in = sc.nextInt();
            int power = in % 10;
            int num = in / 10;
            int result = (int) Math.pow(num, power); 
            total.add(result);
        }
        int out = 0; 
        for (Integer num : total) {
            out += num;
        }
        System.out.println(out);
        sc.close();
    }
}
