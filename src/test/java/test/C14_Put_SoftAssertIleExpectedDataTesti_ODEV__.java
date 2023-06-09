package test;

import baseURL.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testData.TestDataDummy;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti_ODEV__ extends DummyBaseUrl {

    /*
    i
          https://dummy.restapiexample.com/api/v1/update/21 url’ine
          asagidaki body’ye sahip bir PUT request gonderdigimizde donen response’un
          asagidaki gibi oldugunu test edin

          Request Body
            {
            "status": "success",
            "data": {
                      "name": “Ahmet",
                      "salary": "1230",
                      "age": "44",
                      "id": 40
                    }
            }

            Response Body
            {
            "status": "success",
            "data": {
                     "status": "success",
                     "data": {
                              "name": “Ahmet",
                              "salary": "1230",
                              "age": "44",
                              "id": 40 }
                     },
            "message": "Successfully! Record has been updated."}
     */

    TestDataDummy dummy = new TestDataDummy();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void put01(){

        // 1 - Url
        specDummy.pathParams("pp1","update","pp2",21);

        JSONObject rqBody = dummy.requestBodyOlusturmaJson();

        // 2 - Expected Data

        // 3 - Response

        Response response = given().spec(specDummy).contentType(ContentType.JSON).when().body(rqBody.toString()).put("/{pp1}/{pp2}");
        response.prettyPrint();

        // 4 - Assertion

        JsonPath respBody = response.jsonPath();
        softAssert.assertEquals(respBody.get("data.status"),rqBody.get("status"));
        softAssert.assertEquals(respBody.get("data.data.name"),rqBody.getJSONObject("data").get("name"));
        softAssert.assertEquals(respBody.get("data.data.salary"),rqBody.getJSONObject("data").get("salary"));
        softAssert.assertEquals(respBody.get("data.data.age"),rqBody.getJSONObject("data").get("age"));
        softAssert.assertEquals(respBody.get("data.data.id"),rqBody.getJSONObject("data").get("id"));

    }
}
