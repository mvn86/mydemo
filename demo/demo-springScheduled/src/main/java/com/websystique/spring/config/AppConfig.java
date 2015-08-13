/**
 * 
 */
package com.websystique.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.websystique.spring.scheduling.MyBean;

/**
 * @author Chris
 *
 */
@Configuration
@EnableScheduling
public class AppConfig {

	@Bean
	public MyBean bean() {
		return new MyBean();
	}
}
