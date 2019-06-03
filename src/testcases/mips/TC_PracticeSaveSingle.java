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

public class TC_PracticeSaveSingle extends Setup {ConfigurationManager rd=new ConfigurationManager();
TestExecutor exe=new TestExecutor();
ExcelReader ex= new ExcelReader();

@Test(dataProvider="TC_PracticeSaveSingle")
public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
{
	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("MipsProviderexcell");
	Setup.log.info("\nTest Case: TC_Verifywelcomepage starts");
	exe.testexecute(Filelocation,"Tc_SavePractice",data);
	Setup.log.info("Test Case: TC_PracticeSaveSingle");
	Setup.testcase.assertAll();
}

@DataProvider(name="TC_PracticeSaveSingle")
public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
{
    String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("MipsProviderexcell");
    Object[][] object=ex.getDataingrid(Filelocation,"Tc_SavePractice_data");
    return object;    
}
}

