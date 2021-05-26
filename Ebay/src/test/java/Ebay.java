import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ebay {

    WebDriver driver;
//3A(arrange ,asct ,assert )

    @BeforeMethod
    public void ouvrirChrome()
    {
        driver= new ChromeDriver();

        driver.get("https://www.ebay.fr/");

        driver.manage().window().maximize();

    }

    @AfterMethod
    public void fermerchrome()
    {
        driver.quit();
    }
    @Test
    public void ebay()
    {
        //Arrange
        String result="Panier (1 objet)";

        //Act
        By explore_par_categorie= By.id("gh-shop-a");
        driver.findElement(explore_par_categorie).click();

        By sport_vacance=By.cssSelector("[_sp='m570.l3778']");

        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(sport_vacance));
        driver.findElement(sport_vacance).click();

        By first_element=By.cssSelector(".b-list__items_nofooter li:nth-of-type(1)");

        driver.findElement(first_element).click();

        By ajout_panier_btn=By.id("isCartBtn_btn");
        driver.findElement(ajout_panier_btn).click();


        By panier_graphic=By.cssSelector("[data-test-id='main-title']");
        driver.findElement(panier_graphic);
        //Assertion

        Assert.assertFalse(panier_graphic.equals(result));


    }
}
