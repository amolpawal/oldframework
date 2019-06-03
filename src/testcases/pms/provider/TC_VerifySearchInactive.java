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
* This test case validate Inactive search
* @author awadhesh.sengar
* Date 13/12/2017
*/
public class TC_VerifySearchInactive  extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="SearchInactive")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");		
		log.info("\n test case to check Searching in provider inactive status ");
		exe.testexecute(Filelocation,"TC_SearchInactive",data);
		log.info("\nTC to validate searching in provider Inactive column ");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="SearchInactive")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_SearchInactive_data");
		Setup.log.info("\n test case to check Searching in provider inactive status   ends   "+Filelocation);
        return object;    
    } 

}
