import java.util.Scanner;
import java.util.ArrayList;

class LastFactorialDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        ArrayList<String> store = new ArrayList<>();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String factorial = Integer.toString(getFactorial(n) % 10);
            store.add(factorial);
        }
        
        for (String udin : store) {
            System.out.println(udin);
        }
        
        scanner.close();
    }
    
    public static int getFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1; 
        }
        
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i);
        }
        
        return result;
    }
}
