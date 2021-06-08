package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class SchoolSortedWithCandidate {

    private int id;
    private String candidateFirstName;
    private String candidateLastName;
    private String schoolName;
    private String graduateYear;

    public void setGraduateYear(String graduateYear) throws ParseException {
        if (graduateYear==null){
            graduateYear="Hala okuyor";
        }else{


        }
    }

}
