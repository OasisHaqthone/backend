package com.oasis.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oasis.model.JreModel;
@Repository
public interface JreRepo extends CrudRepository<JreModel, Integer>,JpaSpecificationExecutor<JreModel> {
	@Query("SELECT jre FROM JreModel jre WHERE jre.jrename LIKE %?1% ")	
	public List<JreModel> searchJreByName(String searchKey);
	
	@Query("SELECT jre FROM JreModel jre WHERE jre.jrename =?1")	
	public JreModel findJreByName(String searchKey);

	
	
}
