package com.agility.focis.rc.carrierContract.air;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarrierContractAirStepDefinitions {
	
	private CarrierContractAirSteps carrierContractAirSteps;

	public CarrierContractAirStepDefinitions() throws IOException {
		carrierContractAirSteps = new CarrierContractAirSteps();
	}
	


	@When("clicks on {string} button from Air Freight-Carrier Contract-List page")
	public void clicks_on_button_from_Air_Freight_Carrier_Contract_List_page(String upload) throws InterruptedException {
		carrierContractAirSteps.clickOnaUploadButton(upload);
	}

	@When("clicks on {string} from Air Freight Carrier Contract Upload screen")
	public void clicks_on_from_Air_Freight_Carrier_Contract_Upload_screen(String CountryName) throws InterruptedException {
		carrierContractAirSteps.selctCountryName(CountryName); 
	    
	}

	@When("Selects Template Name")
	public void selects_Template_Name(List<Map<String, String>> dataTable) {
		String selectTempName;
		for (int i = 0; i < dataTable.size(); i++) {
			selectTempName = dataTable.get(i).get("SelectTempName");
			carrierContractAirSteps.selectTemplateName(selectTempName);
		}
	   
	}

	@When("Click on {string} button and Upload Excel File")
	public void click_on_button_and_Upload_Excel_File(String excelUpload) {
		carrierContractAirSteps.uploadExcelButton(excelUpload);
	}

	@When("Click on {string} button")
	public void click_on_button(String uploadButton) {
		carrierContractAirSteps.uploadButton(uploadButton);
	    
	}
	
	@When("Verify text message File upload completed. Please continue with next file message after template upload")
	public void verify_text_message_File_upload_completed_Please_continue_with_next_file_message_after_template_upload() {
		carrierContractAirSteps.verifyTextPresent("File upload completed. Please continue with next file.");
	}

	/*@When("AF-P{int}PCharge template - File upload completed")
	public void af_P_PCharge_template_File_upload_completed(Integer int1) {
	    
	}*/
	
	@When("Wait for page load and click on {string} icon from Upload Files Status List page")
	public void wait_for_page_load_and_click_on_icon_from_Upload_Files_Status_List_page(String reloadGrid) throws InterruptedException {
		carrierContractAirSteps.clickonReloadgrid(reloadGrid);
	}

	@Then("Upload status is display as COMPLETED")
	public void upload_status_is_display_as_COMPLETED() throws InterruptedException {
		carrierContractAirSteps.verifyUploadStatus();
		
	}
}
