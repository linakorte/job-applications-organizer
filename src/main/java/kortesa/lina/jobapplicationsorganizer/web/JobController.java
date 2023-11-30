package kortesa.lina.jobapplicationsorganizer.web;

import jakarta.validation.Valid;
import kortesa.lina.jobapplicationsorganizer.entity.Job;
import kortesa.lina.jobapplicationsorganizer.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("/all")
    public ResponseEntity<List<Job>> getAllJobs() {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJob(@PathVariable Long id) {
        return new ResponseEntity<>(jobService.getJob(id), HttpStatus.OK);
    }

    @GetMapping("/company/{company_id}")
    public ResponseEntity<List<Job>> getCompanyJobs(@PathVariable Long company_id) {
        return new ResponseEntity<>(jobService.getCompanyJobs(company_id), HttpStatus.OK);
    }

    @PostMapping("/addJob")
    public ResponseEntity<Job> saveJob(@Valid @RequestBody Job job) {
        return new ResponseEntity<>(jobService.saveJob(job), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job job) {
        return new ResponseEntity<>(jobService.updateJob(id, job), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<HttpStatus> deleteAllJobs() {
        jobService.deleteAllJobs();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
