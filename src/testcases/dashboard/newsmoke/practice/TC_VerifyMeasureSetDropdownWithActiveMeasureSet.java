package testcases.dashboard.newsmoke.practice;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class TC_VerifyMeasureSetDropdownWithActiveMeasureSet extends Setup{
	
	
	private ConfigurationManager rd=new ConfigurationManager();
	private TestExecutor exe=new TestExecutor();
	private ExcelReader ex= new ExcelReader();

	/*
	 * Testcase ID- TC_0034 : TC_CrossCuttingMeasuresForMeasureSet2018"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 */
	/**
	 * The Displayer class displays text 
	 * on the computer screen.
	 *
	 * @author  Amol Bande
	 * @version 1.0 01/06/18
	 * @see     java.lang.System
	 */
	
	@Test(dataProvider="SelectingMeasureSet")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokePractice");		
		log.info("\nTest Case: TC_Verify MeasureSet Dropdow With Active Measure Set starts");
		exe.testexecute(Filelocation,"TC_MeasureSetDDWithActive",data);
		log.info("\n  test case TC_AllMeasuresn ");
		Setup.testcase.assertAll();

	}

	
	@DataProvider(name="SelectingMeasureSet")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
		
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokePractice");
        Setup.log.info("\nTC_Verify MeasureSet Dropdow With Active Measure Set starts : "+Filelocation);
        Object[][] object=ex.getDataingrid(Filelocation,"TC_MeasureSetDDWithActive_Data");
        return object;    
    }

    
    

}
