package com.oasis.model;

import java.io.Serializable;

public class JreModel implements Serializable {
	int id;
	String jrename;
	String basepackage;
	String location;
	
	

	/**
	 * @param id
	 * @param jrename
	 * @param basepackage
	 * @param location
	 */
	public JreModel(int id, String jrename, String basepackage, String location) {
		super();
		this.id = id;
		this.jrename = jrename;
		this.basepackage = basepackage;
		this.location = location;
	}

	
	/**
	 * 
	 */
	public JreModel() {
		
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the jrename
	 */
	public String getJrename() {
		return jrename;
	}

	/**
	 * @param jrename
	 *            the jrename to set
	 */
	public void setJrename(String jrename) {
		this.jrename = jrename;
	}

	/**
	 * @return the basepackage
	 */
	public String getBasepackage() {
		return basepackage;
	}

	/**
	 * @param basepackage
	 *            the basepackage to set
	 */
	public void setBasepackage(String basepackage) {
		this.basepackage = basepackage;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jrename == null) ? 0 : jrename.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JreModel other = (JreModel) obj;
		if (jrename == null) {
			if (other.jrename != null)
				return false;
		} else if (!jrename.equals(other.jrename))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}

}
