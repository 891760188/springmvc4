package com.wisely.highlight_springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice //1-  控制器建言  对于控制器的全局配置放在同一位置
public class ExceptionHandlerAdvice {

	/**
	 * 全局异常处理
	 * @param exception
	 * @param request
	 * @return
     */
	@ExceptionHandler(value = Exception.class)//2-此处定义全局处理，value属性可以过滤拦截条件，此处我拦截所有的异常
	public ModelAndView exception(Exception exception, WebRequest request) {
		ModelAndView modelAndView = new ModelAndView("error");// error页面
		modelAndView.addObject("errorMessage", exception.getMessage());
		return modelAndView;
	}

    /**
     * 将该键值对添加倒全局 所有注解requestmapping都可以获取该键值对
     * @param model
     */
	@ModelAttribute //3
	public void addAttributes(Model model) {
		model.addAttribute("msg", "额外信息"); //3
	}

	@InitBinder //4
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("id"); //5
	}
}
