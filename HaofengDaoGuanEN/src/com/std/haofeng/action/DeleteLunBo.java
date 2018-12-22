package com.std.haofeng.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxh.smart.SmartUpload;
import org.lxh.smart.SmartUploadException;

import com.std.haofeng.service.IArticleService;
import com.std.haofeng.service.impl.ArticleService;
import com.std.haofeng.util.Util;
import com.std.haofeng.vo.Admin;
import com.std.haofeng.vo.LunBo;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/MyAdmin/DeleteLunBo")
public class DeleteLunBo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DeleteLunBo() {
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
		IArticleService articleService = new ArticleService();
		int id = Integer.parseInt(request.getParameter("id"));
		articleService.DeleteLunBo(id);

		response.sendRedirect("chakanlunbo.jsp");
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
