package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.HomePage;
import pages.SearchPage;

public class SearchTestCase {
   
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
      HomePage home = new HomePage(driver);
      assertTrue(home.selectCountry(countryToSelect));
      assertEquals("The correct URL was not found after clicking "+countryToSelect,
            "http://www.sqs.com/ir/index.php",driver.getCurrentUrl());
   }
   
   @Test
   public void testSearch() {
      HomePage home = new HomePage(driver);
      SearchPage search = home.searchFor(searchTerm);
      assertEquals("http://www.sqs.com/en-group/_meta/search.php?search_item="+searchTerm,driver.getCurrentUrl());
      System.out.println("The number of search results found was: "+search.searchResult());
   }

}
