package com.wisely.highlight_springmvc4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 该类实现了该接口，会自动被springServletContainerInitializer（用来启动servlet的容器）获取到
 */

public class WebInitializer implements WebApplicationInitializer {//1-替代web.xml

//	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyMvcConfig.class);
        ctx.setServletContext(servletContext); //2-全局上下文
        
        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx)); //3-注册当前的前端控制器
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        servlet.setAsyncSupported(true);//1

	}

}
