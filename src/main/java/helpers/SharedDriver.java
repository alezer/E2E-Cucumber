package helpers;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SharedDriver extends EventFiringWebDriver {
	private static WebDriver driver;
	
	private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
        	getDriver().quit();
        }
    };
    
    public SharedDriver() {
        super(getDriver());
    }
    
    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }
	
	public static WebDriver getDriver() {
		if(!Optional.ofNullable(driver).isPresent()) {
			System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriverMac");
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	@Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException("You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.quit();
    }
}
