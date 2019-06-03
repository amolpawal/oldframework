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

public class TC_ProviderReSubmissionMultiTin extends  Setup {

ConfigurationManager rd=new ConfigurationManager();
TestExecutor exe=new TestExecutor();
ExcelReader ex= new ExcelReader();

@Test(dataProvider="ProReSubmissionMultiTin_data")
public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
{
	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("MipsProviderexcell");
	Setup.log.info("\nTest Case: TC_MipsPracticeReSubmissionMultiTin starts");
	exe.testexecute(Filelocation,"TC_ProReSubmissionMultiTin",data);
	Setup.log.info("Test Case: ProviderReSubmissionMultiTin");
	Setup.testcase.assertAll();
}

@DataProvider(name="ProReSubmissionMultiTin_data")
public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
{
    String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("MipsProviderexcell");
    Object[][] object=ex.getDataingrid(Filelocation,"TC_ProReSubmissionMultiTin_data");
    return object;    
}
}
