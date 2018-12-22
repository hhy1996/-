package com.std.haofeng.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.std.haofeng.service.IAdminService;
import com.std.haofeng.service.impl.AdminService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/MyAdmin/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		IAdminService adminService=new AdminService();
		if(adminService.Login(user, pwd)) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("AdminHomePage");
			return;
		}
		else {
			response.sendRedirect("login.jsp?error=1");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
