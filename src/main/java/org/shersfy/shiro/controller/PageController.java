package org.shersfy.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController extends BaseController{
	
	@RequestMapping("/")
	public ModelAndView index1() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/index")
	public ModelAndView index2() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		if (getLoginUser()!=null) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("login");
	}
	
}