package com.sagnik.NewBackend_Practice.Job;

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
    public List<Job> findAll(){
        return jobService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findById(@PathVariable Long id){
        Job job = jobService.findById(id);
        if(job != null)
            return new ResponseEntity<>(job,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.add(job);
        return new ResponseEntity<>("Job Created",HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobbyId(@PathVariable Long id){
        boolean delete = jobService.deleteJobById(id);
        if(delete)
            return new ResponseEntity<>("Job Deleted", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobbyId(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJobById(id,updatedJob);
        if(updated)
            return new ResponseEntity<>("Job Updated", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
