package test;

import baseURL.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataHerOkuApp;

import static io.restassured.RestAssured.given;

public class C16_BaseUrlHerokuapp_ODEV__ extends HerokuAppBaseUrl {
     /*

         Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin

         1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
            gonderdigimizde donen response’un status code’unun 200 oldugunu ve
            Response’ta 12 booking oldugunu test edin

         2- https://restful-booker.herokuapp.com/booking
            endpointine asagidaki body’ye sahip bir POST
            request gonderdigimizde donen response’un
            status code’unun 200 oldugunu ve “firstname”
            degerinin “Ahmet” oldugunu test edin
     */

    @Test
    public void get01(){

        /*
            1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
               gonderdigimizde donen response’un status code’unun 200 oldugunu ve
               Response’ta 12 booking oldugunu test edin
        */

        // 1 -
        specHerokuApp.pathParam("pp1","booking");

        // 2 -

        // 3 -
        Response response = given().spec(specHerokuApp).when().get("/{pp1}");
        response.prettyPrint();

        // 4 -
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(12));
    }
    @Test
    public void post01(){

        /*
            2- https://restful-booker.herokuapp.com/booking
               endpointine asagidaki body’ye sahip bir POST
               request gonderdigimizde donen response’un
               status code’unun 200 oldugunu ve “firstname”
               degerinin “Ahmet” oldugunu test edin

               {
                  "firstname" : "Ahmet",
                  "lastname" : “Bulut",
                  "totalprice" : 500,
                  "depositpaid" : false,
                  "bookingdates" : {
                  "checkin" : "2021-06-01",
                  "checkout" : "2021-06-10"
               },
                  "additionalneeds" : "wi-fi"
               }

         */
        TestDataHerOkuApp herOkuApp = new TestDataHerOkuApp();

        // 1 -
        specHerokuApp.pathParam("pp1","booking");

        JSONObject rqBody = herOkuApp.requestBodyOlusturmaJson();

        // 2 -

        // 3 -
        Response response = given()
                                .contentType(ContentType.JSON)
                                .spec(specHerokuApp)
                           .when()
                                .body(rqBody.toString())
                                .post("/{pp1}");

        response.prettyPrint();

        // 4 -
        response.then().assertThat()
                .statusCode(200)
                .body("booking.firstname",Matchers.equalTo("Ahmet"));
    }
}
