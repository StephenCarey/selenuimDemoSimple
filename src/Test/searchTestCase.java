package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.homePage;
import pages.searchPage;

public class searchTestCase {
	
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
	public void testSelectCountry() {
		homePage home = new homePage(driver);
		assertTrue(home.selectCountry(countryToSelect));
		assertEquals("The correct URL was not found after clicking "+countryToSelect,
				"http://www.sqs.com/ir/index.php",driver.getCurrentUrl());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testSearch() {
		homePage home = new homePage(driver);
		searchPage search = home.searchFor(searchTerm);
		assertEquals("http://www.sqs.com/en-group/_meta/search.php?search_item="+searchTerm,driver.getCurrentUrl());
		System.out.print("The number of search results found was: "+search.searchResult());
	}

}
