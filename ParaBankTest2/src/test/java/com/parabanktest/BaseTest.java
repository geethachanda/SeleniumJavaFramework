package com.parabanktest;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
	public static WebDriver driver;
	

public static void setUp(String browservalue) {
	switch(browservalue){
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = new ChromeDriver();
			break;		
			
	}
	driver.manage().window().maximize();
	driver.get("https://parabank.parasoft.com/parabank/index.htm");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
}


public static String screenshot(String testCaseName, WebDriver driver) throws IOException {
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //commons-io dependency added for placing screenshot from one location to another
	File des= new File(System.getProperty("user.dir")+ "//reports//"+testCaseName+".png"); // ./- current directory
	FileUtils.copyFile(src, des);
	return System.getProperty ("user.dir") + "//reports//"+testCaseName+".png";
	
}

public static ExtentReports Reports() {
	
	String path= System.getProperty("user.dir")+ "//reports//testreport.html";
	ExtentSparkReporter reporter =new ExtentSparkReporter(path);
	reporter.config().setReportName("ParaBank Test Report");
	reporter.config().setDocumentTitle("Test Results");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Geetha");
    return extent;

	
	
}


}

	






	