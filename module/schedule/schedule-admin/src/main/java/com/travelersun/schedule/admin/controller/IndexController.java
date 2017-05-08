package com.travelersun.schedule.admin.controller;

import com.travelersun.schedule.core.biz.model.ReturnT;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * index controller
 * @author xuxueli 2015-12-19 16:13:16
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(Model model, HttpServletRequest request) {

		return "redirect:/jobinfo";
	}
	
	@RequestMapping(value = "/toLogin",method= RequestMethod.GET)
	public String toLogin(Model model, HttpServletRequest request) {

		return "login";
	}
	
	@RequestMapping(value="login", method= RequestMethod.POST)
	@ResponseBody
	public ReturnT<String> loginDo(HttpServletRequest request, HttpServletResponse response, String userName, String password, String ifRemember){

		return ReturnT.SUCCESS;
	}
	
	@RequestMapping(value="logout", method= RequestMethod.POST)
	@ResponseBody

	public ReturnT<String> logout(HttpServletRequest request, HttpServletResponse response){

		return ReturnT.SUCCESS;
	}
	
	@RequestMapping("/help")
	public String help() {
		return "help";
	}
	
}
