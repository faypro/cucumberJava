package step_definitions;

import comand_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.RealApr;
import java.util.List;
import java.util.Map;

public class MortgageCalculatorSteps {
    WebDriver driver = Hooks.driver;

    @Given("^user is in the mortgage calculator home page$")
    public void navigateToMortgageCalculatorHomePage () {
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }
    @And("^user is navigated to the Real Apr page$")
    public void navigateToRealAprPage() {
        new Home(driver)
                .mouseHoverToRates()
                .navigateToRealApr();
    }
    @When("^user click on the calculate button upon entering the data$")
    public void clickCalculationButtonUponEnteringTheData(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps(String.class, String.class);
        for (Map<String, String> cells: dataTable) {
            new RealApr(driver)
                    .typeHomeValue(cells.get("HomePrice"))
                    .typeDownPayment(cells.get("DownPayment"))
                    .typeInterestRate(cells.get("InterestRate"))
                    .clickOnCalculateButton();
        }
    }
    @Then("^the real apr rate is \"(.+?)\"$")
    public void theRealAprRateIs(String realApr) {
        new RealApr(driver)
                .validatingRealAprRates(realApr);
    }
}
