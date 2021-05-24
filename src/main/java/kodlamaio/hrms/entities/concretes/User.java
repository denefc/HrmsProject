package kodlamaio.hrms.entities.concretes;


import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public  class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mail")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "verify")
    private boolean verify;

}
