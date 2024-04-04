package com.mcomment.mcommentpatient.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mcomment.mcommentpatient.model.CommentPatientMO;

public interface CommentRepository extends MongoRepository<CommentPatientMO, String> {

	@Query(value = "{ 'patient' : ?0 }", fields = "{ 'patId' : 1, '_id' : 0 }")
	List<String> findDistinctPatIdsByPatient(@Param("patient") String patient);

	List<CommentPatientMO> findByPatient(String patient);

}
