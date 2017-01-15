package utlis;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {
	
		// System.out.println(loadProperty("QA"));
		//System.out.println(getProperty("appUrl"));
		// browser
	//	System.out.println(getSaucelabsProperty("Saucelabs"));
	
    //   test run and test environment  
	
	public String getProperty(String key) {
		String value = null;
		Properties prop = loadProperty("testRun");
		value = prop.getProperty(key);
		
		if (value == null) {
			String testEnv = prop.getProperty("testEnv");
			prop = loadProperty(testEnv);
			value = prop.getProperty(key);
			// System.out.println("prop");
			
		}
		
		return value;
	}
	// for saucelabs properties ar konno method 
	public String getSaucelabsProperty(String key) {
		String value = null;
		Properties prop = loadProperty("saucelabs");
		value = prop.getProperty(key);
		
		return value;
	}
	
	// This part is first done by sir property file load korar jonno
	// properties is build in class for Java
	private Properties loadProperty(String fileName) {
		Properties prop = new Properties();
		String filePath = "./src/main/resources/properties/" + fileName + ".properties";
		
		// File file = new File(filePath);
		try {
			File file = new File(filePath);
			FileInputStream fileStream = new FileInputStream(file);
			prop.load(fileStream);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return prop;
	}
}
