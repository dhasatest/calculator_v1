/***
 * Page Objects : Calculator Home page 
 * FileName : CalculatorHome.java
 * 
 * 
 * Date       | Version	   | 		CreatedBy 		| 	Change log		| Reviewed bY
 * ----------------------------------------------------------------------------------	
 * 11-04-2024 |		v1	   |       Dhasarathan		| Initial Version	|
 *  

*****************************************************************************/

package net.calculator.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorHome {
	
	WebDriver driver;
	
	
	public CalculatorHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[@onclick=\"r('C')\"]")
	WebElement btnAllClear;	
	
	@FindBy(xpath ="//div[@id='sciOutPut']")
	WebElement result;
	
	@FindBy(xpath="//span[@onclick=\"r('=')\"]")
	WebElement btnEqualTo;
	
	
	
	public void clickNumberButtons(String number) {
        // Split the number into digits and click corresponding buttons
        for (char digit : number.toCharArray()) {
        	String buttonPath;
        	WebElement button;
        	
        	try {
        		 buttonPath = "//span[@onclick=\"r("+ digit + ")\"]";
        		 button = driver.findElement(By.xpath(buttonPath)); 
			} catch (Exception e) {
				buttonPath = "//span[@onclick=\"r('" + digit +"')\"]";
				button = driver.findElement(By.xpath(buttonPath)); 
			}
        	
        	button.click();
        	           
        }
    }
	
	public void clickOperationButton(String operator) {
			String operatorId = "//span[@onclick=\"r('" + operator +"')\"]";
	        driver.findElement(By.xpath(operatorId)).click();
	    }

	public String getResult() {
		return result.getText();
	}
	
	public void clickAllClear() {
		btnAllClear.click();
	}
	

}
