
public interface FracADT {

	public int getNum();   //returns numerator part
	public int getDenom();   //returns denominator part
	public void setNum(int iNum);  //sets new numerator
	public void setDenom(int iDenom);  //sets new denominator

	public FracADT add(FracADT f);    //returns this + f
	public FracADT minus(FracADT f);  //returns this - f
	public FracADT times(FracADT f);  //returns this * f
	public FracADT divide(FracADT f); //returns this / f
	public FracADT simplify(); //returns simplified version
} 
