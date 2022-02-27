package com.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.page.objects.CartPage;
import com.page.objects.HomePage;
import com.page.objects.ProductsListingPage;
import com.utilities.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends Utility {

    public StepDefinitions(WebDriver driverInstance) {
        super(driverInstance);
    }

    public StepDefinitions() {

    }

    @Given("I launch the app {string}")
    public void i_launch_the_flipkart_app(String app) throws Exception {
        try {
            System.out.println("::" + System.getProperty("environment"));
            HomePage.openApp();
        } catch (Exception e) {
            throw e;
        }
    }

    @Given("I find the homepage loaded")
    public void i_find_the_homepage_loaded() {
        try {
            HomePage.launchHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I click on ViewAll button")
    public void i_click_on_view_all_button() {
        HomePage.clickViewAllButton();
    }

    @Then("I verify product listing page loaded")
    public void i_verify_product_listing_page_loaded() {
        ProductsListingPage.verifyProductsPage();
    }

    @When("I search for an {string} from search field")
    public void i_search_for_an_from_search_field(String searchItem) {
        ProductsListingPage.searchItem(searchItem);
    }

    @Then("I verify the product listing page based on the search {string}")
    public void i_verify_the_product_listing_page_based_on_the_search(String string) {
        ProductsListingPage.verifyProductsPageOnSearch(string);
    }

    @Then("I verify the filter option on the product listing page")
    public void i_verify_the_filter_option_on_the_product_listing_page() {
        ProductsListingPage.verifyFilter();
    }

    @When("I click on a product from the product listing page")
    public void i_click_on_a_product_from_the_product_listing_page() {
        ProductsListingPage.clickOnProduct();
    }

    @Then("I verify the product description")
    public void i_verify_the_product_description() {
        ProductsListingPage.verifyProductDescription();
    }

    @Then("I verify the seller rating")
    public void i_verify_the_seller_rating() {
        ProductsListingPage.verifySeller();
    }

    @When("I add two products to the cart")
    public void i_add_two_products_to_the_cart() {
        CartPage.addProductsToCart();
    }

    @Then("I find the cart count is {string}")
    public void i_find_the_cart_count_is(String cartCount) {
        CartPage.verifyCartCount(cartCount);
    }

    @When("I delete one product from the cart")
    public void i_delete_one_product_from_the_cart() {
        CartPage.deleteItemFromCart();
    }

    @Then("I verify cart count is decreased to {int}")
    public void i_verify_cart_count_is_decreased_to(Integer cartCount) {
        CartPage.verifyCartAfterDeletion(cartCount);
    }

//    @Given("^I have a fruit||vegatable \"([^\"]*)\" whose price is (\\d+)$")
//    public void i_have_a_fruit_something_whose_price_is_(String fruit, int price) throws Throwable {
//        System.out.println("fruit or veg: " + fruit);
//        System.out.println("original price: " + price);
//    }

    @When("^I sell it in the shop$")
    public void i_sell_it_in_the_shop() throws Throwable {
        System.out.println("fruit or veg sold out");
    }

    @Then("^I get double the price (\\d+)$")
    public void i_get_double_the_price_(String finalPrice) throws Throwable {
        System.out.println("final Price: " + finalPrice);
    }

}
