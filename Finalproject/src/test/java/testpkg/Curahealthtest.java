package testpkg;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basepkg.Baseclass;
import pagepkg.Curahealthpage;
import utilities.Excelutils;

public class Curahealthtest extends Baseclass {
	
	@Test
	public void curahealthlogin() throws Exception
	{
	
	Curahealthpage ob=new Curahealthpage(driver);
	String xl="C:\\Users\\anura\\OneDrive\\Desktop\\Ananthu P\\Book3.xlsx";
	String Sheet="Sheet1";
	int row=Excelutils.getRowCount(xl, Sheet);
	for(int i=1;i<=row;i++)
	{
		String un=Excelutils.getCellValue(xl, Sheet, i, 0);
		System.out.println("username----"+un);
		
		String pswd=Excelutils.getCellValue(xl, Sheet, i, 1);
		System.out.println("password----"+pswd);
		
		
		ob.setValues(un, pswd);
		ob.loginclick();
		
//		 boolean isLoginSuccessful = driver.findElements(By.xpath("//*[@id=\"appointment\"]/div/div/div/h2 ")).size() > 0;
//		  if (isLoginSuccessful) {
//	            System.out.println("Login successful!");
//	        } else
//	        {
//	        	ob.copypaste();
//	        	ob.loginclick();
//	        }
		String expurl="https://katalon-demo-cura.herokuapp.com/#appointment";
		String acturl=driver.getCurrentUrl();
		if(expurl.equals(acturl))
		{

			 System.out.println("Login successful!");
			 
			ob.Dropdown();
			Thread.sleep(1000);
			
			ob.Checkbox();
			Thread.sleep(1000);
			
			ob.radioclick();
			Thread.sleep(1000);
			
			ob.datepicker();
			Thread.sleep(1000);
			
			ob.comment();
			Thread.sleep(1000);
			
			ob.bookAppoinment();
			Thread.sleep(4000);
			
			ob.homepage();
				
		}
		else
		{
			driver.navigate().refresh();
			driver.findElement(By.xpath("//*[@id=\"txt-username\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"txt-password\"]")).clear();
		}
  }
	
	}

}
