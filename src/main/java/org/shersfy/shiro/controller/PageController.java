package org.shersfy.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController extends BaseController{
	
	@RequestMapping("/")
	public ModelAndView index1() {
		setBasePath(getRequest(), getResponse());
		return new ModelAndView("index");
	}
	
	@RequestMapping("/index")
	public ModelAndView index2() {
		setBasePath(getRequest(), getResponse());
		return new ModelAndView("index");
	}
	
}