package net.calculator.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is "+ e.getMessage());
		}
	}
	
		public String getApplicationUrl() {
			return pro.getProperty("baseUrl");
		}
		
		public String getDataFilePath() {
			return pro.getProperty("path");
		}
		
		public String getSheetName() {
			return pro.getProperty("sheetName");
		
		}
		
	
	}
