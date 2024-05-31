package com.JobPortal.portalms.job.repo;


import com.JobPortal.portalms.job.pojo.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
