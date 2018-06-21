package com.wisely.highlight_springmvc4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//1
public class HelloController {
	
	@RequestMapping("/index")//2
	public  String hello(){

		return "index";
	}

	@RequestMapping("/index2")//2
	public @ResponseBody String hello2(){
        StringBuilder sb = null;
        sb.append("1");
		return "index";
	}
}
