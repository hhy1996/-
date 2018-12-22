package com.std.haofeng.dao;

import java.util.List;

import com.std.haofeng.vo.ShopInfo;

public interface IShopInfoDao {
	/**
	 * 向数据表中插入一条数据
	 * 
	 * @param shopInfo
	 *            要插入的数据
	 * @return 返回操作是否成功
	 */
	public boolean doCreate(ShopInfo shopInfo);

	/**
	 * 移除一条数据
	 * 
	 * @param ID
	 *            要移除的数据的ID
	 * @return 返回操作是否成功
	 */
	public boolean doRemove(int ID);

	/**
	 * 根据ID更新一条数据的shopName值
	 * 
	 * @param ID
	 *            要更新数据的ID值
	 * @param newShopName
	 *            新的shopName值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdateName(int ID, String newShopName);

	/**
	 * 根据ID更新一条数据的Province值
	 * 
	 * @param ID
	 *            要更新数据的ID
	 * @param newPrivince
	 *            新的Privince值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdateProvince(int ID, String newProvince);

	/**
	 * 根据ID更新一条数据的地址值
	 * 
	 * @param ID
	 *            要更新数据的ID值
	 * @param newAddress
	 *            新的地址值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdateAddress(int ID, String newAddress);

	/**
	 * 根据ID更新一条数据的Way值
	 * 
	 * @param ID
	 *            要更新数据的ID编号
	 * @param newWay
	 *            新的Way值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdateWay(int ID, String newWay);

	/**
	 * 根据ID编号更新一条数据的Tel值
	 * 
	 * @param ID
	 *            要更新数据的ID编号
	 * @param newTel
	 *            新的Tel值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdateTel(int ID, String newTel);

	/**
	 * 根据编号查询一个城市的信息
	 * 
	 * @param ID
	 *            要查找数据的ID编号
	 * @return
	 */
	public ShopInfo findShop(int ID);

	/**
	 * 查找所有的店铺数据
	 * 
	 * @return 返回找到的数据,如果没找到返回长度为0的List
	 */
	public List<ShopInfo> findShop();

	/**
	 * 通过城市名称查询店铺
	 * 
	 * @param province
	 *            要查询的城市名
	 * @return 返回找到的店铺列表,如果没找到返回长度为0的List
	 */
	public List<ShopInfo> findShopByProvince(String province);
}
