package kortesa.lina.jobapplicationsorganizer.service;

import kortesa.lina.jobapplicationsorganizer.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getCompany(Long id);
    Company savecompany(Company company);
    void deleteCompany(Long id);
    Company updateCompany(Long id, Company company);

    void deleteAllCompanies();
}
