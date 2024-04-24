package com.mcomment.mcommentpatient.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mcomment.mcommentpatient.model.CommentPatientMO;

/**
 * Repository interface for CommentPatientMO entities.
 */
public interface CommentRepository extends MongoRepository<CommentPatientMO, String> {

	/**
	 * Retrieves distinct patient IDs by patient name.
	 *
	 * @param patient The name of the patient.
	 * @return A list of distinct patient IDs.
	 */
	@Query(value = "{ 'patient' : ?0 }", fields = "{ 'patId' : 1, '_id' : 0 }")
	List<String> findDistinctPatIdsByPatient(@Param("patient") String patient);

	/**
	 * Retrieves comments by patient name.
	 *
	 * @param patient The name of the patient.
	 * @return A list of comments associated with the specified patient.
	 */
	List<CommentPatientMO> findByPatient(String patient);

}
