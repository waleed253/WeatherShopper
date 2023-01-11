package PO;


import Pages.MoisturizersPage;
import Pages.SunScreenPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class Drivers {
    public static ExtentReports extent;
    public static ExtentSparkReporter spark ;
    public static ExtentTest test;
    public static WebDriver driver;
    protected MoisturizersPage moisturizersPage;
    protected SunScreenPage sunScreenPage;


    @BeforeSuite
    public void reportSetUp() {
        // start reporters
        spark = new ExtentSparkReporter("Spark.html");
        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(spark);

    }

    @BeforeTest
    public void drivers(){
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver.get("https://weathershopper.pythonanywhere.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        moisturizersPage = new MoisturizersPage(driver);
        sunScreenPage = new SunScreenPage(driver);

    }

    //log the test for Pass, Fail and Skip case
    @AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }

    //flush report and close driver
    @AfterTest
    public void reportTearDown() {
        extent.flush();
        driver.close();
    }

}
