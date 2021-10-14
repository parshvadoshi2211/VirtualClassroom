package com.example.demo.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AssignmentRepo;
import com.example.demo.dao.SubmissionRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.model.Assignment;
import com.example.demo.model.Submission;
import com.example.demo.model.SubmissionDto;
import com.example.demo.model.User;

@Service
public class SubmissionService {
	@Autowired
	SubmissionRepo stuAssRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AssignmentRepo assRepo;
	
	public String addStuAss(SubmissionDto assdto) {
		try {
			stuAssRepo.save(assDtoToModel(assdto));
			return "Success";
		}
		catch (Exception e) {
			System.out.println(e);
			return "Failed";
		}
	}
	public Submission assDtoToModel(SubmissionDto assdto){
		Submission submission=new Submission();
		submission.setAss_file(assdto.getAss_file());
		Assignment assignment=assRepo.findById(assdto.getAss_id()).get();
		submission.setAss_id(assignment);
		submission.setDeleted_at(assdto.getDeleted_at());
		submission.setRemark(assdto.getRemark());
		submission.setSub_id(assdto.getSub_id());
		submission.setSubmitted_at(assdto.getSubmitted_at());
		submission.setUpdated_at(assdto.getUpdated_at());
		User user=userRepo.findById(assdto.getUser_id()).get();
		submission.setUser_id(user);
		return submission;
}
	
	public List<Submission> getStuAss(){
		List<Submission> stuAss=(List<Submission>)stuAssRepo.findAll();
		return stuAss;
	}

	public Submission getSubmissionById(int subID) throws UserPrincipalNotFoundException {
		Optional<Submission> submission = stuAssRepo.findById(subID);
		
		if( !submission.isPresent() )
			throw new UserPrincipalNotFoundException("Id - " + subID);
		
		return submission.get();
	}
	
	public String deleteStuAss(int subID) {
		try {
			stuAssRepo.deleteById(subID);
			return "Success";
			}
			catch (Exception e) {
				System.out.println(e);
				return "Failed";
			}	
	}
}
