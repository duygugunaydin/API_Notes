package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C07_Get_BodyTekrarlardanKurtulma {
    /*
                https://restful-booker.herokuapp.com/booking/14018 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve response body’sindeki
                    "firstname“in,"James",
                    ve "lastname“in, "Brown",
                    ve "totalprice“in, 111,
                    ve "depositpaid“in,true,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */
    @Test
    public void get01(){

        // 1 -

        String url = "https://restful-booker.herokuapp.com/booking/10";


        // 2 - Expected data hazirla

        // 3 - Request i kaydet

        Response response = given().when().get(url);

        // 4 - Assertion

        /*

        response
                .then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Mark"),
                        "lastname",Matchers.equalTo("Jackson"),
                        "totalprice",Matchers.equalTo(233),
                        "depositpaid",Matchers.equalTo(false),
                        "additionalneeds",Matchers.nullValue());

         */
        response
                .then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Mark"),
                        "lastname", equalTo("Jackson"),
                        "totalprice", equalTo(233),
                        "depositpaid", equalTo(false),
                        "additionalneeds",nullValue());



    }
}
