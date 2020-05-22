package specialist;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SigninTest 
{
	WebDriver driver;

	@Test(priority=1)
	public void Loginscreen() throws InterruptedException, AWTException
	{
		String path = System.getProperty("user.dir");
		System.out.println(path); 
		System.setProperty("webdriver.gecko.driver",path+"\\lib\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://qa.accesselitenow.com");	 
		Thread.sleep(5000);
	}

	@Test(priority=2, dependsOnMethods= {"Loginscreen"})
	public void Signup() throws InterruptedException
	{
		driver.findElement(By.xpath("//p[@class='elite-form-signup']/a")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(4000);
	}

	@Test(priority=3, dependsOnMethods= {"Signup"})
	public void Callbutton() throws InterruptedException, AWTException
	{
		driver.findElement(By.xpath("//form[@class='new_user']/div/p[3]/a")).click();
		Thread.sleep(4000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
    	Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(4000);
	}

	@Test(priority=4, dependsOnMethods= {"Callbutton"})
	public void ForgotPassword() throws InterruptedException
	{
		driver.findElement(By.xpath("//p[@class='elite-forgot-pwd']/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//form[@id='reset_password_form']/button")).click();
		Thread.sleep(5000);

	}

	@Test(priority=5, dependsOnMethods= {"ForgotPassword"})
	public void Forgotpassword() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='elite-email']")).sendKeys("nm+qa@conciergekeyhealth.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[@class='elite-forgot-pwd']/a")).click(); 

	}

	@Test(priority=6, dependsOnMethods= {"Forgotpassword"})
	public void forgotpassword() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//form[@id='reset_password_form']/button")).click();
		driver.findElement(By.xpath("//input[@id='elite-email']")).clear();
	}

	@Test(priority=7, dependsOnMethods= {"forgotpassword"})
	public void password() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='elite-login-form']/p[1]/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='forgot_password_email']")).sendKeys("nm+qa@conciergekeyhealth.com");
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//input[@name='commit']")).click();
		driver.findElement(By.xpath("//form[@id='reset_password_form']/button")).click();

	}

	@Test(priority=8, dependsOnMethods= {"password"})
	public void Login() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);

	}

	@Test(priority=9, dependsOnMethods= {"Login"})
	public void LoginEmail() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='elite-email']")).sendKeys("nm+qaopcp@conciergekeyhealth.com");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);	 
		driver.findElement(By.xpath("//input[@id='elite-email']")).clear();
	}

	@Test(priority=10, dependsOnMethods= {"LoginEmail"})
	public void InvalidEmail() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='elite-email']")).sendKeys("nm+qaopcp.com");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);	 
		driver.findElement(By.xpath("//input[@id='elite-email']")).clear();
	}

	@Test(priority=11, dependsOnMethods={"InvalidEmail"})
	public void Invalidsignin() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='elite-email']")).sendKeys("nm+qaop@conciergekeyhealth.com");
		driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys("password");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);	 
	}

	@Test(priority=2, dependsOnMethods={"Invalidsignin"})
	public void signin() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='elite-email']")).sendKeys("nm+qaopcp@conciergekeyhealth.com");
		driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys("Password1");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);	 
	}
}
