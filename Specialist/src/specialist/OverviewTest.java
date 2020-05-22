package specialist;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class OverviewTest extends SigninTest{

	@Test(priority=13, dependsOnMethods={"signin"})
	public void Announcement() throws InterruptedException, AWTException 
	{
		driver.findElement(By.xpath("//div[@id='main_content']/div[2]/div/div/div[1]/div/p[2]/a")).click();
		Thread.sleep(3000);
		for(int i=0;i<=90;i++) 
		{
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(3000);
		}
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_HOME);	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='specialistAgreementModal']/div/div/button")).click(); 
		Thread.sleep(3000);

	}
	@Test(priority=3, dependsOnMethods={"Announcement"})
	public void Resources() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='announcements']/div/div[2]/div/p[2]/a")).click();
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='left-panel']/ul[1]/a[1]/li")).click();
	}

	@Test(priority=4, dependsOnMethods={"Resources"})
	public void Appointment() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='main-content']/p[1]/a")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@class='left-panel']/ul[1]/a[1]/li")).click();
	}

}
