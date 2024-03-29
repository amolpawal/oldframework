package buisness.core;

import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.MeasureComputationSummaryGrid;
import configuration.Setup;
import javax.xml.bind.SchemaOutputResolver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Handles all the information on web page that would be required 
 * 
 * @author Sachin.Gawade
 * Date: 8 Jan 2016
 *
 */
public class DashboardUI extends ElementMethod{
	
	private ConfigurationManager config;
	private ElementMethod em;
	public String measureID;
	public DashboardUI()

	{
		config=new ConfigurationManager();
		em=new ElementMethod();
	}
	/**
	 * Returns logged in user's name from the UI
	 * 
	 * @author Sachin.Gawade
	 * Date: 8 Jan 2016
	 *
	 */
	public String getLoggedInUser()
	{
		String locator=config.read_ObjectRepositoryfile("LoggedInUser");
		return em.gettext("id",locator);
	}
	
	
	public String getLoggedInUserFIGUserUID()
	{
		return null;
	}
	
	public String getSelectedPractice()
	{
		return null;
	}

	public String getSelectedPracticeUID()
	{
		return null;
	}
	
	/** Trims unnecessary data for the captured data from the UI
	 * @param rawcount:  Untrimmed total record from the UI
	 * Returns actual count as String
	 * @author-ashwini.gore
	 */
	public String  trimuicount(String rawcount)
	{
		int index=0;
		char character = ' ';
		for(int i = 0; i < rawcount.length(); i++){
		    if(rawcount.charAt(i) == character){
		    	index=i;
		    }
		}
		return rawcount.substring(index+1,rawcount.length());
		
	}
	
	/**
	 * This class trims extra spaces from String.<p>
	 * Example: <p>
	 * Passed string: abc   frd df<p>
	 * Returned String:abc frd df<p>
	 * @param text String to be trimmed<p>
	 * @return trimmed String
	 * @author Rakesh.Kulkarni
	 */
	public String trimMultiSpace(String text)
	{
		String string = text;
		String[] parts = string.split(" ");
		String s = new String();
		for (int i = 0; i < parts.length; i++) {
			parts[i] = parts[i].trim();
			if (!parts[i].equals(" ")) {
				s = s + "" + parts[i];
		}
			}
		return s;
	}
	

 /** This method gets the label as input and output as only count by timing the invalid data
	 * @param UIlabel
	 * @return only count of data present on label
	 */
	public int trimInvalidDataFromUICount(String UIlabel)
	{


		 int index=0;
			char character = ' ';
			for(int i = 0; i < UIlabel.length(); i++){
			    if(UIlabel.charAt(i) == character){
			    	index=i;
			    }
			}
			int withoutspaceCount = Integer.parseInt(UIlabel.substring(index+1,UIlabel.length()));
			return withoutspaceCount;
	}
	
	/**
	 * Returns selected Provider's serviceproviderUid
	 * @author awadhesh sengar
	 * Date: 2 Mar 2018
	 *
	 */
	public String getSelectedProvierUID() {
		String providerlocator = config.read_ObjectRepositoryfile("SelectedRandomProvider");
		String serviceprovideruid = getattribute("xpath", providerlocator, "href");
		System.out.println(serviceprovideruid);
		return serviceprovideruid.substring(serviceprovideruid.length() - 36, serviceprovideruid.length());
	}

	
	/**
	 * Returns selected Provider's serviceproviderUid and selected measureUid
	 * @author probeer.roy
	 * Date: 20 Dec 2017
	 *
	 */
	public String newwayProviderUid() {
		String serviceprovideruid = Setup.driver.findElement(By.id("hdnProviderUID")).getAttribute("value");
		// System.out.println(serviceprovideruid);
		return serviceprovideruid;
	}
	
