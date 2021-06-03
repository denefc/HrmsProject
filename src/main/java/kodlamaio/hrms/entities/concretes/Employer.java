package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisementList"})
public class Employer extends User {


    @Column(name = "company_name")
    private String companyName;

    @Column(name = "website")
    private String website;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name="verification_status")
    private boolean verificationStatus;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisementList;
}
