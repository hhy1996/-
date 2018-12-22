package com.std.haofeng.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.std.haofeng.service.IClassService;
import com.std.haofeng.service.impl.ClassService;
import com.std.haofeng.vo.FirstLevel;
import com.std.haofeng.vo.SecondLevel;

/**
 * Servlet implementation class Course
 */
@WebServlet("/Course")
public class Course extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Course() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		IClassService classService=new ClassService();
		List<FirstLevel> courseType=classService.getAllFirstLevel();
		List<SecondLevel> courseInfo=classService.GetAllSecondLevel();
		String chooseType=request.getParameter("chooseType");
		request.setAttribute("courseType", courseType);
		request.setAttribute("courseInfo", courseInfo);
		if(chooseType==null)
			request.getRequestDispatcher("course.jsp").forward(request, response);
		else
			request.getRequestDispatcher("course.jsp?chooseType="+chooseType).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
