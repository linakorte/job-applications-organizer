package kortesa.lina.jobapplicationsorganizer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job", uniqueConstraints = @UniqueConstraint(columnNames = "job_reference"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Insert Company Name")
    @Column(name = "company_name")
    private String companyName;

    @NotBlank(message = "Insert Job Title")
    @Column(name = "job_position")
    private String jobPosition;

    @URL
    @NotBlank(message = "Insert Job Reference")
    @Column(name = "job_reference")
    private String jobReference;

    @NotBlank(message = "How did you apply?")
    @Column(name = "application_means")
    private String applicationMeans;


    @Past(message = "Application Date must be in the past")
    @Column(name = "application_date")
    private LocalDate applicationDate;

    @NotBlank(message = "Insert status")
    @Column(name = "status")
    private String status;

    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;



}
