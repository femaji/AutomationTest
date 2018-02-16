package AutomationTest;

 

import java.util.concurrent.TimeUnit;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



 
public class Update {
		private static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fajiboye\\Documents\\AutomationFramework\\TestWeb\\src\\AutomationTest\\chromedriver.exe");
		// Chromedriver
       
		driver = new ChromeDriver();
 
        //a Implicit wait
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        //Launch the Website
 
        driver.get("http://computer-database.herokuapp.com/computers?p=1");
 
        
        //Verify that user can search for computer name "Test" 
        
        driver.findElement(By.id("searchbox")).sendKeys("test2"); 
        
        // Search or filter button
        driver.findElement(By.id("searchsubmit")).click();
        
        // Select from the result
        
        driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[1]/a")).click();
        
     
       // Verify that user can change a "computer name"
        driver.findElement(By.id("name")).clear();
        
        driver.findElement(By.id("name")).sendKeys("test2"); 
 
 
        //Verify that user can change Introduced date" in the right format
        
        driver.findElement(By.id("introduced")).clear();
        
        driver.findElement(By.id("introduced")).sendKeys("2018-02-02"); 
        Thread.sleep(2000);
        //Verify that user can change Discontinued date" in the right format
        driver.findElement(By.id("discontinued")).clear();
        
        driver.findElement(By.id("discontinued")).sendKeys("2018-02-12"); 
        Thread.sleep(2000);              
        
        //Verify that user can select a company name from the drop down in order to change the company name
        Select companyDropdown = new Select(driver.findElement(By.id("company")));
        companyDropdown.selectByVisibleText("RCA");
        Thread.sleep(2000);
        
        //Verify that user can click on the create this company button
        driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/input")).click();
        Thread.sleep(2000);
        
        // Confirmation message
        
        if(driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]")).getText().equalsIgnoreCase("Done! Computer test2 has been updated"))
        {
        	 //print
        	System.out.println("Done! Computer test2 has been updated");
        }

        else
        {
        	 //print
        	
        	System.out.println("Text Not found");
        }
 
        // Close the driver
        Thread.sleep(2000);
        driver.quit();
 
	}
 
}
