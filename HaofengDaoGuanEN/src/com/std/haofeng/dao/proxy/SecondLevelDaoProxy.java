package com.std.haofeng.dao.proxy;

import java.util.List;

import com.std.haofeng.dao.ISecondLevelDao;
import com.std.haofeng.dao.impl.SecondLevelDao;
import com.std.haofeng.dbc.DataBaseConnection;
import com.std.haofeng.vo.SecondLevel;

public class SecondLevelDaoProxy implements ISecondLevelDao{

	private DataBaseConnection dbc = null;

	private ISecondLevelDao dao = null;

	public  SecondLevelDaoProxy(){
		try {
			this.dbc = new DataBaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new SecondLevelDao(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(SecondLevel secondLevel) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findSecond(secondLevel.getID()) == null)
				flag = this.dao.doCreate(secondLevel);
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
			if (this.dao.findSecond(ID) != null)
				flag = this.dao.doRemove(ID);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doRemoveByRoot(int rootID) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findSecond(rootID) != null)
				flag = this.dao.doRemove(rootID);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdateRootID(int ID, int newRootID) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findSecond(ID) != null)
				flag = this.dao.doUpdateRootID(ID, newRootID);
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
			if (this.dao.findSecond(ID) != null)
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
			if (this.dao.findSecond(ID) != null)
				flag = this.dao.doUpdateIntroduce(ID, newIntroduce);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdateProductID(int ID,int newProductID) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findSecond(ID) != null)
				flag = this.dao.doUpdateProductID(ID, newProductID);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public SecondLevel findSecond(int ID) {
		// TODO Auto-generated method stub
		SecondLevel secondLevel = null;
		try {
			secondLevel = this.dao.findSecond(ID);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return secondLevel;
	}

	@Override
	public List<SecondLevel> findSecond() {
		// TODO Auto-generated method stub
		List<SecondLevel> all = null;
		try {
			all = this.dao.findSecond();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	@Override
	public List<SecondLevel> findSecondByRoot(int rootID) {
		List<SecondLevel> all = null;
		try {
			all = this.dao.findSecondByRoot(rootID);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

}
