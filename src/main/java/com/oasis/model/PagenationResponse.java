package com.oasis.model;

import java.util.List;

public class PagenationResponse {
	private List<JrePackage> jrePackage;
	private int totalPages;
	private int pageNumber;
	private int pageSize;
	public PagenationResponse() {
	
	}
	/**
	 * 
	 */
	public PagenationResponse(List<JrePackage> jrePackage,int totalPages,
			int pageNumber, int pageSize) {
		this.jrePackage =  jrePackage;
		this.totalPages = totalPages;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	/**
	 * @return the jrePackage
	 */
	public List<JrePackage> getJrePackage() {
		return jrePackage;
	}
	/**
	 * @param jrePackage the jrePackage to set
	 */
	public void setJrePackage(List<JrePackage> jrePackage) {
		this.jrePackage = jrePackage;
	}
	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}
	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	/**
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		return pageNumber;
	}
	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	

}
