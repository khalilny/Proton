package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utlis.ReadProperties;

public class Driver extends ReadProperties {
	// Field variable static variable danay baka hoy
	public static WebDriver driver;

	public void setDriver() {
		String browser = getProperty("browser");

		if (browser.equalsIgnoreCase("firefox")) {
			initFirefox();
			// we can set another browser else if block foe that we need to
			// create another method by down
		} else {
			initFirefox();
			// if we want to firefox as a default brower
		}

		setDriverProperties();
		driver.get(getProperty("appUrl"));

	}

	private void setDriverProperties() {
		driver.manage().window().maximize();

	}

	private void initFirefox() {

		driver = new FirefoxDriver();

	}

}
