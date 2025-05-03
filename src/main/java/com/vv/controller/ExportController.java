package com.vv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExportController {

	@RequestMapping("/")
	public String welcome() {
		return "export";
	}

}