package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_photo")
public class CvPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="photo_link")
    private String photoLink;

    @Column(name="uploaded_date")
    private LocalDate uploadedDate;

    @OneToOne
    @JoinColumn(name = "cv_id")
    @JsonIgnore
    private Cv cv;

}
