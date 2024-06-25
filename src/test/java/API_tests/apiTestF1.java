package API_tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class apiTestF1 {

    String baseUrl = "https://ergast.com/api/f1";

    @Test
    public void lastResultReturns200 () {

        RestAssured.baseURI = baseUrl ;

        given()
                .when()
                .get("/current/last/results.json")
                .then().log().everything() //dit is niet persee nodig, maar geeft je de results
                .statusCode(200);
    }

    @Test
    public void checkLastRace () {

        RestAssured.baseURI = baseUrl;

        given()
                .when()
                .get("/current/last/results.json")
                .then()
                .statusCode(200)
                .body("MRData.RaceTable.Races.raceName", contains("Spanish Grand Prix"));
    }

    @Test
    public void getToken () {

        String username = "trainee1@polteq.com";
        String password = "1AmAPolteqTrainee1";

        String token = given()
                .baseUri("https://vgp-shop.polteq-testing.com/wp-json/jwt-auth/v1/token")
                .when()
                    .formParam("username" , username)
                    .and().formParam("password", password)
                    .and().post()
                .then()
                    .log().everything()
                    .extract().body().jsonPath().getString("token");

        System.out.println(token);
    }
}
