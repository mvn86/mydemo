/**
 * 
 */
package com.websystique.spring.scheduling;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Chris
 *
 */
public class MyBean {

	@Scheduled(cron="*/5 * * * * *") 
	public void printMessage() {
		System.out.println("I am called by Spring scheduler");
	}
}
