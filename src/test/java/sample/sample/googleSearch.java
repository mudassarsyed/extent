package sample.sample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;

public class googleSearch {
	public static final String AUTOMATE_USERNAME = "mayankmaurya4";
	  public static final String AUTOMATE_ACCESS_KEY ="JzJJjes3cyzHaynTqJpe";
	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	  static String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
	  
	  
	  @BeforeTest
	  public void setup()
	  {
		  com.browserstack.utils.ExtentReportListner.onTestStart();
		  
	  }
	  public static void googleSearch(WebDriver driver) throws MalformedURLException, InterruptedException

	  {
	
		  // Open google.com
		driver.get("https://www.google.com/");
		WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack");
        element.submit();
        Thread.sleep(5000);
        Assert.assertEquals("BrowserStack - Google Search", driver.getTitle());
        
        
		
		driver.quit();
	  }
	  
	  @Test
	public static void launchChrome() throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
		  DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setCapability("os_version", "10");
		    caps.setCapability("resolution", "1920x1080");
		    caps.setCapability("browser_version", "84.0 beta");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("browser", "chrome");
		    caps.setCapability("project", "Automate Project");
		    caps.setCapability("build", "My First Build");
		    caps.setCapability("name", "launchChrome Test");
//		    caps.setCapability("browserstack.local", browserstackLocal);
//		    caps.setCapability("browserstack.local", "true");
		    com.browserstack.utils.BrowserStackAPI bsApi= new com.browserstack.utils.BrowserStackAPI();
			  com.browserstack.utils.ExtentReportListner reporter= new com.browserstack.utils.ExtentReportListner();
		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		    SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
		    String session_id=sessionid.toString();
		  
		    googleSearch(driver);
		    System.out.println(bsApi.getSessionDetails(session_id));
		    String sessionName=bsApi.getValue(bsApi.getSessionDetails(session_id), "name");
	        bsApi.markTestStatus(session_id, "FAILED", "Fail");
	        reporter.onTestFailure(sessionName);
	        
	
	}
	  
	@Test
	public static void launchEdge() throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os_version", "10");
		    caps.setCapability("resolution", "1920x1080");
		    caps.setCapability("browser_version", "85.0");
		    caps.setCapability("os", "Windows");
		   caps.setCapability("browser", "Edge"); 
		   caps.setCapability("project", "Automate Project");
		    caps.setCapability("build", "My First Build");
		    caps.setCapability("name", "launchEdge Test");
		    com.browserstack.utils.BrowserStackAPI bsApi= new com.browserstack.utils.BrowserStackAPI();
			  com.browserstack.utils.ExtentReportListner reporter= new com.browserstack.utils.ExtentReportListner();
//		    caps.setCapability("browserstack.local", browserstackLocal);
		   WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		   SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
		   System.out.println(sessionid);
		  
		   googleSearch(driver);
		   
		   String session_id=sessionid.toString();
		   String sessionName=bsApi.getValue(bsApi.getSessionDetails(session_id), "name");
		   System.out.println(bsApi.getSessionDetails(session_id));
	        bsApi.markTestStatus(session_id, "FAILED", "Fail");
	        reporter.onTestFailure(sessionName);

	}
	
	@Test
	public static void launchSafari() throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os_version", "Mojave");
	    caps.setCapability("resolution", "1920x1080");
	    caps.setCapability("browser", "Safari");
	    caps.setCapability("browser_version", "12.1");
	    caps.setCapability("os", "OS X"); 
	 // Enabling network logs
	    caps.setCapability("browserstack.networkLogs", "true");
	    caps.setCapability("browserstack.console", "info");
	    caps.setCapability("browserstack.debug", "true");
	    caps.setCapability("browserstack.maskCommands", "setValues, getValues, setCookies, getCookies");
	    caps.setCapability("project", "Automate Project");
	    caps.setCapability("build", "My First Build");
	    caps.setCapability("name", "launchSafari Test");
//	    caps.setCapability("browserstack.local", browserstackLocal);
	    com.browserstack.utils.BrowserStackAPI bsApi= new com.browserstack.utils.BrowserStackAPI();
		  com.browserstack.utils.ExtentReportListner reporter= new com.browserstack.utils.ExtentReportListner();
	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
	    System.out.println(sessionid);
	    
		googleSearch(driver);
		String session_id=sessionid.toString();
		 String sessionName=bsApi.getValue(bsApi.getSessionDetails(session_id), "name");
		   System.out.println(bsApi.getSessionDetails(session_id));
	        bsApi.markTestStatus(session_id, "PASSED", "Pass");
	        reporter.onTestPass(sessionName);


	}
	
	  @Test
		public static void launchFirefox() throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
			  DesiredCapabilities caps = new DesiredCapabilities();
			  	caps.setCapability("os_version", "Mojave");
			    caps.setCapability("resolution", "1920x1080");
			    caps.setCapability("browser", "Firefox");
			    caps.setCapability("browser_version", "79.0");
			    caps.setCapability("os", "OS X");     
			    caps.setCapability("project", "Automate Project");
			    caps.setCapability("build", "My First Build");
			    caps.setCapability("name", "launchFirefox Test");
			    com.browserstack.utils.BrowserStackAPI bsApi= new com.browserstack.utils.BrowserStackAPI();
				  com.browserstack.utils.ExtentReportListner reporter= new com.browserstack.utils.ExtentReportListner();
//			    caps.setCapability("browserstack.local", browserstackLocal);
			    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
			    SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
			   
			    googleSearch(driver);
			    
			    String session_id=sessionid.toString();
			    String sessionName=bsApi.getValue(bsApi.getSessionDetails(session_id), "name");
				   System.out.println(bsApi.getSessionDetails(session_id));
			        bsApi.markTestStatus(session_id, "PASSED", "Pass");
			        reporter.onTestPass(sessionName);

		
		}
	
	 
	  
	  @AfterTest
	  public void teardown()
	  {
		  com.browserstack.utils.ExtentReportListner.onFinish();
	  }

	public static void mark(SessionId sessionid) throws URISyntaxException, UnsupportedEncodingException, IOException {
		  URI uri = new URI("https://mayankmaurya2:qwudT56wfMJxWLKKhRv1@api.browserstack.com/automate/sessions/"+sessionid+".json");
		  HttpPut putRequest = new HttpPut(uri);

		  ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		  nameValuePairs.add((new BasicNameValuePair("status", "passed")));
		  nameValuePairs.add((new BasicNameValuePair("reason", "")));
		  putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		  HttpClientBuilder.create().build().execute(putRequest);
		}
}
