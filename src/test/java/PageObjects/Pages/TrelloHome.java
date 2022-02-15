package PageObjects.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Hook.Hook;

import static Hook.Util.viewObject;


public class TrelloHome {
    private WebDriver driver;

    public TrelloHome(){
        this.driver = Hook.driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[contains(text(),'Iniciar sesión')]")
    private WebElement btnIniciarSesion;

    public void irLogin(){
        if(viewObject(btnIniciarSesion,30)){
            btnIniciarSesion.click();
        }
    }
}
