package com.std.haofeng.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.std.haofeng.service.IAdminService;
import com.std.haofeng.service.IArticleService;
import com.std.haofeng.service.impl.AdminService;
import com.std.haofeng.service.impl.ArticleService;
import com.std.haofeng.vo.Admin;
import com.std.haofeng.vo.Article;
import com.std.haofeng.vo.LunBo;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/MyAdmin/ChangeLunBo")
public class ChangeLunBo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ChangeLunBo() {
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

		String id = request.getParameter("id");
		String lunboimg1 = request.getParameter("lunboimg1");
		String lunboimg2 = request.getParameter("lunboimg2");
		String lunbotext1 = request.getParameter("lunbotext1");
		String lunbotext2 = request.getParameter("lunbotext2");
		String lunbolink = request.getParameter("lunbolink");
		request.setAttribute("id", id);
		request.setAttribute("lunboimg1", lunboimg1);
		request.setAttribute("lunboimg2", lunboimg2);
		request.setAttribute("lunbotext1", lunbotext1);
		request.setAttribute("lunbotext2", lunbotext2);
		request.setAttribute("lunbolink", lunbolink);



		request.getRequestDispatcher("changelunbo.jsp").forward(request,response); 
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
