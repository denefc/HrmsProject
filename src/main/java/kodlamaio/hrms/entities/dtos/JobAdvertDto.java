package kodlamaio.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {
    private int id;
    private String jobDescription;
    private int minimumSalary;
    private int maximumSalary;
    private int openPositions;
    private LocalDateTime applicationDeadline;
    private boolean isActive;
    private LocalDateTime createdDate;
    private String companyName;
    private String cityName;
}
