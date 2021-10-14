package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Submission;

@Repository
public interface SubmissionRepo extends JpaRepository<Submission, Integer>{

}
