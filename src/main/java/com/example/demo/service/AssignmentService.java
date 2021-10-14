package com.example.demo.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AssignmentRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.model.Assignment;
import com.example.demo.model.AssignmentDto;
import com.example.demo.model.User;

@Service
public class AssignmentService {
	
	@Autowired
	AssignmentRepo assignmentRepo;
	
	@Autowired
	UserRepo userRepo;
	
	public String addAssignment(AssignmentDto assdto) {
		try {
			assignmentRepo.save(assDtoToModel(assdto));
		return "Success";
		}
		catch (Exception e) {
			System.out.println(e);
			return "Failed";
		}
	}
	
	
	public Assignment assDtoToModel(AssignmentDto assdto){
		Assignment assignment=new Assignment();
		assignment.setAss_id(assdto.getAss_id());
		assignment.setCreated_at(assdto.getCreated_at());
		assignment.setDeleted_at(assdto.getDeleted_at());
		assignment.setDescription(assdto.getDescription());
		assignment.setDueDate(assdto.getDueDate());
		assignment.setPublishedDate(assdto.getPublishedDate());
		assignment.setTitle(assdto.getTitle());
		//assignment.setStatus(assdto.getStatus());
		assignment.setUpdated_at(assdto.getUpdated_at());
		User user=userRepo.findById(assdto.getUser_id()).get();
		assignment.setUser_id(user);
		return assignment;
}
	
	public List<Assignment> getAllAssignment(){
		List<Assignment> assignments=(List<Assignment>)assignmentRepo.findAll();
		return assignments;
	}
	
	
	public Assignment getAssignmentById(int assID) throws UserPrincipalNotFoundException {
		Optional<Assignment> assignment = assignmentRepo.findById(assID);
		
		if( !assignment.isPresent() )
			throw new UserPrincipalNotFoundException("Id - " + assID);
		
		return assignment.get();
	}
	
	public String deleteAssignment(int assID) {
		try {
			assignmentRepo.deleteById(assID);
			return "Success";
			}
			catch (Exception e) {
				System.out.println(e);
				return "Failed";
			}	
	}
	
	public List<Assignment> getAllAssignmentByTutor(int usrID){
		List<Assignment> assignments = assignmentRepo.getAllAssTutor(usrID);
		return assignments;
	}
	
	public List<Assignment> getTutorSchdulerAssignments(int status,int usrID){
		if(status==1) {
			List<Assignment> assignments = assignmentRepo.getTutorSchuleAss(usrID);
			return assignments;
		}
		else if(status==2)
		{
			List<Assignment> assignments = assignmentRepo.getTutorOngoingAss(usrID);
			return assignments;
		}
		return null;	
	}
	
	public List<Assignment> getAllAssignmentByStudent(int usrID) {
		List<Assignment> assignments = assignmentRepo.getStuAllAss(usrID);
		return assignments;
	}
	
	public List<Assignment> getStudnetSchdulerAssignments(int status , int usrID) {
		if( status == 1 ) {
			List<Assignment> assignments = assignmentRepo.getStuSchduleAss(usrID);
			return assignments;
		}
		else if( status == 2 ) {
			List<Assignment> assignments = assignmentRepo.getStuOngoingAss(usrID);
			return assignments;
		}
		else if( status == 3 ) {
			List<Assignment> assignments = assignmentRepo.getStuPendingAss(usrID);
			return assignments;
		}
		else if( status == 4 ) {
			List<Assignment> assignments = assignmentRepo.getStuOverdueAss(usrID);
			return assignments;
		}
		else if( status == 5 ) {
			List<Assignment> assignments = assignmentRepo.getStuSubmittedAss(usrID);
			return assignments;
		}
		return null;
	}
}
