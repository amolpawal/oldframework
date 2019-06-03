package buisness.core.dashboard.provider.rolling;

import java.sql.ResultSet;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import buisness.core.DashboardUI;
import buisness.core.ElementMethod;
import buisness.core.dashboard.provider.ProviderPatientDrillDownCount;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;

public class verifyDetailedPatientDrillDownCountR extends ProviderPatientDrillDownCount {
	ElementMethod Ele = new ElementMethod();
	DashboardUI Dash = new DashboardUI();
	public String quarter;
	public String uiCount;
	public String dbCount;
	public String measureuid;
	public String query;
	public String getmeasurename;
	public boolean verifyDetailedPatientDrillDownCountR(String elementmethod, String locator) throws InterruptedException {

		System.out.println("***************************************************");
		 Setup st = new Setup();
		 Thread.sleep(5000);
		 Random rand = new Random();
		List<WebElement> Provider = getWebElements(elementmethod, locator);
		int noofproviders = Provider.size();
		 int  n = rand.nextInt(noofproviders);
		 
		 if(n==0){
			 n=n+1;
		 }
		
		try {
			Thread.sleep(2000);
			st.driver.findElement(By.xpath("//div[@id='accordion']/div[@class='panel panel-default']/div[1]/h4/div/table/tbody/tr/td[1]/a/i")).click();
		} catch (Exception e) {
			Thread.sleep(2000);
			st.driver.findElement(By.xpath(".//*[@id='row52ed9967-baa6-4c11-9777-25df5c09e2df']/div[1]/h4/div/table/tbody/tr/td[1]/a")).click();
		}
		
		String PatientDrillDownCountUI = "";
		st.driver.findElement(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr[1]/td[3]")).click();
		Thread.sleep(5000);
		try {
			PatientDrillDownCountUI = st.driver.findElement(By.xpath("//*[@class='table table-striped table-bordered table-hover cursor-default']/tbody/tr[1]/td[3]/a")).getText();
			 Thread.sleep(2000);
		} catch (Exception e) {
			PatientDrillDownCountUI = st.driver.findElement(By.xpath("//*[@id='sample-table-1']/tbody[1]/tr[" + n + "]/td[3]/table/tbody/tr/td/table/tbody/tr/td[1]/div[1]/span")).getText();
			 Thread.sleep(2000);
		}
		System.out.println("PatientDrillDownCount UI :"+PatientDrillDownCountUI);
		try {
			st.driver.findElement(By.xpath("//*[@class='table table-striped table-bordered table-hover cursor-default']/tbody/tr[1]/td[3]/a")).click();
			 Thread.sleep(2000);
		} catch (Exception e) {
			 st.driver.findElement(By.xpath("//*[@id='sample-table-1']/tbody[1]/tr[" + n + "]/td[3]/table/tbody/tr/td/table/tbody/tr/td[1]/div[1]/span")).click();
			 Thread.sleep(2000);
		}
		
		String PatientDrillDownCountAfterUI = "";
		Thread.sleep(5000);
		try {
			PatientDrillDownCountAfterUI = st.driver.findElement(By.xpath("//*[@id='divProviderDrilDownPager']/div")).getText();
			 Thread.sleep(2000);
		} catch (Exception e) {
			PatientDrillDownCountAfterUI = st.driver.findElement(By.xpath("//*[@id='divProviderDrilDownPager']/b")).getText();
			 Thread.sleep(2000);
		}
		st.driver.findElement(By.xpath(".//*[@id='ModalNumerator']/div/div/div[1]/button")).click();
		System.out.println("PatientDrillDownCountAfter UI :"+PatientDrillDownCountAfterUI);
		
		if((PatientDrillDownCountUI.replaceAll(" ", "")).contains(PatientDrillDownCountAfterUI.replaceAll(" ", ""))){
				System.out.println("\nTo verify Drill down count for measure in Quartely rolling Matched.");
				Setup.log.trace("\nTo verify Drill down count for measure in Quartely rolling Matched.");
				Setup.testcase.assertTrue(true);
			 return true;
		 }
			else
			{
				System.out.println("Unable To verify Drill down count for measure in Quartely rolling.");
				Setup.log.trace("\nUnable To verify Drill down count for measure in Quartely rolling Matched.");
				Setup.testcase.fail();
				return false;
			}
		
		
	}

}
