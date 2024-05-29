package com.parabankframework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterObjects {
	 WebDriver driver;
		public RegisterObjects(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this); //initialize current class driver- constructor is the 1st thing execute in a class when object is created
		}
		
		@FindBy(linkText="Register")
		WebElement Register;
		
		@FindBy(id="customer.firstName")
		WebElement First_Name;
		
		@FindBy(id="customer.lastName")
		WebElement Last_Name;
		
		@FindBy(id="customer.address.street")
		WebElement Add_ress;
		
		@FindBy(id="customer.address.city")
		WebElement Ci_ty;
		
		@FindBy(id="customer.address.state")
		WebElement Sta_te;
		
		@FindBy(id="customer.address.zipCode")
		WebElement Zip_Code;
		
		@FindBy(id="customer.phoneNumber")
		WebElement Phone_Number;
		
		@FindBy(id="customer.ssn")
		WebElement SSN_No;
		
		@FindBy(id="customer.username")
		WebElement User_Name;
		
		@FindBy(id="customer.password")
		WebElement Pass_Word;
		
		@FindBy(id="repeatedPassword")
		WebElement Confirm_Pwd;
		
		@FindBy(xpath="//input[@value='Register']")
		WebElement Register_Button;
		
	public void assertfields() {
		Register.click();
        Assert.assertEquals(driver.getTitle(), "ParaBank | Register for Free Online Account Access");
        boolean fname = First_Name.isDisplayed();//whether field is displayed or not
   	    Assert.assertTrue(fname);
   	    boolean fnameenabled = First_Name.isEnabled(); 
   	    Assert.assertTrue(fnameenabled);
   	    boolean lname = Last_Name.isDisplayed();
	    Assert.assertTrue(lname);
	    boolean lnameenabled = Last_Name.isEnabled();
	    Assert.assertTrue(lnameenabled);
	    boolean address=  Add_ress.isDisplayed();
	    Assert.assertTrue(address);
	    boolean addressenabled =  Add_ress.isEnabled(); 
	    Assert.assertTrue(addressenabled);
	    boolean city=  Ci_ty.isDisplayed();//whether field is displayed or not
	    Assert.assertTrue(city);
	    boolean cityenabled =  Ci_ty.isEnabled(); ////whether field is enabled or not for edit
	    Assert.assertTrue(cityenabled);
	    boolean state=  Sta_te.isDisplayed();//whether field is displayed or not
	    Assert.assertTrue(state);
	    boolean stateenabled =  Sta_te.isEnabled(); ////whether field is enabled or not for edit
	    Assert.assertTrue(stateenabled);
	    Assert.assertTrue(Zip_Code.isDisplayed());
	    Assert.assertTrue(Zip_Code.isEnabled());
	    Assert.assertTrue(Phone_Number.isDisplayed());
	    Assert.assertTrue(Phone_Number.isEnabled());
	    Assert.assertTrue(SSN_No.isDisplayed());
	    Assert.assertTrue(SSN_No.isEnabled());
	    Assert.assertTrue(User_Name.isDisplayed());
	    Assert.assertTrue(User_Name.isEnabled());
	    Assert.assertTrue(Pass_Word.isDisplayed());
	    Assert.assertTrue(Pass_Word.isEnabled());
	    Assert.assertTrue(Confirm_Pwd.isDisplayed());
	    Assert.assertTrue(Confirm_Pwd.isEnabled());
	    Assert.assertTrue(Register_Button.isDisplayed());
	    Assert.assertTrue(Register_Button.isEnabled());
	}
		
       public void regiterdata(String uname) throws InterruptedException {
 
          
    	  First_Name.sendKeys("Anvika");
    	  Last_Name.sendKeys("Shinde");
    	  Add_ress.sendKeys("MGR");
    	  Ci_ty.sendKeys("Noida");
    	  Sta_te.sendKeys("Uttar Pradesh");
    	  Zip_Code.sendKeys("1000110");
    	  Phone_Number.sendKeys("100011000");
    	  SSN_No.sendKeys("123"); 
    	  User_Name.sendKeys(uname);
    	  Pass_Word.sendKeys("Anvi123");
    	  Confirm_Pwd.sendKeys("Anvi123");
    	  Register_Button.click();
    	  Thread.sleep(3000);
    	  System.out.println(driver.findElement(By.xpath("//h1[@class='title']")).getText());
    	  Assert.assertEquals(driver.getTitle(),"ParaBank | Customer Created");
    	//  boolean welcomename= driver.findElement(By.xpath("//h1[@class='title']")).isDisplayed();
    	 // String welcomemessage= driver.findElement(By.xpath("//h1[@class='title']")).getText();
    	  //Assert.assertEquals(welcomemessage, "Welcome atest");
}
      
}
