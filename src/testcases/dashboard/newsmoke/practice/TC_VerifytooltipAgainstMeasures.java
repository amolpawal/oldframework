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

public class TC_VerifytooltipAgainstMeasures extends Setup{
	
	
	private ConfigurationManager rd=new ConfigurationManager();
	private TestExecutor exe=new TestExecutor();
	private ExcelReader ex= new ExcelReader();

	
	/*
	 * Testcase ID- TC_0043 : TC_VerifytooltipAgainstMeasures"
	 * To verify tool tip is displayed against measures.
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 */
	/**
	
	 *
	 * @author  Amol Bande
	 * @version 1.0 05/06/18
	 * @see     java.lang.System
	 */
	
	
	
	@Test(dataProvider="TC_VerifytooltipAgainstMeasures")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokePractice");		
		log.info("\n To verify tool tip is displayed against measures.");
		exe.testexecute(Filelocation,"TC_VerifytooltipMeasures",data);
		log.info("\n  test case TC_AllMeasuresn ");
		Setup.testcase.assertAll();
	  

	}

		
	
	@DataProvider(name="TC_VerifytooltipAgainstMeasures")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokePractice");
        Setup.log.info("\nTo verify tool tip is displayed against measures :"+Filelocation);
        Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifytooltipMeasures_Data");
        return object;    
    }

    

}
