package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	public static Properties prop;
	public static File file;
	public static FileInputStream fis;

	public ReadConfig() {

		try {
			file = new File("./src/main/resources/Configuration/Config.properties");
			fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
			fis.close();
		} catch (Exception e) {

			System.out.println("Exception is--" + e.getMessage());
		}

	}

	public String getUrl() {
		String url = prop.getProperty("url");
		return url;
	}
}
