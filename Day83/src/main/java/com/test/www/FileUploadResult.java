package com.test.www;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileUploadResult")
public class FileUploadResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileUploadResult() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ServletInputStream p_in = request.getInputStream();
		
		
		response.setContentType("text/html;charset=UTF-8");
		ServletOutputStream p_out = response.getOutputStream();
		
		p_out.write("Start!!!<br/>".getBytes());
		while(true) {
			int x = p_in.read();
			if(x == -1) break;
			p_out.write((char)x);
		}
		p_out.write("<br/>End!!!".getBytes());
		
		p_in.close();
		p_out.close();
	}
}
