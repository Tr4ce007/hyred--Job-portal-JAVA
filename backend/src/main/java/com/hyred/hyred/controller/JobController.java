package com.hyred.hyred.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyred.hyred.model.Job;
import com.hyred.hyred.repository.JobRepository;
import com.hyred.hyred.repository.SearchRepository;

import jakarta.servlet.http.HttpServletResponse;
// import springfox.documentation.annotations.ApiIgnore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
public class JobController {

    @Autowired
    JobRepository jobRepo;

    @Autowired
    SearchRepository searchRepo;

    // @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/jobs")
    @CrossOrigin
    public List<Job> getAllJobs(){
        return jobRepo.findAll();
    }

    @GetMapping("/jobs/{text}")
    @CrossOrigin
    public List<Job> searchJobs(@PathVariable String text){
        return searchRepo.findByText(text);
    }

    @PostMapping("/job")
    @CrossOrigin
    public Job createJob(@RequestBody Job job) {
        return jobRepo.save(job);
    }
    
}
