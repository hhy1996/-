package com.std.haofeng.action;

import java.io.IOException;
import java.io.Serializable;
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
import com.std.haofeng.vo.FirstLevel;;

/**
 * Servlet implementation class Article
 */
@WebServlet("/Blog")
public class Blog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Blog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		IArticleService articleService=new ArticleService();
		List<Article> articleData=articleService.GetAllArticle();
		IClassService firstlevelService=new ClassService();
		List<FirstLevel> firstLevelData=firstlevelService.getAllFirstLevel();
		String id=request.getParameter("pageid");
		int a=0,b=0;
		int idint=1;
		int max=(articleData.size()/5)+1;
		int yu=articleData.size()%5;
		int size=0;
		Boolean is1display=true;
		Boolean is2display=true;
		if(id==null)idint=1;
		else idint=Integer.parseInt(id);
		if(idint>max)idint=1;
		else if(idint<max) {
			a=(idint-1)*5;
			b=idint*5-1;
			
		}else if(idint==max) {
			a=(idint-1)*5;
			b=a+yu;
		}
		if(idint==1) {
			is1display=false;
		}
		if(idint==max) {
			is2display=false;
		}
		if(articleData.size()>=3)size=3;
		if(articleData.size()<3)size=articleData.size();
		request.setAttribute("idint", String.valueOf(idint));
		request.setAttribute("a", String.valueOf(a));
		request.setAttribute("b", String.valueOf(b));
		request.setAttribute("is1display", is1display);
		request.setAttribute("is2display", is2display);
		request.setAttribute("articledata", articleData);
		request.setAttribute("firstLeveldata", firstLevelData);
		request.setAttribute("size", String.valueOf(size));
		request.getRequestDispatcher("blog.jsp").forward(request,response); 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
