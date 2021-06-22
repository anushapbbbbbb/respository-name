package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesFile{ // Reading test data from properties{
	public static String getProperties(String key) {
		Properties prop = new Properties();
		FileInputStream input;
		try {
			input = new FileInputStream("resources/ObjectRepository/projectConfig.properties");
			prop.load(input);
		} catch (Exception e) {

			e.printStackTrace();
		}

		String value = prop.getProperty(key);
		return value;

	}

}


