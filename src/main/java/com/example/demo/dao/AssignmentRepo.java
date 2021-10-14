package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Assignment;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment, Integer> {
	
	@Query(value = "SELECT * from assignment_tbl at where at.user_id=?1", nativeQuery = true)
	public List<Assignment> getAllAssTutor(int usrID);
	
	@Query( value = "SELECT * FROM assignment_tbl at WHERE at.user_id =?1 AND at.ass_published_date > DATE(NOW())", nativeQuery = true )
	public List<Assignment> getTutorSchuleAss(int usrID);
	
	@Query( value = "SELECT * FROM assignment_tbl at WHERE at.user_id =?1 AND at.ass_published_date <= DATE(NOW())", nativeQuery = true )
	public List<Assignment> getTutorOngoingAss(int usrID);
	
	@Query( value = " SELECT at.* FROM assignment_tbl at INNER JOIN ( SELECT sa.ass_id FROM submission_tbl sa WHERE sa.user_id=?1 ) sub ON ( at.ass_id = sub.ass_id )" , nativeQuery = true )
	public List<Assignment> getStuAllAss(int usrID);
	
	@Query( value = " SELECT at.* FROM assignment_tbl at INNER JOIN ( SELECT sa.ass_id FROM submission_tbl sa WHERE sa.user_id=?1 ) sub ON ( at.ass_id = sub.ass_id ) WHERE at.ass_published_date > DATE(NOW())" , nativeQuery = true )
	public List<Assignment> getStuSchduleAss(int usrID);
	
	@Query( value = " SELECT at.* FROM assignment_tbl at INNER JOIN ( SELECT sa.ass_id FROM submission_tbl sa WHERE sa.user_id=?1 ) sub ON ( at.ass_id = sub.ass_id ) WHERE at.ass_published_date <= DATE(NOW())" , nativeQuery = true )
	public List<Assignment> getStuOngoingAss(int usrID);
	
	@Query( value = "SELECT at.* FROM assignment_tbl at INNER JOIN ( SELECT sa.ass_id FROM submission_tbl sa WHERE sa.user_id=?1 AND sa.sub_submitted_at IS NULL ) sub ON ( at.ass_id = sub.ass_id )" , nativeQuery = true )
	public List<Assignment> getStuPendingAss(int usrID);
	
	@Query( value = "SELECT at.* FROM assignment_tbl at INNER JOIN ( SELECT sa.* FROM submission_tbl sa WHERE sa.user_id=?1 ) sub ON ( at.ass_id = sub.ass_id ) WHERE sub.sub_submitted_at > at.ass_due_date" , nativeQuery = true )
	public List<Assignment> getStuOverdueAss(int usrID);
	
	@Query( value = "SELECT at.* FROM assignment_tbl at INNER JOIN ( SELECT sa.* FROM submission_tbl sa WHERE sa.user_id=?1 ) sub ON ( at.ass_id = sub.ass_id ) WHERE sub.sub_submitted_at <= at.ass_due_date" , nativeQuery = true )
	public List<Assignment> getStuSubmittedAss(int usrID);
}
