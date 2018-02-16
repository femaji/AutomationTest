package AutomationTest;

 
import java.util.concurrent.TimeUnit;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;




 
public class Create {
		private static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fajiboye\\Documents\\AutomationFramework\\TestWeb\\src\\AutomationTest\\chromedriver.exe");
		// Create a new instance of the Firefox driver
 
        //driver = new FirefoxDriver();
		driver = new ChromeDriver();
 
        //a Implicit wait
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        //Launch the Website
 
        driver.get("http://computer-database.herokuapp.com/computers?p=1");
 
        // Verify that user's can click on "add a new computer" from the home page
 
        driver.findElement(By.id("add")).click();
        Thread.sleep(2000);
        

        // Verify that user can enter a "computer name"
 
        driver.findElement(By.id("name")).sendKeys("test2"); 
 
 
        //Verify that user can enter Introduced date" in the right format
        
        driver.findElement(By.id("introduced")).sendKeys("2018-01-01"); 
        Thread.sleep(2000);
        //Verify that user can enter Discontinued date" in the right format
        
        driver.findElement(By.id("discontinued")).sendKeys("2018-01-10"); 
        Thread.sleep(2000);
        
        //Verify that user can select a company name from the drop down
        Select companyDropdown = new Select(driver.findElement(By.id("company")));
        companyDropdown.selectByVisibleText("Sony");
        Thread.sleep(2000);
        
        //Verify that user can click on the create this company button
        driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/input")).click();
        Thread.sleep(2000);
        
        // Confirmation message
        if(driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]")).getText().equalsIgnoreCase("Done! Computer test2 has been created"))
        {
        	 //print
        	System.out.println("Done! Computer test2 has been created");
        }

        else
        {
        	 //print
        	
        	System.out.println("Text Not found");
        }
        
 
        // Close the driver
 
        driver.quit();
 
	
 
}}