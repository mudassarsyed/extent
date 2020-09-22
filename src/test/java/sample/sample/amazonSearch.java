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

public class amazonSearch {
	public static final String AUTOMATE_USERNAME = "mayankmaurya2";
	  public static final String AUTOMATE_ACCESS_KEY ="qwudT56wfMJxWLKKhRv1";
	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	  static String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
	
	  public static void amazonProductSearch(WebDriver driver) throws MalformedURLException, InterruptedException

	  {
		    
		  	
		  
		  // Open Amazon.com
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iPhone X");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//span[text()='Phone Color']"));
	
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		driver.findElement(By.xpath("//span[text()='iOS']/..//div")).click();
		
		Thread.sleep(3000);
		WebElement element2 = driver.findElement(By.xpath("//span[@class='a-button a-button-dropdown a-button-small']//span[@class='a-button-text a-declarative']"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='a-button a-button-dropdown a-button-small']")).click();
		
		driver.findElement(By.xpath("//a[text()='Price: High to Low']")).click();
		
		Thread.sleep(3000);
		
		List<WebElement> productList=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> displayPriceList=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<WebElement> linkslist=driver.findElements(By.xpath("//a[@class='a-size-base a-link-normal a-text-normal']"));
		for (int i=0;i<productList.size();i++)
		{
		System.out.println("Product List   ="+productList.get(i).getText());	
		System.out.println("*********************************************************************************************");
		}
		for (int i=0;i<displayPriceList.size();i++)
		{
		
		System.out.println("Display Price List   ="+displayPriceList.get(i).getText());
		System.out.println("*********************************************************************************************");
		}
		for (int i=0;i<linkslist.size();i++)
		{
		System.out.println("Links List   ="+linkslist.get(i).getAttribute("href"));
		System.out.println("*********************************************************************************************");
		}
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
		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		    SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
		    mark(sessionid);
		    System.out.println(sessionid);
		    amazonProductSearch(driver);
	
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
//		    caps.setCapability("browserstack.local", browserstackLocal);
		   WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		   SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
		   System.out.println(sessionid);
		   mark(sessionid);
		   amazonProductSearch(driver);

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
	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
	    System.out.println(sessionid);
	    mark(sessionid);
		amazonProductSearch(driver);

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
//			    caps.setCapability("browserstack.local", browserstackLocal);
			    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
			    SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
			    mark(sessionid);
			    System.out.println(sessionid);
			    amazonProductSearch(driver);
		
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
