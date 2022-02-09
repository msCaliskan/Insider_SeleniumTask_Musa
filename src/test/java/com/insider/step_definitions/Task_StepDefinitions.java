package com.insider.step_definitions;

import com.insider.pages.CareersPage;
import com.insider.pages.HomePage;
import com.insider.pages.LeverAppPage;
import com.insider.pages.OpenPositionsPage;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Task_StepDefinitions {

    Map<String ,String> positionText;
    int select;


    @Given("The user is on the home page and checks Insider page is opened or not")
    public void the_user_is_on_the_home_page_and_checks_Insider_page_is_opened_or_not() {
        new HomePage().gotoHomePage();
        HomePage.checkHomePage();
}

    @Given("The user navigates to {string} tab {string} module")
    public void the_user_navigates_to_tab_module(String tab, String module) {
        HomePage.navigateToModule(tab,module);
    }

    @When("Checks on the Careers Page following blocks are opened or not")
    public void checks_on_the_Careers_Page_following_blocks_are_opened_or_not(List<String> blockListAll) {
       new CareersPage().blockList(blockListAll);
    }

    @When("Scroll to {string} button and click")
    public void click_to(String string) {
        CareersPage.scrollTo(string);

    }

    @Then("Apply filter jobs by Location {string} and department {string}")
    public void apply_filter_jobs_by_Location_and_department(String location, String department) {
        new OpenPositionsPage().dropDown(location,department);

    }

    @Then("Check presence of jobs list")
    public void check_presence_of_jobs_list() {
        new OpenPositionsPage().jobList();
    }
//
    @Then("Check all jobs positions contains {string} or {string}")
    public void check_all_jobs_positions_contains(String position1, String position2) {
        new OpenPositionsPage().positionCheck(position1,position2);
    }

    @Then("Check all departments contains {string}")
    public void check_all_departments_contains(String department) {
        new OpenPositionsPage().departmentCheck(department);
    }

    @Then("Check all locations contains {string}")
    public void check_all_locations_contains(String location) {
        new OpenPositionsPage().locationCheck(location);
    }

    @When("Select one of the positions listed check correct position page is opened")
    public void select_one_of_the_positions_listed_check_correct_position_page_is_opened() {
        Random rn = new Random();
        select = rn.nextInt(new OpenPositionsPage().applyNowBut_Loc.size());
        positionText = new OpenPositionsPage().getCorrectPosition(select);
        new LeverAppPage().verifyInformation(positionText);
    }

    @Then("Check presence of job description, requirements and {string} button")
    public void check_presence_of_job_description_requirements_and_button(String string) {
        new LeverAppPage().verifyJobs(string);
    }

    @Then("Click {string} button and check that this action redirects us to Lever Application form page")
    public void click_button_and_check_that_this_action_redirects_us_to_Lever_Application_form_page(String button) {
        new LeverAppPage().checkLeverPage(button);
    }



}
