package org.interview.question.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtables {

	public static void main(String[] args) {
		String value="Clock Tower Hotel";
		String value1="Mecca";
		System.setProperty("webdriver.chrome.driver",
				"F://Elecipse_neon//Neon_Java//Santhosh//1FrameworkFullConcepts//src//resources//java//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://toolsqa.wpengine.com/automation-practice-table");
		List<WebElement> wTH = driver.findElements(By.xpath("//div[@id='content']/table/tbody/tr/th"));
		int totHead = wTH.size();
		System.out.println(totHead);
		for (int i = 1; i <=totHead; i++) {
			WebElement thData = wTH.get(i);
			System.out.println("***********************"+thData.getText());
			//driver.findElement(By.xpath(""))
			if (thData.getText().equalsIgnoreCase(value)) {
				System.out.println("******"+i);
				/*List<WebElement> wTd = driver.findElements(By.xpath("//div[@id='content']/table/tbody/tr/td"));
				int size = wTd.size();*/
				//List<WebElement> wTd = wTH.get(i).findElements(By.xpath("//div[@id='content']/table/tbody/tr["+i+"]"+"//*[contains(text(),'"+thData.getText()+"')]"));
				List<WebElement> wTd = wTH.get(i).findElements(By.xpath("//div[@id='content']/table/tbody/tr["+(i+1)+"]/td"));
				int size = wTd.size();
				System.out.println(size);
				for (int j = 1; j <=size; j++) {
					//System.out.println(wTd.get(j).getText());
					String insideRowValue = wTd.get(j).getText();
					System.out.println("************"+j);
					if (insideRowValue.equalsIgnoreCase(value1)) {
					for (int k =1 ; k <3; k++) {
						//System.out.println("last loop"+j);
						WebElement lastLoop = wTH.get(i).findElement(By.xpath("//div[@id='content']/table/tbody/tr["+(j+1)+"]/td["+(k+1)+"]"));
						String lasttext = lastLoop.getText();
						System.out.println(lasttext);
						
					}
					break;
					}
				}
				break;
			}
		}
driver.quit();
	}

}
