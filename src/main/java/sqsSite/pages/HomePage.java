package sqsSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
   
   WebDriver driver;
   
   public HomePage(WebDriver driver) {
      this.driver = driver;
      
      (new WebDriverWait(driver, 50)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.className("image_main")).isDisplayed();
            }
        });
      
   }
   
   public Boolean selectCountry(String country){
      
      try{
         driver.findElement(By.partialLinkText("Select country")).click();
         if(driver.findElement(By.partialLinkText(country)).isDisplayed()) {
            driver.findElement(By.partialLinkText(country)).click();
         }
         return true;

      } catch (NoSuchElementException e) {
         System.err.println("Link not seen");
         return false;
      }
   }
   
   public String listCountries() {
      // return a list of countries
      return null;
   }
   
   public SearchPage searchFor(String searchTerm) {
      driver.findElement(By.name("search_item")).sendKeys(searchTerm);
      driver.findElement(By.className("searchSubmit")).submit();
      return new SearchPage(driver);
   }
   
   public static void main(String[] arg0) {
      
      WebDriver driver = new FirefoxDriver();
      driver.get("http://www.sqs.com");
      
      HomePage home = new HomePage(driver);
      
      home.searchFor("Something");
   }
}
