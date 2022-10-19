package Week4.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDragandDrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/drag.xhtml;jsessionid=node03verg0z075n31ai7n4a3r1rfp365346.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Find the element for drag around
		WebElement pass1 = driver.findElement(By.xpath("//div[@id='form:conpnl_content']"));
		Point location = pass1.getLocation();
		int x=location.getX();
		int y =location.getY();
		Actions a =new Actions(driver);
		a.dragAndDropBy(pass1, x, y).perform();
		
		//Find the element for drag and drop to target Location
		WebElement ele1 = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
		WebElement ele2 = driver.findElement(By.xpath("//p[@class='ui-widget-header']"));
		a.dragAndDrop(ele1, ele2).perform();
		String text = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
		System.out.println(text);
		
		//Find the element for drag columns
		WebElement col1 = driver.findElement(By.xpath("//th[@id='form:j_idt94:j_idt97']"));
		WebElement col2 = driver.findElement(By.xpath("//th[@id='form:j_idt94:j_idt95']"));
		a.dragAndDrop(col1, col2).perform();
		String text2 = driver.findElement(By.xpath("//span[text()='Columns reordered']")).getText();
		System.out.println(text2);
	}

}
