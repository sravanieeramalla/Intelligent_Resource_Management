package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.testview.Resource;
import com.testview.Task;

public class servercall extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    Task task=null;
    Resource resource=null;
	
    public servercall() {
    }
	    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	task=new Task();
    	resource= new Resource();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("--Test---");
		String type = request.getParameter("type");
		String dataformate= request.getParameter("formate");
		String responsedata=null;
		
		if(dataformate!=null && dataformate.equalsIgnoreCase("json")){

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			if (type.equals("tasklist")) {
				responsedata= new Gson().toJson(task.getTaskList(),ArrayList.class);
			}
			
		}
		
		response.getWriter().write(responsedata);
				
	}

}
