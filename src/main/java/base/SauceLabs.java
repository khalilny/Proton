package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


import utlis.ReadProperties;

public class SauceLabs extends ReadProperties{
	DesiredCapabilities caps;
	
	
	
	public static WebDriver driver;
	
	
	//private static String userName;
	  //public static String accesskey;
	  //public static final String URL = "https://" + userName + ":" + accesskey + "@ondemand.saucelabs.com:443/wd/hub";
	
	public void setSauceLabs(){
		
		
		String userName = getSaucelabsProperty("userName");
		String accesskey = getSaucelabsProperty("accessKey");
		String url = "https://" + userName + ":" + accesskey + "@ondemand.saucelabs.com:443/wd/hub";
	
		
		caps = setCapabilites();
		try {
			driver = new RemoteWebDriver(new URL(url),caps);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		driver.get(getProperty("appUrl"));
		
		
	}
	
	public DesiredCapabilities setCapabilites(){
		
		String browser = getSaucelabsProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")){
			
			caps = DesiredCapabilities.chrome();
			
		} else if(browser.equalsIgnoreCase("Firefox")){
			caps = DesiredCapabilities.firefox();
			
			
		}else if(browser.equalsIgnoreCase("safari")){
			caps = DesiredCapabilities.safari();
			
			
		}else {
			caps = DesiredCapabilities.firefox();	
				
		}
		
		
		
		
		caps.setCapability("version", getSaucelabsProperty("browserVersion"));
		
		caps.setCapability("platform",getSaucelabsProperty("operatingSystem"));
		
		return caps;
		
	}

	
}
