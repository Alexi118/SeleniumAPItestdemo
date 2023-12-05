package day1;

import groovy.json.JsonToken;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTPRequests{
    int id;
    @Test
    void getUserGET(){
        given()
        .when()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .log().all();
    }
    @Test
    void creatUserPOST_usingExternalJSONFile() throws FileNotFoundException {
        File f =new File(".\\user.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);

        id = given()
                .contentType("application/json")
                .body(data.toString())
        .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
//        .then()
//                .statusCode(201)
//                .log().all();
    }
    @Test
    void updateUserPUT(){
        given()
        .when()
        .then();
    }
}