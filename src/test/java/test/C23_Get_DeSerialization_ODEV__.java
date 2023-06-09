package test;

import baseURL.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testData.TestDataDummy;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C23_Get_DeSerialization_ODEV__ extends DummyBaseUrl {
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
    public void get(){

        specDummy.pathParams("pp1","employee","pp2",3);

        HashMap<String ,Object> expData= testDataDummy.expectedBodyOlusturmaMap();

        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}");
        response.prettyPrint();

        HashMap<String ,Object> respMap = response.as(HashMap.class);


        softAssert.assertEquals(respMap.get("status"),expData.get("status"));

        softAssert.assertEquals( ((Map)(respMap.get("data"))).get("id")                          , ((Map)(expData.get("data"))).get("id") );
        softAssert.assertEquals( ((Map)(respMap.get("data"))).get("employee_name")               , ((Map)(expData.get("data"))).get("employee_name") );
        softAssert.assertEquals( ((Map)(respMap.get("data"))).get("employee_ageemployee_salary") , ((Map)(expData.get("data"))).get("employee_ageemployee_salary") );
        softAssert.assertEquals( ((Map)(respMap.get("data"))).get("employee_age")                , ((Map)(expData.get("data"))).get("employee_age") );
        softAssert.assertEquals( ((Map)(respMap.get("data"))).get("profile_image")               , ((Map)(expData.get("data"))).get("profile_image") );

        softAssert.assertEquals(respMap.get("message"),expData.get("message"));

        softAssert.assertAll();
    }
}
