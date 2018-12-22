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
import com.std.haofeng.service.IShopService;
import com.std.haofeng.service.impl.AdminService;
import com.std.haofeng.service.impl.ArticleService;
import com.std.haofeng.service.impl.ShopService;
import com.std.haofeng.util.Util;
import com.std.haofeng.vo.Admin;
import com.std.haofeng.vo.LunBo;
import com.std.haofeng.vo.ShopInfo;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/MyAdmin/AddShop")
public class AddShop extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AddShop() {
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
		IShopService shopService = new ShopService();
        int id = Util.CreateRandomID();
		String shopname = request.getParameter("shopname");
		String province = request.getParameter("province");
		String address = request.getParameter("address");
		String way = request.getParameter("way");
		String tel = request.getParameter("tel");

		ShopInfo shopinfo = new ShopInfo();
	
		shopinfo.setID(id);
		shopinfo.setShopName(shopname);
		shopinfo.setShopProvince(province);
		shopinfo.setShopAddress(address);
		shopinfo.setShopWay(way);
		shopinfo.setShopTel(tel);
		

		shopService.AddShop(shopinfo);
		response.sendRedirect("ShowShop.jsp");
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
