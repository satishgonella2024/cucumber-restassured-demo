package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ApiSteps {

    private Response response;
    private RequestSpecification request;

    @Given("I send a GET request to {string}")
    public void i_send_a_get_request_to(String url) {
        request = given();
        response = request.get(url);
    }

    @Given("I send a POST request to {string} with the following body:")
    public void i_send_a_post_request_to_with_the_following_body(String url, String body) {
        request = given().body(body).header("Content-Type", "application/json");
        response = request.post(url);
    }

    @Given("I send a PUT request to {string} with the following body:")
    public void i_send_a_put_request_to_with_the_following_body(String url, String body) {
        request = given().body(body).header("Content-Type", "application/json");
        response = request.put(url);
    }

    @Given("I send a DELETE request to {string}")
    public void i_send_a_delete_request_to(String url) {
        request = given();
        response = request.delete(url);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response body should contain {string}")
    public void the_response_body_should_contain(String expectedText) {
        String responseBody = response.getBody().asString();
        assertEquals(true, responseBody.contains(expectedText));
    }

    @Then("the response body should contain {string} with value {string}")
    public void the_response_body_should_contain_with_value(String key, String expectedValue) {
        JsonPath jsonPath = new JsonPath(response.getBody().asString());
        String actualValue = jsonPath.getString(key);
        assertEquals(expectedValue, actualValue);
    }
}