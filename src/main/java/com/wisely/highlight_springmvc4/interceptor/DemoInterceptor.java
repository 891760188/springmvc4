package com.wisely.highlight_springmvc4.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 简单的拦截器开发配置
 * 计算每一次请求的处理时间
 */

public class DemoInterceptor extends HandlerInterceptorAdapter {//1继承这个类来自定义拦截器

    /**
     * 请求发生前执行的方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
	@Override
	public boolean preHandle(HttpServletRequest request, //2
			HttpServletResponse response, Object handler) throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}

    /**
     * 请求完成后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView  视图
     * @throws Exception
     */
	@Override
	public void postHandle(HttpServletRequest request, //3
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		request.removeAttribute("startTime");
		long endTime = System.currentTimeMillis();
		System.out.println("本次请求处理时间为:" + new Long(endTime - startTime)+"ms");
		request.setAttribute("handlingTime", endTime - startTime);
	}

}
