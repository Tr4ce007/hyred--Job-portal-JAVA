package com.hyred.hyred.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hyred.hyred.model.Job;

public interface JobRepository extends MongoRepository<Job, String> {

}
