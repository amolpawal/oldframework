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

public class TC_VerifyRegistryAvgOnPerformanceTrendModalForPractice extends Setup{
	
	
	private ConfigurationManager rd=new ConfigurationManager();
	private TestExecutor exe=new TestExecutor();
	private ExcelReader ex= new ExcelReader();
	
	
	
	
	/*
	 * Testcase ID- TC_0039 : TC_VerifyHeaderDetailsforPatientDDWhenOpenedForMeasure"
	 *To verify Provider name is displayed in drill down header for Measure.
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 */
	/**
	 * The Displayer class displays text 
	 * on the computer screen.
	 *
	 * @author  Amol Bande
	 * @version 1.0 06/06/18
	 * @see     java.lang.System
	 */
	
	
	@Test(dataProvider="TC_VerifyRegistryAvgOnPerformanceTrendModalForPractice")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokePractice");		
		log.info("\nTest Case:  verify Provider name is displayed in drill down header for Measure.");
		exe.testexecute(Filelocation,"TC_RegistryAvgOnPerformance",data);
		log.info("\n  test case TC_VerifyRegistryAvgOnPerformanceTrendModalForPractice ");
		Setup.testcase.assertAll();

	}

	
	@DataProvider(name="TC_VerifyRegistryAvgOnPerformanceTrendModalForPractice")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
		
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokePractice");
        Setup.log.info("\nProvider name is displayed in drill down header for Measure:"+Filelocation);
        Object[][] object=ex.getDataingrid(Filelocation,"TC_RegistryAvgOnPerformance_Dat");
        return object;    
    }

}















