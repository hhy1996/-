package com.std.haofeng.service;

import java.util.List;

import com.std.haofeng.vo.*;

public interface IAdminService {
	/**
	 * 添加一个管理员,注意将密码进行加密
	 * @param admin 要添加的管理员数据
	 * @return 返回操作是否成功
	 */
	public boolean AddAdmin(Admin admin);
	
	/**
	 * 
	 * @param ID
	 * @param pwd
	 * @return
	 */
	public boolean Login(String ID,String pwd);
	
	/**
	 * 修改一个账户的密码
	 * @param ID 要修改密码的ID
	 * @param Pwd 旧的密码
	 * @param newPwd 新的密码
	 * @return
	 */
	public boolean ChangePwd(String ID,String Pwd,String newPwd);
	
	/**
	 * 删除一个管理员
	 * @param ID 要删除的管理员的ID
	 * @return 返回操作是否成功
	 */
	public boolean DeleteAdmin(String ID);
	
	/**
	 * 获取所有的管理员账户
	 * @return 返回找到的所有管理员账户
	 */
	public List<Admin> GetAllAdmin();
}
