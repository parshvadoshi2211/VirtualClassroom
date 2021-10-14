package com.example.demo.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Submission;
import com.example.demo.model.SubmissionDto;
import com.example.demo.service.SubmissionService;

@RestController
@RequestMapping("/submission")
public class SubmissionController {
	
	@Autowired
	SubmissionService stuAssService;
	
	@Autowired
	UserController userController;
	
	@PostMapping("add-student-assignment")
	public String addStuAss(@RequestBody SubmissionDto assdto){
		if(userController.userType != 2) {	
			return "You have no rights to Submit Assignment , Please Login as a Student...";
		}
		String response=stuAssService.addStuAss(assdto);
		return response;
	}
	
	@GetMapping("get-student-assignment")
	public List<Submission> getStuAss(){
		List<Submission> stuAss=stuAssService.getStuAss();
		return stuAss;
	}
	
	@GetMapping("{subID}")
	public Submission getSubmissionById( @PathVariable("subID") int subID) throws UserPrincipalNotFoundException {
		Submission submission = stuAssService.getSubmissionById(subID);
		return submission;
	}
	
	@DeleteMapping(value="{subID}")
	public String deleteStuAss(@PathVariable("subID") int subID){
		if(userController.userType != 2) {	
			return "You have no rights to Delete the Submitted Assignment , Please Login as a Student...";
		}
		String response=stuAssService.deleteStuAss(subID);
		return response;
	}
	
	@PutMapping("update-student-assignment")
	public String updateStuAss(@RequestBody SubmissionDto assdto){
		if(userController.userType != 2) {	
			return "You have no rights to Update the Submit Assignment , Please Login as a Student...";
		}
		String response=stuAssService.addStuAss(assdto);
		return response;
	}
}
