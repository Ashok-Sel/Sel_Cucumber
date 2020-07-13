package sel_july;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("https://juliemr.github.io/protractor-demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String input1=JOptionPane.showInputDialog("Input 1");
		String input2=JOptionPane.showInputDialog("Input 2");
		
		driver.findElementByXPath("//input[@ng-model='first']").sendKeys(input1);
		WebElement operator=driver.findElementByXPath("//select[@ng-model='operator']");
		
		Select dropdown=new Select(operator);
		dropdown.selectByValue("MULTIPLICATION");
		
		driver.findElementByXPath("//input[@ng-model='second']").sendKeys(input2);;
		
		driver.findElementByXPath("//button[text()='Go!']").click();
		
		Integer sum=Integer.parseInt(input1)*Integer.parseInt(input2);
		
		String str = sum.toString();
		
		System.out.println("str "+str);
		
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		WebElement text = driver.findElementByXPath("//h2[1]");
		
		wait.until(ExpectedConditions.textToBePresentInElement(text,str));
		
		System.out.println(text.getText());
		
		
		

	}

}
