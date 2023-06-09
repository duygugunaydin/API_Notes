package test;

import baseURL.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataHerOkuApp;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_Post_TestDataKullanimi extends HerokuAppBaseUrl {
    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip
    bir POST request gonderdigimizde donen response’un status kodunu ve id haric
    body'sinin asagidaki gibi oldugunu test edin.
    Request body
          {
          "firstname" : "Ali",
          "lastname" : “Bak",
          "totalprice" : 500,
          "depositpaid" : false,
          "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                        },
          "additionalneeds" : "wi-fi"
           }
    Expected Body
    {
    "bookingid":24,
    "booking":{
            "firstname":"Ali",
            "lastname":"Bak",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                            },
            "additionalneeds":"wi-fi"
               }
    }
     */

    TestDataHerOkuApp herOkuApp = new TestDataHerOkuApp();

    @Test
    public void post01(){

        // 1 - Url Body

        specHerokuApp.pathParam("pp1","booking");

        JSONObject reqBody = herOkuApp.requestBodyJson();

        // 2 - Expected Data

        JSONObject expectedData = herOkuApp.expectedBodyJson();

        // 3 - Response'u kaydet

        Response response = given()
                                    .contentType(ContentType.JSON)
                                    .spec(specHerokuApp)
                            .when()
                                    .body(reqBody.toString())
                                    .post("/{pp1}");

        response.prettyPrint();

        // 4 - Assertion

        JsonPath resJP = response.jsonPath();

        assertEquals(herOkuApp.basariliStatusKodu,response.getStatusCode());
        assertEquals(expectedData.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJP.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resJP.get("booking.bookingdates.checkout"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));

    }
}
