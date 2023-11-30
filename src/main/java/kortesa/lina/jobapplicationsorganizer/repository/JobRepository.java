package kortesa.lina.jobapplicationsorganizer.repository;

import kortesa.lina.jobapplicationsorganizer.entity.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface JobRepository extends CrudRepository<Job, Long> {
    List<Job> findByCompanyId(Long companyId);
}
