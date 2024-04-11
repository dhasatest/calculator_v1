package net.calculator.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.calculator.utilities.ReadConfig;
import net.calculator.utilities.XLUtility;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();	
	public String baseUrl = readconfig.getApplicationUrl();
	
	public static WebDriver driver;
	
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
		driver.get(baseUrl);	
		driver.manage().window().maximize();
		
				
	}
	
	@AfterClass
	void tearDown() {
		if (driver != null) driver.quit();
	}
	
// Get Data from XL File	
	String[][] getXlData(String path, String sheetName) throws IOException{
		
		XLUtility xlData = new XLUtility(path);
		int totalRows = xlData.getRowCount(sheetName);
		int totalCols = xlData.getCellCount(sheetName, 1);
		
		String inputData[][] = new String[totalRows][totalCols];
		
		for(int i=1; i<=totalRows;i++) {
			
			for(int j=0; j<totalCols; j++) {
				inputData[i-1][j] = xlData.getCellData(sheetName, i, j);
			}
		}
		return inputData;
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("./Screenshot/"+tname+".png"));		
	}
	
}
