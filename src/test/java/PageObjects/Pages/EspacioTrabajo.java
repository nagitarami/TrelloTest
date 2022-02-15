package PageObjects.Pages;

import Hook.Hook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Hook.Util.*;

public class EspacioTrabajo {
    private WebDriver driver;

    public EspacioTrabajo() {
        this.driver = Hook.driver;
        PageFactory.initElements(this.driver, this);
    }

    //@FindBy(xpath = "//ul[@class=\"boards-page-board-section-list\"]//ancestor::p/span[contains(text(),\"Crear un tablero nuevo\")]")
    @FindBy(xpath = "//*[contains(text(),'Crear un tablero nuevo')]")
    private WebElement bntTableroNuevo;

    @FindBy(xpath = "//input[contains(@data-test-id,'create-board-title-input')]")
    private WebElement txtNombreTablero;

    @FindBy(xpath = "//button[contains(text(),\"Crear\")]")
    private WebElement btnCrear;

    public void creaTablero(String nombreTablero) throws InterruptedException {
        Actions actions = new Actions(driver);
        System.out.println("Ingresar espacio de trabajo");
        if (viewObject(bntTableroNuevo,30)){
            bntTableroNuevo.click();
            if (viewObject(txtNombreTablero,30)){
                txtNombreTablero.sendKeys(nombreTablero);
                isEnabled(btnCrear).click();
            }
        }
    }
}