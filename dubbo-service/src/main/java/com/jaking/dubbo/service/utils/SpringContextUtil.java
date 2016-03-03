package com.jaking.dubbo.service.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {
	public static ApplicationContext context;

	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
		context = applicationContext;
	}

}
