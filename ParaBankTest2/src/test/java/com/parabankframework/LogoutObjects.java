package com.parabankframework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutObjects {
       WebDriver driver;
		public LogoutObjects(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this); //initialize current class driver- constructor is the 1st thing execute in a class when object is created
		}
	@FindBy(linkText="Log Out")
	WebElement logOut;
	
	public void logout() {
	logOut.click();

	}
}
