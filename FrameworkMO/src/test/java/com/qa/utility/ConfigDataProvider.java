package com.qa.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
		Properties prop;
		public ConfigDataProvider() {
				prop = new Properties();
			try {
				FileInputStream pfis = new FileInputStream("./Config/Config.properties");
				prop.load(pfis);
			} catch (Exception e) {
				System.out.println("Not able to load file>> "+e.getMessage());
			}
		}
		
		public String getConfigData(String keyToSearch) {
			return prop.getProperty(keyToSearch);
		}
		
		public String getBrowser() {
			return prop.getProperty("browser");
		}
		
		public String getStagingURL() {
			return prop.getProperty("qaURL");
			
		}
}
