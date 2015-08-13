/**
 * 
 */
package com.websystique.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.websystique.spring.config.AppConfig;

/**
 * @author Chris
 *
 */
public class AppMain {

	public static void main(String[] args) {
		@SuppressWarnings({ "resource", "unused" })
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
	}
}
