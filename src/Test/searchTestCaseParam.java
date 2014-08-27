package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 

import pages.homePage;
import pages.searchPage;
import junitparams.*;

@RunWith(JUnitParamsRunner.class)
public class searchTestCaseParam {

	WebDriver driver;
	String searchTerm = "SQS";
	String countryToSelect = "Ireland";

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("http://www.sqs.com");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	@Parameters({"selenium, 1","SQS, 25","test, 162"})
	public void searchTestCase(String searchTerm,int searchCount) {
		homePage home = new homePage(driver);
		searchPage search = home.searchFor(searchTerm);
		assertEquals("http://www.sqs.com/en-group/_meta/search.php?search_item="+searchTerm,driver.getCurrentUrl());
		assertEquals("The search count for "+searchTerm+" didnt match",searchCount,search.searchResult());
	}
	
}
