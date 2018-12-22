package com.std.haofeng.dao.proxy;

import java.util.List;

import com.std.haofeng.dao.IFirstLevelDao;
import com.std.haofeng.dao.impl.FirstLevelDao;
import com.std.haofeng.dbc.DataBaseConnection;
import com.std.haofeng.vo.FirstLevel;

public class FirstLevelDaoProxy implements IFirstLevelDao {

	private DataBaseConnection dbc = null;

	private IFirstLevelDao dao = null;

	public FirstLevelDaoProxy() {
		try {
			this.dbc = new DataBaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new FirstLevelDao(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(FirstLevel firstInfo) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findFirstLevel(firstInfo.getID()) == null)
				flag = this.dao.doCreate(firstInfo);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doRemoveByID(int ID) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findFirstLevel(ID) != null)
				flag = this.dao.doRemoveByID(ID);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdateTypeName(int ID, String newName) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findFirstLevel(ID) != null)
				flag = this.dao.doUpdateTypeName(ID, newName);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpodateIntroduce(int ID, String newIntroduce) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findFirstLevel(ID) != null)
				flag = this.dao.doUpdateTypeName(ID, newIntroduce);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public FirstLevel findFirstLevel(int ID) {
		// TODO Auto-generated method stub
		FirstLevel firstLevel = null;
		try {
			firstLevel = this.dao.findFirstLevel(ID);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return firstLevel;
	}

	@Override
	public List<FirstLevel> findFirstLevel() {
		// TODO Auto-generated method stub
		List<FirstLevel> all = null;
		try {
			all = this.dao.findFirstLevel();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

}
