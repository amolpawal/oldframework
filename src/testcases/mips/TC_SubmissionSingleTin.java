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

public class TC_SubmissionSingleTin  extends Setup {ConfigurationManager rd=new ConfigurationManager();
TestExecutor exe=new TestExecutor();
ExcelReader ex= new ExcelReader();

@Test(dataProvider="SubmissionSingleTin")
public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
{
	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("MipsProviderexcell");
	Setup.log.info("\nTest Case: TC_SubmissionSingleTin starts");
	exe.testexecute(Filelocation,"TC_SubmissionSingleTin",data);
	Setup.log.info("Test Case: SubmissionSingleTin");
	Setup.testcase.assertAll();
}

@DataProvider(name="SubmissionSingleTin")
public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
{
    String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("MipsProviderexcell");
    Object[][] object=ex.getDataingrid(Filelocation,"TC_SubmissionSingleTin_data");
    return object;    
}
}

