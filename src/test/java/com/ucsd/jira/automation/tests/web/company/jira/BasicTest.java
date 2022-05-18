package com.ucsd.jira.automation.tests.web.company.jira;

import com.pwc.core.framework.annotations.Issue;
import com.pwc.core.framework.listeners.Retry;
import com.ucsd.jira.automation.data.Constants;
import com.ucsd.jira.automation.frameworksupport.Groups;
import com.ucsd.jira.automation.frameworksupport.JiraTestCase;
import org.testng.annotations.Test;

import static com.pwc.logging.service.LoggerService.*;


public class BasicTest extends JiraTestCase {

    @Override
    public void beforeMethod() {
    }

    @Override
    public void afterMethod() {
    }

    @Issue("STORY-1234")
    @Test(retryAnalyzer = Retry.class, groups = {Groups.ACCEPTANCE_TEST})
    public void testBasic() {

        FEATURE("Basic Jira Test sneak developer");
        SCENARIO("User logs in and validates basic navigation functionality");

        GIVEN("I am a valid user");
        webElementVisible(Constants.NEW_TEST_HEADING); //More Button visible

        WHEN("I navigate with the left menu");
        webAction(Constants.ISSUES_AND_FILTERS_DIV); //Click Projects Button
//        redirect(Constants.HOME_URL);

//        THEN("The expected pages are displayed");
//        webAction(Constants.DASHBOARD_DIV); //View All Project

        redirect(Constants.HOME_URL);
        GIVEN("I am filtered out");
        webElementVisible(Constants.NEW_NAME);

        GIVEN("Create Filter");
        webAction(Constants.CREATE_FILTER); //Create Filter

        WHEN("Open Issue");
        webAction(Constants.OPEN_ISSUE); //Open Issue

        THEN("We can see Open Issues Header");
        webElementVisible(Constants.OPEN_ISSUES_HEADER); //View All Project

        redirect(Constants.MAIN_URL);
        GIVEN("Main Screen");
        webElementVisible(Constants.ISSUES_AND_FILTERS_DIV);

        redirect(Constants.PEOPLE_URL);
        GIVEN("Invite People Screen");
        webElementVisible(Constants.ADD_PEOPLE);
    }

}
