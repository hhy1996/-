package com.std.haofeng.service;

import java.util.List;

import com.std.haofeng.vo.ShopInfo;

public interface IShopService {
	/**
	 * 添加一个新的店铺
	 * @param shopInfo 要添加的店铺信息数据
	 * @return 返回操作是否成功
	 */
	public boolean AddShop(ShopInfo shopInfo);
	
	/**
	 * 删除一个店铺
	 * @param ID 要删除的店铺ID
	 * @return 返回操作是否成功
	 */
	public boolean DeleteShop(int ID);
	
	/**
	 * 找到所有的店铺信息
	 * @return 返回找到的信息
	 */
	public List<ShopInfo> GetAllShioInfo();
	
	/**
	 * 修改一个店铺的信息数据
	 * @param oldInfo 旧的数据
	 * @param newInfo 新的数据
	 * @return 返回操作是否成功
	 */
	public boolean ChangeShopInfo(ShopInfo oldInfo,ShopInfo newInfo);
}
