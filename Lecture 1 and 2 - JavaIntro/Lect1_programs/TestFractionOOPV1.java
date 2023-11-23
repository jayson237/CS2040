import java.util.*; // or import java.util.Scanner;

class FractionOOPV1 {
  public int num, denom;
  
  public FractionOOPV1(int iNum, int iDenom) { 
    num = iNum;
    denom = iDenom;
  }

  public int getNum() { return num; }
  public int getDenom() { return denom; }
  public void setNum(int iNum) {num = iNum;}
  public void setDenom(int iDenom) {denom = iDenom;}
  public static int gcd(int e, int f) {
    int rem;

    while (f > 0) { 
      rem = e%f;
      e = f;
      f = rem;
    }
    return e;  
  }

  // instance method add -> takes in another fraction add to this fraction and modify it
  public void add(FractionOOPV1 iFrac) {
    num = num*iFrac.getDenom()+denom*iFrac.getNum();
    denom = denom*iFrac.getDenom();
    int divisor = gcd(num,denom);
    num /= divisor;
    denom /= divisor;
  }

  public void add(int iNum, int iDenom) {
    num = num*iDenom+denom*iNum;
    denom = denom*iDenom;
    int divisor = gcd(num,denom);
    num /= divisor;
    denom /= divisor;
  }
  
  public String toString() {
    return num+"/"+denom;
  }
}

public class TestFractionOOPV1 {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int numAdd = sc.nextInt();
    
    for (int i=0; i < numAdd; i++) {
      FractionOOPV1 f1 = new FractionOOPV1(sc.nextInt(),sc.nextInt());
      FractionOOPV1 f2 = new FractionOOPV1(sc.nextInt(),sc.nextInt());
      f1.add(f2);
      System.out.println(f1);
    }
  }
}
