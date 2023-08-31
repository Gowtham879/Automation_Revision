package pageObjects;

import Utilities.SeleniumCommands;
import hooks.Hooks;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends SeleniumCommands {
    Hooks hks=new Hooks();
    public void logout(){
        String xpath="//a[text()='Log out']";
        this.ClickXpath(xpath);
    }
    public void login(){
        String xpath="//a[text()='Log in']";
        this.ClickXpath(xpath);
    }
    private void logEmail(String Email){
        String xpath="//input[@id='Email']";
        this.SendData(xpath,Email);
    }
    private void logPasswordt(String Password){
        String xpath="//input[@id='Password']";
        this.SendData(xpath,Password);
    }
    private void RememberMe(){
        String xpath="//input[@type='checkbox']";
        this.ClickXpath(xpath);
    }
    private void Login(){
        String xpath="//input[@value='Log in']";
        this.ClickXpath(xpath);
    }
    public void verfify(){
        String xpath="//a[@class='account']";
        String actual= this.gettext(xpath);
        Assert.assertEquals(actual,"Charli777@gmail.com");
    }

    public void LoginDetails(String Email, String Password){
//        this.logout();
//        this.login();
        this.logEmail(Email);
        this.logPasswordt(Password);
        this.RememberMe();
        this.Login();
    }
    public  void LoginForShipping(){
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("Charli777@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Charli777");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }
}
