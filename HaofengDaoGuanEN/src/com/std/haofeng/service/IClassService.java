package com.std.haofeng.service;

import java.util.List;

import com.std.haofeng.vo.*;

public interface IClassService {
	/**
	 * 添加一个最大产品类型
	 * 
	 * @param firstLevel
	 *            要添加的数据信息
	 * @return 返回操作是否成功
	 */
	public boolean AddFirstType(FirstLevel firstLevel);

	/**
	 * 获取所有的最大产品类型
	 * 
	 * @return 返回找到的数据信息
	 */
	public List<FirstLevel> getAllFirstLevel();

	/**
	 * 获取一个最大产品类型
	 * @param ID 要获取的类型ID
	 * @return
	 */
	public FirstLevel getFirstLevel(int ID);
	
	/**
	 * 修改一个最大产品类型的信息
	 * 
	 * @param oldID
	 *            旧的产品类型ID
	 * @param newFirst
	 *            新的产品类型数据
	 * @return
	 */
	public boolean ChangeFirstLevel(int oldID, FirstLevel newFirst);

	/**
	 * 删除一个旧的最大层级信息
	 * 
	 * @param ID
	 *            要删除的数据ID
	 * @return 返回操作是否成功
	 */
	public boolean DeleteFirstLevel(int ID);

	/**
	 * 添加一个产品信息
	 * 
	 * @param secondLevel
	 * @param productInfo
	 * @return
	 */
	public boolean AddSecondType(SecondLevel secondLevel, ProductInfo productInfo);

	/**
	 * 获取所有的产品概览
	 * 
	 * @return
	 */
	public List<SecondLevel> GetAllSecondLevel();

	/**
	 * 根据最大分类节点找到所有的概览数据
	 * 
	 * @param rootID
	 *            要查找的父节点编号
	 * @return
	 */
	public List<SecondLevel> GetAllSecondLevel(int rootID);

	/**
	 * 修改某个产品数据
	 * 
	 * @param oldProduct
	 *            旧的产品信息
	 * @param newProduct
	 *            新的产品信息
	 * @return 返回操作是否成功
	 */
	public boolean ChangeProduct(ProductInfo oldProduct, ProductInfo newProduct);

	/**
	 * 删除一个产品
	 * @param secondID
	 * @return
	 */
	public boolean DeleteProduct(int secondID,String folder);

	/**
	 * 根据ID编号查找到某个产品具体信息
	 * 
	 * @return
	 */
	public ProductInfo GetProduct(int ID);
}
