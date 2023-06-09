package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataHerOkuApp {

    public int basariliStatusKodu=200;

    public JSONObject requestBodyOlusturmaJson() {


        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin", "2021-06-01");
        bookingDates.put("checkout", "2021-06-10");


        JSONObject reqBody = new JSONObject();

        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", bookingDates);
        reqBody.put("additionalneeds", "wi-fi");

        return reqBody;
    }


        // yukaridakini ben kendim olusturmustum..
    ///////////////////////////////////////////////////////////////////////////////////////////

    public JSONObject requestBodyJson() {

        JSONObject reqBody = new JSONObject();

        reqBody.put("firstname", "Ali");
        reqBody.put("lastname", "Bak");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", bookingdatesJson());
        reqBody.put("additionalneeds", "wi-fi");

        return reqBody;
    }

    public JSONObject bookingdatesJson() {

        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin", "2021-06-01");
        bookingDates.put("checkout", "2021-06-10");

        return bookingDates;
    }

    public JSONObject expectedBodyJson() {

        /*
        Expected Body
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
         */

        JSONObject expBody = new JSONObject();

        expBody.put("bookingid",24);
        expBody.put("booking", requestBodyJson());

        return expBody;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public HashMap bookingdatesMap() {
    /*
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
     */
        HashMap<String,Object> bookingdates = new HashMap<>();

        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        return bookingdates;
    }


    public HashMap requestBodyMap() {
    /*
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
     */
        HashMap<String,Object> booking = new HashMap<>();

        booking.put("firstname","Ali");
        booking.put("lastname","Bak");
        booking.put("totalprice",500.0);
        booking.put("depositpaid",false);
        booking.put("bookingdates",bookingdatesMap());
        booking.put("additionalneeds","wi-fi");

        return booking;
    }

    public HashMap expectedBodyMap() {
    /*
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
        HashMap<String ,Object> expBody = new HashMap<>();

        expBody.put("bookingid",24);
        expBody.put("booking",requestBodyMap());

        return expBody;
    }
}
