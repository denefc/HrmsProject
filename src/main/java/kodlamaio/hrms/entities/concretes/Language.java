package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="language")
    private String language;

    @Column(name="language_level")
    private int languageLevel;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    @JsonIgnore
    private Cv cv;
}
