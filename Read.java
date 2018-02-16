package AutomationTest;

 
import java.util.concurrent.TimeUnit;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




 
public class Read {
		private static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fajiboye\\Documents\\AutomationFramework\\TestWeb\\src\\AutomationTest\\chromedriver.exe");
		
 
        //Chrome driver
		driver = new ChromeDriver();
 
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        //Launch the Website
 
        driver.get("http://computer-database.herokuapp.com/computers?p=1");
 
        //Verify that "computer name" column is present
        Thread.sleep(2000);
        if(driver.findElement(By.xpath("//*[@id=\"main\"]/table/thead/tr/th[1]")).getText().equalsIgnoreCase("Computer name"))
        {
            //print
        	System.out.println("Computer name");
        }

        else
        {
            //print
        	
        	System.out.println("Text Not found");
        }
        Thread.sleep(2000);
        //Verify that "Introduced" column is present
        
        if(driver.findElement(By.xpath("//*[@id=\"main\"]/table/thead/tr/th[2]")).getText().equalsIgnoreCase("introduced"))
        {
        	 //print
        	System.out.println("Introduced");
        }

        else
        {
        	 //print
        	
        	System.out.println("Text Not found");
        }
        Thread.sleep(2000);
       // Verify that "Discontinued" column is present
        if(driver.findElement(By.xpath("//*[@id=\"main\"]/table/thead/tr/th[3]")).getText().equalsIgnoreCase("Discontinued"))
        {
        	 //print
        	System.out.println("Discontinued");
        }

        else
        {
        	 //print
        	
        	System.out.println("Text Not found");
        }
        Thread.sleep(2000);
        
        //Verify that "Company" column is present
        if(driver.findElement(By.xpath("//*[@id=\"main\"]/table/thead/tr/th[4]")).getText().equalsIgnoreCase("Company"))
        {
        	 //print
        	System.out.println("Company");
        }

        else
        {
        	 //print
        	
        	System.out.println("Text Not found");
        }
      
        // Close the driver
        Thread.sleep(2000);
 
        driver.quit();
 
	
 
}}