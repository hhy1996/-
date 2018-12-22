package com.std.haofeng.dao.proxy;

import java.util.List;

import com.std.haofeng.dao.IProductInfoDao;
import com.std.haofeng.dao.impl.ProductInfoDao;
import com.std.haofeng.dbc.DataBaseConnection;
import com.std.haofeng.vo.ProductInfo;

public class ProductInfoDaoProxy implements IProductInfoDao{

	private DataBaseConnection dbc = null;

	private IProductInfoDao dao = null;

	public ProductInfoDaoProxy(){
		try {
			this.dbc = new DataBaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new ProductInfoDao(this.dbc.getConnection());
	}


	@Override
	public boolean doCreate(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findProduct(productInfo.getID()) == null)
				flag = this.dao.doCreate(productInfo);
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
			if (this.dao.findProduct(ID) != null)
				flag = this.dao.doRemove(ID);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdateName(int ID, String newName) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findProduct(ID) != null)
				flag = this.dao.doUpdateName(ID, newName);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdateIntroduce(int ID, String newIntroduce) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findProduct(ID) != null)
				flag = this.dao.doUpdateIntroduce(ID, newIntroduce);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdatePhotoPath(int ID, String newPath) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findProduct(ID) != null)
				flag = this.dao.doUpdatePhotoPath(ID, newPath);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdatethreeWords(int ID, String newThreeWords) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findProduct(ID) != null)
				flag = this.dao.doUpdatethreeWords(ID, newThreeWords);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdatePassage(int ID, String newPassage) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findProduct(ID) != null)
				flag = this.dao.doUpdatePassage(ID, newPassage);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public ProductInfo findProduct(int ID) {
		// TODO Auto-generated method stub
		ProductInfo productInfo = null;
		try {
			productInfo = this.dao.findProduct(ID);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return productInfo;
	}

	@Override
	public List<ProductInfo> findProduct() {
		// TODO Auto-generated method stub
		List<ProductInfo> all = null;
		try {
			all = this.dao.findProduct();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

}
