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
 * This test case to check practice technical information previous buttom 
 *  Data is provided through data sheet from excel
 * @author awadhesh sengar
 * Date 12-1-2018
 */
public class TC_VTechincalInformationPreviousButtonNavigation  extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="VerifyPreviousButtonNavigation")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");		
		log.info("\n test case to check Previous button navigation  in technical information");
		exe.testexecute(Filelocation,"TC_VerifyPreviousTi",data);
		log.info("\nTC to validate Practice save button is avaiable in technical information");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="VerifyPreviousButtonNavigation")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifyPreviousTi_data");
		Setup.log.info("\n test case to check the Previous button navigation  in technical information ends  "+Filelocation);
        return object;    
    } 

}
