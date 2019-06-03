package buisness.keywords.administration;

import buisness.core.administration.pms.CompareActiveClinician;
import buisness.core.administration.pms.ComparePracticeStatus;
import buisness.core.administration.pms.PMrcmExtractionMethod;
import buisness.core.administration.pms.Pm;
import buisness.core.administration.pms.PmsVerifyContent;
import buisness.core.administration.pms.VefiryElixirID;
import buisness.core.administration.pms.VerifyEHRPushFileType;
import buisness.core.administration.pms.VerifyEHRpushMethod;
import buisness.core.administration.pms.VerifyEMRaccountNumber;
import buisness.core.administration.pms.VerifyElixirKey;
import buisness.core.administration.pms.VerifyExtractFrequency;
import buisness.core.administration.pms.VerifyExtractStartTime;
import buisness.core.administration.pms.VerifyExtractStopTime;
import buisness.core.administration.pms.VerifyITContactEmail;
import buisness.core.administration.pms.VerifyITContactName;
import buisness.core.administration.pms.VerifyITContactPhone;
import buisness.core.administration.pms.VerifyPEmrVersion;
import buisness.core.administration.pms.VerifyPMrcmPushFileType;
import buisness.core.administration.pms.VerifyPmIntegrationDate;
import buisness.core.administration.pms.VerifyPmSystemVersion;
import buisness.core.administration.pms.VerifyPracticeAddress;
import buisness.core.administration.pms.VerifyPracticeCity;
import buisness.core.administration.pms.VerifyPracticeConnectivity;
import buisness.core.administration.pms.VerifyPracticeEHRExtractionMethod;
import buisness.core.administration.pms.VerifyPracticeEMR;
import buisness.core.administration.pms.VerifyPracticeEMRHosting;
import buisness.core.administration.pms.VerifyPracticeState;
import buisness.core.administration.pms.VerifyPracticeTimeZone;
import buisness.core.administration.pms.VerifyPracticeZip;
import buisness.core.administration.pms.VerifyRoasterMessage;
import buisness.core.administration.pms.VerifyRpcInstallDate;
import buisness.core.administration.pms.VerifyRpcInstalledOn;
import buisness.core.administration.pms.VerifySubmissionMethod;
import buisness.core.administration.pms.agreement.PracticeAgreementPopUpView;
import buisness.core.administration.pms.custominformation.VerifyAco;
import buisness.core.administration.pms.custominformation.VerifyGpro;
import buisness.core.administration.pms.custominformation.VerifyLastUpdateDate;
import buisness.core.administration.pms.custominformation.VerifyMipsComponent;
import buisness.core.administration.pms.custominformation.VerifyPace;
import buisness.core.administration.pms.custominformation.VerifyPrimaryCare;
import buisness.core.administration.pms.custominformation.VerifyRemark;
import buisness.core.administration.pms.custominformation.VerifyVip;
import buisness.core.administration.pms.provider.VerifyNpiSearch;
import buisness.core.administration.pms.provider.VerifyPPopUpMessageUpdate;
import buisness.core.administration.pms.provider.VerifyProviderNameSearch;
import buisness.core.administration.pms.provider.VerifySearchEmail;
import buisness.core.administration.pms.provider.VerifySearchInactive;
import buisness.core.administration.pms.provider.VerifySearchMemberID;
import buisness.keywords.Common;
import configuration.Setup;
import configuration.UtilityFunction;
import testcases.dashboard.provider.UtilityFunctionDashboardProvider;

public class Pms extends Common {
	
