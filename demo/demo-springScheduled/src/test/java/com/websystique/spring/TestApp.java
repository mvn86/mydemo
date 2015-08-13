/**
 * 
 */
package com.websystique.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.websystique.spring.config.AppConfig;

/**
 * @author Chris
 *
 */
public class TestApp {

	@Test
	public void testAppScheduled() {
		@SuppressWarnings({ "resource", "unused" })
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
	}
}
