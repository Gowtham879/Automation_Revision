package SeleniumExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class DropDowns {
    static  WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
//        DropDowns dropDowns=new DropDowns();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("disable-notifications");
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
        driver.get("https://demoqa.com/select-menu");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("//b[text()='Multiselect drop down']/../following-sibling::div//div[@class=' css-yk16xz-control']")).click();
        selectMutlipleOption(driver,"Green","Blue");
//        List<WebElement>select=driver.findElements(By.xpath("//div[@class=' css-11unzgr']//div"));
//        System.out.println(select.size());
//        selectFromDropDown(select,"Blue");
//        driver.get("https://www.hdfcbank.com/");
//        //ProductsTypes
//        driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
//        List<WebElement>productType=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
//        System.out.println("Number of ProductTypes "+productType.size());
//        dropDowns.selectFromDropDown(productType,"Cards");
//        //Product
//        driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
//        List<WebElement>product=driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
//        System.out.println("Number of Product "+product.size());
//        dropDowns.selectFromDropDown(product,"Credit Cards");
//
   }
//    public static void selectFromDropDown(List<WebElement>Options,String value){
//        for (WebElement option:Options) {
//            if (option.getText().equals(value)){
//                option.click();
//                break;
//            }
//
//        }
//
//   }

    public static void selectMutlipleOption(WebDriver driver,String... Value){
        List<WebElement>select=driver.findElements(By.xpath("//div[@class=' css-11unzgr']//div"));
        if (!Value[0].equalsIgnoreCase("all")){
            for (WebElement item:select) {
                String text=item.getText();
                for (String value:Value) {
                    if(text.equals(value)){
                        item.click();
                        break;
                    }
                }
            }

        }
        else {
            for (WebElement item:select) {
                item.click();
            }
        }
    }
}
