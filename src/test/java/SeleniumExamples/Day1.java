package SeleniumExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Day1 {
    public static void main(String[] args) {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("disable-notifications");
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.lenskart.com/");
        List<WebElement>ele=driver.findElements(By.cssSelector("div[class='widget-title']"));
        int count=ele.size();
        System.out.println(count);
        for (WebElement name:ele) {
            String Names=name.getText();
            System.out.println(Names);
        }
        WebElement ele1=driver.findElement(By.xpath("//a[text()='Computer Glasses']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(ele1).perform();
//        driver.close();

    }
}
