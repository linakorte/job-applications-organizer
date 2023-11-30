package kortesa.lina.jobapplicationsorganizer.service;

import kortesa.lina.jobapplicationsorganizer.entity.Company;
import kortesa.lina.jobapplicationsorganizer.entity.Job;
import kortesa.lina.jobapplicationsorganizer.exception.JobNotFoundException;
import kortesa.lina.jobapplicationsorganizer.repository.CompanyRepository;
import kortesa.lina.jobapplicationsorganizer.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;
    CompanyRepository companyRepository;

    @Override
    public List<Job> getAllJobs() {

        return (List<Job>) jobRepository.findAll();
    }

    @Override
    public Job getJob(Long id) {
        Optional<Job> job = jobRepository.findById(id);
        return unwrapJob(job, id);
    }

    @Override
    public Job saveJob(Job job) {

        String companyName = job.getCompanyName();
        Optional<Company> companyOptional = companyRepository.findByCompanyName(companyName);
        Company company;
        if (companyOptional.isPresent()) {
            company = companyOptional.get();
        } else {
            company = new Company();
            company.setCompanyName(companyName);
            company = companyRepository.save(company);
        }
        job.setCompany(company);
        company.getJobs().add(job);

        return jobRepository.save(job);
    }

    @Override
    public void deleteJob(Long id) {
        Optional<Job> job = jobRepository.findById(id);
        jobRepository.delete(unwrapJob(job, id));
    }

    @Override
    public void deleteAllJobs() {
        jobRepository.deleteAll();
    }

    @Override
    public List<Job> getCompanyJobs(Long companyId) {
        return jobRepository.findByCompanyId(companyId);
    }

    @Override
    public Job updateJob(Long id, Job job) {
        Optional<Job> origJob = jobRepository.findById(id);
        Job unwrappedJob = unwrapJob(origJob, id);

        String newCompanyName = job.getCompanyName();

        if(newCompanyName != null && !newCompanyName.equals(unwrappedJob.getCompanyName())) {
            Optional<Company> companyOptional = companyRepository.findByCompanyName(newCompanyName);

            Company company;
            if (companyOptional.isPresent()) {
                company = companyOptional.get();
            } else {
                company = new Company();
                company.setCompanyName(newCompanyName);
                company = companyRepository.save(company);
            }
            unwrappedJob.setCompany(company);
        }

        if (job.getCompanyName() != null) {
            unwrappedJob.setCompanyName(job.getCompanyName());
        }
        if (job.getJobPosition() != null) {
            unwrappedJob.setJobPosition(job.getJobPosition());
        }
        if (job.getJobReference() != null) {
            unwrappedJob.setJobReference(job.getJobReference());
        }
        if (job.getApplicationMeans() != null) {
            unwrappedJob.setApplicationMeans(job.getApplicationMeans());
        }
        if (job.getApplicationDate() != null) {
            unwrappedJob.setApplicationDate(job.getApplicationDate());
        }
        if (job.getStatus() != null) {
            unwrappedJob.setStatus(job.getStatus());
        }
        if (job.getNotes() != null) {
            unwrappedJob.setNotes(job.getNotes());
        }
        return jobRepository.save(unwrappedJob);

    }


    static Job unwrapJob(Optional<Job> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new JobNotFoundException(id);
    }
}
