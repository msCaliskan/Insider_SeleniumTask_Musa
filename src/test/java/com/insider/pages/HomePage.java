package com.insider.pages;

import com.insider.utilities.ConfigurationReader;
import com.insider.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

    @FindBy(css = "#wt-cli-accept-all-btn")
    public WebElement cookiesAccept_Loc;


    public void gotoHomePage(){

        Driver.get().get(ConfigurationReader.get("url"));
        cookiesAccept_Loc.click();
    }

    public static void checkHomePage(){
        String expectedTitle ="Insider | Platform for individualized, cross-channel customer experiences";
        checkTitle(expectedTitle);
    }

}
