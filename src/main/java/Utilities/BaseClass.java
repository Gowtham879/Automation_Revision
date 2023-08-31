package Utilities;
import hooks.AppUrl;
import hooks.Hooks;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass extends SeleniumCommands{
    Hooks hookss=new Hooks();
    AppUrl appUrl=new AppUrl();
    public void launchDemoWebShop()  {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("disable-notifications");
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
//        driver.get(appUrl.urls("Flipkart"));
        driver.get(hookss.getURL());
        hookss.delayScript(1);
    }
    public void Exit(){
        driver.close();
    }
}
