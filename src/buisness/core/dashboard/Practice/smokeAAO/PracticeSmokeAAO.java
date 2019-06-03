package buisness.core.dashboard.Practice.smokeAAO;

import java.awt.List;
import java.sql.SQLException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import buisness.core.ElementMethod;
import buisness.core.dashboard.provider.ProviderPatientDrillDownCount;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

/**
 * Verifies Practice Patient DrillDown Count present on Dashboard > Practice > Measure computation summary For NOnRolling<p>
 * Extends ProviderLocationCount<p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureCountNR class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate Grid.
 * @author Rakesh.Kulkarni<p>
 * Created Date: 18/03/2016
 * 
 */
public class PracticeSmokeAAO extends ProviderPatientDrillDownCount{

	






	/** Compares Provider\Location Count for from UI and Database
	 * Passes locator : To Find the element
	 * Passes Parameters elementmethod and locator to verify() Dashboard > Practice > Measure computation summary For NOnRolling
	 * This method verify Count
	 * Method to compare object of DatabaseGrid and WebGrid. It check value present on UI with Database
	 * @param locator : To Find the element Name of locator in object repository<p>
	 * @param elementmethod : To Find the element by the type of Element Example xpath, id,
	 * @Param data : quarter or month
	 * @return result of Test case "Pass" or "Fail"
	 * @throws SQLException 
	 */
	
	
	// Code Added by amol Bande
	
	public boolean activemeasureset2018 (String elementmethod,String locator) throws SQLException  
	{
		String databseCount;
		String webCount;
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("activemeasureset2018");
		try {
			
			java.util.List<WebElement> we = this.getWebElements(elementmethod, locator);
			int count = we.size();
			webCount= Integer.toString(count);
		} catch (Exception e1) {
			Setup.log.trace("\nCount from Database and UI is not getting matched");
			Setup.testcase.fail();
			return false;
		}
		// Passing query and column name
		System.out.println(query);
		databseCount=getdatabaseQyeryRowCount(query,"inactive");
		
		Setup.log.info("Active measureset2018 UI_Count:" +webCount);
		Setup.log.info("Active measureset2018 Db_Count:" +databseCount);
		
		
		if(webCount.equals(databseCount))
		{
			Setup.log.trace("\nActive measureset2018 from Database and UI getting matched");
			Setup.testcase.assertTrue(true);
			
			return true;
		}
		else
		{
			Setup.log.trace("\nActive measureset2018 from Database and UI is not getting matched");
			Setup.testcase.fail();
			return false;
		}
	}
		
		
		
		
		
		
		//
		
		
		public boolean CrossCuttingMeasuresForMeasureSet2018(String elementmethod,String locator) throws SQLException  
		{
			String activeCount;
			String inactiveCount;
			ConfigurationManager config=new ConfigurationManager();
			String queryCrossCuttingMeasureActive = config.getQuery("CrossCuttingMeasuresForMeasureSet2018Active");
			String queryCrossCuttingMeasureInActive = config.getQuery("CrossCuttingMeasuresForMeasureSet2018InActive");
			int CrossCuttingYesCountUI=0;
		    int CrossCuttingNoCountUI=0;
			try {
				 java.util.List<WebElement> listactive =this.getWebElements(elementmethod, locator);
			       
			        for ( WebElement we: listactive) { 
			            if(we.getText().equals("NO")){
			            	CrossCuttingNoCountUI++;
			            }else{
			            	CrossCuttingYesCountUI++;
			            }
			       }
			        Setup.log.info("Total CrossCutting Measures UI_Count:" +listactive.size());
					
			} catch (Exception e1) {
				Setup.log.trace("\n UI Count not getting.");
				Setup.testcase.fail();
				return false;
			}
			
			// DB Calling 
			// Passing the column parameter 
			activeCount=getdatabaseQyeryRowCount(queryCrossCuttingMeasureActive,"iscrosscuttingmeasure");
			inactiveCount=getdatabaseQyeryRowCount(queryCrossCuttingMeasureInActive,"iscrosscuttingmeasure");
			Setup.log.info("Yes CrossCutting Measures UI_Count:" +CrossCuttingYesCountUI);
			Setup.log.info("No CrossCutting Measures UI_Count:" +CrossCuttingNoCountUI);
			Setup.log.info("Yes CrossCutting Measures DB_Count:" +activeCount);
			Setup.log.info("No CrossCutting Measures DB_Count:" +inactiveCount);
			
		
			//if( Integer.toString(CrossCuttingYesCountUI).equals(activeCount)){
				if( Integer.toString(CrossCuttingNoCountUI).equals(inactiveCount)){
				Setup.log.trace("\nCross Cutting measureset 2018 from Database and UI getting matched");
				Setup.testcase.assertTrue(true);
				return true;
			//}
			}
			else
			{
				Setup.log.trace("\nCross Cutting measureset from Database and UI is not getting matched");
				Setup.testcase.fail();
				return false;
			}
				
		}
				
				
				public boolean OutcomeMeasuresForMeasureSet2018(String elementmethod,String locator) throws SQLException  
				{
					String outcomeMeasurActiveCount;
					String outcomeMeasurInactiveCount;
					ConfigurationManager config=new ConfigurationManager();
					String queryOutcomeMeasureActive = config.getQuery("OutcomeMeasuresForMeasureSet2018Active");
					String queryOutcomegMeasureInActive = config.getQuery("OutcomeMeasuresForMeasureSet2018InActive");
					int CrossCuttingYesCountUI=0;
				    int CrossCuttingNoCountUI=0;
					try {
						 java.util.List<WebElement> listactive =this.getWebElements(elementmethod, locator);
					       
					        for ( WebElement we: listactive) { 
					            if(we.getText().equals("NO")){
					            	CrossCuttingNoCountUI++;
					            }else{
					            	CrossCuttingYesCountUI++;
					            }
					       }
					        Setup.log.info("Total Outcome Measures UI_Count:" +listactive.size());
							
					} catch (Exception e1) {
						Setup.log.trace("\n UI Count not getting.");
						Setup.testcase.fail();
						return false;
					}
					
					// DB Calling 
					outcomeMeasurActiveCount=getdatabaseQyeryRowCount(queryOutcomeMeasureActive,"isoutcomemeasure");
					outcomeMeasurInactiveCount=getdatabaseQyeryRowCount(queryOutcomegMeasureInActive,"isoutcomemeasure");
					Setup.log.info("Yes Outcome Measures UI_Count:" +CrossCuttingYesCountUI);
					Setup.log.info("No Outcome Measures UI_Count:" +CrossCuttingNoCountUI);
					Setup.log.info("Yes Outcome Measures DB_Count:" +outcomeMeasurActiveCount);
					Setup.log.info("No Outcome Measures DB_Count:" +outcomeMeasurInactiveCount);
					
				
					//if( Integer.toString(CrossCuttingYesCountUI).equals(activeCount)){
						if( Integer.toString(CrossCuttingNoCountUI).equals(outcomeMeasurInactiveCount)){
						Setup.log.trace("\nCross Outcome measureset 2018 from Database and UI getting matched");
						Setup.testcase.assertTrue(true);
						return true;
					//}
					}
					else
					{
						Setup.log.trace("\nCross Outcome measureset from Database and UI is not getting matched");
						Setup.testcase.fail();
						return false;
					}			
				
	}






