package PageObjects.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Hook.Hook;
import static Hook.Util.viewObject;

public class TrelloLogin {
    private WebDriver driver;

    public TrelloLogin(){
        this.driver = Hook.driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@name=\"user\"]")
    private WebElement txtUsername;

    @FindBy(xpath = "//*[@name=\"password\"]")
    private WebElement txtUPassword;

    @FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@class=\"error-message\"]")
    private WebElement lblError;

    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    private WebElement btnIniciarSesion;

    public void iniciarLogin(String userName, String password){
        if(viewObject(txtUsername,30)){
            txtUsername.sendKeys(userName);
            if (viewObject(txtUPassword,40)){
                txtUPassword.sendKeys(password);
            }
        }
        btnLogin.click();
        if (viewObject(btnIniciarSesion,30)){
            txtUPassword.sendKeys(password);
            btnIniciarSesion.click();
        }
    }

    public boolean isLogin(){
        return viewObject(lblError,30);
    }
}