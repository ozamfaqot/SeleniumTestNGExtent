package pages;

import org.openqa.selenium.By;
import static tests.SeleniumTest.driver;

public class HomePage {

    public static String humburger_menu_xpath = "//*[@id=\"menuToggle\"]/input";

    public  static  String onlineProducts_link_xpath = "//*[@id=\"menu\"]/a[3]/li";

    public  static void click_humburger_menu() {
        driver.findElement(By.xpath(humburger_menu_xpath)).click();
    }

    public static void click_onlineProducts_link() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(onlineProducts_link_xpath)).click();
    }
}
