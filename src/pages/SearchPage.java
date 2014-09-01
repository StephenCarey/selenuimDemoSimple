package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public int searchResult() {
		
		String[] resultText = driver.findElement(By.className("searchHeader1")).getText().split(" ");
		return Integer.parseInt(resultText[0]);

	}

}