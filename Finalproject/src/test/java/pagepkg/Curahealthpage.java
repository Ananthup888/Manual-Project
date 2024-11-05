package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Curahealthpage {
	
WebDriver driver;
	
	
	@FindBy(id="txt-username")
	WebElement chname;
	@FindBy(id="txt-password")
	WebElement chpass;
	@FindBy(id="btn-login")
	WebElement chloginbtn;
	
	
	public  Curahealthpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public void setValues(String uname,String pswd)
	{
		chname.sendKeys(uname);
		chpass.sendKeys(pswd);
	}
	
	public void loginclick()
	{
		chloginbtn.click();	
	}
//	public void copypaste()
//	{
//		WebElement usename=driver.findElement(By.id("txt-username"));
//		WebElement demoname=driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[2]/form/div[1]/div[1]/div/div/input"));
//		WebElement demopass=driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[2]/form/div[1]/div[2]/div/div/input"));
//		WebElement passwrd=driver.findElement(By.id("txt-password"));
//	
//		Actions act=new Actions(driver);
//		act.keyDown(demoname,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
//		act.keyDown(demoname,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
//		act.keyDown(usename,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
//		act.keyDown(demopass,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
//		act.keyDown(demopass,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
//		act.keyDown(passwrd,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
//		act.perform();
//	}

	
	public void Dropdown()
	{
		Select appointDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"combo_facility\"]")));
		appointDropdown.selectByVisibleText("Seoul CURA Healthcare Center");
	}
	
	public void Checkbox()
	{
		WebElement checkbox= driver.findElement(By.id("chk_hospotal_readmission"));
		
		if(!checkbox.isSelected()) 
		{
			checkbox.click();
		}
	}
	public void radioclick()
	{

	 WebElement radioButton = driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/form/div[3]/div/label[2]")); 

    
     if (!radioButton.isSelected()) 
     {
         radioButton.click(); 
     }
     if (radioButton.isSelected()) {
         System.out.println("Radio button is selected.");
     } else {
         System.out.println("Radio button is not selected.");
     }
	}
	public void datepicker() 
	{
		WebElement dateInput = driver.findElement(By.id("txt_visit_date")); 
		 dateInput.click();
		WebElement selectedDate = driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr[4]/td[5]"));
		selectedDate.click();
	}
	public void comment()
	{
		driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).sendKeys("Please schedule the appointment in between 10 AM-12 PM ");	
	}
	public void bookAppoinment()
	{
		WebElement bappoinmentbtn=driver.findElement(By.id("btn-book-appointment"));
		bappoinmentbtn.click();
		
	}
	public void homepage()
	{
		driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[7]/p/a")).click();
	}
}
