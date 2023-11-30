package kortesa.lina.jobapplicationsorganizer.repository;

import kortesa.lina.jobapplicationsorganizer.entity.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    Optional<Company> findByCompanyName(String companyName);
}
