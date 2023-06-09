package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JSONObjectVerileriCagirma {
        /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
    },
    "phoneNumbers": [
        {
            "type": "iPhone",
            "number": "0123-4567-8888"
        },
        {
            "type": "home",
            "number": "0123-4567-8910"
        }
    ]
}
     */

    @Test
    public void json(){
        JSONObject address = new JSONObject();
        address.put("streetAddress","naist street").put("city","Nara").put("postalCode","630-0192");

        JSONObject cepTel = new JSONObject();
         cepTel.put("type","iPhone").put("number","0123-4567-8888");

        JSONObject evTel = new JSONObject();
        evTel.put("type","home").put("number","0123-4567-8910");

        JSONArray phoneNumbers = new JSONArray();
        phoneNumbers.put(0,evTel).put(1,cepTel);

        //

        JSONObject kisiBilgisi = new JSONObject();

        kisiBilgisi.put("firstName","John")
                .put("lastName","doe")
                .put("age",26)
                .put("address",address)
                .put("phoneNumbers",phoneNumbers);

        System.out.println("kisiBilgisi = " + kisiBilgisi);

        //

        System.out.println("Isim = " + kisiBilgisi.get("firstName"));
        System.out.println("lastName = " + kisiBilgisi.get("lastName"));
        System.out.println("age = " + kisiBilgisi.get("age"));
        System.out.println("address = " + kisiBilgisi.get("address"));
        System.out.println("phoneNumbers = " + kisiBilgisi.get("phoneNumbers"));


        System.out.println("address/streetAddress = " + kisiBilgisi.getJSONObject("address").get("streetAddress"));
        System.out.println("address/city = " + kisiBilgisi.getJSONObject("address").get("city"));
        System.out.println("address/postalCode = " + kisiBilgisi.getJSONObject("address").get("postalCode"));


        System.out.println("Phone Type = " + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));
        System.out.println("Phone Number = " + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        System.out.println("Phone Type = " + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(1).get("type"));
        System.out.println("Phone Number = " + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));


    }
}
