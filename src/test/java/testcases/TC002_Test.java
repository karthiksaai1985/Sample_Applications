package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Baseclass;
import pageObjects.SearchPage_Page;
import utils.ReadiniFile;

public class TC002_Test extends Baseclass{
	public static ReadiniFile fileread = new ReadiniFile(
			System.getProperty("user.dir") + "/src/test/resources/TestData.ini");
	
	@Test
	public void VerifySearchFeature()
	{
		
		SearchPage_Page hmpg= new SearchPage_Page(driver);
		hmpg.ClickSearchBox();
		String val = fileread.readSection("Inputs", "searchText");
		hmpg.SearchText(val);
	}

}
