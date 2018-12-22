package com.std.haofeng.dao;

import java.util.List;

import com.std.haofeng.vo.ProductInfo;

public interface IProductInfoDao {
	/**
	 * 向productInfo表中插入一条新数据
	 * 
	 * @param productInfo
	 *            要插入的数据内容
	 * @return 返回操作是否成功
	 */
	public boolean doCreate(ProductInfo productInfo);

	/**
	 * 从数据表中移除一条数据
	 * 
	 * @param ID
	 *            要移除的数据的ID
	 * @return 返回操作是否成功
	 */
	public boolean doRemove(int ID);

	/**
	 * 更新一条数据的productName属性
	 * 
	 * @param ID
	 *            要更新数据的ID编号
	 * @param newName
	 *            新的productName值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdateName(int ID, String newName);

	/**
	 * 更新一条数据的Introduce数据
	 * 
	 * @param ID
	 *            要更新的数据的ID编号
	 * @param newIntroduce
	 *            新的Introduce值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdateIntroduce(int ID, String newIntroduce);

	/**
	 * 更新一条数据的照片路径数据
	 * 
	 * @param ID
	 *            要更新数据的ID编号
	 * @param newPath
	 *            新的照片路径值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdatePhotoPath(int ID, String newPath);

	/**
	 * 更新一条数据的threeWords值
	 * 
	 * @param ID
	 *            要更新数据的ID编号
	 * @param newThreeWords
	 *            新的threeWords值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdatethreeWords(int ID, String newThreeWords);

	/**
	 * 更新一条数据的Passage值
	 * 
	 * @param ID
	 *            要更新的数据的ID编号
	 * @param newPassage
	 *            新的Passage值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdatePassage(int ID, String newPassage);

	/**
	 * 通过ID编号查找的一条Product数据
	 * 
	 * @param ID
	 *            要查找的数据编号
	 * @return 返回找到的数据,如果没找到返回null
	 */
	public ProductInfo findProduct(int ID);

	/**
	 * 查找所有的ProductInfo表中数据
	 * 
	 * @return 返回找到的值,如果没找到返回长度为0的List
	 */
	public List<ProductInfo> findProduct();
}
