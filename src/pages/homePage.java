package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class homePage {
	
	WebDriver driver;
	
	public homePage(WebDriver driver) {
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
			System.out.println("Link not seen");
			return false;
		}
	}
	
	public void listCountries(){
		
	}
	
	public searchPage searchFor(String searchTerm) {
		driver.findElement(By.name("search_item")).sendKeys(searchTerm);
		driver.findElement(By.className("searchSubmit")).submit();
		return new searchPage(driver);
	}
	
	public static void main(String[] arg0) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.sqs.com");
		
		homePage home = new homePage(driver);
		//home.selectCountry("Ireland");
		
		home.searchFor("Something");
	}
}
