package com.std.haofeng.dao.proxy;

import java.util.List;

import com.std.haofeng.dao.IShopInfoDao;
import com.std.haofeng.dao.impl.ShopInfoDao;
import com.std.haofeng.dbc.DataBaseConnection;
import com.std.haofeng.vo.ShopInfo;

public class ShopInfoDaoProxy implements IShopInfoDao{
	private DataBaseConnection dbc = null;

	private IShopInfoDao dao = null;

	public ShopInfoDaoProxy(){
		try {
			this.dbc = new DataBaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new ShopInfoDao(this.dbc.getConnection());

	}

	@Override
	public boolean doCreate(ShopInfo shopInfo) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findShop(shopInfo.getID()) == null)
				flag = this.dao.doCreate(shopInfo);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doRemove(int ID) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findShop(ID) != null)
				flag = this.dao.doRemove(ID);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdateName(int ID, String newShopName) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findShop(ID) != null)
				flag = this.dao.doUpdateName(ID, newShopName);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdateProvince(int ID, String newProvince) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findShop(ID) != null)
				flag = this.dao.doUpdateProvince(ID, newProvince);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdateAddress(int ID, String newAddress) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findShop(ID) != null)
				flag = this.dao.doUpdateAddress(ID, newAddress);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdateWay(int ID, String newWay) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findShop(ID) != null)
				flag = this.dao.doUpdateWay(ID, newWay);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdateTel(int ID, String newTel) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findShop(ID) != null)
				flag = this.dao.doUpdateTel(ID, newTel);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public ShopInfo findShop(int ID) {
		// TODO Auto-generated method stub
		ShopInfo shopInfo = null;
		try {
			shopInfo = this.dao.findShop(ID);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return shopInfo;
	}

	@Override
	public List<ShopInfo> findShop() {
		// TODO Auto-generated method stub
		List<ShopInfo> all = null;
		try {
			all = this.dao.findShop();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	@Override
	public List<ShopInfo> findShopByProvince(String province) {
		List<ShopInfo> all = null;
		try {
			all = this.dao.findShopByProvince(province);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

}
