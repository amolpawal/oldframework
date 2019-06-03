package testcases.dashboard.measureset;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class TC_SelectingMeasureSet    extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="SelectingMeasureSet")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokeCommon");		
		log.info("\n test case select measure set after login");
		exe.testexecute(Filelocation,"TC_SwitchingMeasureSet",data);
		log.info("\n  test case select measure set after login ");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="SelectingMeasureSet")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokeCommon");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_SwitchingMeasureSet_data");
		Setup.log.info("\n   test case select measure set after login ends  "+Filelocation);
        return object;    
    } 

}
