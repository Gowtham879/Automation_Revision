package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SeleniumCommands{
    public static WebDriver driver;
    public WebElement getWebElementByXpath(String xpath){
    WebElement element=SeleniumCommands.driver.findElement(By.xpath(xpath));
    return element;
    }
    public List<WebElement> getWebElementsByXapth(String xpath) {
       List<WebElement> element = SeleniumCommands.driver.findElements(By.xpath(xpath));
        return element;
    }
    public WebElement getWebElemntByCssSelector(String cssslector){
        WebElement element=SeleniumCommands.driver.findElement(By.cssSelector(cssslector));
        return element;
    }
    public void ClickXpath(String xpath){
        WebElement element=this.getWebElementByXpath(xpath);
        if (element.isEnabled()){
            element.click();
        }
    }
    public void ClickCssSelector(String cssslector){
        WebElement element=this.getWebElemntByCssSelector(cssslector);
        if (element.isEnabled()){
            element.click();
        }
    }
    public void SendData(String xpath, String data){
        WebElement element=this.getWebElementByXpath(xpath);
        element.clear();
        if (element.isEnabled()){
            this.ClickXpath(xpath);
            element.sendKeys(data);
        }
    }
    public void WinHandles(){
        Set<String>windows=driver.getWindowHandles();
        Iterator<String>iterater= windows.iterator();
        String paentId=iterater.next();
        String childId=iterater.next();
        driver.switchTo().window(childId);
    }
    public void ExplicitWait(String xpath){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    public void MouseHover(String xpath){
       WebElement element= this.getWebElementByXpath(xpath);
        Actions actions=new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    public void Scroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }
    public String gettext(String xpath) {
        WebElement ele=this.getWebElementByXpath(xpath);
        String text = ele.getText();
        return text;
    }
}
