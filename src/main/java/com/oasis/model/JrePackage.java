/**
 * 
 */
package com.oasis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ARJUN
 *
 */
@Entity
@Table(name="jrepackage")
public class JrePackage {
	@Id
	int id;
	@Column
	String packagename;
	@Column
	String description;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the packageName
	 */
	public String getPackageName() {
		return packagename;
	}
	/**
	 * @param packageName the packageName to set
	 */
	public void setPackageName(String packagename) {
		this.packagename = packagename;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	

}
