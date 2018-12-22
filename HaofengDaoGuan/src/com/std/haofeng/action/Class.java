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
import com.std.haofeng.vo.ProductInfo;
import com.std.haofeng.vo.SecondLevel;

/**
 * Servlet implementation class Class
 */
@WebServlet("/Class")
public class Class extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String productID = request.getParameter("productID");
		String rootID = request.getParameter("productType");
		IClassService classService = new ClassService();
		if (productID == null || rootID == null) {
			response.sendRedirect("Course");
			return;
		}
		try {
			int INT_productID = Integer.parseInt(productID);
			int INT_rootID = Integer.parseInt(rootID);
			ProductInfo product = classService.GetProduct(INT_productID);
			FirstLevel pruductType = classService.getFirstLevel(INT_rootID);
			List<SecondLevel> productList = classService.GetAllSecondLevel(INT_rootID);
			if (product == null || pruductType == null) {
				response.sendRedirect("Course");
				return;
			}
			request.setAttribute("productList", productList);
			request.setAttribute("productInfo", product);
			request.setAttribute("pruductType", pruductType);
			request.getRequestDispatcher("class.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("Course");
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
