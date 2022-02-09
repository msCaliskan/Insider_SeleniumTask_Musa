package com.insider.pages;

import com.insider.utilities.BrowserUtils;
import static org.junit.Assert.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenPositionsPage extends BasePage {

    @FindBy(xpath = "//select[@id='filter-by-location']")
    public WebElement location_Loc;

    @FindBy(xpath = "//select[@id='filter-by-department']")
    public WebElement department_Loc;

    @FindBy(css = "span.totalResult")
    public WebElement job_Loc;

    @FindBy(xpath = "//a[text()='Apply Now']")
    public List<WebElement> applyNowBut_Loc;

    @FindBy(css = ".position-title.font-weight-bold")
    public List<WebElement> positionList_Loc;

    @FindBy(css = ".position-department.text-large.font-weight-600.text-primary")
    public List<WebElement> departmentList_Loc;

    @FindBy(css = ".position-location.text-large")
    public List<WebElement> locationList_Loc;



    public void dropDown(String location, String department) {

        Select locationDrop = new Select(location_Loc);
        locationDrop.selectByVisibleText(location);
        BrowserUtils.waitFor(1);
        Select departmentDrop = new Select(department_Loc);
        departmentDrop.selectByVisibleText(department);
    }

    public void jobList() {
        BrowserUtils.scrollToElement(job_Loc);
        BrowserUtils.waitForVisibility(job_Loc,5);
        int actualResult = Integer.parseInt(job_Loc.getText());
        assertNotEquals(0,actualResult);
    }

    public void positionCheck(String position1, String position2){
        for (WebElement element : positionList_Loc) {
            assertTrue(element.getText().contains(position1) || element.getText().contains(position2));
        }
    }
    public void departmentCheck(String department){
        for (WebElement element : departmentList_Loc) {
            assertTrue(element.getText().toLowerCase().contains(department.toLowerCase()));
        }
    }
    public void locationCheck(String location){
        for (WebElement element : locationList_Loc) {
            assertTrue(element.getText().toLowerCase().contains(location.toLowerCase()));
        }

    }
    public Map<String,String> getCorrectPosition(int select){

        BrowserUtils.scrollToElement(positionList_Loc.get(select));
        Map<String,String> common= new HashMap<>();
        common.put("positionCheck",positionList_Loc.get(select).getText().toLowerCase());
        common.put("departmentCheck",departmentList_Loc.get(select).getText().toLowerCase());
        common.put("locationCheck",locationList_Loc.get(select).getText().toLowerCase());

        BrowserUtils.waitFor(1);
        applyNowBut_Loc.get(select).click();
        BrowserUtils.getWindowHandle();
        BrowserUtils.waitFor(1);

        return common;
    }



}
