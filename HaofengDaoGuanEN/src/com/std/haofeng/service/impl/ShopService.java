package com.std.haofeng.service.impl;

import java.util.List;

import com.std.haofeng.factory.DaoFactory;
import com.std.haofeng.service.IShopService;
import com.std.haofeng.util.Util;
import com.std.haofeng.vo.ShopInfo;

public class ShopService implements IShopService {

	@Override
	public boolean AddShop(ShopInfo shopInfo) {
		shopInfo.setID(Util.CreateRandomID());
		return DaoFactory.getShopInfoDao().doCreate(shopInfo);
	}

	@Override
	public boolean DeleteShop(int ID) {
		return DaoFactory.getShopInfoDao().doRemove(ID);
	}

	@Override
	public List<ShopInfo> GetAllShioInfo() {
		return DaoFactory.getShopInfoDao().findShop();
	}

	@Override
	public boolean ChangeShopInfo(ShopInfo oldInfo, ShopInfo newInfo) {
		boolean result = true;
		int ID = oldInfo.getID();
		if (!oldInfo.getShopAddress().equals(newInfo.getShopAddress()))
			result = result && DaoFactory.getShopInfoDao().doUpdateAddress(ID, newInfo.getShopAddress());
		if (!oldInfo.getShopName().equals(newInfo.getShopName()))
			result = result && DaoFactory.getShopInfoDao().doUpdateName(ID, newInfo.getShopName());
		if (!oldInfo.getShopProvince().equals(newInfo.getShopProvince()))
			result = result && DaoFactory.getShopInfoDao().doUpdateProvince(ID, newInfo.getShopProvince());
		if (!oldInfo.getShopTel().equals(newInfo.getShopTel()))
			result = result && DaoFactory.getShopInfoDao().doUpdateTel(ID, newInfo.getShopTel());
		if (!oldInfo.getShopWay().equals(newInfo.getShopWay()))
			result = result && DaoFactory.getShopInfoDao().doUpdateWay(ID, newInfo.getShopWay());
		return result;
	}

}
