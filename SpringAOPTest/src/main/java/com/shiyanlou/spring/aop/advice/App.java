package com.shiyanlou.spring.aop.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "SpringAOPAdvice.xml" });

		System.out.println("使用Spring AOP 如下");
		// 注意这里获取的是proxy的bean
		CustomerService cust = (CustomerService) appContext
				.getBean("customerServiceProxy");
		System.out.println("*************************");
		cust.printName();
		System.out.println("*************************");
		cust.printURL();
		System.out.println("*************************");

		try {
			cust.printThrowException();
		} catch (Exception e) {

		}

	}

}
