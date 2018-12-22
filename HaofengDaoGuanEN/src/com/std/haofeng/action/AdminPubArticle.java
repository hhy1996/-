package com.std.haofeng.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.std.haofeng.service.IArticleService;
import com.std.haofeng.service.impl.ArticleService;

/**
 * Servlet implementation class AdminPubArticle
 */
@WebServlet("/MyAdmin/PubArticle")
public class AdminPubArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPubArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null)
		{
			response.sendRedirect("login.jsp");
			return;
		}
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String title=request.getParameter("title");
		String htmlcode=request.getParameter("htmlCode");
		String textcode=request.getParameter("textCode");
		if(title==null||htmlcode==null||textcode==null)
		{
			response.sendRedirect("AddArticle.jsp");
			return;
		}
		IArticleService articleService=new ArticleService();
		articleService.PubLishArticle(title, textcode, htmlcode, this.getServletContext().getRealPath("/Article")+ java.io.File.separator , null);
		response.sendRedirect("ShowArticle.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
