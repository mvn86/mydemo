/**
 * 
 */
package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chao.yu
 *
 */
@Controller
public class HelloWorldController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
		String message = "Hello World, Spring 3.0!";
		ModelAndView m = new ModelAndView();
		m.setViewName("hello");
		m.addObject("message", message);
		logger.info("request hello value {}", message);

		return m;
	}

	@RequestMapping("/post")
	public ModelAndView getformvalue(HttpServletRequest request) {
		ModelAndView m = new ModelAndView();
		m.setViewName("success");
		// 获取request 参数值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String radiosex = request.getParameter("radiosex");
		String[] checkbox = request.getParameterValues("checkbox");
		String select = request.getParameter("select");
		String textarea = request.getParameter("textarea");
		// 返回page数据
		m.addObject("username", username);
		m.addObject("password", password);
		m.addObject("radiosex", radiosex);
		m.addObject("checkbox", checkbox);
		m.addObject("select", select);
		m.addObject("textarea", textarea);

		return m;
	}
}
