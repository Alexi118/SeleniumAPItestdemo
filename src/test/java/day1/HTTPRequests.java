package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class HTTPRequests{
    @Test
    void getUserGET(){
        given()
        .when()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .body("per_page",equalTo(6))
                .log().all();
    }
    @Test
    void creatUserPOST(){
        given()
        .when()
        .then();
    }
}