// This program illustrates the use of Math class.
// The following methods are used: pow(), max(), random()

import java.util.*;     

public class TestMath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter 3 values: ");
		double num1 = sc.nextDouble();
		double num2 = sc.nextDouble();
		double num3 = sc.nextDouble();

		System.out.printf("pow(%.2f,%.2f) = %.3f\n", 
		                  num1, num2, Math.pow(num1,num2));

		System.out.println("Largest = " + 
		                   Math.max(Math.max(num1,num2), num3));

		System.out.println("Generating 5 random values:");
		for (int i=0; i<5; i++)
			System.out.println(Math.random());
	}
}