				public boolean VerifyHeaderDetailsforPatientDDWhenOpenedForMeasure() throws InterruptedException {
				
					 Setup st = new Setup();
					  Thread.sleep(10000);
					 String UIMeasureName = st.driver.findElement(By.xpath("//*[@id='sample-table-1']/tbody[1]/tr[1]/td[2]")).getText();
				     System.out.println("UI Measure Name:"+UIMeasureName);
				     st.driver.findElement(By.xpath("//*[@id='sample-table-1']/tbody[1]/tr[1]/td[2]")).click();
				     Thread.sleep(2000);
				     st.driver.findElement(By.xpath("//table[@class='table table-striped table-bordered table-hover cursor-default']/tbody/tr[1]/td[3]/a")).click();
				     Thread.sleep(2000);
				     String MesuresDrillDownHeaderText = st.driver.findElement(By.xpath("//*[@id='ModalNumerator']/div/div/div[1]/div[3]/div[2]/div[2]/div")).getText();
				     System.out.println("Drill Down Measure Name :"+MesuresDrillDownHeaderText);
				     Thread.sleep(5000);
				     st.driver.findElement(By.xpath("//*[@id='ModalNumerator']/div/div/div[1]/button")).click();
					if( MesuresDrillDownHeaderText.contains(UIMeasureName)){
						System.out.println("\nMeasure name is displayed in drill down header for Measure Matched.");
						Setup.log.trace("\nMeasure name is displayed in drill down header for Measure Matched.");
						Setup.testcase.assertTrue(true);
						return true;
					}
					else
					{
						System.out.println("Unable Measure name is displayed in drill down header for Measure Matched.");
						Setup.log.trace("\nUnable Measure name is displayed in drill down header for Measure Matched.");
						Setup.testcase.fail();
						return false;
					}		
					
				}
	
	
				public boolean VerifyHeaderDetailsforPatientDDWhenOpenedForProvider() throws InterruptedException {
					
					 Setup st = new Setup();
					  Thread.sleep(10000);
					  //WebDriverWait wait = new WebDriverWait(st.driver, 60);
					// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='panel panel-default'][1]/div[1]/h4/div/table/tbody/tr/td[1]/a")));
					 String UIProviderName = st.driver.findElement(By.xpath("//div[@class='panel panel-default'][1]/div[1]/h4/div/table/tbody/tr/td[1]/a")).getText();
				     System.out.println("UI Provider Name:"+UIProviderName);
				     Thread.sleep(5000);
				   //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='sample-table-1']/tbody[1]/tr[1]/td[2]")));
				     st.driver.findElement(By.xpath("//*[@id='sample-table-1']/tbody[1]/tr[1]/td[2]")).click();
				   
				     Thread.sleep(5000);
				  //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped table-bordered table-hover cursor-default']/tbody/tr[1]/td[3]/a")));
				     st.driver.findElement(By.xpath("//table[@class='table table-striped table-bordered table-hover cursor-default']/tbody/tr[1]/td[3]/a")).click();
				     Thread.sleep(15000);
				    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='spnModalPatientDrilDownHeader']")));
				     String ProviderDrillDownHeaderText = st.driver.findElement(By.xpath("//*[@id='spnModalPatientDrilDownHeader']")).getText();
				     System.out.println("Drill Down Measure Name :"+ProviderDrillDownHeaderText);
				     Thread.sleep(5000);
				   //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ModalNumerator']/div/div/div[1]/button")));
				     st.driver.findElement(By.xpath("//*[@id='ModalNumerator']/div/div/div[1]/button")).click();
					if( ProviderDrillDownHeaderText.contains(ProviderDrillDownHeaderText)){
						System.out.println("\nProvider name is displayed in drill down header for Provider Matched.");
						Setup.log.trace("\nProvider name is displayed in drill down header for Provider Matched.");
						Setup.testcase.assertTrue(true);
						return true;
					}
					else
					{
						System.out.println("Unable Provider name is displayed in drill down header for Provider Matched.");
						Setup.log.trace("\nUnable Provider name is displayed in drill down header for Provider Matched.");
						Setup.testcase.fail();
						return false;
					}		
					
				}
	
	
	
				public boolean TC_VerifyRegistryAvgOnPerformanceTrendModalForPractice() throws InterruptedException {
					
					 Setup st = new Setup();
					 Thread.sleep(10000);
					 
					 
					 Random rand = new Random();

					 int  n = rand.nextInt(25) + 1;
					 
					 if(n==0){
						 n=n+1;
					 }
					 if((n % 2 == 0) ){
						 n=n+1;
					 }
			
					 st.driver.navigate().refresh();
					 Thread.sleep(2000);
					 try {
						 st.driver.findElement(By.xpath("//div[@class='panel panel-default']//h4/div/table/tbody/tr/td[1]/a/i")).click();
					} catch (Exception e) {
						st.driver.findElement(By.xpath("//*[@id='MasterWrapperMeasureSet']/div[2]/a")).click();
						 st.driver.findElement(By.xpath("//div[@class='panel panel-default']//h4/div/table/tbody/tr/td[1]/a/i")).click();
					}
					
					 
					/* String CMSBenchmarkAverageUI = st.driver.findElement(By.xpath("//*[@id='sample-table-1']/tbody[1]/tr[" + n + "]/td[3]/table/tbody/tr/td/table/tbody/tr/td[1]/div[1]/span")).getText();
					 Thread.sleep(2000);
					 String RegistryBenchmarkUI = st.driver.findElement(By.xpath("//*[@id='sample-table-1']/tbody[1]/tr[" + n + "]/td[3]/table/tbody/tr/td/table/tbody/tr/td[1]/div[5]")).getText();
					 Thread.sleep(2000);
					 String spnAverageUI = st.driver.findElement(By.xpath("//*[@id='sample-table-1']/tbody[1]/tr[" + n + "]/td[3]/table/tbody/tr/td/table/tbody/tr/td[2]")).getText();
					 	// st.driver.findElement(By.xpath("//*[@id='sample-table-1']/tbody[1]//tr[" + n + "]/td[3]")).click();
					 */
					 
					 String CMSBenchmarkAverageUI = st.driver.findElement(By.xpath("//tr/td[1]/div[1]/span[@class='cmsbenchmark-text-color']")).getText();
					 Thread.sleep(2000);
					 String RegistryBenchmarkUI = st.driver.findElement(By.xpath("//td//div[@class='registrybenchmark-text']")).getText();
					 Thread.sleep(2000);
					 String spnAverageUI = st.driver.findElement(By.xpath("//tr/td/table/tbody/tr/td[2]")).getText();
					 st.driver.findElement(By.xpath("//td//div[@class='registrybenchmark-text']")).click();
					 System.out.println("UI CMSBenchmarkAverageUI :"+CMSBenchmarkAverageUI);
					 System.out.println("UI RegistryBenchmarkUI :"+RegistryBenchmarkUI);
					 System.out.println("UI spnAverage :"+spnAverageUI);
					 
					 
					 
					//tr/td/table/tbody/tr/td[2]
					 CMSBenchmarkAverageUI = (CMSBenchmarkAverageUI.replace(":","")); 
					 RegistryBenchmarkUI = (RegistryBenchmarkUI.replace(":","")); 
					 
					 Thread.sleep(10000);
					 String CMSBenchmarkAverageDrillDown = st.driver.findElement(By.xpath(".//*[@id='spanCMSAverage']")).getText();
					 Thread.sleep(2000);
					 String CMSRegistryBenchmarkUIDrillDown = st.driver.findElement(By.xpath("//*[@id='spanNationalAverage']")).getText();
					 Thread.sleep(2000);
					 String spnAverageDrillDown = st.driver.findElement(By.xpath(".//*[@id='spnAverage']")).getText();
					 
					 System.out.println("Drill down CMSBenchmarkAverageUI :"+CMSBenchmarkAverageDrillDown);
					 System.out.println("Drill down RegistryBenchmarkUI :"+CMSRegistryBenchmarkUIDrillDown);
					 System.out.println("Drill down spnAverage :"+spnAverageDrillDown);
					 
					 Thread.sleep(5000);
				     st.driver.findElement(By.xpath(".//*[@id='ModalSummryProviderLocationPractice']/div/div/button")).click();
					 //System.out.println((RegistryBenchmarkUI.replaceAll(" ", "")).contains(CMSRegistryBenchmarkUIDrillDown.replaceAll(" ", "")));   
					 if((RegistryBenchmarkUI.replaceAll(" ", "")).contains(CMSRegistryBenchmarkUIDrillDown.replaceAll(" ", ""))){
						 if((RegistryBenchmarkUI.replaceAll(" ", "")).contains(CMSBenchmarkAverageDrillDown.replaceAll(" ", ""))){
							System.out.println("\nRegistry Avg On Performance Trend Modal For Practice Matched.");
							Setup.log.trace("\nRegistry Avg On Performance Trend Modal For Practice Matched.");
							Setup.testcase.assertTrue(true);
						}
						 return true;
					 }
						else
						{
							System.out.println("Registry Avg On Performance Trend Modal For Practice Matched.");
							Setup.log.trace("\nRegistry Avg On Performance Trend Modal For Practice Matched.");
							Setup.testcase.fail();
							return false;
						}	
			
	
				}
	
				public boolean TC_VerifytooltipAgainstMeasures() throws InterruptedException {
					
					 Setup st = new Setup();
					
					 String tooltipHigherScoreForMeasure="Higher score for this measure is Better";
					 String tooltipLowerScoreForMeasure="Higher score for this measure is Better";
					 
					 Thread.sleep(10000);
					 st.driver.findElement(By.xpath("//table/tbody/tr/td[1]/a[@class='accordion-toggle collapsed']")).click();
					 Thread.sleep(5000);
					 WebElement infoMeasure_tooltip=st.driver.findElement(By.xpath("//*[@id='sample-table-1']/tbody[1]/tr[1]/td[7]//i[1]"));
					 Thread.sleep(5000);
					 String tooltip_msg1=infoMeasure_tooltip.getAttribute("title");
					 
					 Actions builder=new Actions(st.driver);
					 builder.moveToElement(infoMeasure_tooltip).perform();
					 Thread.sleep(5000);
					 String tooltip_msg2=infoMeasure_tooltip.getAttribute("title");
					 
					 System.out.println("InfoMeasure Tooltip message without focus on tootip:"+tooltip_msg1);
					 System.out.println("InfoMeasure Tooltip message with focus on tootip:"+tooltip_msg2);
				
					 if(tooltipHigherScoreForMeasure.trim().equals(tooltip_msg1.trim())){
						 if(tooltip_msg2.equals("")){
							 System.out.println("Verified tool tip is displayed against measures.");
							 Setup.testcase.assertTrue(true);
						 }
						 return true;
					 }else {
						System.out.println("Unable To verifiy tool tip is displayed against measures..");
						Setup.testcase.assertTrue(false);
						Setup.testcase.fail();
						return false;
					}
				
	
				}
				
				
	
		
}
