package com.chirag.seleniumframework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.chirag.seleniumframework.resources.Base;

public class HomePageTest extends Base {
	
	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
	}
	
	@Test
	public void openHomePage() {
		driver.get("https://www.lg.com/in");
		log.info("Opened Home Page: " + driver.getCurrentUrl());
	}
	
	@AfterTest
	public void disposeDriver() {
		driver.close();
		driver = null;
	}

}
