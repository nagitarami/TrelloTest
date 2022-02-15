package Hook;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Util {

    public static boolean viewObject(WebElement elementName, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(Hook.driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(elementName));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getScreenShot(WebDriver driver){
        TakesScreenshot ts = (TakesScreenshot) driver;
        File scr = ts.getScreenshotAs(OutputType.FILE);
        String path= System.getProperty("user.dir") + "\\src\\test\\resources\\screenShot\\evidencia_" + System.currentTimeMillis() + ".png";
        File destino = new File(path);

        try {
            FileUtils.copyFile(scr,destino);
        }catch (IOException e){
            System.out.println("Caputra fallada " + e.getMessage());
        }
        return path;
    }

    public static void jExecutor(WebElement element, WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()",element);
    }

    public static WebElement isEnabled(WebElement element) throws InterruptedException {
        int i =0;
        while(!element.isEnabled() && i<5){
            Thread.sleep(500);
            i++;
        }
        return element;
    }
}
