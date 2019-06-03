package testcases.mips;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class TC_PracticeReSubmissionSingleTin  extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="PracticeReSubmissionSingleTin")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("MipsProviderexcell");		
		log.info("\n to verify Practice Re Submission on practice level");
		exe.testexecute(Filelocation,"TC_P_RESubmissionSingleTin",data);
		log.info("\nTC to validate ");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="PracticeReSubmissionSingleTin")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("MipsProviderexcell");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_P_RESubmissionSingleTin_data");
		Setup.log.info("\n to verify Practice Re Submission on practice level ends "+Filelocation);
        return object;    
    } 

}