	public String newwayMeasureUid(){
		String measureuid = Setup.driver.findElement(By.id("hdnRequestMesureUID")).getAttribute("value");
		return measureuid;
	}
	
	
	/**Created by Awadhesh Sengar
	 * Get tool tip from dashboard
	 * 
	 * 
	 * 
	 */

	
	/**
	 * Created By Awadhesh Sengar
	 * 5-28-2018
	 * This method will get the tool tip from the Measures as per data passed through Excel sheet.
	 */
	
	
	public String UpdateToolTipLocator(String data)
	{
		String Locator   = config.read_ObjectRepositoryfile("Measuretitletooltip");
		Locator = Locator.replace("MeasureNumber",data);
	    String Description= Setup.driver.findElement(By.xpath(Locator)).getAttribute("Title");
		
		
		return Description;
		
		
	}
	
	public String getTooltipMeasure(String data) {
		String Locator = config.read_ObjectRepositoryfile("TooltipMeasureid");//locator xpath
		Locator = Locator.replace("MeasureNumber",data);///locator + xpath replaced
		String Description= Setup.driver.findElement(By.xpath(Locator)).getAttribute("id");
		Description = Description.substring(2);
		
		return Description;
		
		
	}
	
	
	
	/**
	 * Created By Awadhesh Sengar
	 * 5-31-2018
	 * This method will select the measure set as passed in the test case
	 */
	
	

