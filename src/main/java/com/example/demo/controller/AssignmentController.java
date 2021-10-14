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

import com.example.demo.model.Assignment;
import com.example.demo.model.AssignmentDto;
import com.example.demo.model.AuthRequest;
import com.example.demo.service.AssignmentService;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
	
	@Autowired
	AssignmentService assignmentService;
	
	@Autowired 
	AuthRequest authenticationRequest;
	
	@Autowired
	UserController userController;
	
	
	@PostMapping("add-assignment")
	public String addAssignment(@RequestBody AssignmentDto assdto){
		if(userController.userType != 1) {	
			return "You have no rights to create the assignments , Please Login as a Tutor...";
		}
		String response=assignmentService.addAssignment(assdto);
		return response;
		
	}
	
	@GetMapping("get-all-assignment")
	public List<Assignment> getAllAssignment(){
		List<Assignment> assignments=assignmentService.getAllAssignment();
		return assignments;
	}
	
	@GetMapping("{assID}")
	public Assignment getAssignmentById( @PathVariable("assID") int assID) throws UserPrincipalNotFoundException {
		Assignment assignment = assignmentService.getAssignmentById(assID);
		return assignment;
	}
	
	@PutMapping("update-assignment")
	public String updateAssignment(@RequestBody AssignmentDto assdto) {
		if(userController.userType != 1) {	
			return "You have no rights to Update the assignments , Please Login as a Tutor...";
		}
		String response = assignmentService.addAssignment(assdto);
		return response;
	}
	
	@DeleteMapping("{assID}")
	public String deleteAssignment(@PathVariable("assID") int assID){
		if(userController.userType != 1) {	
			return "You have no rights to Delete the assignments , Please Login as a Tutor...";
		}
		String response=assignmentService.deleteAssignment(assID);
		return response;
	}
	
	@GetMapping("/tutor/feed/{usrID}")
	public List<Assignment> getAllAssignmentByTutor( @PathVariable("usrID") int usrID) throws Exception {
		if(userController.userType != 1) {	
			throw new Exception("You are Logged in as a Student , You have no rights for this URL ...");
		}
		List<Assignment> assignments = assignmentService.getAllAssignmentByTutor(usrID);
		return assignments;
	}
	
	@GetMapping("/tutor/feed/{status}/{usrID}")
	public List<Assignment> getTutorSchdulerAssignments(@PathVariable("status") int status, @PathVariable("usrID") int usrID) throws Exception {
		if(userController.userType != 1) {	
			throw new Exception("You are Logged in as a Student , You have no rights for this URL ...");
		}
		List<Assignment> assignments = assignmentService.getTutorSchdulerAssignments(status,usrID);
		return assignments;
	}
	
	@GetMapping("/student/feed/{usrID}")
	public List<Assignment> getAllAssignmentByStudent( @PathVariable("usrID") int usrID) throws Exception {
		if(userController.userType != 2) {	
			throw new Exception("You are Logged in as a Tutor , You have no rights for this URL ...");
		}
		List<Assignment> assignments = assignmentService.getAllAssignmentByStudent(usrID);
		return assignments;
	}
	
	@GetMapping("/student/feed/{status}/{usrID}")
	public List<Assignment> getStudnetSchdulerAssignments(@PathVariable("status") int status, @PathVariable("usrID") int usrID) throws Exception {
		if(userController.userType != 2) {	
			throw new Exception("You are Logged in as a Tutor , You have no rights for this URL ...");
		}
		List<Assignment> assignments = assignmentService.getStudnetSchdulerAssignments(status,usrID);
		return assignments;
	}
}
