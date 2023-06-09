package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataJsonPlaceHolder {

    public int basariliStatusCode = 200;
    public String contentType = "application/json; charset=utf-8";
    public String header = "keep-alive";

    public JSONObject expectedBodyJson(){

        /*
        {
            "userId":3,
            "id":22,
            "title":"dolor sint quo a velit explicabo quia nam",
            "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
            um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
         */

        JSONObject expBody = new JSONObject();

        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expBody;
    }
    public HashMap requestBodyMap(){

        /*
        Request Body
            {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
            }
         */

        HashMap<String, Object> rqBody = new HashMap<>();

        rqBody.put("title","Ahmet");
        rqBody.put("body","Merhaba");
        rqBody.put("userId",10.0);
        rqBody.put("id",70.0);


        return rqBody;
    }




    //////////////////////////////////////////////////////////////////////////////
    // asagidakini dersten ayri kendime yaptim

    public JSONObject expBodyOlusturJson(String title, String body, int userid, int id){

        /*
        {
            "userId":3,
            "id":22,
            "title":"dolor sint quo a velit explicabo quia nam",
            "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
            um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
         */

        JSONObject expBody = new JSONObject();

        expBody.put("title",title);
        expBody.put("body",body);
        expBody.put("userId",userid);
        expBody.put("id",id);

        return expBody;
    }

    public JSONObject reqBodyOlusturJson(String title, String body, int userid, int id){

        /*
        Request Body
            {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
            }
         */

        JSONObject rqBody = new JSONObject();

        rqBody.put("title",title);
        rqBody.put("body",body);
        rqBody.put("userId",userid);
        rqBody.put("id",id);

        return rqBody;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////




}