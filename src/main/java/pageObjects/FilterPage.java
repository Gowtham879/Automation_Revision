package pageObjects;

import Utilities.SeleniumCommands;
import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FilterPage extends SeleniumCommands {
    Hooks hks=new Hooks();
    private void processor(String FilterName1){
        String xpath="//label[contains(.,'"+FilterName1+"')]";
        this.ClickXpath(xpath);
    }
    private void Ram(String FiterName2){
        String xpath="//label[contains(.,'"+FiterName2+"')]";
        this.ClickXpath(xpath);
    }
    private void processorName(){
        String xpath="";
    }
    private void filterType(String FilterName){
        String xpath="//label[normalize-space()='"+FilterName+"']";
        this.ClickXpath(xpath);
    }
    private void fiterValue(String FilterValue){
        String xpath="//label[text()='"+FilterValue+"']";
        this.ClickXpath(xpath);
    }
    public void addtocart(){
        String xpath="//input[@id='add-to-cart-button-16']";
        this.ClickXpath(xpath);
    }
    public void firstTwoFilter1(String FilterValue1, String FilterValue2){
       WebElement processer= driver.findElement(By.id("product_attribute_16_5_4"));
        selectFromDropdown(processer,FilterValue1);
       WebElement ram= driver.findElement(By.id("product_attribute_16_6_5"));
       selectFromDropdown(ram,FilterValue2);
    }
    public void firstTwoFilter2(){
        WebElement processer= driver.findElement(By.id("product_attribute_16_5_4"));
        Select select=new Select(processer);
        select.selectByValue("13");
        hks.delayScript(2);
        WebElement ram= driver.findElement(By.id("product_attribute_16_6_5"));
        Select select1=new Select(ram);
        select1.selectByValue("17");
    }
    public void selectFromDropdown(WebElement ele ,String value){
        Select dropdown=new Select(ele);
        List<WebElement>options=dropdown.getOptions();
        for (WebElement option:options) {
            if (option.getText().equals(value)){
                option.click();
                break;
            }
        }
    }
    public void FiterDetails1(String FiterValue1, String FilterValue2) {
        this.firstTwoFilter1(FiterValue1, FilterValue2);
    }
    public void FiterDetails2(String FilterName, String FilterValue){
        this.filterType(FilterName);
        this.fiterValue(FilterValue);
    }
}
