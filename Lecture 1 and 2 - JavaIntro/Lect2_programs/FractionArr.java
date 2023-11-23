
class FractionArr implements FracADT {
  public int[] members; // index 0 is num, index 1 is denom
  public static final int num = 0;
  public static final int denom = 1;
    
  //Constructor – note we don’t have the default constructor here  
  public FractionArr(int iNum, int iDenom) { 
    members = new int[2];
    setNum(iNum); 
    setDenom(iDenom);
  }

  // Accessors 
  public int getNum() {return members[num];} 
  public int getDenom() {return members[denom];} 

  // Mutators
  public void setNum(int iNum) {members[num] = iNum;}
  public void setDenom(int iDenom) {members[denom] = iDenom;}

  // Fill in the code for all the methods below
  public FracADT simplify() { 
    int divisor = gcd(members[num],members[denom]);
    FractionArr result = new FractionArr(members[num]/divisor,members[denom]/divisor);

    return result;
  }

  public FracADT add(FracADT f) {
    Fraction result;
    int tnum, tdenom;

    tnum = members[num]*f.getDenom()+members[denom]*f.getNum();
    tdenom = members[denom]*f.getDenom();
    int divisor = gcd(tnum,tdenom);
    result = new Fraction(tnum/divisor, tdenom/divisor); 

    return result;
  }

  public FracADT minus(FracADT f) {
   /*dummy code - replace to perform proper subtraction */ 
    Fraction result = new Fraction();

    return result;
  }

  public FracADT times(FracADT f) { 
   /*dummy code - replace to perform proper multiplication */ 
    Fraction result = new Fraction();

    return result;
  }

  public FracADT divide(FracADT f) { 
    /*dummy code - replace to perform proper division */ 
    Fraction result = new Fraction();

    return result;
  }

  // Overriding methods toString() and equals()
  public String toString() {
    return members[num]+"/"+members[denom];
  }

  public boolean equals(Object obj) { 
    if (obj instanceof FracADT) {
      FracADT temp1 = ((FracADT) obj).simplify(); // result of casting
      FracADT temp2 = simplify();

      return ((temp1.getNum() == temp2.getNum()) &&
              (temp1.getDenom() == temp2.getDenom()));
    }
    return false;
  }

  // Returns greatest common divisor of a and b
  public static int gcd(int a, int b) {
    int rem;

    while (b > 0) { 
      rem = a%b;
      a = b;
      b = rem;
    }
    return a;  
  }
}
