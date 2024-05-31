package com.JobPortal.portalms.job.controller;



import com.JobPortal.portalms.job.dto.JobDTO;
import com.JobPortal.portalms.job.pojo.Job;
import com.JobPortal.portalms.job.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> getAllJobs(){
//        List<JobWithCompanyDto>  job= jobService.findAll();
//        if(job !=null){
//            return  ResponseEntity.ok(job);
//        }
//        return new ResponseEntity<>(job, HttpStatus.NOT_FOUND);
        return  ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping()
    public ResponseEntity<String> createJobs( @RequestBody Job job){
        jobService.createJoB(job);
//        Company c= job.getCompany();
        return ResponseEntity.ok("jobs added");
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJob(@PathVariable Long id) {
//        ResponseEntity responseEntity = new ResponseEntity<>();
        JobDTO jobWithCompanyDto = jobService.getJobById(id);
                  if(jobWithCompanyDto !=null){
                      return  new ResponseEntity<>(jobWithCompanyDto, HttpStatus.OK);
                  }
                      return new ResponseEntity<>(jobWithCompanyDto, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob( @PathVariable Long id){
            Boolean del = jobService.deleteByJobId(id);
             if(del) {
                 return ResponseEntity.ok("deleted");
             }
             return new ResponseEntity<>("Not deleted", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob( @PathVariable Long id ,@RequestBody Job updatedJob){
        Boolean del = jobService.updateJob(id,updatedJob);
        if(del) {
            return ResponseEntity.ok("Updated");
        }
        return new ResponseEntity<>("Not updated", HttpStatus.NOT_FOUND);
    }
}
