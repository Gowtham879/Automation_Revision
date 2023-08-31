package SeleniumExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("disable-notifications");
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/browser-windows");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.id("tabButton")).click();
        WindowHandles();
        driver.findElement(By.id("windowButton")).click();
        WindowHandles();
        driver.quit();
    }
    public static void WindowHandles() throws InterruptedException {
        Set<String>window=driver.getWindowHandles();
        Iterator<String> it=window.iterator();
        String parentId=it.next();
        String childId=it.next();
        driver.switchTo().window(childId);
        Thread.sleep(3000);
        WebElement ele=driver.findElement(By.id("sampleHeading"));
        String text=ele.getText();
        System.out.println(text);
        driver.switchTo().window(parentId);
        driver.switchTo().window(childId);
        driver.close();
        driver.switchTo().window(parentId);
    }
}
