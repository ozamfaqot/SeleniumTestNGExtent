package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.netty.handler.codec.http.multipart.FileUpload;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.*;
import pages.HomePage;
import pages.ProductPage;

import java.io.File;
import java.io.IOException;

public class SeleniumTest {
    public static WebDriver driver;

    /*Extent Reports*/
    static ExtentReports report;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

//    @BeforeTest
    @BeforeSuite
    public static void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        HomePage.click_humburger_menu();
        HomePage.click_onlineProducts_link();
    }

    public static String capture(WebDriver driver) throws IOException, IOException {
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("src/../ExecImages/" + System.currentTimeMillis() + ".png");

        String errflpath = destinationFile.getAbsolutePath();
        FileHandler.copy(sourceFile,destinationFile);
//        FileUtils.copyFile(sourceFile,destinationFile);
        return  errflpath;
    }

    @Test
    void validateTitles_OnlineProducts() throws InterruptedException {
        test = extent.createTest("Validate Shoe Title on Product Page", "Thi test validates that the different Shoetypes are correct on Products Page");
        ProductPage.formalShoes_verifyTitle();
        ProductPage.sportsShoes_verifyTitle();
        ProductPage.sneakers_verifyTitle();
//        extent.flush();
    }

    @Test
    void validateFirstFormalShoe() {
        test = extent.createTest("Validate First Formal Shoename", "This test validates first formal shoes on Products page");
        ProductPage.formalShoes_firstShoeName_verify();
    }

    @Test
    void validateFirstSportShoe() {
        test = extent.createTest("Validate First Sport Shoename", "This test validates first Sport shoes on Products page");
        ProductPage.sportsShoes_firstShoeName_verify();
    }

    @Test
    void validateFirstSneaker() {
        test = extent.createTest("Validate First Sneaker Shoename", "This test validates first Sneaker shoes on Products page");
        ProductPage.sneakers_firstShoeName_verify();
    }

//    @AfterTest
//    public static void tierDown() {
//        driver.close();
//    }
    @AfterSuite
    public static void cleanUp() {
        extent.flush();
        driver.close();
    }
}
