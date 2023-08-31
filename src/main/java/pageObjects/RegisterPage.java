package pageObjects;

import Utilities.SeleniumCommands;
import hooks.Hooks;

public class RegisterPage extends SeleniumCommands {
    Hooks hks=new Hooks();
    private void registerButton(){
        String xpath="//a[text()='Register']";
        this.ClickXpath(xpath);
    }
    private void gender(){
        String xpath="//input[@type='radio' and @id='gender-male' ]";
        this.ClickXpath(xpath);
    }
    private void firstName(String Firstname){
        String xpath="//input[@id='FirstName']";
        this.SendData(xpath,Firstname);
    }
    private void lastName(String Lastname){
        String xpath="//input[@id='LastName']";
        this.SendData(xpath,Lastname);
    }
    private void email(String Email){
        String xpath="//input[@id='Email']";
        this.SendData(xpath,Email);
    }
    private void password(String Password){
        String xpath="//input[@id='Password']";
        this.SendData(xpath,Password);
    }
    private void confirmPassword(String ConfirmPassword){
        String xpath="//input[@id='ConfirmPassword']";
        this.SendData(xpath,ConfirmPassword);
    }
    private void Register(){
        String xpath="//input[@id='register-button']";
        this.ClickXpath(xpath);
    }
    private void confirmMessage(){
        String xpath="//div[@class='result']";
        this.gettext(xpath);
    }
    private void contin(){
        String xpath="//input[@value='Continue']";
        this.ClickXpath(xpath);
    }
    public void RegisterDetails1(String Firstname) {
        this.registerButton();
        hks.delayScript(1);
        this.firstName(Firstname);
        hks.delayScript(1);
    }
    public void RegisterDetails2(String Lastname, String Email, String Password, String ConfirmPassword){
        this.lastName(Lastname);
        hks.delayScript(1);
        this.email(Email);
        hks.delayScript(1);
        this.password(Password);
        hks.delayScript(1);
        this.confirmPassword(ConfirmPassword);
        hks.delayScript(1);
           }
    public void RegisterDeatails3(){
        this.Register();
        hks.delayScript(2);
        this.confirmMessage();
        hks.delayScript(2);

        this.contin();
    }
}
