package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

//Wrapping methods like click, sendKeys, find, etc. in order to explicitly wait for the elements
//This class also includes useful methods (like checkVisibilityOf) for making validations easily from the StepDefinitions
public class BrowserInteraction {
	private static int DEFAULT_TIME_OUT_IN_SECONDS = 10;
    private static int DEFAULT_POOLING_IN_MILLISECONDS = 500;
	
	public static <T> boolean checkVisibilityOf(T criteria) {
        try {
            WebElement element = getElement(criteria);
            waitFor(ExpectedConditions.visibilityOf(element), NoSuchElementException.class);
            return true;
        } catch (TimeoutException | StaleElementReferenceException e) {
            return false;
        }
    }
	
	private static <T> WebElement getElement(T criteria) {
        return (criteria.getClass().getName().contains("By")) ? find((By) criteria) : (WebElement) criteria;
    }
	
	public static WebElement find(By criteria) {
        Function<WebDriver, WebElement> condition = driver1 -> driver1.findElement(criteria);
        return waitFor(condition, NoSuchElementException.class);
    }
	
	private static <T> T waitFor(Function<WebDriver, T> condition, Class<? extends Throwable> ignoringType) {
        WebDriverWait wait = new WebDriverWait(SharedDriver.getDriver(), DEFAULT_TIME_OUT_IN_SECONDS);
        wait.pollingEvery(Duration.of(DEFAULT_POOLING_IN_MILLISECONDS, ChronoUnit.MILLIS)).ignoring(ignoringType);
        return wait.until(condition);
    }
	
	public static <T> WebElement click(T criteria) {
        WebElement element = getElement(criteria);
        waitFor(ExpectedConditions.elementToBeClickable(element), NoSuchElementException.class);
        waitFor(ExpectedConditions.elementToBeClickable(element), ElementClickInterceptedException.class);
        waitFor(ExpectedConditions.elementToBeClickable(element), StaleElementReferenceException.class);
        element.click();
        return element;
    }
	
	public static <T> WebElement sendKeys(T criteria, String string){
        WebElement element = getElement(criteria);
        if (checkVisibilityOf(element)) {
            waitFor(ExpectedConditions.visibilityOf(element), ElementNotInteractableException.class);
            element.clear();
            element.sendKeys(string);
        }
        return element;
    }
	
	public static <T> String getText(T criteria) {
        WebElement element = getElement(criteria);
        try {
            waitFor(ExpectedConditions.attributeToBeNotEmpty(element, "innerText"), NoSuchElementException.class);
            return element.getText();
        } catch (TimeoutException e) {
        	return "";
        }
    }
}
