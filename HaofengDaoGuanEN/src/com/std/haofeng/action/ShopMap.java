package com.std.haofeng.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.std.haofeng.service.IShopService;
import com.std.haofeng.service.impl.ShopService;
import com.std.haofeng.vo.ShopInfo;

/**
 * Servlet implementation class Map
 */
@WebServlet("/Map")
public class ShopMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopMap() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		IShopService shopService =new ShopService();
		List<ShopInfo> _shopList=shopService.GetAllShioInfo();
		List<String> provinceName=new ArrayList<String>();
		List<List<ShopInfo>> shopList=new ArrayList<List<ShopInfo>>();
		for(int i=0;i<_shopList.size();i++)
		{
			String province=_shopList.get(i).getShopProvince();//城市名称
			int index;
			if((index=provinceName.indexOf(province))==-1) {
				provinceName.add(province);
				List<ShopInfo> tempList=new ArrayList<ShopInfo>();
				tempList.add(_shopList.get(i));
				shopList.add(tempList);
			}else{
				shopList.get(index).add(_shopList.get(i));
			}
		}
		request.setAttribute("provinceName", provinceName);
		request.setAttribute("shopList", shopList);
		request.getRequestDispatcher("map.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
