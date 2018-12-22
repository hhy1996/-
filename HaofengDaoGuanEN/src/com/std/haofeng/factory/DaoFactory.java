package com.std.haofeng.factory;

import com.std.haofeng.dao.*;
import com.std.haofeng.dao.proxy.*;

public class DaoFactory {
	public static IAdminDao getAdminDao() {
		return new AdminDaoProxy();
	}

	public static IArticleDao getArticleDao() {
		return new ArticleDaoProxy();
	}

	public static IFirstLevelDao getFirstLevelDao() {
		return new FirstLevelDaoProxy();
	}

	public static ILunBoDao getLunBoDao() {
		return new LunBoDaoProxy();
	}

	public static IProductInfoDao getProductInfoDao() {
		return new ProductInfoDaoProxy();
	}

	public static ISecondLevelDao getSecondLevelDao() {
		return new SecondLevelDaoProxy();
	}

	public static IShopInfoDao getShopInfoDao() {
		return new ShopInfoDaoProxy();
	}
}
