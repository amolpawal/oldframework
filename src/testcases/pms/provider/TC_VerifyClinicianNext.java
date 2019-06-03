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
* This test case validate next button in clinician
* @author awadhesh.sengar
* Date 13/12/2017
*/
public class TC_VerifyClinicianNext   extends Setup {
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="VerifyClinicianNext")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");		
		log.info("\n test case to check  user is able to go to  next  using next button from clinician");
		exe.testexecute(Filelocation,"TC_VerifyClinicianNext",data);
		log.info("\ntest case to check  user is able to go to  next  using next button from clinician");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="VerifyClinicianNext")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifyClinicianNext_data");
		Setup.log.info("\n  test case to check  user is able to go to  next  using next button from clinician ends  "+Filelocation);
        return object;    
    } 

}
