import java.util.*; // or import java.util.Scanner;

public class FractionV4 {

  public static int gcd(int e, int f) {
    int rem;

    while (f > 0) { 
      rem = e%f;
      e = f;
      f = rem;
    }
    return e;  
  }

	public static void main(String[] args) {
    int a,b,c,d,newNum,newDenom;
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter 2 Fractions to be added: ");
    a = sc.nextInt();
    b = sc.nextInt();
    c = sc.nextInt();
    d = sc.nextInt();

    newDenom = b*d;
    newNum = a*d+c*b;

    int divisor = gcd(newNum,newDenom);
    newNum /= divisor;
    newDenom /= divisor;   
    System.out.println("New Fraction = "+newNum+"/"+newDenom);
	}
}
