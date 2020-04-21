package view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FilmTest {
    WebDriver driver;

    String url = "http://localhost:8080/web_war_exploded/";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\paeps\\Documents\\19-20\\Semester2\\Webontwikkeling2\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url + "FilmInfo");
    }

    @After
    public void clear(){
        driver.quit();
    }

    @Test
    public void test_formulier_volleding_ingevuld_toont_nieuwe_film_in_tabel(){
        driver.get(url + "voegToe.jsp");
        fillOutForm("Rambo V", "Actie", 99, 8);

        driver.findElement(By.id("submit")).click();

        assertEquals("Film overzicht", driver.getTitle());
        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(containsWebElementsWithText(tds, "Rambo V"));
    }

    @Test
    public void test_zoek_film_niet_toegevoegd_geeft_niet_gevonden(){
        driver.get(url + "zoek.jsp");

        driver.findElement(By.id("titel")).sendKeys("Star Wars");
        driver.findElement(By.id("zoek")).click();

        assertEquals("Niet gevonden", driver.getTitle());
    }

    @Test
    public void test_film_uit_constructor_wordt_gevonden(){
        driver.get(url + "zoek.jsp");

        driver.findElement(By.id("titel")).sendKeys("Cars 3");
        driver.findElement(By.id("zoek")).click();

        assertEquals("Gevonden", driver.getTitle());
    }

    @Test
    public void test_nieuw_toegevoegd_film_wordt_gevonden(){
        driver.get(url + "voegToe.jsp");
        fillOutForm("The Avengers", "Actie", 143, 10);
        driver.findElement(By.id("submit")).click();

        driver.get(url + "zoek.jsp");
        driver.findElement(By.id("titel")).sendKeys("The Avengers");
        driver.findElement(By.id("zoek")).click();

        assertEquals("Gevonden", driver.getTitle());
    }

    @Test
    public void test_lege_film_toevoegen_toont_formulier_met_foutboodschappen(){
        driver.get((url + "voegToe.jsp"));
        driver.findElement(By.id("submit")).click();

        assertEquals("Film toevoegen", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Vul een titel in."));
        assertTrue(containsWebElementsWithText(lis, "Kies een genre."));
        assertTrue(containsWebElementsWithText(lis, "Vul een speelduur groter in dan 0."));
        assertTrue(containsWebElementsWithText(lis, "Vul een rating in tussen 0 en 10."));
    }

    @Test
    public void test_als_enkel_speelduur_verkeer_is_bevatten_overige_velden_vorige_waarde(){
        driver.get(url + "voegToe.jsp");
        fillOutForm("Joker", "Misdaad", 0, 10);
        driver.findElement(By.id("submit")).click();

        assertEquals("Film toevoegen", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Vul een speelduur groter in dan 0."));
        assertEquals("Joker", driver.findElement(By.id("titel")).getAttribute("value"));
    }

    @Test
    public void test_als_bestaande_film_wordt_toegevoegd_wordt_formulier_met_bijhorende_foutboodschap_getoond(){
        driver.get(url + "voegToe.jsp");
        fillOutForm("Cars 3", "Animatie", 109, 7);
        driver.findElement(By.id("submit")).click();

        assertEquals("Film toevoegen", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Deze film bestaat al."));
    }

    private boolean containsWebElementsWithText(ArrayList<WebElement> elements, String text) {
        for (int i = 0; i < elements.size(); i ++){
            if (elements.get(i).getText().equals(text)){
                return true;
            }
        }
        return false;
    }

    private void fillOutForm(String titel, String genre, int speelduur, int rating){
        driver.findElement(By.id("titel")).sendKeys(titel);
        driver.findElement(By.id("genre")).sendKeys(genre);
        driver.findElement(By.id("speelduur")).sendKeys(String.valueOf(speelduur));
        driver.findElement(By.id("rating")).sendKeys(String.valueOf(rating));
    }
}
