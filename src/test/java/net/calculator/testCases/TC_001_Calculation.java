/***
 * Test Case_01 : Verify the calculation result of the input of two given numbers (Integer).
 * (This includes verification of Addition , Subtraction, Multiplication and Division  )
 * 
 * Input Data: Refer input data excel file(testData/data.xlsx)
 * Step 1 : Open Calculator application in Google Chrome browser- url from config file : https://www.calculator.net/
 * Step 2 : Enter first number  by clicking the number buttons in the calculator application.
 * Step 3 : Click the operator button (+, -, *, / )
 * Step 4 : Click Equalto(=) button.
 * Step 5 : Validate the result.  
 * Step 6 : Click AllCreal button.
 * Repeat the execution for given set of input data.
 * 
 * 
 * FileName : TC_001_Calculation.java
 * 
 * 
 * Date       | Version	   | 		CreatedBy 		| 	Change log		| Reviewed bY
 * ----------------------------------------------------------------------------------	
 * 11-04-2024 |		v1	   |       Dhasarathan		| Initial Version	|
 *  

***********************************************************************************************/
package net.calculator.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.calculator.pageObjects.CalculatorHome;


public class TC_001_Calculation extends BaseClass {
	
	@Test(dataProvider="CalcInput")
	public void Calculation(String n1, String n2, String op) throws IOException{
		CalculatorHome cal = new CalculatorHome(driver);
		cal.clickNumberButtons(n1);
		cal.clickOperationButton(op);		
		cal.clickNumberButtons(n2);		
		String resulttxt = cal.getResult();
		
		int result = Integer.parseInt(resulttxt.replace(" ", ""));
		
		int num1 =Integer.valueOf(n1);
		int num2 =Integer.valueOf(n2);
		int expected =0;
				switch (op) {
					case "+":
					expected = num1+num2;	
						break;
					case "-":
						expected = num1-num2;	
							break;
					case "/":
						expected = num1/num2;	
							break;
					case "*":
						expected = num1*num2;	
							break;
				}
		//Validate the result
		Assert.assertEquals(result, expected); 
		captureScreenshot(driver,"Result " + result);
	
		//System.out.println(result);
		cal.clickAllClear();
		
	}

	
	@DataProvider(name="CalcInput")
	public String [][] getInput() throws IOException{
		
		String path = readconfig.getDataFilePath();
		String sheetName = readconfig.getSheetName();
		
		return getXlData(path,sheetName);		
		
	}
}
