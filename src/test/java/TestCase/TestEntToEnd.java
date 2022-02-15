package TestCase;

import Hook.Hook;
import PageObjects.Pages.EspacioTrabajo;
import PageObjects.Pages.HomeTablero;
import PageObjects.Pages.TrelloHome;
import PageObjects.Pages.TrelloLogin;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static Hook.Util.getScreenShot;

public class TestEntToEnd extends Hook {
    @Test
    @Parameters({"usuario2","pass2","tablero"})
    public void flujoEndToEnd(String usuario, String pass,String tablero) throws IOException, InterruptedException {
        logger = extent.createTest("CP02 - Flujo end to end");
        TrelloHome th = new TrelloHome();
        TrelloLogin tl = new TrelloLogin();
        EspacioTrabajo ep = new EspacioTrabajo();
        HomeTablero ht = new HomeTablero();
        th.irLogin();
        logger.pass("Accediendo a formulario de login", MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot(driver)).build());
        tl.iniciarLogin(usuario, pass);
        Assert.assertFalse(tl.isLogin());
        logger.pass("Password correcto", MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot(driver)).build());
        ep.creaTablero(tablero);
        logger.pass("Tablero creado", MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot(driver)).build());
        ht.eliminarLista();
        ht.agregarLista("Por Hacer");
        ht.agregarLista("En Proceso");
        ht.agregarLista("Finalizado");
        ht.crearTarjeta("Test Tarjeta");
        logger.pass("Tarjeta Creado", MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot(driver)).build());
        ht.openCard();
        ht.agregarDatosTarjeta("Este es una prueba autoamtizada");
        ht.colorTarget();
        ht.expireDate("26/2/2022");
        ht.adjuntarImagen();
        logger.pass("Tarjeta con datos culminados", MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot(driver)).build());
        ht.closeTarget();
    }
}
