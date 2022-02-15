package PageObjects.Pages;

import Hook.Hook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static Hook.Util.*;

public class HomeTablero {
    private WebDriver driver;

    public HomeTablero() {
        this.driver = Hook.driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@id=\"board\"]/div[1]/div/div[1]/div[2]/a")
    private WebElement btnMenuLista;

    @FindBy(xpath = "//*[@id=\"chrome-container\"]/div[4]/div/div[2]/div/div/div/ul[3]/li/a")
    private WebElement btnarchivarLista;

    @FindBy(xpath = "//*[@id=\"board\"]/div/form/a/span")
    private WebElement btnAddList;

    @FindBy(xpath = "//*[@id=\"board\"]/div/form/input")
    private WebElement txtNameList;

    @FindBy(xpath = "//*[@id=\"board\"]/div/form/div/input")
    private WebElement btnAdd;

    @FindBy(xpath = "//a[contains(@class,'icon-lg icon-close dark-hover js-cancel-edit')]")
    private WebElement btnCerrarList;

    @FindBy(xpath = "(//a[@class='open-card-composer js-open-card-composer'])[1]")
    private WebElement btnCrearTarjeta;

    @FindBy(xpath = "//textarea[@class='list-card-composer-textarea js-card-title']")
    private WebElement txtTitloCard;

    @FindBy(xpath = "//input[contains(@class,'nch-button nch-button--primary confirm mod-compact js-add-card')]")
    private WebElement btnAddTarget;

    //@FindBy(xpath = "//*[@id=\"board\"]/div[1]/div/div[2]/a/div[3]/span")
    @FindBy(xpath = "//span[@class=\"list-card-title js-card-name\"]")
    private WebElement btnOpenCard;

    @FindBy(xpath = "//a[contains(@class,'description-fake-text-area hide-on-edit js-edit-desc  js-hide-with-draft')]")
    private WebElement txtDescriptionCard;

    @FindBy(xpath = "//a[@class='button-link js-edit-labels'][contains(.,'Etiquetas')]")
    private WebElement btnLabel;

    @FindBy(xpath = "//span[contains(@data-color,'blue')]")
    private WebElement lblBlue;

    @FindBy(xpath = "//a[@class='pop-over-header-close-btn icon-sm icon-close']")
    private WebElement btnCerrarLabel;

    @FindBy(xpath = "//button[contains(@data-test-id,'card-back-due-date-button')]")
    private WebElement btnExpireDate;

    @FindBy(xpath = "//input[@data-test-id='due-date-field']")
    private WebElement txtExpireDate;

    @FindBy(xpath = "//input[@value=\"Guardar\"]//following::a[@class=\"icon-lg icon-close dark-hover cancel js-cancel-edit\"]")
    private WebElement btnCerrarDescriptionTarget;

    @FindBy(xpath = "//button[contains(text(),\"Guardar\")]")
    private WebElement btnGuardarExpire;

    @FindBy(xpath = "//*[@id=\"chrome-container\"]/div[3]/div/div/div/div[5]/div[2]/div/a[4]")
    private WebElement btnAdjuntar;

    @FindBy(xpath = "//*[@id=\"addLink\"]")
    private WebElement txtLink;

    @FindBy(xpath = "//input[@value=\"Adjuntar\"]")
    private WebElement btnAdjuntarImagen;

    @FindBy(xpath = "//*[@id=\"chrome-container\"]/div[3]/div/div/a")
    private WebElement btcCloseWindows;

    public void eliminarLista(){
        int i = 0;
        if (viewObject(btnCerrarList,30)){
            btnCerrarList.click();
        }else{
            while (viewObject(btnMenuLista,30) && i <3){
                btnMenuLista.click();
                if (viewObject(btnarchivarLista,30)){
                    btnarchivarLista.click();
                    i++;
                }
            }
        }
    }

    public void agregarLista(String nombre){
        if (viewObject(btnAddList,30)){
            btnAddList.click();
            txtNameList.sendKeys(nombre);
            btnAdd.click();
            if (viewObject(btnCerrarList,30)){
                btnCerrarList.click();
            }
        }
    }

    public void crearTarjeta(String name){
        if (viewObject(btnCrearTarjeta,30)){
            btnCrearTarjeta.click();
            if (viewObject(txtTitloCard,30)){
                txtTitloCard.sendKeys(name);
                if (viewObject(btnAddTarget,30)){
                    btnAddTarget.click();
                }
            }
        }
    }
    public void openCard() {
        while (!viewObject(btnCerrarDescriptionTarget,30)){
            if (viewObject(btnOpenCard,30)){
                btnOpenCard.click();
            }
        }
    }

    public void agregarDatosTarjeta(String description){
        if (viewObject(txtDescriptionCard,30)){
            txtDescriptionCard.sendKeys(description);
        }
    }
    public void colorTarget(){
        if (viewObject(btnLabel,30)){
            btnLabel.click();
            if (viewObject(lblBlue, 30)) {
                lblBlue.click();
                btnCerrarLabel.click();
            }
        }
    }

    public void expireDate(String dato){
        Actions action = new Actions(Hook.driver);
        if (viewObject(btnExpireDate,30)){
            btnExpireDate.click();
            if (viewObject(txtExpireDate,30)){
                action.doubleClick(txtExpireDate);
                txtExpireDate.sendKeys(dato);
            }
        }
        if (viewObject(btnGuardarExpire,30)){
            btnGuardarExpire.click();
        }
    }

    public void adjuntarImagen(){
        String url = "https://static-cse.canva.com/blob/210847/50-creative-facebook-covers-to-inspire-you.e3344fa1.jpg";
        if (viewObject(btnAdjuntar,33)){
            btnAdjuntar.click();
            if(viewObject(txtLink,30)){
                txtLink.sendKeys(url);
                btnAdjuntarImagen.click();
            }
        }
    }

    public void closeTarget(){
        int i = 0;
        Actions action = new Actions(Hook.driver);
        while(viewObject(btnAdjuntar,30) && i<3){
            if (viewObject(btcCloseWindows,30)){
                action.click(btcCloseWindows);
            }
            i++;
        }
    }
}
