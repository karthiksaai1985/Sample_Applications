package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Baseclass;
import pageObjects.SearchPage_Page;
import utils.ReadiniFile;

public class TC001_Test extends Baseclass{
	public static ReadiniFile fileread = new ReadiniFile(
			System.getProperty("user.dir") + "/src/test/resources/TestData.ini");
	
	
	@Test(priority=1, description ="Navigate to URL")
	public void VerifyPageTitle()
	{
		SearchPage_Page hmpg= new SearchPage_Page(driver);
		String pageTitle = fileread.readSection("ExpectedResults", "pageTitle");
		Assert.assertEquals(hmpg.GetPageTitle(), pageTitle);
	}
	
	@Test(priority=2, description ="Search with invalid Test Data")
	public void VerifySearchFeatureInvalidData()
	{
		SearchPage_Page hmpg= new SearchPage_Page(driver);
		hmpg.ClickSearchBox();
		String val = fileread.readSection("Inputs", "InvalidText");
		hmpg.SearchText(val);
		hmpg.ClickSubmitSearch();
		Assert.assertFalse(hmpg.VerifySearchResult(val));
		driver.navigate().refresh();
		}
	
	@Test(priority=3, description ="Search with valid Test Data")
	public void VerifySearchFeature()
	{
		SearchPage_Page hmpg= new SearchPage_Page(driver);
		hmpg.ClickSearchBox();
		String val = fileread.readSection("Inputs", "searchText");
		hmpg.SearchText(val);
		hmpg.ClickSubmitSearch();
		Assert.assertTrue(hmpg.VerifySearchResult(val));
		}
	
	@Test(priority=4, description ="Navigate to Search Results")
	public void VerifyOpenSearchResults()
	{
		SearchPage_Page hmpg= new SearchPage_Page(driver);
		for (int i=0;i<hmpg.GetResultsSize();i++)
		{
			String ResultName=hmpg.GetResultName(i);
			System.out.println(ResultName);
			hmpg.ClickResult(i);
			String ResultPageTitle=hmpg.GetResultPageTitle();
			System.out.println(ResultPageTitle);
			Assert.assertTrue(hmpg.VerifyPageTitle(ResultPageTitle,ResultName));
		}
	}

}
