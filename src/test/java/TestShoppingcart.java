import cucumber.api.java.no.Gitt;
import cucumber.api.java.no.Når;
import cucumber.api.java.no.Så;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by olavh96 on 9/22/17.
 */
public class TestShoppingcart {

    WebDriver driver = new FirefoxDriver();

    static {
        System.setProperty("webdriver.gecko.driver", "/home/faiter/IntelliJ/Projects/CucumberStart/geckodriver");

    }

    @Gitt("^at en bruker putter (\\d+) varer i handlekurven$")
    public void at_en_bruker_putter_varer_i_handlekurven(int arg1) throws Throwable {

        driver.get("http://localhost:8080/cuke/");

        //Thread.sleep(1000);

        driver.findElement(By.id("add-item")).click();

        //Thread.sleep(1000);

        driver.findElement(By.id("go-to-cart")).click();

    }

    @Når("^brukeren trykker på bestill-knappen$")
    public void brukeren_trykker_på_bestill_knappen() throws Throwable {


        //Thread.sleep(1000);
        driver.findElement(By.id("place-order")).click();

    }

    @Så("^skal det opprettes en ordre$")
    public void skal_det_opprettes_en_ordre() throws Throwable {

        Thread.sleep(1000);
        assert(driver.findElement(By.id("order-confirmation"))!= null);
    }

    @Så("^ordren skal legges til i ordrehistorikken$")
    public void ordren_skal_legges_til_i_ordrehistorikken() throws Throwable {


        driver.close();
    }
}
