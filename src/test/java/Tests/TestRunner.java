package Tests;

import PO.Drivers;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class TestRunner extends Drivers {

    public void BuyWinter() throws InterruptedException {
        moisturizersPage.ClickBuyMoistBtn();
        test.log(Status.INFO,"Clicked on Moisturizer button.");
        moisturizersPage.ClickAddBtn();
        test.log(Status.INFO,"Clicked on first product add button.");
        moisturizersPage.clickaddsecond();
        test.log(Status.INFO,"Clicked on second product add button.");
        moisturizersPage.ClickCartBtn();
        test.log(Status.INFO,"Clicked on cart items button.");
        moisturizersPage.verifyingamount();
        test.log(Status.INFO,"Actual and expected amount is verifed successfully");
        moisturizersPage.ClickPaybtn();
        test.log(Status.INFO,"Clicked on pay with card button.");
        Thread.sleep(1000);
        moisturizersPage.SwitchScreenfun();
        test.log(Status.INFO,"Successfully switching the screen focus.");
        moisturizersPage.Clickemailbtn();
        Thread.sleep(1000);
        moisturizersPage.Sendemail();
        moisturizersPage.Clickcardbtn();
        for (int i = 0; i < 4; i++) {
            moisturizersPage.Sendcardnumber();
        }
        moisturizersPage.ClickMonth();
        moisturizersPage.SendMonth();
        moisturizersPage.Clickcvc();
        moisturizersPage.Sendcvc();
        moisturizersPage.ClickMonth();
        moisturizersPage.Sendyear();
        moisturizersPage.Clickpostal();
        moisturizersPage.Sendpostal();
        moisturizersPage.Clickpay();
        test.log(Status.INFO, "Checkout Moisturizer products successfully");
        moisturizersPage.VerifyUrl();

    }

    public void BuySummer() throws InterruptedException {
        sunScreenPage.ClickBuysummertBtn();
        test.log(Status.INFO,"Clicked on sunscreen button.");
        sunScreenPage.ClickAddBtn();
        test.log(Status.INFO,"Clicked on first product add button.");
        sunScreenPage.clickaddsecond();
        test.log(Status.INFO,"Clicked on second product add button.");
        sunScreenPage.ClickCartBtn();
        test.log(Status.INFO,"Clicked on cart items button.");
        sunScreenPage.verifyingamount();
        test.log(Status.INFO,"Actual and expected amount is verifed successfully.");
        sunScreenPage.ClickPaybtn();
        test.log(Status.INFO,"Clicked on pay with card button.");
        Thread.sleep(1000);
        sunScreenPage.SwitchScreenfun();
        test.log(Status.INFO,"Successfully switching the screen focus.");
        sunScreenPage.Clickemailbtn();
        Thread.sleep(1000);
        sunScreenPage.Sendemail();
        sunScreenPage.Clickcardbtn();
        for (int i = 0; i < 4; i++) {
            sunScreenPage.Sendcardnumber();
        }
        sunScreenPage.ClickMonth();
        sunScreenPage.SendMonth();
        sunScreenPage.Clickcvc();
        sunScreenPage.Sendcvc();
        sunScreenPage.ClickMonth();
        sunScreenPage.Sendyear();
        sunScreenPage.Clickpostal();
        sunScreenPage.Sendpostal();
        sunScreenPage.Clickpay();
        test.log(Status.INFO, "Checkout sunscreens products successfully");
        sunScreenPage.VerifyUrl();

    }

    @Test(priority = 1)
    public void CheckoutTest() throws InterruptedException, IOException {
        test = extent.createTest("Checkout Process Test", "Checkout Process Test Case");

        int temperature = moisturizersPage.gettemp();

            if (temperature > 34) {
                BuySummer();
            }
            else if(temperature < 19) {
                BuyWinter();
            }


    }
}





