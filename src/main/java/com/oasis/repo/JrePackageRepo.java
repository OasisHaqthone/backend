/**
 * 
 */
package com.oasis.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.oasis.model.JrePackage;

/**
 * @author ARJUN
 *
 */
@Repository
public interface JrePackageRepo extends PagingAndSortingRepository<JrePackage, Long> {

}
