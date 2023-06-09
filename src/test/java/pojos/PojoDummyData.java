package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                  // getter(), setter(), toString methodunu olusturur,,bunlara>>lombok dependency ile ulasırız
@NoArgsConstructor     // parametresiz kons olusturur
@AllArgsConstructor    // parametreli kons olusturur
public class PojoDummyData {

    /*
    {
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            }
     */

    private int id;
    private String employee_name;
    private int employee_salary;
    private int employee_age;
    private String profile_image;

}