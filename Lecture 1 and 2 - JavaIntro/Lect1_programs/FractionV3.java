import java.util.*; // or import java.util.Scanner;

public class FractionV3 {
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

        // compute GCD of newNum and newDenom
        int rem,e,f;

        e = newNum;
        f = newDenom;
        while (f > 0) { 
          rem = e%f;
          e = f;
          f = rem;
      }
      // GCD is the value of e after while loop stops

      newNum /= e;
      newDenom /= e;
      System.out.println("New Fraction = "+newNum+"/"+newDenom);
  }
}