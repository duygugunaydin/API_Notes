package test;

import baseURL.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.TestDataHerOkuApp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_Post_Deserialization extends HerokuAppBaseUrl {
    /*
      https://restful-booker.herokuapp.com/booking url'ine asagidaki
      body'ye sahip bir POST request gonderdigimizde donen response'un
      id haric asagidaki gibi oldugunu test edin.
        Request body
   {
        "firstname" : "Ali",
        "lastname" : "Bak",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
                 "checkin" : "2021-06-01",
                 "checkout" : "2021-06-10"
                          },
        "additionalneeds" : "wi-fi"
    }
       Response Body
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
    TestDataHerOkuApp testDataHerOkuApp = new TestDataHerOkuApp();

    @Test
    public void post01(){

        // 1 -
        specHerokuApp.pathParam("pp1","booking");

        HashMap<String,Object> reqBody= testDataHerOkuApp.requestBodyMap();

        // 2 -
        HashMap<String,Object> expBody= testDataHerOkuApp.expectedBodyMap();

        // 3 -
        Response response = given()
                                    .spec(specHerokuApp)
                                    .contentType(ContentType.JSON)
                            .when()
                                    .body(reqBody).post("/{pp1}");


        response.prettyPrint();

        // 4 - Assertion
        HashMap<String ,Object> respMap = response.as(HashMap.class);

        assertEquals(((Map)(expBody.get("booking"))).get("firstname")        ,((Map)(respMap.get("booking"))).get("firstname"));
        assertEquals(((Map)(expBody.get("booking"))).get("lastname")         ,((Map)(respMap.get("booking"))).get("lastname"));
        assertEquals(((Map)(expBody.get("booking"))).get("totalprice")       ,((Map)(respMap.get("booking"))).get("totalprice"));
        assertEquals(((Map)(expBody.get("booking"))).get("depositpaid")      ,((Map)(respMap.get("booking"))).get("depositpaid"));
        assertEquals(((Map)(expBody.get("booking"))).get("additionalneeds")  ,((Map)(respMap.get("booking"))).get("additionalneeds"));

        assertEquals(((Map)(((Map)(expBody.get("booking"))).get("bookingdates"))).get("checkin")  ,((Map)(((Map)(expBody.get("booking"))).get("bookingdates"))).get("checkin"));
        assertEquals(((Map)(((Map)(expBody.get("booking"))).get("bookingdates"))).get("checkout") ,((Map)(((Map)(expBody.get("booking"))).get("bookingdates"))).get("checkout"));


        // 20  23  2526aynı
    }
}
