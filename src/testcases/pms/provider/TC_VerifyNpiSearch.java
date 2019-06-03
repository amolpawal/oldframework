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
* This test case validate npi search in clinician 
* @author awadhesh.sengar
* Date 13/12/2017
*/
public class TC_VerifyNpiSearch extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="SearchNPI")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");		
		log.info("\n test case to check Searching in provider NPI ");
		exe.testexecute(Filelocation,"TC_SearchNPI",data);
		log.info("\nTC to validate searching in provider NPI ");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="SearchNPI")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_SearchNPI_data");
		Setup.log.info("\n test case to check Searching in provider NPI  ends   "+Filelocation);
        return object;    
    } 

}