	public String SelectMeasureSet(String data)
	{
	   WebElement c;
	   String ActualMeasureset;
	   
	 
	   ActualMeasureset= Setup.driver.findElement(By.xpath("//table[@id='tblMeasureSetDropDownList']//tbody/tr[@id][@class='rowselected']/td/input")).getAttribute("data-lable");
	 
	   if(ActualMeasureset.equalsIgnoreCase(data))
	   {
		  System.out.println("Measure set "+data+  "is already selected"); 
		  
		  return ActualMeasureset;
		    
		 }
	   else if (ActualMeasureset.isEmpty())
	   {
		   System.out.println("No data is provided for selecting measure set"); 
	   }
	   else 
	   {
		   try {
			c= Setup.driver.findElement(By.xpath("//table[@id='tblMeasureSetDropDownList']//input[@data-lable='"+data+"']"));
			  System.out.println("Selecting measure set " +data);
			  WebDriverWait wait = new WebDriverWait(Setup.driver,30);
			    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='accordion']//td[2]/a"))); 
			   
			  ActualMeasureset= c.getAttribute("data-lable");
			  c.click();
			  
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Occurred while selecting the measure set");
			e.printStackTrace();
		}
		  
		   
	   }
	return ActualMeasureset;
		  	
	}
	
	
	
	
	
	
	
	
	

	/**
	 * 
	 * @param data Selected quarter\month from drop down list
	 * @return true if quarter is selected or false if month is selected
	 * @author Sachin.Gawade
	 * Date: 11 Mar 2016
	 */
	public boolean isQuarter(String data)
	{
		 try {
			 	//data=trimMultiSpace(data);
		
		        Integer.parseInt(data.substring(0,1));
		        Setup.log.debug("Quarter Selected.");
		        return true;
		    } 
		 catch (NumberFormatException e) {
			 Setup.log.debug("Month Selected.");
		    }
		    return false;
	}

	
	/**
	 * Returns selected Measures NationalProgramQualityMeasureUid
	 * @author Sachin.Gawade
	 * Date: 14 Mar 2016
	 *
	 */
	public String getSelectedMeasureUID() {
		String measurelocator = config.read_ObjectRepositoryfile("SelectedRandomMeasure");
		String measureuid = getattribute("xpath", measurelocator, "id");
		// System.out.println("Measure id " +measureuid);
		return measureuid.substring(measureuid.length() - 36, measureuid.length());
	}

	/**
	 * This method will return the Measure details
	 * 
	 * @author probeer.roy Created Date: 29-Dec-2017
	 **/
	public String getSelectedMeasureDetails() {
		//String measuredetails = Setup.driver
				//.findElement(By.xpath(config.read_ObjectRepositoryfile("MeasuresdetailsonPPDDpop_up"))).getText();
		 String measurename=
		Setup.driver.findElement(By.id("hdnMeasureName")).getAttribute("value");
		return measurename;
	}

	//////////////////
	public String extractID() {
		String id = null;
		String measurelocator = config.read_ObjectRepositoryfile("SelectrdMeasureUIDonMeasuePopup");
		String str = em.gettext("xpath", measurelocator);
		String regex = "(IRIS|QIM)(\\s*)[0-9]+(\\-[0-9]+)?";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			 id = matcher.group();
			return id;
		}
		return id;
	}
	    public String getSelectrdMeasureUIDonMeasuePopup ()
		{

			String grade = extractID();
			
		/*	if (grade.equals("APA 01 : Preventive Care and Screening: Screening for Clinical Depression and Follow-Up Plan")) {
				String APA01Uid = "a19dd2c5-729f-4247-ad65-f7dcd7dc47c7";
				System.err.println("APA01Uid="+APA01Uid);
				return APA01Uid;
			} else if (grade.equals("APA 02 : Preventive Care and Screening: Unhealthy Alcohol Use � Screening & Brief Counseling")) {
				String APA02Uid = "d3eeaefc-e462-476d-8eb4-b062c5274d59";
				System.err.println("APA02Uid="+APA02Uid);
				return APA02Uid;
			} else if (grade.equals("APA 03 : Adult Major Depressive Disorder (MDD): Suicide Risk Assessment")) {
				String APA03Uid = "c123f3be-26a4-447e-ad7b-e839b59b7e69";
				System.err.println("APA03Uid="+APA03Uid);
				return APA03Uid;
			} else if (grade.equals("APA 04 : Adherence to Antipsychotics Medications for Individuals with Schizophrenia")) {
				String APA04Uid = "abe112cb-f874-4bd2-98de-7dbb70b69503";
				System.err.println("APA04Uid="+APA04Uid);
				return APA04Uid;
			} else if (grade.equals("APA 05 : Functional Outcome Assessment")) {
				String APA05Uid = "1ffb24fc-af94-4eec-a3b3-54668c3be369";
				System.err.println("APA05Uid="+APA05Uid);
				return APA05Uid;
			} else if (grade.equals("APA 06 : Documentation of Current Medications in the Medical Record")) {
				String APA06Uid = "2339930b-5b2a-4ad4-ad42-a68d3b553759";
				System.err.println("APA06Uid="+APA06Uid);
				return APA06Uid;
		    } else {
				System.out.println("No measure is match hence nothing to return");
			}
			return grade;
		}
		*/

		if (grade.equals("IRIS eCQM 1 : Primary Open-Angle Glaucoma (POAG): Optic Nerve Evaluation")) {
				String IRIS1Uid = "d4494222-69fa-44f6-8055-9139d73b3cf3";
				System.err.println("IRIS1Uid"+IRIS1Uid);
				return IRIS1Uid;
			} else if (grade.equals("IRIS eCQM 2 : Diabetic Retinopathy: Documentation of Presence or Absence of Macular Edema and Level of Severity of Retinopathy")) {
				String IRIS2Uid = "a68c6835-98a3-4306-9af2-54153f288153";
				System.err.println("IRIS2Uid"+IRIS2Uid);
				return IRIS2Uid;
			} else if (grade.equals("IRIS eCQM 3 : Diabetic Retinopathy: Communication with the Physician Managing Ongoing Diabetes Care")) {
				String IRIS3Uid = "c146a51d-20c3-457d-a4ea-010fc547be6d";
				System.err.println("IRIS3Uid"+IRIS3Uid);
				return IRIS3Uid;
			} else if (grade.equals("IRIS eCQM 4 : Cataracts: 20/40 or Better Visual Acuity within 90 Days Following Cataract Surgery")) {
				String IRIS4Uid = "8485ab6e-57ee-44cf-85c9-03473839b549";
				System.err.println("IRIS4Uid"+IRIS4Uid);
				return IRIS4Uid;
			} else if (grade.equals("IRIS eCQM 5 : Cataracts: Complications within 30 Days Following Cataract Surgery Requiring Additional Surgical Procedures")) {
				String IRIS5Uid = "eab920e0-0378-4f7d-8a4e-b3d23cc6f1fc";
				System.err.println("IRIS5Uid"+IRIS5Uid);
				return IRIS5Uid;
			} else if (grade.equals("IRIS eCQM 6 : Diabetes: Eye Exam")) {
				String IRIS6Uid = "48979b47-25e1-470d-8398-d00698858342";
				System.err.println("IRIS6Uid"+IRIS6Uid);
				return IRIS6Uid;
			} else if (grade.equals("IRIS eCQM 14 : Preventive Care and Screening: Tobacco Use: Screening and Cessation Intervention")) {
				String IRIS14Uid = "e6e01517-a15d-48df-9b76-604a24fd30e7";
				System.err.println("IRIS14Uid"+IRIS14Uid);
				return IRIS14Uid;
			} else if (grade.equals("IRIS eCQM 15-1 : Use of High-Risk Medications in the Elderly")) {
				String IRIS151Uid = "84b7bd79-6693-427e-bd00-c1788e6dcc99";
				System.err.println("IRIS151Uid"+IRIS151Uid);
				return IRIS151Uid;
			} else if (grade.equals("IRIS eCQM 15-2 : Use of High-Risk Medications in the Elderly")) {
				String IRIS152Uid = "a7b8a925-b83f-4d81-9a1f-982536981931";
				System.err.println("IRIS152Uid"+IRIS152Uid);
				return IRIS152Uid;
			} else if (grade.equals("IRIS eCQM 16 : Falls: Screening for Future Fall Risk")) {
				String IRIS16Uid = "8e9d8fce-ade0-47e6-9daf-e1d4b78df886";
				System.err.println("IRIS16Uid"+IRIS16Uid);
				return IRIS16Uid;
			} else if (grade.equals("IRIS eCQM 17 : Documentation of Current Medications in the Medical Record")) {
				String IRIS17Uid = "2afed429-50e1-4c4e-9458-5caed8f8cd0e";
				System.err.println("IRIS17Uid"+IRIS17Uid);
				return IRIS17Uid;
			} else if (grade.equals("IRIS eCQM 18 : Controlling High Blood Pressure")) {
				String IRIS18Uid = "4afe0aa4-6b41-41f5-9a62-e29d34bd220b";
				System.err.println("IRIS18Uid"+IRIS18Uid);
				return IRIS18Uid;
			} else if (grade.equals("IRIS eCQM 19 : Closing the referral loop: receipt of specialist report")) {
				String IRIS19Uid = "3e9acb4c-f6f2-471b-a3b9-2f28fc6b38aa";
				System.err.println("IRIS202Uid"+IRIS19Uid);
				return IRIS19Uid;
			} else if (grade.equals("IRIS eCQM 20 : Preventive Care and Screening: Body Mass Index (BMI) Screening and Follow-Up Plan")) {
				String IRIS20Uid = "50e9f6be-3e7e-4721-9a30-1405b4aaea5e";
				System.err.println("IRIS21Uid"+IRIS20Uid);
				return IRIS20Uid;
			} else if (grade.equals("IRIS eCQM 21 : Preventive Care and Screening: Influenza Immunization")) {
				String IRIS21Uid = "576f3d2f-2679-4c4f-a81c-bf592af691af";
				System.err.println("IRIS22Uid"+IRIS21Uid);
				return IRIS21Uid;
			} else if (grade.equals("IRIS eCQM 22 : Pneumococcal Vaccination Status for Older Adults")) {
				String IRIS21Uid = "8ce5bb59-0c6b-4915-971e-a64983cfeda4";
				System.err.println("QIM5Uid"+IRIS21Uid);
				return IRIS21Uid;
			
			} else {
				System.out.println("No measure is match hence nothing to return");
			}
			return grade;
		}

			
			
