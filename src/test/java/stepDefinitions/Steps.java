package stepDefinitions;

import java.util.List;

import org.junit.Assert;

import org.openqa.selenium.support.PageFactory;

import data.CommentData;

import static helpers.BrowserInteraction.*;

import static helpers.SharedDriver.getDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;

public class Steps {
	private MainPage mainPage;
	CommentData commentData;
	
	@Before
	public void before() {
		mainPage = PageFactory.initElements(getDriver(), MainPage.class);
	}
	
	@Given("I navigate to the Open Wine Database application")
	public void iNavigateToTheOpenWineDatabaseApplication() {
		getDriver().get(mainPage.getUrl());
		checkVisibilityOf(mainPage.getPageTitle());
	}

	@Then("I can see the following Regions")
	public void iCanSeeThFollowingRegions(List<String> regionsList) {
		for(String region : regionsList) {
			Assert.assertTrue(checkVisibilityOf(mainPage.getRegionOrWineLink(region)));
		}
	}

	@When("I select \"([^\"]*)\" from the Regions list")
	public void iSelectFromTheRegionsList(String region) {
		click(mainPage.getRegionOrWineLink(region));
	}

	@When("I select \"([^\"]*)\" from the Wines list")
	public void iSelectFromTheWinesList(String wine) {
		click(mainPage.getRegionOrWineLink(wine));
		checkVisibilityOf(mainPage.getWineCardTitle(wine));
	}
	
	@When("I add a comment to the selected wine")
	public void iAddACommentToTheSelectedWine() {
		commentData = new CommentData();
		click(mainPage.getCommentButton());
		sendKeys(mainPage.getInputComment(), commentData.getComment());
		click(mainPage.getSubmitButton());
	}

	@Then("the comment is shown in the Wine Details section")
	public void theCommentIsShownInTheWineDetailsSection() {
		Assert.assertTrue(checkVisibilityOf(mainPage.getComment(commentData.getComment())));
	}
}