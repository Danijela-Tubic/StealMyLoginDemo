import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StealMyLoginDemo {
    /*Otići na https://www.stealmylogin.com/demo.html, uneti bilo koje kredencijale za login, prisisnuti dugme.
Izvršiti proveru da je, nakon logina, URL promenjen na https://example.com/ kroz grananje. Ako jeste, štampati “Nice”. Ako nije, štampati “Not nice.”
Sve elemente koji se koriste smestiti u intuitivno imenovane promenljive.
Kod na git, screen recording puštanja i izvršavanja testa na Drive.*/
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tubic\\Desktop\\IT BOOTCAMP\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Proveravam da li sam na Google i da li se očekivani i dobijeni naslov poklapaju:
        driver.get("https://www.google.rs");

        String actualGoogleTitle = driver.getTitle();
        String expectedTitleForGoogle = "Google";

        if (actualGoogleTitle.equals(expectedTitleForGoogle)) {
            System.out.println("Google title: Valid!");
        } else {
            System.out.println("Actual result: " + actualGoogleTitle);
        }

        //Pretraga na Google:
        WebElement googleSearch = driver.findElement(By.name("q"));
        googleSearch.sendKeys("Steal my login demo");
        googleSearch.submit();

        //Ulazak na StealMyLogin:
        driver.get("https://www.stealmylogin.com/demo.html");

        //Unos username-a i password-a:
        driver.findElement(By.name("username")).sendKeys("Danijela");
        WebElement inputPassword = driver.findElement(By.name("password"));
        inputPassword.sendKeys("Sifra123");
        inputPassword.sendKeys(Keys.ENTER);

        //Poređenje URL-a:
        String expectedUrl = driver.getCurrentUrl();
        String actualUrl = "https://example.com/";

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Nice");
        } else {
            System.out.println("Not nice");
        }

        //Zatvaranje:
        driver.close();

    }
}
