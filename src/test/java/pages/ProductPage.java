package pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static tests.SeleniumTest.*;

public class ProductPage {

    /*Title*/
    public static String formalShoes_xpath ="/html/body/div[2]/center/h2";
    public static String sportsShoes_xpath ="/html/body/div[3]/center/h2";
    public static String sneakers_xpath ="/html/body/div[4]/center/h2";

    /*Dropdown icon*/
    public static String formalShoesDropdown_xpath = "/html/body/div[2]/center/div/i[1]";
    public static String sportShoesDropdown_xpath = "/html/body/div[3]/center/div/i[1]";
    public static String sneakersDropdown_xpath = "/html/body/div[4]/center/div/i[1]";

    /*Table content*/
    public static String formalShoes_firstShoeName_xpath = "/html/body/div[2]/table/tbody/tr[1]/td[1]";
    public static String sportsShoes_firstShoeName_xpath = "/html/body/div[3]/table/tbody/tr[1]/td[1]";
    public static String sneaker_firstShoeName_xpath = "/html/body/div[4]/table/tbody/tr[1]/td[1]";

    /*Title - action*/
    public static void formalShoes_verifyTitle() {
        String expectedTitleFS = "Formal Shoes";
        String actualTitleFS = driver.findElement(By.xpath(formalShoes_xpath)).getText();
        Assert.assertEquals(expectedTitleFS, actualTitleFS);

        if(expectedTitleFS.equals(actualTitleFS)) {
            test.log(Status.PASS, "Test passed for title verification of Formal Shoes");
            try {
                test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Test Passed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(false){
//            test.log(Status.FAIL, "Test failed for title verification of Formal Shoes");
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        }
    }
    public static void sportsShoes_verifyTitle() {
        String expectedTitleSS = "Sports Shoes";
        String actualTitleSS = driver.findElement(By.xpath(sportsShoes_xpath)).getText();
        Assert.assertEquals(expectedTitleSS, actualTitleSS);
        if(expectedTitleSS.equals(actualTitleSS)) {
            test.log(Status.PASS, "Test passed for title verification of Sport Shoes");
        }
    }
    public static void sneakers_verifyTitle() {
        String expectedTitleSn = "Sneakers";
        String actualTitleSn = driver.findElement(By.xpath(sneakers_xpath)).getText();
        Assert.assertEquals(expectedTitleSn, actualTitleSn);

        if(expectedTitleSn.equals(actualTitleSn)) {
            test.log(Status.PASS, "Test passed for title verification of Sneaker");
        }
    }

    /*Dropdown icon - action
    public static void formalShoesDropdown_click() {}
    public static void sportShoesDropdown_click() {}
    public static void sneakersDropdown_click() {}*/

    /*Table content - action*/
    public static void formalShoes_firstShoeName_verify() {
        String expectedFirstFormalShoe = "   Classic Cheltenham";
        driver.findElement(By.xpath(formalShoesDropdown_xpath)).click();
        String actualFirstFormalShoe = driver.findElement(By.xpath(formalShoes_firstShoeName_xpath)).getText();
        Assert.assertEquals(expectedFirstFormalShoe, actualFirstFormalShoe);

        if(expectedFirstFormalShoe.equals(actualFirstFormalShoe)) {
            test.log(Status.PASS, "Test passed for first shoe name of Formal Shoe i.e Classic Cheltenham");
        }
    }
    public static void sportsShoes_firstShoeName_verify() {
        String expectedFirstSportShoe = "   Ultimate";
        driver.findElement(By.xpath(sportShoesDropdown_xpath)).click();
        String actualFirstSportShoe = driver.findElement(By.xpath(sportsShoes_firstShoeName_xpath)).getText();
        Assert.assertEquals(expectedFirstSportShoe, actualFirstSportShoe);

        if(expectedFirstSportShoe.equals(actualFirstSportShoe)) {
            test.log(Status.PASS, "Test passed for first shoe name of Sport Shoe i.e Ultimate");
        }
    }
    public static void sneakers_firstShoeName_verify() {
        String expectedFirstSneaker = "   Archivo";
        driver.findElement(By.xpath(sneakersDropdown_xpath)).click();
        String actualFirstSneaker = driver.findElement(By.xpath(sneaker_firstShoeName_xpath)).getText();
        Assert.assertEquals(expectedFirstSneaker, actualFirstSneaker);

        if(expectedFirstSneaker.equals(actualFirstSneaker)) {
            test.log(Status.PASS, "Test passed for first shoe name of Sneaker i.e Archivo");
        }
    }





}
