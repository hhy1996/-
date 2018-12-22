package com.std.haofeng.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.std.haofeng.common.Config;
import com.std.haofeng.util.MailSendMessage;

/**
 * Servlet implementation class SendEmail
 */
@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name,tel,mail,liuyan;
		name=request.getParameter("name");
		tel=request.getParameter("tel");
		mail=request.getParameter("mail");
		liuyan=request.getParameter("liuyan");
		if(name==null||tel==null||mail==null||liuyan==null)
		{
			response.sendRedirect("contact.jsp");
			return;
		}
		MailSendMessage.sendMsg("用户反馈数据-浩枫道馆", "姓名:"+name+",联系电话:"+tel+",邮箱:"+mail+",留言内容:"+liuyan, Config.sendTo);
		response.sendRedirect("contact.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
