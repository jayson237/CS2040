import java.util.*;

public class Fib {

	public static int fib(int n) {
	  if (n <= 2)
		return 1;
	  else
		return fib(n-1) + fib(n-2);
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println("fib("+n+")"+" = "+fib(n));
	}
}
