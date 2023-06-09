package test;

import baseURL.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testData.TestDataDummy;

import static io.restassured.RestAssured.given;

public class C20_Get_TestDataKullanimi_ODEV__ extends DummyBaseUrl {
    /*

          http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
          gonderdigimizde donen response’un status code’unun 200, content Type’inin
          application/json ve body’sinin asagidaki gibi oldugunu test edin.
          Response Body
             {
             "status": "success",
             "data": {
                      "id": 3,
                      "employee_name": "Ashton Cox",
                      "employee_salary": 86000,
                      "employee_age": 66,
                      "profile_image": ""
                      },
             "message": "Successfully! Record has been fetched."
          }
     */

    TestDataDummy testDataDummy = new TestDataDummy();
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void get01(){

        specDummy.pathParams("pp1","employee","pp2",3);

        JSONObject expectedData = testDataDummy.expectedBodyOlusturmaJson();

        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}");
        response.prettyPrint();

        JsonPath respJP = response.jsonPath();

        softAssert.assertEquals(testDataDummy.basariliStatusKodu,response.getStatusCode());
        softAssert.assertEquals(expectedData.get("status"),respJP.get("status"));
        //softAssert.assertEquals(expectedData.getJSONObject("data").get("id"),respJP.get("data.id"));
        softAssert.assertEquals(expectedData.getJSONObject("data").get("employee_name"),respJP.get("data.employee_name"));
        softAssert.assertEquals(expectedData.getJSONObject("data").get("employee_salary"),respJP.get("data.employee_salary"));
        softAssert.assertEquals(expectedData.getJSONObject("data").get("employee_age"),respJP.get("data.employee_age"));
        softAssert.assertEquals(expectedData.getJSONObject("data").get("profile_image"),respJP.get("data.profile_image"));
        softAssert.assertEquals(expectedData.get("message"),respJP.get("message"));

        softAssert.assertAll();

    }
}
