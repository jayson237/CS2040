
public class TestFracADT {
	public static void main(String[] args) {
		FracADT frac1 = new Fraction(1,2);
		FracADT frac2 = new FractionArr(8,12);

		if (frac1.equals(frac2))
			System.out.println(frac1 + " == " + frac2);
		else
			System.out.println(frac1 + " != " + frac2);
		FracADT frac3 = frac1.add(frac2);
		System.out.println(frac3);
	}
}