/*	public String getSelectrdMeasureUIDonMeasuePopup()
	{
		String measurelocator=config.read_ObjectRepositoryfile("SelectrdMeasureUIDonMeasuePopup");
		String nameOfMeasure= em.gettext("xpath",measurelocator);
		System.out.println(nameOfMeasure);
	//	nameOfMeasure = nameOfMeasure.replaceAll("[^-?0-9]+", "");

	//	String abc=nameOfMeasure.replaceAll("/[0-9-?]/g", "");
	//	System.err.println("           : "+abc);


		String nameOfMeasureT=nameOfMeasure.substring(12);
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("getSelectrdMeasureUIDonMeasuePopup");
		query=query.replace( "@name",nameOfMeasureT);
	//	query=query.replace( "@name",nameOfMeasure);
		DatabaseManger.SQLserverConnection();
		ResultSet rs = DatabaseManger.exeQuery(query);

		Setup.log.debug(query);
		Setup.log.debug(rs);
		Setup.log.debug("Measurename   :"+nameOfMeasure);
		Setup.log.debug("Measurename   :"+nameOfMeasure);
		try {
			while(rs.next())
			{
				try {
					if(rs != null)
					 measureID = rs.getString("measurename");
					else
						measureID="8CE5BB59-0C6B-4915-971E-A64983CFEDA4";
				} catch (SQLException e) {
					Setup.log.warn("SQL Exception. Please check query in query repository");
					Setup.testcase.fail();
					return measureID="8CE5BB59-0C6B-4915-971E-A64983CFEDA4";
				} catch (Exception e) {
					Setup.log.warn("Exception faced while fetching data from Database.");
					Setup.testcase.fail();
					return measureID="8CE5BB59-0C6B-4915-971E-A64983CFEDA4";
				}

			}
		} catch (NullPointerException e)
		{
			Setup.log.debug("Result set for query is Null.");
			return measureID="8CE5BB59-0C6B-4915-971E-A64983CFEDA4";
			//	e.printStackTrace();
		}
		catch (Exception e)
		{
			Setup.log.debug("Exception faced while fetching data from Database.");
			return measureID="8CE5BB59-0C6B-4915-971E-A64983CFEDA4";
		}
		Setup.log.debug("MeasureID     :"+measureID);
		return measureID;
	}*/

		/**PMS
		 * Returns selected Location's locationUid FOR Dashboard > Location and select random location by ClickRandom
		 * @author Awadhesh Sengar
		 * Date: 4 Mar 2016
		 */
	    
	    public String getPMSpracticeName()
	    {
	    	String PMSpracticeName = Setup.driver.findElement(By.id("lblPMSPracticeName")).getAttribute("title");
			// System.out.println(serviceprovideruid);
			return PMSpracticeName;
	    	
	    }
	    
	    
	    
	    
	    


	/**
	 * Returns selected Location's locationUid FOR Dashboard > Location and select random location by ClickRandom
	 * @author Rakesh.Kulkarni
	 * Date: 4 Mar 2016
	 */
	public String getSelectedLocationUID()
	{
		String Locationlocator=config.read_ObjectRepositoryfile("SelectedRandomLocation");
		String Locationuid=getattribute("xpath",Locationlocator,"href");
		return Locationuid.substring(Locationuid.length()-36, Locationuid.length());
	}

	/**
	 * Returns selected Location's locationUid FOR Dashboard > Location and select random location by ClickRandom
	 * @author Rakesh.Kulkarni
	 * Date: 4 Mar 2016
	 */
	public String getMeasureUIDOnLocation()
	{
		String Measurelocator=config.read_ObjectRepositoryfile("SelectedRandomMeasureOnLocation");
		String measureuid=getattribute("xpath",Measurelocator,"id");
		return measureuid.substring(measureuid.length()-36, measureuid.length());
	}
}
