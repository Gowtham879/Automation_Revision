package pageObjects;

import Utilities.SeleniumCommands;
import hooks.Hooks;
import org.testng.Assert;

public class CheckOutProcess extends SeleniumCommands {
    Hooks hks=new Hooks();
    private void shippingcart(){
        String xpath="//span[text()='Shopping cart']";
        this.ClickXpath(xpath);
    }
    private void terms_condition(){
        String xpath="//input[@id='termsofservice']";
        this.ClickXpath(xpath);
    }
    private void checkout(){
        String xpath="//button[@id='checkout']";
        this.ClickXpath(xpath);
    }
    private void billingAddress(){
        String xpath="//h2[text()='Billing address']/../..//input[@value='Continue']";
        this.ClickXpath(xpath);
    }
    private void shippingAddress(){
        String xpath="//input[@onclick='Shipping.save()']";
        this.ClickXpath(xpath);
    }
    private void shippingMethod(){
        String xpath="//h2[text()='Shipping method']/../..//input[@value='Continue']";
        this.ClickXpath(xpath);
    }
    private void paymentMethod(){
        String xpath="//h2[text()='Payment method']/../..//input[@value='Continue']";
        this.ClickXpath(xpath);
    }
    private void payemtInfo(){
        String xpath="//h2[text()='Payment information']/../..//input[@value='Continue']";
        this.ClickXpath(xpath);
    }
    private void confirm(){
        this.Scroll();
        String xpath="//h2[text()='Confirm order']/../..//input[@value='Confirm']";
        this.ClickXpath(xpath);
    }
    private void continu(){
        String xpath="//input[@value='Continue']";
        this.ClickXpath(xpath);
    }
    public void verifycation(){
        String xpath="//strong[normalize-space()='Your order has been successfully processed!']";
        String actual=this.gettext(xpath);
        Assert.assertEquals(actual,"Your order has been successfully processed!");
        this.continu();
    }
    public void checkoutprocess(){
        this.shippingcart();
        this.terms_condition();
        this.checkout();
        this.billingAddress();
        this.Scroll();
        hks.delayScript(2);
        this.shippingAddress();
        hks.delayScript(2);
        this.shippingMethod();
        hks.delayScript(2);
        this.paymentMethod();
        hks.delayScript(2);
        this.payemtInfo();
        hks.delayScript(2);
        this.confirm();
        hks.delayScript(2);
            }
}
