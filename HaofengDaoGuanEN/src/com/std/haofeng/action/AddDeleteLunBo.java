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

import com.std.haofeng.service.IAdminService;
import com.std.haofeng.service.IArticleService;
import com.std.haofeng.service.impl.AdminService;
import com.std.haofeng.service.impl.ArticleService;
import com.std.haofeng.util.Util;
import com.std.haofeng.vo.Admin;
import com.std.haofeng.vo.LunBo;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/MyAdmin/AddDeleteLunBo")
public class AddDeleteLunBo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AddDeleteLunBo() {
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

		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		try {
			su.upload();
			String lunboid = su.getRequest().getParameter("lunboid");
			int id = Integer.parseInt(lunboid);
			articleService.DeleteLunBo(id);
			String lunbotext1 = su.getRequest().getParameter("lunbotext1");
			String lunbotext2 = su.getRequest().getParameter("lunbotext2");
			String lunbolink = su.getRequest().getParameter("lunbolink");
			String color=su.getRequest().getParameter("color");
			LunBo lunbo = new LunBo();
			lunbo.setID(id);
			lunbo.setContent(lunbotext1 + "!" + lunbotext2+"!"+color);
			lunbo.setLink("Article"+java.io.File.separator+lunbolink);


			long a = System.currentTimeMillis();
			String trainFilePath1 = this.getServletContext().getRealPath("/") + "images" + java.io.File.separator + a
					+ ".jpg";
			String trainFilePath2 = this.getServletContext().getRealPath("/") + "images" + java.io.File.separator + (a
					+ 1) + ".jpg";
			su.getFiles().getFile(0).saveAs(trainFilePath1);
			su.getFiles().getFile(1).saveAs(trainFilePath2);
			lunbo.setPhotoPath(a + ".jpg!" + (a + 1) + ".jpg");
			articleService.AddLunBo(lunbo);

		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
