package kortesa.lina.jobapplicationsorganizer.service;

import kortesa.lina.jobapplicationsorganizer.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();

    Job getJob(Long id);

    Job saveJob(Job job);

    void deleteJob(Long id);

    Job updateJob(Long id, Job job);

    void deleteAllJobs();

    List<Job> getCompanyJobs(Long companyId);
}
