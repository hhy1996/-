package com.std.haofeng.dao;

import java.util.List;

import com.std.haofeng.vo.Admin;

public interface IAdminDao {
	/**
	 * 添加一条数据到表中
	 * 
	 * @param admin
	 *            要插入的输入
	 * @return 返回操作是否成功
	 */
	public boolean doCreate(Admin admin);

	/**
	 * 移除一条数据
	 * 
	 * @param b
	 *            要移除的数据的ID编号
	 * @return
	 */
	public boolean doRemove(String id);

	/**
	 * 更新一条数据的密码
	 * 
	 * @param id
	 *            要更新数据的ID编号
	 * @param newPwd
	 *            新的密码
	 * @return
	 */
	public boolean doUpdatePwd(String id, String newPwd);

	/**
	 * 查找一条数据
	 * 
	 * @param id
	 *            要查找的数据的ID编号
	 * @return 返回查找到的数据,没找到返回null
	 */
	public Admin findAdmin(String id);

	/**
	 * 查找所有的数据
	 * 
	 * @return 返回查找到的数据,没找到返回长度为0的List
	 */
	public List<Admin> findAdmin();
}
