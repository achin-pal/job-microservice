package com.JobPortal.portalms.job.service;



import com.JobPortal.portalms.job.dto.JobDTO;
import com.JobPortal.portalms.job.pojo.Job;

import java.util.List;

public interface JobService {

    List<JobDTO> findAll();
    String createJoB(Job job);
    JobDTO getJobById(Long id);
    Boolean deleteByJobId(Long id);

    Boolean updateJob(Long id, Job updatedJob);
}
