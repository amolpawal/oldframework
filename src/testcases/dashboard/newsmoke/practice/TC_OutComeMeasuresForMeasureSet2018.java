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

public class TC_OutComeMeasuresForMeasureSet2018 extends Setup{
	
	
	private ConfigurationManager rd=new ConfigurationManager();
	private TestExecutor exe=new TestExecutor();
	private ExcelReader ex= new ExcelReader();

	
	/*
	 * Testcase ID- TC_0035 : TC_OutcomeMeasuresForMeasureSet2018"
	 * To verify outcome measures count is correct for measures Displayed in measure set.
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 */
	/**
	 * The Displayer class displays text 
	 * on the computer screen.
	 *
	 * @author  Amol Bande
	 * @version 1.0 05/06/18
	 * @see     java.lang.System
	 */
	
	
	
	@Test(dataProvider="OutcomeMeasuresForMeasureSet2018")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokePractice");		
		log.info("\nTest Case: test case Outcome For MeasureSet 2018 starts");
		exe.testexecute(Filelocation,"TC_OutcomeForMeasureSet",data);
		log.info("\n  test case TC_AllMeasuresn ");
		Setup.testcase.assertAll();
	  

	}

		
	
	@DataProvider(name="OutcomeMeasuresForMeasureSet2018")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokeAAO");
        Setup.log.info("\ntest case Outcome For MeasureSet 2018"+Filelocation);
        Object[][] object=ex.getDataingrid(Filelocation,"TC_OutcomeForMeasureSet_Data");
        return object;    
    }

    

}
