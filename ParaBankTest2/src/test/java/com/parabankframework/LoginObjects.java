package com.parabankframework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginObjects {

    WebDriver driver;
	public LoginObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this); 

	}	
	@FindBy(name="username")
	WebElement userName;

	@FindBy(name="password")
	WebElement passWord;

	@FindBy(xpath="//input[@value='Log In']")
	WebElement logIn;

	public void loginpage(String uname, String pwd) {
		userName.sendKeys(uname);
		passWord.sendKeys(pwd);
		logIn.click();



	}
}

