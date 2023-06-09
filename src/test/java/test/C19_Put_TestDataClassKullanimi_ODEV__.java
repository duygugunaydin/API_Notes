package test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C19_Put_TestDataClassKullanimi_ODEV__ extends JsonPlaceHolderBaseURL {

    /*
            https://jsonplaceholder.typicode.com/posts/70 url'ine
            asagidaki body’e sahip bir PUT request yolladigimizda donen response’in
            Request Body
            {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
            }

            status kodunun 200,
            content type’inin “application/json charset=utf-8”,
            Connection header degerinin “keep-alive”
            response body’sinin asagida verilen ile ayni oldugunu test ediniz
            Expected Data :
            {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
            }

     */

    TestDataJsonPlaceHolder jsonPlaceHolder=new TestDataJsonPlaceHolder();

    @Test
    public void put01(){

        // 1 -
        specJsonPlace.pathParams("pp1","posts","pp2",70);

        JSONObject rqBody = jsonPlaceHolder.reqBodyOlusturJson("Ahmet","Merhaba",10,70);

        // 2 -

        JSONObject expData = jsonPlaceHolder.expBodyOlusturJson("Ahmet","Merhaba",10,70);

        // 3 -
        Response response = given().contentType(ContentType.JSON).spec(specJsonPlace)
                            .when().body(rqBody.toString()).put("/{pp1}/{pp2}");
        response.prettyPrint();

        // 4 -
        JsonPath respJP=response.jsonPath();
        assertEquals(jsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        assertEquals(jsonPlaceHolder.contentType,response.getContentType());
        assertEquals(jsonPlaceHolder.header,response.getHeader("Connection"));
        assertEquals(expData.get("title"),respJP.get("title"));
        assertEquals(expData.get("body"),respJP.get("body"));
        assertEquals(expData.get("userId"),respJP.get("userId"));
        assertEquals(expData.get("id"),respJP.get("id"));

    }
}
