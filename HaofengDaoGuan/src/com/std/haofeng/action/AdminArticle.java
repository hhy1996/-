package com.std.haofeng.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.std.haofeng.service.IArticleService;
import com.std.haofeng.service.impl.ArticleService;
import com.std.haofeng.vo.Article;

/**
 * Servlet implementation class AdminArticle
 */
@WebServlet("/MyAdmin/Article")
public class AdminArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminArticle() {
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
		if (action == null)
			action = "getInfo";
		IArticleService articleService = new ArticleService();
		switch (action) {
		case "getInfo": 
			{
				List<Article> result = articleService.GetAllArticle();
				request.setAttribute("result", result);
				request.getRequestDispatcher("ShowArticle.jsp").forward(request, response);
				break;
			}
		case "delete":
			{
				String deleteID=request.getParameter("deleteID");
				if(deleteID!=null)
				{
					articleService.DeleteArticle(Integer.parseInt(deleteID), this.getServletContext().getRealPath("/Article")+ java.io.File.separator);
				}
				response.sendRedirect("Article?action=getInfo");
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
