package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SunScreenPage {


    //driver
    public WebDriver driver;
    WebDriverWait webDriverWait;

    //constructor
    public SunScreenPage(WebDriver driver) {
        this.driver = driver;
    }

    // Xpaths
    private By Buysummerbtn =  By.xpath("//button[text()='Buy sunscreens']");
    private By Buybtn =  By.xpath("//button[text()='Buy moisturizers']");
    private By Addbtn =  By.xpath("//body/div[@class='container']/div[2]/div[1]/button[1]");
    private By CartBtn = By.xpath("//button[@class='thin-text nav-link']");
    private By Paybtn =  By.xpath("//span[normalize-space()='Pay with Card']");
    private By email  =  By.xpath("//input[@id='email']");
    private By emaail = By.cssSelector("#email");
    private By card   =  By.xpath("//input[@id='card_number']");
    private By checkoutbtn = By.xpath("//iframe[@name='stripe_checkout_app']");
    private By month = By.xpath("//input[@id='cc-exp']");
    private By cvc = By.xpath("//input[@id='cc-csc']");
    private By pay = By.xpath("//span[@class='iconTick']");
    private By postal = By.xpath("//input[@id='billing-zip']");
    private By temp = By.xpath("//span[@id='temperature']");
    private By addsecond = By.xpath("//body/div[@class='container']/div[2]/div[2]/button[1]");
    private By rowone = By.xpath("//table/tbody/tr[1]/td[2]");
    private By rowtwo = By.xpath("//table/tbody/tr[2]/td[2]");
    private By total = By.xpath("//p[@id='total']");

    //Getting the int value
    public String Verifysum(){
        String text = driver.findElement(total).getText();
        String str = text.substring(14);
        return str;
    }

    //Verfying the total amount
    public void verifyingamount(){
        SoftAssert SA = new SoftAssert();
        SA.assertEquals(Verifysum(),sum());

    }

    //Getting amount of first product
    public Integer getrowone(){
        String text =driver.findElement(rowone).getText();
        int onetext = Integer.parseInt(text);
        return onetext;
    }

    //Getting amount of second product
    public Integer getrowtwo(){
        String texttwo =driver.findElement(rowtwo).getText();
        int twotext = Integer.parseInt(texttwo);
        return twotext;
    }

    //Sum of products
    public Integer sum(){
        String text =driver.findElement(rowone).getText();
        int onetext = Integer.parseInt(text);
        String texttwo =driver.findElement(rowtwo).getText();
        int twotext = Integer.parseInt(texttwo);
        int sum =  onetext + twotext;

        return sum;
    }

    // Getting temperature value
    public Integer gettemp(){
        String tempp = driver.findElement(temp).getText();
        String str = tempp.substring(0,tempp.length() - 3);
        int tp = Integer.parseInt(str);
        return tp;
    }

    // Wait function
    public void SetWebDriverWait(By locatorString) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locatorString));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locatorString));
    }

    //Click and sendkeys funtions
    public void clickaddsecond(){driver.findElement(addsecond).click();}
    public void ClickBuysummertBtn(){driver.findElement(Buysummerbtn).click();}
    public void ClickBuyMoistBtn(){driver.findElement(Buybtn).click();}
    public void ClickAddBtn(){driver.findElement(Addbtn).click();}
    public void ClickCartBtn(){driver.findElement(CartBtn).click();}
    public void ClickPaybtn(){driver.findElement(Paybtn).click();SetWebDriverWait(Paybtn);}
    public void Clickemailbtn(){driver.findElement(emaail).click();SetWebDriverWait(emaail);}
    public void Sendemail(){driver.findElement(emaail).sendKeys("test@yopmail.com");}
    public void Clickcardbtn() {driver.findElement(card).click();}
    public void Sendcardnumber() {driver.findElement(card).sendKeys("4242 4242 4242 4242");}
    public void ClickCheckoutbtn(){driver.findElement(checkoutbtn).click();}
    public void ClickMonth(){driver.findElement(month).click();}
    public void SendMonth(){driver.findElement(month).sendKeys("2");}
    public void Sendyear(){driver.findElement(month).sendKeys("29");}
    public void Clickcvc(){driver.findElement(cvc).click();}
    public void Sendcvc(){driver.findElement(cvc).sendKeys("123");}
    public void Clickpay(){driver.findElement(pay).click();}
    public void Clickpostal(){SetWebDriverWait(postal);driver.findElement(postal).click();}
    public void Sendpostal(){driver.findElement(postal).sendKeys("4444");}

    //Verify confirmation URL
    public void VerifyUrl(){
        SoftAssert SA = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains("confirmation"));
        SA.assertEquals(driver.getCurrentUrl(), "https://weathershopper.pythonanywhere.com/confirmation");
    }

    //Switching the screen focus to strips
    public void SwitchScreenfun(){
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[1]")));
    }

}
