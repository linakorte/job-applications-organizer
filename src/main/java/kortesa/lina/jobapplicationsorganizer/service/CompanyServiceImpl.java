package kortesa.lina.jobapplicationsorganizer.service;

import kortesa.lina.jobapplicationsorganizer.entity.Company;
import kortesa.lina.jobapplicationsorganizer.exception.CompanyNotFoundException;
import kortesa.lina.jobapplicationsorganizer.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService{

    CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompanies() {
        return (List<Company>) companyRepository.findAll();
    }

    @Override
    public Company getCompany(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return unwrapCompany(company, id);
    }

    @Override
    public Company savecompany(Company company) {

        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        Optional<Company> company =  companyRepository.findById(id);
        companyRepository.delete(unwrapCompany(company, id));
    }

    @Override
    public void deleteAllCompanies() {
        companyRepository.deleteAll();
    }

    @Override
    public Company updateCompany(Long id, Company company) {
        Optional<Company> origCompany = companyRepository.findById(id);
        Company unrappedCompany = unwrapCompany(origCompany, id);

        if (company.getCompanyName() != null) {
            unrappedCompany.setCompanyName(company.getCompanyName());
        }
        if (company.getCompanyWebsite() != null) {
            unrappedCompany.setCompanyWebsite(company.getCompanyWebsite());
        }

        return companyRepository.save(unrappedCompany);
    }



    static Company unwrapCompany(Optional<Company> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new CompanyNotFoundException(id);
    }

}
