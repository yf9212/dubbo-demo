package com.jaking.dubbo.web.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;

@Controller
public abstract class BaseControll {
	
	/**
	 * postConstruct标注的方法会在构造方法执行完成之后,
	 * servlet的init()方法执行之前执行
	 */
	@PostConstruct
	protected void init(){
		
	}
}
