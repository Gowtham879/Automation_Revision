package SeleniumExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class DatePicker {
    static WebDriver driver;
    static String Date = "7";
    static String Month = "oct";
    static String Year = "2024";

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("disable-notifications");
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://www.easemytrip.com/");
        driver.findElement(By.id("dvfarecal")).click();
        datePicker();
    }

    public static void datePicker() {
        while (true) {
            String monthYear = driver.findElement(By.xpath("//div[@class='month2']")).getText();
            String arr[] = monthYear.split(" ");
            String month = arr[0];
            String year = arr[1];
            if (month.equalsIgnoreCase(Month) && year.equals(Year) ) {
                break;
            } else {
                driver.findElement(By.xpath("//img[@onclick=\"NextPrevClick('nxtMnt')\"]")).click();
                }
            }
            List<WebElement> alldates = driver.findElements(By.xpath("//div[@class='box']//div[@class='days']//li[text()='"+Date+"']"));
            int total = alldates.size();
            System.out.println(total);
            for (WebElement ele : alldates) {
                String date = ele.getText();
                System.out.println(date);
                if (date.equals(Date)) {
                    ele.click();
                    break;
                }
            }
        }
    }
//"//div[@class='box']//div[@class='days']//li[text()='"+Date+"']
