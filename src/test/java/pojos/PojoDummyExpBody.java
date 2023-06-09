package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                  // getter(), setter(), toString methodunu olusturur
@NoArgsConstructor     // parametresiz kons olusturur
@AllArgsConstructor    // parametreli kons olusturur
public class PojoDummyExpBody {
    /*
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
     */
    private String status;
    private PojoDummyData data;
    private String message;



}