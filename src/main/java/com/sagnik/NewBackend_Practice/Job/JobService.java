package com.sagnik.NewBackend_Practice.Job;

import java.util.List;

public  interface JobService {

    List<Job> findAll();

    void createJob(Job job);

    Job findById(Long id);

    void add(Job job);

    boolean deleteJobById(Long id);

    boolean updateJobById(Long id, Job updatedJob);
}
