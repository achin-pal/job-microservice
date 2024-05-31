package com.JobPortal.portalms.job.serviceimpl;


import com.JobPortal.portalms.job.dto.JobDTO;
import com.JobPortal.portalms.job.external.Company;
import com.JobPortal.portalms.job.external.Review;
import com.JobPortal.portalms.job.mapper.JobMapper;
import com.JobPortal.portalms.job.pojo.Job;
import com.JobPortal.portalms.job.repo.JobRepository;
import com.JobPortal.portalms.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
//    private List<Job>  jobs = new ArrayList<>();
    JobRepository jobRepository;
    private Long nextId= 1L;
    @Autowired
    RestTemplate restTemplate;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public List<JobDTO> findAll() {

        List<Job> jobs =jobRepository.findAll();


        return jobs.stream().map(this::convert).collect(Collectors.toList());
    }

    private JobDTO convert(Job job){
//        RestTemplate restTemplate = new RestTemplate();
//                Company company=restTemplate.getForObject("http://COMPANY-MICROSERVICE:8081/companies/"+ job.getCompanyId(),
//                Company.class);

           

                ResponseEntity<List<Review>> responseEntity= restTemplate.exchange(
                "http://REVIEW-MICROSERVICE:8083/reviews?companyId="+job.getCompanyId(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Review>>(){
                });
                List<Review> reviews= responseEntity.getBody();

        JobDTO jobWithCompanyDto = JobMapper.mapJobWithCompanyDto(job,company,reviews);
//        jobWithCompanyDto.setCompany(company);
        return jobWithCompanyDto;
    }

    @Override
    public String createJoB(Job job) {
        job.setId(nextId++);
        jobRepository.save(job);
        return "job added";
    }

    @Override
    public JobDTO getJobById(Long id) {
        Job job= jobRepository.findById(id).orElse(null);
        return convert(job);
//        for (Job job : jobRepository.findById(id)){
//            if(job.getId().equals(id)){
//                return job;
//            }
//        }
//        return null;
    }

    @Override
    public Boolean deleteByJobId(Long id) {   // for removing you can use iterator]
   try {
       jobRepository.deleteById(id);
       return true;
       }catch (Exception e){
       return false;
   }

//        Iterator<Job> jobIterator= jobs.iterator();
//        while(jobIterator.hasNext()){
//             Job job = jobIterator.next();
//            if(job.getId().equals(id)){
//                jobIterator.remove();
//                return true;
//            }
//        }
//        return false;
    }

    @Override
    public Boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> optionalJob = jobRepository.findById(id);

//        Iterator<Job> jobIterator= jobs.iterator();
//        while(jobIterator.hasNext()){
//            Job job = jobIterator.next();
            if(optionalJob.isPresent()){
                Job job=optionalJob.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                jobRepository.save(job);
                return true;
            }
        return false;

    }

}
