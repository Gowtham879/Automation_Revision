package SeleniumExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.Set;

public class Cookies {
    static WebDriver driver;
    public static void main(String[] args) throws IOException, InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("disable-notifications");
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://www.kaspersky.com/resource-center/definitions/cookies");
        Set<Cookie> cookie = driver.manage().getCookies();
        System.out.println("The Total Number of Cookies Present " + cookie.size());
        for (Cookie Cookies : cookie) {
            System.out.println(Cookies.getName() + " : " + Cookies.getValue());
        }
        Cookie cook=new Cookie("MyCookies","45yui0e1.");
        driver.manage().addCookie(cook);
        System.out.println(cook);
        Set<Cookie> cookie2= driver.manage().getCookies();
        System.out.println("The Total Number of Cookies Present " + cookie2.size());
        driver.manage().deleteAllCookies();
        Set<Cookie> cookie1= driver.manage().getCookies();
        System.out.println("The Total Number of Cookies Present " + cookie1.size());
        driver.close();
    }
}
