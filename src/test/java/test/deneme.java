package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class deneme {
    @Test
    public void post01(){

        // 1 - Request icin gerekli url ve body hazırla

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject jsonObjeBookingdates= new JSONObject();
        JSONObject jsonObje= new JSONObject();

        jsonObjeBookingdates.put("checkin","2018-01-01");
        jsonObjeBookingdates.put("checkout","2019-01-01");

        jsonObje.put("firstname","duygu");
        jsonObje.put("additionalneeds","Breakfast");
        jsonObje.put("bookingdates",jsonObjeBookingdates);
        jsonObje.put("totalprice",111);
        jsonObje.put("depositpaid",true);
        jsonObje.put("lastname","Brownnnn");

        // 2 - Expected data hazirla

        // 3 - Response i kaydet

        Response response= given().contentType(ContentType.JSON)
                .when().body(jsonObje.toString()).post(url);


        // 4 - Assertion


    }
}
