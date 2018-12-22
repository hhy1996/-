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

/**
 * Servlet implementation class AdminFirstLevel
 */
@WebServlet("/MyAdmin/AdminFirstLevel")
public class AdminFirstLevel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminFirstLevel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null)
		{
			response.sendRedirect("login.jsp");
			return;
		}
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		IClassService classService=new ClassService();
		switch (action) {
			case "add": {
				String typeName=request.getParameter("typeName");
				String typeIntroduce=request.getParameter("typeIntroduce");
				if(typeName!=null&&typeIntroduce!=null)
				{
					FirstLevel first=new FirstLevel();
					first.setTypeIntroduce(typeIntroduce);
					first.setTypeName(typeName);
					classService.AddFirstType(first);
					response.sendRedirect("AdminFirstLevel?action=getInfo");
				}
				break;
			}
			case "getInfo": {
				List<FirstLevel> firstList=classService.getAllFirstLevel();
				request.setAttribute("firstList", firstList);
				request.getRequestDispatcher("ShowFirstLevel.jsp").forward(request, response);
				break;
			}
			case "delete": {
				String deleteID=request.getParameter("deleteID");
				if(deleteID!=null)
				{
					classService.DeleteFirstLevel(Integer.parseInt(deleteID));
					response.sendRedirect("AdminFirstLevel?action=getInfo");
				}
				break;
			}
			case "change": {
				String changeID=request.getParameter("changeID");
				String newName=request.getParameter("typeName");
				String newIntroduce=request.getParameter("typeIntroduce");
				if(changeID!=null&&newName!=null&&newIntroduce!=null)
				{
					FirstLevel firstLevel=new FirstLevel();
					firstLevel.setID(Integer.parseInt(changeID));
					firstLevel.setTypeIntroduce(newIntroduce);
					firstLevel.setTypeName(newName);
					classService.ChangeFirstLevel(Integer.parseInt(changeID), firstLevel);
					response.sendRedirect("AdminFirstLevel?action=getInfo");
				}
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
