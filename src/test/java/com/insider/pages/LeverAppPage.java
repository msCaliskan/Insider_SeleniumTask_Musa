package com.insider.pages;

import com.insider.utilities.BrowserUtils;
import com.insider.utilities.Driver;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class LeverAppPage extends BasePage {

    @FindBy(xpath = "//h2")
    public WebElement positionTitle_Loc;

    @FindBy(css = ".sort-by-time.posting-category.medium-category-label")
    public WebElement locationTitle_Loc;

    @FindBy(css = ".sort-by-team.posting-category.medium-category-label")
    public WebElement departmentTitle_Loc;

    @FindBy(css = ".postings-btn.template-btn-submit.shamrock")
    public List<WebElement> applyButton_Loc;

    @FindBy(xpath = "(//ul[@class='posting-requirements plain-list'])[1]")
    public WebElement jobDescription_Loc;

    @FindBy(xpath = "(//ul[@class='posting-requirements plain-list'])[2]")
    public WebElement jobRequirements_Loc;



    public void verifyInformation(Map<String,String> common){
        assertEquals(common.get("positionCheck"), positionTitle_Loc.getText().toLowerCase());
        assertTrue(locationTitle_Loc.getText().toLowerCase().contains(common.get("locationCheck")));
        assertTrue(departmentTitle_Loc.getText().toLowerCase().contains(common.get("departmentCheck")));

    }
    public void verifyJobs(String button){
        assertNotEquals("",jobDescription_Loc.getText());
        assertNotEquals("",jobRequirements_Loc.getText());

        for (WebElement element : applyButton_Loc) {
            assertEquals(button.toLowerCase(), element.getText().toLowerCase());
        }
    }

    public void checkLeverPage(String button){
        WebElement applyButton = Driver.get().findElement(By.xpath("(//a[text()='"+button+"'])[1]"));
        applyButton.click();
        BrowserUtils.waitFor(2);
        String actualTitle = Driver.get().getCurrentUrl();
        System.out.println("actualTitle = " + actualTitle);
        assertTrue(actualTitle.toLowerCase().contains("lever"));
    }

}
