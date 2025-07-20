package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ProductSteps {

	String baseUrl;
	Response response;

	@Given("base URL is set")
	public void base_url_is_set() {
		baseUrl = "https://dummyjson.com";
	}

	@When("I request product ID {int}")
	public void i_request_product_id(Integer productId) {
	    response = given().baseUri(baseUrl).when().get("/products/" + productId);
	    System.out.println("API Response:\n" + response.prettyPrint());

	}


	@Then("status code should be {int}")
	public void status_code_should_be(Integer expectedStatusCode) {
		Assert.assertEquals(response.getStatusCode(), expectedStatusCode.intValue(), "Status code doesn't match!");
	}

	@And("response should contain product ID {int}")
	public void response_should_contain_product_id(Integer expectedProductId) {
		// Parse JSON and get "id"
		Integer actualId = response.jsonPath().getInt("id");
		Assert.assertEquals(actualId, expectedProductId, "Product ID in response doesn't match!");
	}

}