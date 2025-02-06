package stepsdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import manager.WebDriverManager;
import pages.CheckoutInformationPage;

import java.util.Map;

public class CheckoutInformationSteps {

    private final CheckoutInformationPage checkoutInformationPage;

    public CheckoutInformationSteps() {
        this.checkoutInformationPage = new CheckoutInformationPage(WebDriverManager.getDriver());
    }

    @And("the user fill the personal information form")
    public void userFillPersonalInformationForm(DataTable dataTable) {
        Map<String, String> personalInfo = dataTable.asMaps(String.class, String.class).get(0);
        checkoutInformationPage.fillPersonalInformationForm(personalInfo.get("firstName"), personalInfo.get("lastName"), personalInfo.get("postalCode"));
    }
}
