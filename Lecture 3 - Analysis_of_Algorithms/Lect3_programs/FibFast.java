import java.util.*;

public class FibFast {

	public static int fibfast(int n) {
	  int[] f = new int[n];

	  f[0] = 1;
	  f[1] = 1;
	  for (int i=2; i < n; i++)
	  	f[i] = f[i-1]+f[i-2];

	  return f[n-1];
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println("fibfast("+n+")"+" = "+fibfast(n));
	}
}
