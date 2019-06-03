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
* This test case validate Search Member id
* @author awadhesh.sengar
* Date 13/12/2017
*/
public class TC_VerifySearchMemberID extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="SearchMemberID")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");		
		log.info("\n test case to check Searching in provider memberid ");
		exe.testexecute(Filelocation,"TC_SearchMemberID",data);
		log.info("\nTC to validate searching in provider memberid ");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="SearchMemberID")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_SearchMemberID_data");
		Setup.log.info("\n test case to check Searching in provider member id   ends   "+Filelocation);
        return object;    
    } 

}
