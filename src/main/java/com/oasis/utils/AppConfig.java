package com.oasis.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

	@Value("${jre.location}")
	private String jrePath;

	/**
	 * @return the jrePath
	 */
	public String getJrePath() {
		return jrePath;
	}

	/**
	 * @param jrePath
	 *            the jrePath to set
	 */
	public void setJrePath(String jrePath) {
		this.jrePath = jrePath;
	}

}
