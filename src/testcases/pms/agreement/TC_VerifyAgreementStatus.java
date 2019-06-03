package testcases.pms.agreement;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class TC_VerifyAgreementStatus   extends Setup {
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="VerifyAgreementStatus")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");		
		log.info("\n test case to Verify Practice Agreement Status ");
		exe.testexecute(Filelocation,"TC_VerifyAgreementStatus",data);
		log.info("\n to validate if agreement is signed by practice or not ");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="VerifyAgreementStatus")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifyAgreementStatus_data");
		Setup.log.info("\n  test case to Verify Practice Agreement Status  ends  "+Filelocation);
        return object;    
    } 

}
