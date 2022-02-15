package Hook;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.AfterMethod;
import java.io.IOException;
import java.time.Duration;


import static Hook.Util.getScreenShot;

public class Hook {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest logger;


    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://trello.com/es");
    }


    @BeforeSuite
    public void setup() {
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\src\\test\\resources\\report\\trelloReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() ==ITestResult.FAILURE){
            String aux = getScreenShot(driver);
            logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(aux).build());
        }
        extent.flush();
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
