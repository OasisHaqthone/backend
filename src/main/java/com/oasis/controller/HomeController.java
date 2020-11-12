/**
 * 
 */
package com.oasis.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ARJUN
 *
 */
@RestController
public class HomeController {
	@GetMapping(value="/isalive")
	private String isAlive() {
		return Integer.toString(LocalDateTime.now().getYear());
	}

}
