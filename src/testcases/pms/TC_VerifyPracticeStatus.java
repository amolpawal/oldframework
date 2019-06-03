package testcases.pms;


import java.io.IOException;
import java.util.Hashtable;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;
/**
 * This test case validate practice status in PMS
 *  Data is provided through data sheet from excel
 * @author awadhesh sengar
 * Date 12-1-2018
 */
public class TC_VerifyPracticeStatus extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="VerifyPracticeStatus")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");		
		log.info("\n");
		exe.testexecute(Filelocation,"TC_VerifyPstatus",data);
		log.info("\nTC to validate ");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="VerifyPracticeStatus")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifyPstatus_Data");
		Setup.log.info("\n For TC Validate "+Filelocation);
        return object;    
    } 

}
