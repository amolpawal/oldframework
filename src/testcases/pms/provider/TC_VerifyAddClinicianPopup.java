package testcases.pms.provider;

import java.io.IOException;


import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;
/*
* This test case validate add clinician pop up
* @author awadhesh.sengar
* Date 13/12/2017
*/
public class TC_VerifyAddClinicianPopup extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="VerifyAddClincianPopup")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");		
		log.info("\n test case to verify fields available in add clinciain pop up ");
		exe.testexecute(Filelocation,"TC_VerifyAddClinicianPopup",data);
		log.info("\nTC to validate element for their availability in add clinician ");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="VerifyAddClincianPopup")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifyAddClinicianPopup_data");
		Setup.log.info("\n  test case to verify fields available in add clinciain pop up ends   "+Filelocation);
        return object;    
    } 

}
