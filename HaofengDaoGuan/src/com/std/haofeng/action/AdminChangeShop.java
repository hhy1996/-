package com.std.haofeng.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.std.haofeng.factory.DaoFactory;
import com.std.haofeng.service.IShopService;
import com.std.haofeng.service.impl.ShopService;
import com.std.haofeng.vo.ShopInfo;

/**
 * Servlet implementation class AdminChangeShop
 */
@WebServlet("/MyAdmin/AdminChangeShop")
public class AdminChangeShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangeShop() {
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
		String action=request.getParameter("action");
		IShopService shopService=new ShopService();
		if(action==null) {
			response.sendRedirect("ShowShop.jsp");
			return;
		}
		switch(action) {
			case"jumpChange":{
				String shopID=request.getParameter("shopID");
				if(shopID==null)
				{
					response.sendRedirect("ShowShop.jsp");
					return;
				}
				ShopInfo shopInfo=DaoFactory.getShopInfoDao().findShop(Integer.parseInt(shopID));
				request.setAttribute("shopInfo", shopInfo);
				request.setAttribute("shopID", shopID);
				request.getRequestDispatcher("ChangeShop.jsp").forward(request,response); 
				break;
			}
			case "change":{
				String shopID=request.getParameter("shopID");
				if(shopID==null)
				{
					response.sendRedirect("ShowShop.jsp");
					return;
				}
				ShopInfo oldInfo=DaoFactory.getShopInfoDao().findShop(Integer.parseInt(shopID));
				String shopname = request.getParameter("shopname");
				String province = request.getParameter("province");
				String address = request.getParameter("address");
				String way = request.getParameter("way");
				String tel = request.getParameter("tel");
				ShopInfo shopinfo = new ShopInfo();
				shopinfo.setShopName(shopname);
				shopinfo.setShopProvince(province);
				shopinfo.setShopAddress(address);
				shopinfo.setShopWay(way);
				shopinfo.setShopTel(tel);
				shopService.ChangeShopInfo(oldInfo, shopinfo);
				response.sendRedirect("ShowShop.jsp");
			}
			case"delete":{
				String shopID=request.getParameter("deleteID");
				if(shopID==null)
				{
					response.sendRedirect("ShowShop.jsp");
					return;
				}
				shopService.DeleteShop(Integer.parseInt(shopID));
				response.sendRedirect("ShowShop.jsp");
				break;
			}
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
