package com.std.haofeng.dao;

import java.util.List;

import com.std.haofeng.vo.SecondLevel;

public interface ISecondLevelDao {
	/**
	 * 向数据库中插入一条数据
	 * 
	 * @param secondLevel
	 *            要插入的数据
	 * @return 返回操作是否成功
	 */
	public boolean doCreate(SecondLevel secondLevel);

	/**
	 * 根据ID删除一条数据
	 * 
	 * @param ID
	 *            要移除的数据ID
	 * @return 返回操作是否成功
	 */
	public boolean doRemove(int ID);

	/**
	 * 根据rootID移除多条数据
	 * 
	 * @param rootID
	 *            要移除的rootID值
	 * @return 返回操作是否成功
	 */
	public boolean doRemoveByRoot(int rootID);

	/**
	 * 根据ID更新一条数据的rootID值
	 * 
	 * @param ID
	 *            要更新数据的ID值
	 * @param newRootID
	 *            新的rootID值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdateRootID(int ID, int newRootID);

	/**
	 * 更新一条数据的typeName值
	 * 
	 * @param ID
	 *            要更新数据的ID值
	 * @param newName
	 *            新的typeName值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdateName(int ID, String newName);

	/**
	 * 更新一条数据的Introduce值
	 * 
	 * @param ID
	 *            要更新数据的ID值
	 * @param newIntroduce
	 *            新的Introduce值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdateIntroduce(int ID, String newIntroduce);

	/**
	 * 更新一条数据的ProductID值
	 * 
	 * @param ID
	 *            要更新的数据的ID编号
	 * @param newProductID
	 *            新的页面路径
	 * @return 返回操作是否成功
	 */
	public boolean doUpdateProductID(int ID, int newProductID);

	/**
	 * 根据ID找到一条数据
	 * 
	 * @param ID
	 *            要查找的数据的ID编号
	 * @return 返回查找到的数据,如果没找到返回null
	 */
	public SecondLevel findSecond(int ID);

	/**
	 * 找到表内的所有数据
	 * 
	 * @return 返回找到的数据内容,如果没找到返回长度为0的List
	 */
	public List<SecondLevel> findSecond();
	public List<SecondLevel> findSecondByRoot(int rootID);
}
