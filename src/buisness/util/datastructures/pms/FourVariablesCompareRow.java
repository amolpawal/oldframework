package buisness.util.datastructures.pms;

public  class FourVariablesCompareRow implements Comparable<FourVariablesCompareRow> {
	
	private String Var1;
	private String Var2;
	private String Var3;
	private String Var4;
	
	
	FourVariablesCompareRow(String Var1,String Var2,String Var3 ,String Var4)
	{
		this.Var1=Var1;
		this.Var2=Var2;
		this.Var3=Var3;
		this.Var4=Var4;
		
	}
	
	public int compareTo(FourVariablesCompareRow target)
	{
		System.out.println("inside campare 2 of grid row");
		return (this.Var1.compareTo(target.Var1))
				+(this.Var2.compareTo(target.Var2))
				+(this.Var3.compareTo(target.Var3))
				+(this.Var4.compareTo(target.Var4));
	}
	

	

}
