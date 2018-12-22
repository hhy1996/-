package com.std.haofeng.dao.proxy;

import java.util.List;

import com.std.haofeng.dao.IAdminDao;
import com.std.haofeng.dao.impl.AdminDao;
import com.std.haofeng.dbc.DataBaseConnection;
import com.std.haofeng.vo.Admin;

public class AdminDaoProxy implements IAdminDao {

	private DataBaseConnection dbc = null;

	private IAdminDao dao = null;

	public AdminDaoProxy(){
		try {
			this.dbc = new DataBaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new AdminDao(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(Admin admin) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findAdmin(admin.getID()) == null)
				flag = this.dao.doCreate(admin);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doRemove(String id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findAdmin(id) != null)
				flag = this.dao.doRemove(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdatePwd(String id, String newPwd) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findAdmin(id) != null)
				flag = this.dao.doUpdatePwd(id, newPwd);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public Admin findAdmin(String id) {
		// TODO Auto-generated method stub
		Admin admin = null;
		try {
			admin = this.dao.findAdmin(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return admin;
	}

	@Override
	public List<Admin> findAdmin() {
		// TODO Auto-generated method stub
		List<Admin> all = null;
		try {
			all = this.dao.findAdmin();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}
}
