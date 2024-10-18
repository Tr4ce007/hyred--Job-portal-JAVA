package com.hyred.hyred.repository;

import java.util.List;

import com.hyred.hyred.model.Job;

public interface SearchRepository {
    List<Job> findByText(String text);
}
