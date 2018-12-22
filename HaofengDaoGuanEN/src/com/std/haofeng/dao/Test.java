package com.std.haofeng.dao;

import java.util.List;

import com.std.haofeng.dao.proxy.AdminDaoProxy;
import com.std.haofeng.dao.proxy.ArticleDaoProxy;
import com.std.haofeng.dao.proxy.LunBoDaoProxy;
import com.std.haofeng.dao.proxy.ShopInfoDaoProxy;
import com.std.haofeng.vo.Admin;
import com.std.haofeng.vo.Article;
import com.std.haofeng.vo.LunBo;
import com.std.haofeng.vo.ShopInfo;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IShopInfoDao a =new ShopInfoDaoProxy();
		ShopInfo b=new ShopInfo();
		b.setID(1);
		b.setShopName("a");
		b.setShopProvince("b");
		b.setShopAddress("asd");
		b.setShopWay("way");
		b.setShopTel("Tel");
		a.doCreate(b);
		//List<LunBo> c=a.findLunBo();
		//System.out.println(c);
	}
}
