import com.google.common.io.Files;
import cucumber.api.java.no.Gitt;
import cucumber.api.java.no.Når;
import cucumber.api.java.no.Så;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by olavh96 on 9/22/17.
 */
public class Øving4 {

    WebDriver driver = new FirefoxDriver();

    static {
        System.setProperty("webdriver.gecko.driver", "/home/faiter/IntelliJ/Projects/CucumberStart/geckodriver");
    }

    @Gitt("^at en bruker er logget på Nordnet$")
    public void at_en_bruker_er_logget_på_Nordnet() throws Throwable {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://www.nordnet.no/mux/web/nordnet/index.html");

        assertEquals(true, driver.findElement(By.className("signin-btn")) != null);
        //Thread.sleep(1000);

        driver.findElement(By.className("signin-btn")).click();

        //Thread.sleep(100);

        assertEquals(true, driver.findElement(By.className("link-814161023")) != null);


        driver.findElement(By.className("link-814161023")).click();

        assertEquals(true, driver.findElement(By.id("username")) != null);
        assertEquals(true, driver.findElement(By.id("password")) != null);


        driver.findElement(By.id("username")).sendKeys("olavh96");

        List<String> password = Files.readLines(Paths.get("/home/faiter/IntelliJ/Projects/CucumberStart/src/test/resources/password.txt").toFile(), Charset.defaultCharset());
        String[] split = password.get(0).split(",");

        byte[] encoded = new byte[split.length];
        for (int i = 0; i < split.length; i++) {
            encoded[i] = Byte.parseByte(split[i].trim());
        }

        String psw = new String(Base64.getDecoder().decode(encoded));

        driver.findElement(By.id("password")).sendKeys(psw);

        driver.findElement(By.className("block-646414812")).click();

        System.out.println("Log in completed");
    }

    @Når("^brukeren trykker NEL$")
    public void brukeren_trykker_NEL() throws Throwable {

        driver.findElement(By.xpath("//a[contains(text(),'NEL')]")).click();

        System.out.println("Printed text");
    }

    @Så("^skal det åpnes en nettside$")
    public void skal_det_åpnes_en_nettside() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        //Thread.sleep(5000);

        //driver.close();
    }

}
