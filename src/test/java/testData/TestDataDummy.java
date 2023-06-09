package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataDummy {

    public int basariliStatusKodu=200;
    public JSONObject requestBodyOlusturmaJson(){

        JSONObject data = new JSONObject();

        data.put("name","Ahmet");
        data.put("salary","1230");
        data.put("age","44");
        data.put("id","40");


        JSONObject expectedData = new JSONObject();

        expectedData.put("status","success");
        expectedData.put("data",data);

        return expectedData;
    }

    public JSONObject expectedBodyOlusturmaJson(){
        /*
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

        JSONObject data = new JSONObject();

        data.put("id","40");
        data.put("employee_name","Ahmet");
        data.put("employee_salary","1230");
        data.put("employee_age","44");
        data.put("profile_image","");


        JSONObject expectedData = new JSONObject();

        expectedData.put("status","success");
        expectedData.put("data",data);
        expectedData.put("message","Successfully! Record has been fetched.");

        return expectedData;

    }

    public HashMap expectedBodyOlusturmaMap(){
        /*
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

        HashMap<String ,Object> data = new HashMap<>();

        data.put("id","40");
        data.put("employee_name","Ahmet");
        data.put("employee_salary","1230");
        data.put("employee_age","44");
        data.put("profile_image","");


        HashMap<String ,Object> expectedData = new HashMap<>();

        expectedData.put("status","success");
        expectedData.put("data",data);
        expectedData.put("message","Successfully! Record has been fetched.");

        return expectedData;

    }
}
