package kortesa.lina.jobapplicationsorganizer.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company", uniqueConstraints = @UniqueConstraint(columnNames = "company_name"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Insert Company Name")
    @Column(name = "company_name", unique = true)
    private String companyName;

    @URL
    @Column(name = "company_website")
    private String companyWebsite;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs = new ArrayList<>();

}
