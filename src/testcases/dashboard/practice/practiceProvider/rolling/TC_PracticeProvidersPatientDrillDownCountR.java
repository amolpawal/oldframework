package testcases.dashboard.practice.practiceProvider.rolling;
import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

/**

 * @author awadhesh sengar
 * Date 06/017/2018
 */
public class TC_PracticeProvidersPatientDrillDownCountR extends Setup {
	private ConfigurationManager rd = new ConfigurationManager();
	private TestExecutor exe = new TestExecutor();
	private ExcelReader ex = new ExcelReader();
	
	private String FileLocation = System.getProperty("user.dir") + rd.read_Configfile("dashboard_practice");

	@Test(dataProvider = "PracticeProvidersPatientDrillDownCountR", groups = "MeasureGrid")
	public void test(Hashtable<String, String> data) throws IOException, InvalidFormatException {
		System.out.println("------------TC_PracticeProvidersPatientDrillDownCountR--------------");
		log.info(
				"\nTest Case: To check count of patient in patient drill down");
		///exe.testexecute(FileLocation, "TC_VerifyLastUpdated", data);
		exe.testexecute(FileLocation, "TC_PAllProvidersPDDCountR", data);
	
		log.info("\n Test Case: To check count of patient in patient drill down");
	}

	@DataProvider(name = "PracticeProvidersPatientDrillDownCountR")
	public Object[][] getDataFromDataprovider() throws IOException, InvalidFormatException {
		
		Object[][] object = ex.getDataingrid(FileLocation, "TC_PAllProvidersPDDCountR_Data");
		
		return object;
	}
}