package stepDefinitions;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.junit.Assert;

import data.RegionsData;
import data.WineData;

import java.io.IOException;
import java.util.ArrayList;

import helpers.ApiCalls;
import helpers.ResponsesProcessor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiSteps {
	HttpResponse response;
	ArrayList<String> actualRegions;
	ArrayList<String> expectedRegions;
	WineData wineData;
	
	@Given("I have a list of Regions created in my database")
	public void iHaveAListOfRegionsCreatedInMyDatabase() {
		expectedRegions = RegionsData.getRegionsList();
	}

	@When("I call the ([^\"]*) “Regions - All” endpoint")
	public void iCallTheGetRegionsAllEndpoint(String callType) throws UnsupportedOperationException, IOException {
		ApiCalls apiCalls = new ApiCalls();
		response = apiCalls.executeCall(callType, "/api/regions", "");
		String body = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
		actualRegions = ResponsesProcessor.parseResponseIntoArrayList(body);
	}

	@Then("I get a ([^\"]*) response")
	public void iGetAResponse(int statusCode) {
		Assert.assertEquals(statusCode, (response.getStatusLine().getStatusCode()));
	}

	@Then("I get the correct list of Regions")
	public void iGetTheCorrectListOfRegions() {
		Assert.assertTrue(expectedRegions.equals(actualRegions));
	}
	
	@Given("I have a Wine created in my database")
	public void iHaveAWineCreatedInMyDatabase() throws UnsupportedOperationException, IOException {
		wineData = new WineData();
		ApiCalls apiCalls = new ApiCalls();
		response = apiCalls.executeCall("GET", "/api/wines/" + wineData.getId() + "/like", "");
		String body = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
		//Making sure we are changing the value on the POST call
		if(body.contains("true")) {
			wineData.setLike("false");
		} else {
			wineData.setLike("true");
		}
	}

	@When("I call the ([^\"]*) “Wines - Like” endpoint with a valid Id and valid Payload")
	public void iCallTheWinesLikeEndpointWithAValidIdAndPayload(String callType) throws UnsupportedOperationException, IOException {
		ApiCalls apiCalls = new ApiCalls();
		String payload = "{\"like\": " + wineData.getLike() + "}";
		response = apiCalls.executeCall("POST", "/api/wines/" + wineData.getId() + "/like", payload);
	}

	@Then("the selected option is saved")
	public void theSelectedOptionIsSaved() throws UnsupportedOperationException, IOException {
		ApiCalls apiCalls = new ApiCalls();
		response = apiCalls.executeCall("GET", "/api/wines/" + wineData.getId() + "/like", "");
		String body = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
		Assert.assertTrue(body.contains(wineData.getLike()));
	}
}