	UtilityFunction util=new UtilityFunction();
	UtilityFunctionDashboardProvider util_pro=new UtilityFunctionDashboardProvider();
	@Override
	public String meth(String elementmethod,String action,String locator,String...data)
	{
		result=super.meth(elementmethod, action, locator, data);
		try{
			if(action.equals("IsMenuSelected"))	
			{
				result=util.IsMenuSelected(data[0]);
			}
			else if(action.equals("IsSubMenuSelected"))	
			{
				result=util.IsSubMenuSelected(data[0]);
			}
			else if(action.equals("ComparePracticename"))
			{
				PmsVerifyContent PmsVerifyContent = new PmsVerifyContent();
				result = PmsVerifyContent.Verify(elementmethod, locator)?"Pass":"Fail";
			}
			else if(action.equals("CompareActiveClinician"))
			{
			
				CompareActiveClinician  CompareActiveClinician = new CompareActiveClinician();
				result = CompareActiveClinician.Verify(elementmethod, locator)?"Pass":"Fail";
				}
			else if(action.equals("ComparePracticeStatus"))
			{
				
				ComparePracticeStatus  ComparePracticeStatus = new ComparePracticeStatus();
				result = ComparePracticeStatus.Verify(elementmethod, locator)?"Pass":"Fail";
				}
			
			else if(action.equals("VerifyRoasterMessage"))
			{
				
				VerifyRoasterMessage  VerifyRoasterMessage = new VerifyRoasterMessage();
				result = VerifyRoasterMessage.Verify(elementmethod, locator)?"Pass":"Fail";
				}
			
			else if(action.equals("VerifyPracticeAddress"))
			{
				
				VerifyPracticeAddress  VerifyPracticeAddress = new VerifyPracticeAddress();
				result = VerifyPracticeAddress.Verify(elementmethod, locator)?"Pass":"Fail";
				}
			else if(action.equals("VerifyPracticeCity"))
			{
				
				VerifyPracticeCity  VerifyPracticeCity = new VerifyPracticeCity();
				result = VerifyPracticeCity.Verify(elementmethod, locator)?"Pass":"Fail";
				}
			
			else if(action.equals("VerifyPracticeState"))
			{
				
				VerifyPracticeState  VerifyPracticeState = new VerifyPracticeState();
				result = VerifyPracticeState.Verify(elementmethod, locator)?"Pass":"Fail";
				}
			else if(action.equals("VerifyPracticeTimeZone"))
			{
				
				VerifyPracticeTimeZone  VerifyPracticeTimeZone = new VerifyPracticeTimeZone();
				result = VerifyPracticeTimeZone.Verify(elementmethod, locator)?"Pass":"Fail";
				}
			
			else if(action.equals("VerifyPracticeZip"))
			{
				
				VerifyPracticeZip  VerifyPracticeZip = new VerifyPracticeZip();
				result = VerifyPracticeZip.Verify(elementmethod, locator)?"Pass":"Fail";
				}
		 
			else if (action.equalsIgnoreCase("VerifyITContactName"))
			{
				VerifyITContactName VerifyITContactName = new VerifyITContactName();
				result= VerifyITContactName.Verify(elementmethod, locator)?"Pass":"Fail";
				
				
			}

			else if (action.equalsIgnoreCase("VerifyITContactEmail"))
			{
				VerifyITContactEmail VerifyITContactEmail = new VerifyITContactEmail();
				result= VerifyITContactEmail.Verify(elementmethod, locator)?"Pass":"Fail";
				
				
			}
			else if (action.equalsIgnoreCase("VerifyITContactPhone"))
			{
				VerifyITContactPhone VerifyITContactPhone = new VerifyITContactPhone();
				result= VerifyITContactPhone.Verify(elementmethod, locator)?"Pass":"Fail";
				
				 
			}
			else if (action.equalsIgnoreCase("VerifySubmissionMethod"))
			{
				VerifySubmissionMethod VerifySubmissionMethod = new VerifySubmissionMethod();
				result= VerifySubmissionMethod.Verify(elementmethod, locator)?"Pass":"Fail";
				
				 
			}
			else if (action.equalsIgnoreCase("VerifyPracticeEMR"))
			{
				VerifyPracticeEMR VerifyPracticeEMR = new VerifyPracticeEMR();
				result= VerifyPracticeEMR.Verify(elementmethod, locator)?"Pass":"Fail";
					 
			} 
			else if (action.equalsIgnoreCase("VerifyPEmrVersion"))
			{
				VerifyPEmrVersion VerifyPEmrVersion = new VerifyPEmrVersion();
				result= VerifyPEmrVersion.Verify(elementmethod, locator)?"Pass":"Fail";
					 
			}
			else if (action.equalsIgnoreCase("VerifyPracticeEMRHosting"))
			{
				VerifyPracticeEMRHosting VerifyPracticeEMRHosting = new VerifyPracticeEMRHosting();
				result= VerifyPracticeEMRHosting.Verify(elementmethod, locator)?"Pass":"Fail";
					 
			}
			else if (action.equals("VerifyPracticeEHRExtractionMethod"))
			{
				VerifyPracticeEHRExtractionMethod VerifyPracticeEHRExtractionMethod =new VerifyPracticeEHRExtractionMethod();
				result= VerifyPracticeEHRExtractionMethod.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyEHRPushFileType"))
			{
				VerifyEHRPushFileType VerifyEHRPushFileType =new VerifyEHRPushFileType();
				result= VerifyEHRPushFileType.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyEHRpushMethod"))
			{
				VerifyEHRpushMethod VerifyEHRpushMethod =new VerifyEHRpushMethod();
				result= VerifyEHRpushMethod.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("PMrcmExtractionMethod"))
			{
				PMrcmExtractionMethod PMrcmExtractionMethod =new PMrcmExtractionMethod();
				result= PMrcmExtractionMethod.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("Pm"))
			{
				Pm Pm =new Pm();
				result= Pm.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
		
			else if (action.equals("VerifyPMrcmPushFileType"))
			{
				VerifyPMrcmPushFileType VerifyPMrcmPushFileType =new VerifyPMrcmPushFileType();
				result= VerifyPMrcmPushFileType.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyPmSystemVersion"))
			{
				VerifyPmSystemVersion VerifyPmSystemVersion =new VerifyPmSystemVersion();
				result= VerifyPmSystemVersion.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyPmIntegrationDate"))
			{
				VerifyPmIntegrationDate VerifyPmIntegrationDate =new VerifyPmIntegrationDate();
				result= VerifyPmIntegrationDate.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyRpcInstallDate"))
			{
				VerifyRpcInstallDate VerifyRpcInstallDate =new VerifyRpcInstallDate();
				result= VerifyRpcInstallDate.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyRpcInstalledOn"))
			{
				VerifyRpcInstalledOn VerifyRpcInstalledOn =new VerifyRpcInstalledOn();
				result= VerifyRpcInstalledOn.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyPracticeConnectivity"))
			{
				VerifyPracticeConnectivity VerifyPracticeConnectivity =new VerifyPracticeConnectivity();
				result= VerifyPracticeConnectivity.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyExtractFrequency"))
			{
				VerifyExtractFrequency VerifyExtractFrequency =new VerifyExtractFrequency();
				result= VerifyExtractFrequency.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			
			else if (action.equals("VerifyExtractStartTime"))
			{
				VerifyExtractStartTime VerifyExtractStartTime =new VerifyExtractStartTime();
				result= VerifyExtractStartTime.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyExtractStopTime"))
			{
				VerifyExtractStopTime VerifyExtractStopTime =new VerifyExtractStopTime();
				result= VerifyExtractStopTime.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyEMRaccountNumber"))
			{
				VerifyEMRaccountNumber VerifyEMRaccountNumber =new VerifyEMRaccountNumber();
				result= VerifyEMRaccountNumber.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyElixirID"))
			{
				VefiryElixirID VefiryElixirID =new VefiryElixirID();
				result= VefiryElixirID.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyElixirKey"))
			{
				VerifyElixirKey VerifyElixirKey =new VerifyElixirKey();
				result= VerifyElixirKey.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			
			else if (action.equals("VerifyAco"))
			{
				VerifyAco VerifyAco =new VerifyAco();
				result= VerifyAco.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			
			else if (action.equals("VerifyPrimaryCare"))
			{
				VerifyPrimaryCare VerifyPrimaryCare =new VerifyPrimaryCare();
				result= VerifyPrimaryCare.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			
			else if (action.equals("VerifyLastUpdateDate"))
			{
				VerifyLastUpdateDate VerifyLastUpdateDate =new VerifyLastUpdateDate();
				result= VerifyLastUpdateDate.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}

			else if (action.equals("VerifyMipsComponent"))
			{
				VerifyMipsComponent VerifyMipsComponent =new VerifyMipsComponent();
				result= VerifyMipsComponent.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyPace"))
			{
				VerifyPace VerifyPace =new VerifyPace();
				result= VerifyPace.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyVip"))
			{
				VerifyVip VerifyVip =new VerifyVip();
				result= VerifyVip.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyRemark"))
			{
				VerifyRemark VerifyRemark =new VerifyRemark();
				result= VerifyRemark.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyGpro"))
			{
				VerifyGpro VerifyGpro =new VerifyGpro();
				result= VerifyGpro.Verify(elementmethod, locator)?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyProviderNameSearch"))
			{
				VerifyProviderNameSearch VerifyProviderNameSearch =new VerifyProviderNameSearch();
				result= VerifyProviderNameSearch.Verify(elementmethod, locator,data[0])?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyNpiSearch"))
			{
				VerifyNpiSearch VerifyNpiSearch =new VerifyNpiSearch();
				result= VerifyNpiSearch.Verify(elementmethod, locator,data[0])?"Pass":"Fail";
				
			}
			else if (action.equals("VerifyNpiSearch"))
			{
				VerifyNpiSearch VerifyNpiSearch =new VerifyNpiSearch();
				result= VerifyNpiSearch.Verify(elementmethod, locator,data[0])?"Pass":"Fail";
				
			}
			
			else if (action.equals("VerifySearchMemberID"))
			{
				VerifySearchMemberID VerifySearchMemberID =new VerifySearchMemberID();
				result= VerifySearchMemberID.Verify(elementmethod, locator,data[0])?"Pass":"Fail";
				
			}
			else if (action.equals("VerifySearchEmail"))
			{
				VerifySearchEmail VerifySearchEmail =new VerifySearchEmail();
				result= VerifySearchEmail.Verify(elementmethod, locator,data[0])?"Pass":"Fail";
				
			}
			else if (action.equals("VerifySearchInactive"))
			{
				VerifySearchInactive VerifySearchInactive =new VerifySearchInactive();
				result= VerifySearchInactive.Verify(elementmethod, locator,data[0])?"Pass":"Fail";
				
			}
			
			
			else if (action.equals("VerifyPPopUpMessageUpdate"))
			{
				VerifyPPopUpMessageUpdate VerifyPPopUpMessageUpdate =new VerifyPPopUpMessageUpdate();
				result= VerifyPPopUpMessageUpdate.Verify(elementmethod, locator,data[0])?"Pass":"Fail";
				
			}
			else if(action.equals("VerifyAgreementStatus"))
			{
				PracticeAgreementPopUpView PracticeAgreementPopUpView = new PracticeAgreementPopUpView();
				result=PracticeAgreementPopUpView.verify(elementmethod, locator, data[0])? "Pass":"Fail";
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		
		
			
			
		
			
			
		
		
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Setup.testcase.fail();
		}
        	
		return result;		
	}
	
	
	
	
	
	
	
	
	

}
