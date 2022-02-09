package com.insider.pages;

import com.insider.utilities.BrowserUtils;
import com.insider.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CareersPage extends BasePage{

    @FindBy(xpath = "//div[@class='elementor-column-wrap elementor-element-populated']//h2")
    public List<WebElement> blockList1;

    @FindBy(xpath = "//div[@class='elementor-column-wrap elementor-element-populated']//h3")
    public List<WebElement> blockList2;

    List<String> allList = new ArrayList<>();
    public void blockList(List<String> blockListAll){

        for (WebElement element : blockList1) {
            allList.add(element.getText());
        }

        for (WebElement element2 : blockList2) {
            allList.add(element2.getText());
        }
        Assert.assertTrue(allList.containsAll(blockListAll));

    }

    public static void scrollTo(String string){
        WebElement jobButton = Driver.get().findElement(By.xpath("(//*[.='"+string+"'])[2]"));
        BrowserUtils.clickWithJS(jobButton);
        BrowserUtils.waitFor(1);
    }


}
