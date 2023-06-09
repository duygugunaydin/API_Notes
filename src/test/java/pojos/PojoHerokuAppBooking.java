package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                  // getter(), setter(), toString methodunu olusturur
@NoArgsConstructor     // parametresiz kons olusturur
@AllArgsConstructor    // parametreli kons olusturur
public class PojoHerokuAppBooking {
    /*
    {
    	                "firstname" : "Ali",
    	                "lastname" : “Bak",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }
     */

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;   //  >>  boolean yazarsak> Assertion kısmında dataya isDepozidpaid diyererk ulasırız,WrapperClass'i (Boolean) kullanırsak getDeposidpaid diyerek dataya ulasırız.
    private PojoHerokuAppBookingDates bookingdates;
    private String additionalneeds;

}