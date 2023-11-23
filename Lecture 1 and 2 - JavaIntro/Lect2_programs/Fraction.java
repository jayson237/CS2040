
class Fraction implements FracADT {
	public int num;
	public int denom;

	// Constructors
  public Fraction() { this(1,1); /* calls the other constructor */}

	public Fraction(int iNum, int iDenom) { 
		setNum(iNum); 
		setDenom(iDenom);
	}

	// Accessors 
	public int getNum() { return num; } 
	public int getDenom() { return denom;} 

	// Mutators
	public void setNum(int iNum) { num = iNum;}
 	public void setDenom(int iDenom) { denom = iDenom; }

  // Fill in the code for all the methods below
  public FracADT simplify() { 
    int divisor = gcd(num,denom);
    Fraction result = new Fraction(num/divisor,denom/divisor);

    return result;
  }
  public FracADT add(FracADT f) { 
    Fraction result;
    int tnum, tdenom;

    tnum = num*f.getDenom()+denom*f.getNum();
    tdenom = denom*f.getDenom();
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
    return num+"/"+denom;
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
