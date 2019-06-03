package buisness.util.datastructures.pms;

import java.util.ArrayList;

import buisness.util.datastructures.dashboard.practice.PracticeLocationPopUpGridRow;

public class FourVariablesCompare extends ArrayList<FourVariablesCompareRow> implements Comparable<FourVariablesCompare>

{
 public void add(String Var1,String Var2 ,String Var3,String Var4)
 {
	 add(new FourVariablesCompareRow(Var1,Var2,Var3,Var4));
 }
 
public int compareTo(FourVariablesCompare target)
{
	if(target==null)
		return -1;
	if(this.size()==target.size())
	{

		FourVariablesCompareRow sourceRow;
		FourVariablesCompareRow targetRow;
		for(int i=0;i<this.size();i++)
		{
			sourceRow = this.get(i);
			targetRow = target.get(i);			
			if(sourceRow.compareTo(targetRow) != 0)
			{
				return -1;
			}
		}	
		return 0;	
	}
	return -1;
}
}

