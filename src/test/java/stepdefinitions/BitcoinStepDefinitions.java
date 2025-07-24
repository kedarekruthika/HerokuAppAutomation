package stepdefinitions;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class BitcoinStepDefinitions {

    private Response response;

    @Given("the CoinGecko Bitcoin API is available")
    public void the_api_is_available() {
        baseURI = "https://api.coingecko.com/api/v3";
    }

    @When("I send a GET request to the bitcoin endpoint")
    public void i_send_get_request() {
        response = given()
                        .log().all()
                   .when()
                        .get("/coins/bitcoin")
                   .then()
                        .log().all()
                        .extract()
                        .response();

        assertEquals(response.getStatusCode(), 200, "Status code is not 200");
    }

    @Then("the response should contain BPI currencies as USD, GBP, and EUR")
    public void validate_bpi_currencies() {
        Double usd = response.jsonPath().getDouble("market_data.current_price.usd");
        Double gbp = response.jsonPath().getDouble("market_data.current_price.gbp");
        Double eur = response.jsonPath().getDouble("market_data.current_price.eur");

        assertNotNull(usd, "USD not found");
        assertNotNull(gbp, "GBP not found");
        assertNotNull(eur, "EUR not found");

        System.out.println("\n Current Prices:");
        System.out.println("USD: " + usd);
        System.out.println("GBP: " + gbp);
        System.out.println("EUR: " + eur);
    }

    @Then("the market cap should be present for all 3 currencies")
    public void validate_market_cap() {
        Double marketCapUSD = response.jsonPath().getDouble("market_data.market_cap.usd");
        Double marketCapGBP = response.jsonPath().getDouble("market_data.market_cap.gbp");
        Double marketCapEUR = response.jsonPath().getDouble("market_data.market_cap.eur");

        assertNotNull(marketCapUSD, "Market cap USD missing");
        assertNotNull(marketCapGBP, "Market cap GBP missing");
        assertNotNull(marketCapEUR, "Market cap EUR missing");

        System.out.println("\n Market Cap:");
        System.out.println("USD: " + marketCapUSD);
        System.out.println("GBP: " + marketCapGBP);
        System.out.println("EUR: " + marketCapEUR);
    }

    @Then("the total volume should be present for all 3 currencies")
    public void validate_total_volume() {
        Double volumeUSD = response.jsonPath().getDouble("market_data.total_volume.usd");
        Double volumeGBP = response.jsonPath().getDouble("market_data.total_volume.gbp");
        Double volumeEUR = response.jsonPath().getDouble("market_data.total_volume.eur");

        assertNotNull(volumeUSD, "Total volume USD missing");
        assertNotNull(volumeGBP, "Total volume GBP missing");
        assertNotNull(volumeEUR, "Total volume EUR missing");

        System.out.println("\n Total Volume:");
        System.out.println("USD: " + volumeUSD);
        System.out.println("GBP: " + volumeGBP);
        System.out.println("EUR: " + volumeEUR);
    }

    @Then("the price change percentage over the last 24 hours should be available")
    public void validate_price_change_percentage() {
        Double priceChange24h = response.jsonPath().getDouble("market_data.price_change_percentage_24h");
        assertNotNull(priceChange24h, "Price change 24h missing");

        System.out.println("\n Price Change (24h): " + priceChange24h + "%");
    }

    @Then("the homepage URL should not be empty")
    public void validate_homepage_url() {
        String homepage = response.jsonPath().getString("links.homepage[0]");
        assertNotNull(homepage, "Homepage URL is null");
        assertFalse(homepage.isEmpty(), "Homepage URL is empty");

        System.out.println("\n Homepage URL: " + homepage);
    }
}
