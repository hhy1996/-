package com.std.haofeng.dao.proxy;

import java.util.List;

import com.std.haofeng.dao.ILunBoDao;
import com.std.haofeng.dao.impl.LunBoDao;
import com.std.haofeng.dbc.DataBaseConnection;
import com.std.haofeng.vo.LunBo;

public class LunBoDaoProxy implements ILunBoDao {
	private DataBaseConnection dbc = null;

	private ILunBoDao dao = null;

	public LunBoDaoProxy(){
		try {
			this.dbc = new DataBaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new LunBoDao(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(LunBo lunbo) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findLunBo(lunbo.getID()) == null)
				flag = this.dao.doCreate(lunbo);
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
			if (this.dao.findLunBo(ID) != null)
				flag = this.dao.doRemove(ID);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdatePath(int ID, String newPath) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findLunBo(ID) != null)
				flag = this.dao.doUpdatePath(ID, newPath);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdateLink(int ID, String link) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findLunBo(ID) != null)
				flag = this.dao.doUpdatePath(ID, link);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdateContent(int ID, String content) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findLunBo(ID) != null)
				flag = this.dao.doUpdatePath(ID, content);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public LunBo findLunBo(int ID) {
		// TODO Auto-generated method stub
		LunBo lunbo = null;
		try {
			lunbo = this.dao.findLunBo(ID);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return lunbo;
	}

	@Override
	public List<LunBo> findLunBo() {
		// TODO Auto-generated method stub
		List<LunBo> all = null;
		try {
			all = this.dao.findLunBo();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

}
