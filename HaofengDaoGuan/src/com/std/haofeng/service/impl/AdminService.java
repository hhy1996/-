package com.std.haofeng.service.impl;

import java.util.List;

import com.std.haofeng.factory.DaoFactory;
import com.std.haofeng.service.IAdminService;
import com.std.haofeng.util.MD5;
import com.std.haofeng.vo.Admin;

public class AdminService implements IAdminService {

	@Override
	public boolean AddAdmin(Admin admin) {
		admin.setPwd(MD5.Encode(admin.getPwd()));
		return DaoFactory.getAdminDao().doCreate(admin);
	}

	@Override
	public boolean Login(String ID, String pwd) {
		Admin admin = DaoFactory.getAdminDao().findAdmin(ID);
		pwd=MD5.Encode(pwd);
		boolean result = false;
		if (admin != null) {
			result = pwd.equals(admin.getPwd());
		}
		return result;
	}

	@Override
	public boolean ChangePwd(String ID, String Pwd, String newPwd) {
		boolean result=false;
		if(Login(ID,Pwd))
		{
			result=DaoFactory.getAdminDao().doUpdatePwd(ID, newPwd);
		}
		return result;
	}

	@Override
	public boolean DeleteAdmin(String ID) {
		return DaoFactory.getAdminDao().doRemove(ID);
	}

	@Override
	public List<Admin> GetAllAdmin() {
		return DaoFactory.getAdminDao().findAdmin();
	}

}
