package Week4.Day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		2.Go to Mens Fashion
		WebElement men = driver.findElement(By.xpath("//span[@class='catText']"));
		Actions a = new Actions(driver);
		a.moveToElement(men).perform();
		
//		3. Go to Sports Shoes
		WebElement shoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		a.click(shoes).perform();
		
//		4. Get the count of the sports shoes
		String text = driver.findElement(By.xpath("//div[@class='sub-cat-count ']")).getText();
		System.out.println(text);
		
//		5. Click Training shoes
		WebElement training = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		a.click(training).perform();
		
//		6. Sort by Low to High
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
		
//		7. Check if the items displayed are sorted correctly
		String text2 = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[1]")).getText();
		System.out.println(text2);
		
//		8.Select the price range (900-1200)
		driver.findElement(By.xpath("(//input[@class='input-filter'])[1]")).sendKeys("900",Keys.TAB);
		driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).sendKeys("1200",Keys.ENTER);
		
//		9.Filter with color yellow 
		WebElement view = driver.findElement(By.xpath("(//button[@class='view-more-button btn btn-line btn-theme-secondary viewMoreFilter'])[1]"));
		a.click(view).perform();
		WebElement color = driver.findElement(By.xpath("//label[@for='Color_s-Yellow']"));
		a.click(color).perform();
		
//		10 verify the all applied filters 
//		11. Mouse Hover on first resulting Training shoes
		WebElement findElement = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		a.moveToElement(findElement).perform();
		
//		12. click QuickView button
		WebElement quick = driver.findElement(By.xpath("(//div[contains(@class,'center quick-view-bar')])[1]"));
		a.click(quick).perform();
//		13. Print the cost and the discount percentage
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("The Price is "+price);
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("The Discount is "+discount);
//		14. Take the snapshot of the shoes.
		File source =driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./Snaps/YelloShoes.png");
		FileUtils.copyToDirectory(source, des);
		

	}

}
