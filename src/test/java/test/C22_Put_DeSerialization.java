package test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaseURL {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data :
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */

    TestDataJsonPlaceHolder jsonPlaceHolder = new TestDataJsonPlaceHolder();
    @Test
    public void put(){

        // 1 - Url Body
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        HashMap<String,Object> reqBody =jsonPlaceHolder.requestBodyMap();


        // 2 - Expected Data

        HashMap<String,Object> expBody =jsonPlaceHolder.requestBodyMap();

        // 3

        Response response = given().contentType(ContentType.JSON).spec(specJsonPlace).when().body(reqBody).put("/{pp1}/{pp2}");

        response.prettyPeek();

        // 4 -

        HashMap<String , Object> respMap = response.as(HashMap.class);

        assertEquals(jsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        assertEquals(expBody.get("title"),respMap.get("title"));
        assertEquals(expBody.get("body"),respMap.get("body"));
        assertEquals(expBody.get("userId"),respMap.get("userId"));
        assertEquals(expBody.get("id"),respMap.get("id"));



    }
}
