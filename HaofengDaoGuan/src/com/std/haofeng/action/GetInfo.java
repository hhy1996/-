package com.std.haofeng.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.std.haofeng.service.IArticleService;
import com.std.haofeng.service.IClassService;
import com.std.haofeng.service.impl.ArticleService;
import com.std.haofeng.service.impl.ClassService;
import com.std.haofeng.vo.Article;
import com.std.haofeng.vo.FirstLevel;

/**
 * Servlet implementation class GetInfo
 */
@WebServlet("/GetInfo")
public class GetInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetInfo() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		IClassService firstlevelService=new ClassService();
		IArticleService articleService=new ArticleService();
		List<Article> articleData=articleService.GetAllArticle();
		List<FirstLevel> firstLevelData=firstlevelService.getAllFirstLevel();
		int size=0;
		if(articleData.size()>=3)size=3;
		if(articleData.size()<3)size=articleData.size();
		String result=
				"<div class=\"category\">\r\n" + 
				"	<h3>课程分类</h3>\r\n" + 
				"	<ul class=\"list-unstyled\">\r\n" + 
				"	\r\n";
		for (int i = 0; i < firstLevelData.size(); i++) { 
				result+="<li><a href=\"../Course\"><i class=\"icon-angle-right\"></i>"+firstLevelData.get(i).getTypeName()+"</a></li>\r\n";
		}
		result+="\r\n" + 
				"	</ul>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div class=\"blog-post\">\r\n" + 
				"	<h3>最新发布</h3>\r\n";
		for (int i = 0; i < size; i++) { 
				String[] _split = articleData.get(i).getPath().split("!");
				result+="\r\n" + 
				"	<div class=\"media\">\r\n" + 
				"		<div class=\"media-body\">\r\n" + 
				"			<h5 class=\"media-heading\">\r\n" + 
				"				<a href=\""+_split[2]+"\">"+_split[0]+"</a>\r\n" + 
				"			</h5>\r\n" + 
				"			<p>"+_split[1]+"</p>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n";
				}
				result+="</div>";
		response.getWriter().print(result);
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
