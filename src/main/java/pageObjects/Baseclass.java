package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import utils.ReadConfig;

public class Baseclass {

	public WebDriver driver;
	public WebDriver getDriver() {
        return driver;
    }
	public static ReadConfig readConfig = new ReadConfig();
	public static String url = readConfig.getUrl();
	
	@BeforeSuite
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1200,1100");
		this.driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
		 
	@AfterSuite
	 public void tearDown() {
			try {
				driver.quit();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
}
