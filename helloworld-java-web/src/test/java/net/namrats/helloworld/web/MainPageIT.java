package net.namrats.helloworld.web;

import static org.junit.Assert.*;

import java.net.URL;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MainPageIT {
	private URL hubUrl;
	private URL baseUrl;
	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		hubUrl = new URL(System.getProperty("hubUrl"));
		baseUrl = new URL(System.getProperty("baseUrl"));
		driver = new RemoteWebDriver(hubUrl, DesiredCapabilities.firefox());
	}

	@Test
	public void testMainPage() {
		driver.navigate().to(baseUrl);
		String header = driver.findElement(By.xpath("//h1")).getText();
		
		assertThat(header, Matchers.containsString("World"));
	}
}
