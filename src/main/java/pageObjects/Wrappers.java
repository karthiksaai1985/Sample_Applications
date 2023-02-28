package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wrappers extends Baseclass{

	public WebDriver driver;
		
	 public WebElement waitToBeClickable(WebDriver driver, WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver,10);
				return wait.until(ExpectedConditions.elementToBeClickable(element));
		        }
	 public WebElement waitVisibility(WebDriver driver, WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver,10);
				return wait.until(ExpectedConditions.visibilityOf(element));
		        }
	 
	 public void ClickElement(WebDriver driver, WebElement element) {
		 driver.switchTo().activeElement();
		 waitToBeClickable(driver,element);
		 Actions a = new Actions(driver);
	      a.moveToElement(element);
	      a.perform();
		 element.click();
		        }
	 public void SendValues(WebDriver driver, WebElement element, String val) {
		 driver.switchTo().activeElement();
		 waitToBeClickable(driver,element);
		 Actions a = new Actions(driver);
	      a.moveToElement(element);
	      a.perform();
		 element.sendKeys(val);
		        }
	 public String PageTitle(WebDriver driver) {
		 return driver.getTitle(); 
		        }
	 public String GetText(WebDriver driver, WebElement element) {
		 driver.switchTo().activeElement();
		 waitVisibility(driver,element);
		 Actions a = new Actions(driver);
	      a.moveToElement(element);
	      a.perform();
		 return element.getText(); 
		        }
	 public int GetSize(WebDriver driver, List<WebElement> element) {
		 driver.switchTo().activeElement();
		 return element.size(); 
		        }
	 public String GetTextList(WebDriver driver, List<WebElement> element, int i) {
		 driver.switchTo().activeElement();
		 Actions a = new Actions(driver);
	      a.moveToElement(element.get(i));
	      a.perform();
		 return element.get(i).getText();
		        }
	 public void ClickLinkList(WebDriver driver, List<WebElement> element, int i) {
		 driver.switchTo().activeElement();
		 Actions a = new Actions(driver);
	      a.moveToElement(element.get(i));
	      a.perform();
		 element.get(i).click();
		        }
}
