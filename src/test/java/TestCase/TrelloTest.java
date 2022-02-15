package TestCase;

import Hook.Hook;
import PageObjects.Pages.TrelloHome;
import PageObjects.Pages.TrelloLogin;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import static Hook.Util.getScreenShot;

public class TrelloTest extends Hook {


    @Test
    @Parameters({"usuario","pass"})
    public void accederLoginFallido(String usuario, String pass) throws IOException {
        logger = extent.createTest("CP01 - Acceder a trello con passwotd incorrecto");
        TrelloHome th = new TrelloHome();
        TrelloLogin tl = new TrelloLogin();
        th.irLogin();
        logger.pass("Accediendo a formulario de login", MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot(driver)).build());
        tl.iniciarLogin(usuario, pass);
        Assert.assertTrue(tl.isLogin());
        if (tl.isLogin()) {
            logger.pass("Usuario no puede ingresar con Password incorrecto", MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot(driver)).build());
            logger.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\src\\test\\resources\\screenShot\\evidencia1.png");
        } else {
            logger.log(Status.FAIL, "Se inicio sesion");
        }
    }
}
