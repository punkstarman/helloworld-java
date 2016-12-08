package net.namrats.helloworld.web;

import static org.junit.Assert.*;

import java.net.URL;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MainPageIT {
	private URL baseUrl;
	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		String hubUrlString = System.getProperty("hubUrl");
		baseUrl = new URL(System.getProperty("baseUrl"));
		if (hubUrlString == null) {
			driver = new FirefoxDriver();
		} else {
			driver = new RemoteWebDriver(new URL(hubUrlString), DesiredCapabilities.firefox());
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testMainPage() {
		driver.navigate().to(baseUrl);
		String header = driver.findElement(By.xpath("//h1")).getText();
		
		assertThat(header, Matchers.containsString("Hello"));
	}
}
