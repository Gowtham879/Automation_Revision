package pageObjects;

import Utilities.SeleniumCommands;
import hooks.Hooks;

public class HomePageHeader extends SeleniumCommands {
    Hooks hks=new Hooks();
    private void mainCategorie(String MainCategorie){
        String xpath="//ul[@class='top-menu']//a[contains(.,'"+MainCategorie+"')]";
        this.MouseHover(xpath);
    }
    private void product(String Product){
        String xpath="//ul[@class='top-menu']//a[contains(.,'"+Product+"')]";
        this.ClickXpath(xpath);
    }
    private void item(String Item){
        String xpath="//a[text()='"+Item+"']";
        this.ClickXpath(xpath);
    }
    public void HomePageDeatails(String MainCategorie, String Product, String Item){
        this.mainCategorie(MainCategorie);
        this.product(Product);
        this.item(Item);
    }
}
