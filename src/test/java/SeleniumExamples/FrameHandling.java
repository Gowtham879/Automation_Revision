package SeleniumExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FrameHandling {
    static WebDriver driver;
    public static void main(String[] args) {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("disable-notifications");
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
        //Frames-1
      /*  driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        String text1=driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(text1);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        String text2=driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(text2);*/
        //NestedFrames -2
        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame("frame1");
        driver.switchTo().frame(0);
        String childFrame=driver.findElement(By.xpath("//p[contains(.,'Child')]")).getText();
        System.out.println("The text from ChildFrame is "+childFrame);
        driver.switchTo().parentFrame();
        String parentFrame=driver.findElement(By.xpath("//body[contains(.,'Parent')]")).getText();
        System.out.println("The text from ParentFrame is "+parentFrame);
        driver.close();
    }
}
