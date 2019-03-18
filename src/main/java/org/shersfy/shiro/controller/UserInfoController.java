package org.shersfy.shiro.controller;

import org.shersfy.shiro.commons.beans.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController extends BaseController{
	
	@PostMapping("/login")
	public Result login(@RequestParam(required=true)String username, 
			@RequestParam(required=true)String password) {
		Result res = new Result();
		LOGGER.info("login by username:{}, password:{}", username, password);
		res.setModel(username);
		return res;
	}

}
