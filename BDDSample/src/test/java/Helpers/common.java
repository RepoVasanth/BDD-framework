package Helpers;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class common {

	 public boolean waitForUntilVisible(WebDriver driver, long time, By by) {
		    WebDriverWait wait = new WebDriverWait(driver, 120 );
		    try {
		        wait.until( ExpectedConditions.presenceOfElementLocated(by)); 
		    }catch(NoSuchElementException e) {
		        return false;
		    }
		    return true;
		}
	 
	 public boolean checkElementExist(WebDriver driver, WebElement elem) {
		 if(elem.isDisplayed())
			 return true;
		 else
			 return false;
	 }
}
