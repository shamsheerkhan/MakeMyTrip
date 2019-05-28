package com.genericmethods;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class test {
	public static void main(String[] args) {
		String driverPath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.makemytrip.com/flight/search?itinerary=DEL-BLR-28/05/2019_BLR-DEL-04/06/2019&tripType=R&paxType=A-1_C-0_I-0&intl=false&=&cabinClass=E");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		WebElement element=driver.findElement(By.xpath("//div[@id='rt-domrt-jrny']/following-sibling::div/div/div/div/div[3]//p"));
		String s=element.getText();
		if (s.contains("Rs")) {
			s = s.substring(3, s.length());
		}else {
			s = s.substring(2, s.length());
		}
		try {
			if(s.contains(",")){
			s = s.replaceAll(",", "");	// remove commas
		}
			 
		} catch (Exception e) {

		}
		System.out.println(s);
	}
}
