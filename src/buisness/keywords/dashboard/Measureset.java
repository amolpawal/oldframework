package buisness.keywords.dashboard;

import buisness.core.dashboard.Practice.measureset.GetCopyrightYear;
import buisness.core.dashboard.Practice.measureset.SelectMeasureSet;
import buisness.core.dashboard.Practice.rolling.PracticePatientDrillDownSortR;
import buisness.core.dashboard.provider.nonrolling.ProviderCountNR;
import buisness.core.dashboard.provider.nonrolling.ProviderGridViewNR;
import buisness.core.dashboard.provider.nonrolling.ProviderMeasureComputationSummaryViewNR;
import buisness.core.dashboard.provider.nonrolling.ProviderMeasureViewNR;
import buisness.core.dashboard.provider.nonrolling.ProviderPaginationNR;
import buisness.core.dashboard.provider.nonrolling.ProviderPatientDrillDownCountNR;
import buisness.core.dashboard.provider.nonrolling.ProviderPatientDrillDownPaginationNR;
import buisness.core.dashboard.provider.nonrolling.ProviderPatientDrillDownSortNR;
import buisness.core.dashboard.provider.nonrolling.ProviderPatientDrillDownViewNR;
import buisness.core.dashboard.provider.rolling.DetailedPPDrillDownCountR;
import buisness.core.dashboard.provider.rolling.ProviderCountR;
import buisness.core.dashboard.provider.rolling.ProviderGridViewR;
import buisness.core.dashboard.provider.rolling.ProviderMeasureComputationSummaryViewR;
import buisness.core.dashboard.provider.rolling.ProviderMeasureViewR;
import buisness.core.dashboard.provider.rolling.ProviderPaginationR;
import buisness.core.dashboard.provider.rolling.ProviderPatientDrillDownCountR;
import buisness.core.dashboard.provider.rolling.ProviderPatientDrillDownPaginationR;
import buisness.core.dashboard.provider.rolling.ProviderPatientDrillDownSortR;
import buisness.core.dashboard.provider.rolling.ProviderPatientDrillDownViewR;
import buisness.keywords.Common;
import configuration.UtilityFunction;
import testcases.dashboard.provider.UtilityFunctionDashboardProvider;

public class Measureset  extends Common{

	UtilityFunction util=new UtilityFunction();
	UtilityFunctionDashboardProvider util_pro=new UtilityFunctionDashboardProvider();
	
	@Override
	public String meth(String elementmethod,String action,String locator,String...data)
	{
		try
		{
		result=super.meth(elementmethod, action, locator, data);
		if(action.equals("IsMenuSelected"))	
		{
			result=util.IsMenuSelected(data[0]);
		}
		
		else if(action.equals("IsSubMenuSelected"))	
		{
			result=util.IsSubMenuSelected(data[0]);
		}	
		else if (action.equals("GetCopyrightYear"))
		{
			GetCopyrightYear GetCopyrightYear = new GetCopyrightYear();
			result = GetCopyrightYear.verify(elementmethod, locator, data[0])?"Pass":"Fail";
			
			
		}
		else if (action.equals("SelectMeasureSet"))
		
		{
			SelectMeasureSet SelectMeasureSet = new SelectMeasureSet();
			result =  SelectMeasureSet.verify(data[0])?"Pass":"Fail";
			
		}

		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;

	}

}
