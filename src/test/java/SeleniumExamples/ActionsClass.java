package SeleniumExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class ActionsClass {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("disable-notifications");
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        //RightClick
    /*    driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClick).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Quit']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();*/
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        WebElement src1=driver.findElement(By.xpath("//a[text()=' BANK ']"));
        WebElement dst1=driver.findElement(By.xpath("//h3[normalize-space()='DEBIT SIDE']/../descendant::div//h3[normalize-space()='Account']/..//li[@class='placeholder']"));
        WebElement src2=driver.findElement(By.xpath("//a[text()=' 5000']"));
        WebElement dst2=driver.findElement(By.xpath("//h3[normalize-space()='DEBIT SIDE']/../descendant::div//h3[normalize-space()='Amount']/..//li[@class='placeholder']"));
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.dragAndDrop(src1,dst1).perform();
        actions.dragAndDrop(src2,dst2).perform();
        driver.close();
        }
}
