package com.test.www;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletLifeCycleTest")
public class ServletLifeCycleTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletLifeCycleTest() {
        super();
        System.out.println("생성자");
    }
    

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service!");
	}
	
    @PostConstruct
    public void postConstruct() {
    	System.out.println("postconstruct");
    }

	public void destroy() {
		System.out.println("destroy");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("preDestroy");
	}

}
