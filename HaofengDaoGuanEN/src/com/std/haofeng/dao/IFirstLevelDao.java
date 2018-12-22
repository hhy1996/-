package com.std.haofeng.dao;

import java.util.List;

import com.std.haofeng.vo.FirstLevel;

public interface IFirstLevelDao {

	/**
	 * 添加一条新数据到数据库
	 * 
	 * @param firstInfo
	 *            要添加的数据
	 * @return 返回操作是否成功
	 */
	public boolean doCreate(FirstLevel firstInfo);

	/**
	 * 通过ID移除一条数据,注意判断移除数据是否存在
	 * 
	 * @param ID
	 *            要移除的数据的ID
	 * @return 返回操作是否成功
	 */
	public boolean doRemoveByID(int ID);

	/**
	 * 修改一条数据的typeName数据
	 * 
	 * @param ID
	 *            要修改的数据的ID编号
	 * @param newName
	 *            新的typeName值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdateTypeName(int ID, String newName);

	/**
	 * 修改一条数据的Introcude内容
	 * 
	 * @param ID
	 *            要修改数据的ID编号
	 * @param newIntroduce
	 *            新的Introduce值
	 * @return 返回操作是否成功
	 */
	public boolean doUpodateIntroduce(int ID, String newIntroduce);

	/**
	 * 通过ID找到一条数据
	 * 
	 * @param ID
	 *            找到的那条数据
	 * @return 返回找到的数据,没找到返回Null
	 */
	public FirstLevel findFirstLevel(int ID);

	/**
	 * 查找所有的FirstLevel数据
	 * 
	 * @return 返回找到的所有数据,如果不存在返回长度为0的List
	 */
	public List<FirstLevel> findFirstLevel();
}
