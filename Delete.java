package AutomationTest;

 
import java.util.concurrent.TimeUnit;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



 
public class Delete {
		private static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fajiboye\\Documents\\AutomationFramework\\TestWeb\\src\\AutomationTest\\chromedriver.exe");
	
 
        //Chrome driver
		driver = new ChromeDriver();
 
        //a Implicit wait
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        //Launch the Website
 
        driver.get("http://computer-database.herokuapp.com/computers?p=1");
        
     // Verify that user's can click on "add a new computer" from the home page
        
        driver.findElement(By.id("add")).click();
       
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
 
     // Verify that user can search for "test1" from the filter by name field
        
        driver.findElement(By.id("searchbox")).sendKeys("test2"); 
        
        Thread.sleep(2000); 
        
        // Search or filter button
        driver.findElement(By.id("searchsubmit")).click();
        Thread.sleep(2000); 
        // Select from the result
        
        driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[1]/a")).click();
        Thread.sleep(2000); 
        // Verify that user can click on delete button
        
        driver.findElement(By.xpath("//*[@id=\"main\"]/form[2]/input")).click();
        Thread.sleep(2000); 
        
       //Confirmation message
        
        if(driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]")).getText().equalsIgnoreCase("Done! Computer has been deleted"))
        {
        	 //print
        	System.out.println("Done! Computer has been deleted");
        }

        else
        {
        	 //print
        	
        	System.out.println("Text Not found");
        }
        
        Thread.sleep(2000);        
 
 
        // Close the driver
 
        driver.quit();
 
	}
 
}