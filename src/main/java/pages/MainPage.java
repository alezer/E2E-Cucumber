package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.BrowserInteraction.*;

public class MainPage {
	private static final String URL = "https://react-bootcamp.github.io/react-wines-101/#!";
	
	@FindBy (xpath="//h1")
    private WebElement pageTitle;
	@FindBy (xpath="//*[@class='card-action']//*[contains(text(),'Like')]")
    private WebElement likeButton;
	@FindBy (xpath="//*[@class='card-action']//*[contains(text(),'Comment')]")
    private WebElement commentButton;
    @FindBy (id="inputComment")
    private WebElement inputComment;
    @FindBy (linkText="SUBMIT")
    private WebElement submitButton;
	
    private static final String WINE_CARD_TITLE_XPATH = "//*[@class='card-content']//*[contains(text(),'%')]";
    private static final String COMMENT_XPATH = "//*[@class='comment' and contains(text(),'%')]";
    
	public String getUrl() {
		return URL;
	}
	
	public WebElement getPageTitle() {
		return pageTitle;
	}
	
	public WebElement getLikeButton() {
		return likeButton;
	}
	
	public WebElement getCommentButton() {
		return commentButton;
	}
	
	public WebElement getInputComment() {
		return inputComment;
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public WebElement getRegionOrWineLink(String region) {
		return find(By.linkText(region));
	}
	
	public WebElement getWineCardTitle(String wine) {
		return find(By.xpath(WINE_CARD_TITLE_XPATH.replace("%", wine)));
	}
	
	public WebElement getComment(String comment) {
		return find(By.xpath(COMMENT_XPATH.replace("%", comment)));
	}
}
