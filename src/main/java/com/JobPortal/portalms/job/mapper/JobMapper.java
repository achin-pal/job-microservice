package com.JobPortal.portalms.job.mapper;

import com.JobPortal.portalms.job.dto.JobDTO;
import com.JobPortal.portalms.job.external.Company;
import com.JobPortal.portalms.job.external.Review;
import com.JobPortal.portalms.job.pojo.Job;

import java.util.List;

public class JobMapper {

    public static JobDTO mapJobWithCompanyDto(
            Job job,
            Company company, List<Review> reviewList){

        JobDTO jobWithCompanyDto = new JobDTO();
        jobWithCompanyDto.setId(job.getId());
        jobWithCompanyDto.setCompany(company);
        jobWithCompanyDto.setDescription(job.getDescription());
        jobWithCompanyDto.setLocation(job.getLocation());
        jobWithCompanyDto.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDto.setMinSalary(job.getMinSalary());
        jobWithCompanyDto.setTitle(job.getTitle());
        jobWithCompanyDto.setReview(reviewList);
        return jobWithCompanyDto;
    }
}
