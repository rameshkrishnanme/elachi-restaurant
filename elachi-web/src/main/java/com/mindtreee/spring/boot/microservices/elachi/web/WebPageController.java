package com.mindtreee.spring.boot.microservices.elachi.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebPageController {
	@RequestMapping("/")
	public String getHomePage(Model model) {
		return "index";
	}

	@RequestMapping("/book")
	public String getSkatteberegning(Model model) {
		return "booktable";
	}

}