
public class FractionV1 {

	public static void main(String[] args) {
		int a,b,c,d,newNum,newDenom;
        
        a = 1;
        b = 2;
        c = 3;
        d = 4;

        newDenom = b*d;
        newNum = a*d+c*b;

        System.out.println("New Fraction = "+newNum+"/"+newDenom);
    }
}
