package mini_project;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class MiniProject_source {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the browser type:\n1.Chrome\n2.Edge");
		int input = sc.nextInt();
		
		WebDriver driver = createWebDriver(input);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		System.out.println("Browser Launched" + "\u2713");

		mouseHover(driver);
		firstScenario(driver);
		secondScenario(driver);
		thirdScenario(driver);
		closeBrowser(driver);
		
		sc.close();

	}
	public static WebDriver createWebDriver(int browserType) {
		if(browserType == 1)
			return new ChromeDriver();
		else if(browserType == 2)
			return new EdgeDriver();
		
		return null;
	}

	
	/*  Go to URL, http://demo.automationtesting.in/Alerts.html
		Hover the mouse over “SwitchTo” menu
		Click on Alerts */
	public static void mouseHover(WebDriver driver) {
		System.out.println("Application URL: "+driver.getCurrentUrl());
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[4]/a"));
		action.moveToElement(element).perform();
		driver.findElement(By.xpath("//*[@id=\'header\']/nav/div/div[2]/ul/li[4]/ul/li[1]/a")).click();
	}
	
	
	//First Scenario
	/*  1. Click on the link “Alert with OK”" and click on “click the button to display an alert box:”.
		2. Check whether alert pop up appears or not.
		3. Click on “OK” */

	public static void firstScenario(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\'OKTab\']/button")).click();

		Alert alertwindow = driver.switchTo().alert();
		System.out.println("\nFirst Scenario : TestCase Passed \u2713");
		System.out.println("Alert window text is: " + alertwindow.getText());

		Thread.sleep(2000);
		alertwindow.accept();
		Thread.sleep(3000);
		
		

	}
	
	//Second Scenario
	/*  1. Click the Link "Alert with OK & Cancel" in the left menu option.
		2. Click the link "click the button to display a confirm box.
		3. Check whether confirm box pop up appears or not.
		4. Click on “Cancel” and check the respective message displayed */

	public static void secondScenario(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='CancelTab']/button")).click();
		Alert alertwindow2 = driver.switchTo().alert();
		System.out.println("\nSecond Scenario : TestCase Passed \u2713");
		System.out.println("Alert window text is: " + alertwindow2.getText());
		Thread.sleep(2000);
		alertwindow2.dismiss(); 
		
		//second scenario validation.
		String act_text = driver.findElement(By.xpath("//*[@id=\'demo\']")).getText();
		String exp_text = "You Pressed Cancel";
		if (act_text.equals(exp_text))
		{
			System.out.println( "Message: "+ exp_text+ " Test Passed \u2713");
		}else {
			System.out.println("Test Failed");
		}
	}
	
	
	// Third Scenario
	/*  1. Click the Button "Alert with Textbox".
		2. Click the Button "click the button to demonstrate the prompt box.
		3. Check whether prompt box pop up appears or not.
		4. Enter your name in the textbox and click on “OK”
		5. Check if the message Hello <your name> How are you today” is displayed */
	public static void thirdScenario(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'Textbox\']/button")).click();
		
		Alert alertwindow3 = driver.switchTo().alert();
		System.out.println("\nThird Scenario : TestCase Passed \u2713");
		System.out.println("Alert window text: "+alertwindow3.getText());
		
		alertwindow3.sendKeys("Santosh"); //input name
		Thread.sleep(2000);
		alertwindow3.accept();
		Thread.sleep(2000);
		
		//validation
		String act_text2 = driver.findElement(By.xpath("//*[@id=\'demo1\']")).getText();
		String exp_text2 = "Hello Santosh How are you today";
		
		if(act_text2.equals(exp_text2))
		{
			System.out.println("Message: " + exp_text2 + " : " + "Test Passed \u2713");
		}
		else {
			System.out.println("Test Failded");
		}
		Thread.sleep(1000);
	}
	
	// close the browser
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
		System.out.println("\nBrowser Closed \u2713");
	}
	

}
