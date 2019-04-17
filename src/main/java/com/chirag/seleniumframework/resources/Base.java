package com.chirag.seleniumframework.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class Base {
	
	public static WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		Properties properties = new Properties();
		File file = new File("src/main/java/com/chirag/seleniumframework/resources", "data.properties");
		FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
		properties.load(fileInputStream);
		
		String browser = properties.getProperty("browser");
		
		if(browser.equals("chrome")) {
			File chromeFile = new File("src/main/java/com/chirag/seleniumframework/binaries", "chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", chromeFile.getAbsolutePath());
			driver = new ChromeDriver();			
		} else if (browser.equals("firefox")) {
			File firefoxFile = new File("src/main/java/FrameworkLearning/binaries", "geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", firefoxFile.getAbsolutePath());
			driver = new FirefoxDriver();
		} else {
			File edgeFile = new File("src/main/java/FrameworkLearning/binaries", "MicrosoftWebDriver.exe");
			System.setProperty("webdriver.edge.driver", edgeFile.getAbsolutePath());
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshot(String fileName) throws IOException {
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshotFile, new File("Screenshots//" + fileName +".png"));
	}

}
