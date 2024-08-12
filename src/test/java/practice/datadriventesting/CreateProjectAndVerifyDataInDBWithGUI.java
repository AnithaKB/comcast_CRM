package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyDataInDBWithGUI {

	public static void main(String[] args) throws Throwable {
		
		//create project in GUI using Selenium code
		String projectName="Instagram_05";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://106.51.90.215:8084");
		
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectName);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Anitha");
		
		Select sel=new Select(driver.findElement(By.xpath("(//select[@name='status'])[2]")));
		sel.selectByIndex(2);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		//verify the project in Backend[DB] using JDBC
		
		boolean flag=false;
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/qspider","root","root");
		System.out.println("======Done======");
		
		Statement state = con.createStatement();
		
		ResultSet res = state.executeQuery("select * from student");
		while(res.next()) {
			String actName=res.getString(2);
			if(projectName.equals(actName)) {
				flag=true;
			System.out.println(projectName+" is available==PASS");
		}
			}
		
		if(flag==false) {
			System.out.println(projectName+" is not available==FAIL");
		}
		
		//step 5: close the connection
		con.close();	
	}

}
