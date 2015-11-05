package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.testview.Resource;
import com.testview.SuggestedResourceList;
import com.testview.Task;

public class servercall extends HttpServlet {
	
	private static final long serialVersionUID = 10L;

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

		System.out.println("-----------------call start---------------------");
		
		String responsedata="No Data from Server";
		String type = request.getParameter("type");
		String dataformate= request.getParameter("formate");
		
		if(dataformate!=null && dataformate.equalsIgnoreCase("json")){

			System.out.println("check 1");
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			if (type.equals("tasklist")) {
				System.out.println("check 2");
				responsedata= new Gson().toJson(task.getTaskList(),ArrayList.class);
			}else if (type.equals("taskresource")) {
				System.out.println("check 3");
				String taskId= request.getParameter("id");
				if(taskId!=null){
					System.out.println("check 4"+taskId);
					responsedata= new Gson().toJson(resource.getResourceByTaskId(Integer.parseInt(taskId)),ArrayList.class);
				}
			}else if (type.equals("suggestedresourcelist")) {
				System.out.println("check 3");
				String title= request.getParameter("title");
				String sdate= request.getParameter("sdate");
				String edate= request.getParameter("edate");
				String skill= request.getParameter("skill");
				System.out.println("check 4 - "+sdate+"\t"+edate+"\t"+skill+"\t"+title);
				if(title!=null && sdate!=null && edate!=null && skill!=null){
					
					System.out.println("check 5 - "+sdate+"\t"+edate+"\t"+skill+"\t"+title);
					
					SuggestedResourceList srlist=resource.getResourceForTask(skill,0,sdate,edate);
					
					responsedata= new Gson().toJson(srlist);
					
					System.out.println("+++++++++++++++++++++++++++++++++++++++");
							System.out.println(responsedata);
					System.out.println("+++++++++++++++++++++++++++++++++++++++");
					
				//	responsedata="{\"dh\":\"Ashish\",\"spm\":\"Bhupesh\",\"manager\":\"Sundeep\",\"tableData\":{\"header\":[\" Select \",\"Assigned Hour(s)\",\"Name\",\"Status\",\"Occupied\",\"Ratings\"],\"rows\":[[false,20,\"Madhuri\",20,40,5],[true,20,\"Deepak\",60,80,5],[true,20,\"Sravani\",10,80,5]]}}";
				}
			}else if (type.equals("tasksubmit")) {
				
				System.out.println("tasksubmit 1");
				
				String title= request.getParameter("title");
				String sdate= request.getParameter("sdate");
				String edate= request.getParameter("edate");
				String description= request.getParameter("description");
				String clevel= request.getParameter("clevel");
				String rrecord= request.getParameter("rrecord");
				
				int tid=task.save(title,sdate,edate,description,clevel);
				resource.assignTask(tid,rrecord);
				System.out.println("check 4 - "+title+"\t"+sdate+"\t"+edate+"\t"+description+"\t"+clevel+"\t"+rrecord);
				return;
				
			}
		}
				
		response.getWriter().write(responsedata);
				
	}

}
