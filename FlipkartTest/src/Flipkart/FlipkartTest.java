package Flipkart;


import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.openqa.selenium.support.ui.Select;



public class FlipkartTest {



	public static void main(String[] args) throws InterruptedException {
				// TODO Auto-generated method stub
				 WebDriver driver;
				 
			
				System.setProperty("webdriver.chrome.driver", "D:\\Installation\\chromedriver_win32 (1)\\chromedriver.exe");
				driver = new ChromeDriver();
				
			
				 
				 
				driver.get("https://www.flipkart.com/");
				driver.manage().window().maximize();
				driver.findElement(By.linkText("Login"));
			
				//Login functionality
				driver.findElement(By.xpath( "//*[@class="_2hriZF _2rbIyg"]/div/div/div/div/div//*[@type="text"]"));
				driver.findElement(By.xpath("//*[@class='IiD88i _351hSN']//*[@type='text']")).sendKeys("9483628750");
				driver.findElement(By.xpath("//*[@class='IiD88i _351hSN']//*[@type='password']")).sendKeys("Salon@123");
				driver.findElement(By.xpath("//*[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
			    Thread.sleep(1000);
				String ActualResult = driver.getTitle();
				String ExpectedResult = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
				Assert.assertEquals(ExpectedResult, ActualResult);
				
			
				//otp
				//driver.findElement(By.xpath("//*[@class='_2KpZ6l _2HKlqd _3NgS1a']")).click();
				
				
				//Sign up functionality
				//driver.findElement(By.partialLinkText("New to Flipkart? Create an account")).click();
				//driver.findElement(By.xpath("//*[@class='IiD88i _351hSN']//*[@type ='text']")).sendKeys("8904045007");
				//driver.findElement(By.xpath("//*[contains (text(), 'CONTINUE')]")).click();
				
				Thread.sleep(5000);
				
				//Search and click on one of the auto prediction
				driver.findElement(By.xpath("//*[@class='_3704LK']")).sendKeys("La");
                Thread.sleep(2000);
				
				
						
				List<WebElement> autoSuggest = driver.findElements(By.xpath(".//*[@id=\"container\"]//div[@class=\"_3OO5Xc\"]/following::ul/li"));
			    Iterator<WebElement> iterator = autoSuggest.iterator();
			    while(iterator.hasNext()) {
			    WebElement value = iterator.next();
			    System.out.println(value.getText());
			   
			}
			 for(WebElement selectoption: autoSuggest)
			    {
			       
					if(selectoption.getText().equalsIgnoreCase("lakme lipstick"))
					{
						selectoption.click();
						break;
			        }
			    }
			 

			 String Productrows = ".//div [@class=\"_1YokD2 _3Mn1Gg\"][2]//div[@class=\"_1AtVbE col-12-12\"]";
			 Thread.sleep(4000);
			 List<WebElement> rowsTotal = driver.findElements(By.xpath(Productrows));
			 System.out.println("Total number of rows: "+rowsTotal.size());
			 
			 for (int i=1; i<rowsTotal.size()-1;i++)
			 {
				 String ProductColumns = ".//div [@class=\"_1YokD2 _3Mn1Gg\"][2]//div[@class=\"_1AtVbE col-12-12\"]["+i+"]/div/div";
				 Thread.sleep(4000);
				 List<WebElement> columnsTotal = driver.findElements(By.xpath(ProductColumns));
				 System.out.println("Total number of Columns: "+columnsTotal.size());
				 
				 for (int j=1; j<=columnsTotal.size();j++)
				 {
					 String ProductName = ".//div [@class=\"_1YokD2 _3Mn1Gg\"][2]//div[@class=\"_1AtVbE col-12-12\"]["+i+"]/div/div["+j+"]/div/a[2]";
					 Thread.sleep(4000);
					 WebElement product = driver.findElement(By.xpath(ProductName));
					 System.out.println(product.getText().toString());
					//to catch all web elements into list
					    List<WebElement> myList=driver.findElements(By.xpath(ProductName));
					    Thread.sleep(4000);
					 String MyChoice = "Lakmé Enrich Matte Lipstick";
					 for (WebElement Clicking:myList)
					 {
					 if(Clicking.getText().contains(MyChoice))
						{
						 //Click on the product to land on product details page 
						 Clicking.click();
						 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						 System.out.println(tabs.size());
						 driver.switchTo().window(tabs.get(1));
						 String productDetailsPage = driver.getTitle();
						 System.out.println(productDetailsPage);
						 System.out.println("Price of the product is "+ driver.findElement(By.xpath(".//div [@class = \"_30jeq3 _16Jk6d\"]")).getText());
						 driver.findElement(By.xpath("//button [@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
						 System.out.println("Page title is" +driver.getTitle());
							break;
				        }
					 
					 
				 }
				 
				 System.out.println("---------------------------------------------------");
				 
			 }
				   
			
			

			 
			 
			
			 
						 
						 
	}	 
	}
}


			 
			
			


	
	
	
	
		
				
					


			


