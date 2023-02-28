package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage_Page extends Wrappers{

	public static WebDriver driver;
	//public String parenttab ="";	
	//public String childtab 	="";
	
	@FindBy(xpath="//a[@id='open-global-search']")
	WebElement  searchBoxLink;
	
	@FindBy(xpath="//input[@id='site-search-keyword']")
	WebElement  searchBoxInputField;
	
	@FindBy(xpath="//button[@role='submit']")
	WebElement  submitSearchBtn;
	
	@FindBy(xpath="//button[@role='submit']")
	WebElement  searchResultubmitSearchBtn;
	
	@FindBy(xpath="//div[@class='search-result']/p/a")
	List <WebElement>  searchResultCount;
	
	@FindBy(xpath="//h4[@class='results']")
	WebElement  searchResult;
	
	@FindBy(xpath="//*[contains(text(),'Sorry, your search didn')]")
	List <WebElement>  NosearchResult;
	
	/////

	public SearchPage_Page(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}
	
	///////
	
	public String GetPageTitle() {
		return driver.getTitle();
	}
	
	public void ClickSearchBox() {
		ClickElement(driver, searchBoxLink);
	}
	
	public void SearchText(String val) {
		SendValues(driver, searchBoxInputField, val);
	}
	public void ClickSubmitSearch() {
		ClickElement(driver, submitSearchBtn);
	}

	public boolean VerifySearchResult(String val) {
		// TODO Auto-generated method stub
		if(GetText(driver,searchResult).contains(val))
				return true;
		else
			return false;
	}

	public int GetResultsSize() {
		// TODO Auto-generated method stub
		System.out.println(searchResultCount);
		return GetSize(driver,searchResultCount);
	}

	public String GetResultName(int i) {
		// TODO Auto-generated method stub
		return GetTextList(driver, searchResultCount, i);
	}

	public void ClickResult(int i) {
		// TODO Auto-generated method stub
		ClickLinkList(driver, searchResultCount, i);
	}
/*
	public void NavigateToResultPage() {
		// TODO Auto-generated method stub
		ArrayList<String>tabs = new ArrayList<String>(driver.getWindowHandles());
		 parenttab = tabs.get(0);	
		 childtab = tabs.get(1);
		 driver.switchTo().window(childtab);
	}
*/
	public String GetResultPageTitle() {
		// TODO Auto-generated method stub
		String Title=PageTitle(driver);
		driver.navigate().back();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)", "");
		return Title;
	}

	public boolean VerifyPageTitle(String resultPageTitle, String resultName) {
		// TODO Auto-generated method stub
		if (resultPageTitle.contains(resultName))
			return true;
		else
			return false;
	}
}

