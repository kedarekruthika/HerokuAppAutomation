package stepdefinitions;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import com.practice.utils.ConfigReader;

public class Hooks {
    @Before
    public void setup() {
        ConfigReader.loadProperties(); // 💥 Add this line
        RestAssured.baseURI = ConfigReader.get("api.base.url");
        RestAssured.config = RestAssured.config()
            .httpClient(RestAssured.config()
                .getHttpClientConfig()
                .setParam("http.connection.timeout", ConfigReader.getTimeout()));
    }
}
