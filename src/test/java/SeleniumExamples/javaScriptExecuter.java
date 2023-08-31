package SeleniumExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class javaScriptExecuter {
    static WebDriver driver;
    public static void main(String[] args) throws IOException, InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("disable-notifications");
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
//        driver.get("https://demoqa.com/browser-windows");
        WebElement search=driver.findElement(By.id("APjFqb"));
        javaUtilities(search,driver);
        Thread.sleep(2000);
//        TakesScreenshot ts= (TakesScreenshot) driver;
//        File src=ts.getScreenshotAs(OutputType.FILE);
//        File dst=new File("C:\\Users\\gowtham.n\\Pictures\\searc.png");
//        FileUtils.copyFile(src,dst);
//        driver.close();
    }
    public static void javaUtilities(WebElement element, WebDriver driver) throws InterruptedException {
        JavascriptExecutor js= (JavascriptExecutor)driver;
//        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//        Thread.sleep(3000);
//        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
//        js.executeScript("arguments[0].style.border='3px solid red'",element);
//        js.executeScript("arguments[0].click();",element);
//        js.executeScript("arguments[0].clear();",element);



        }
    }

