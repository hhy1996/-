package com.std.haofeng.dao;

import java.util.List;

import com.std.haofeng.vo.LunBo;

public interface ILunBoDao {
	/**
	 * 添加一条轮播数据
	 * 
	 * @param lunbo
	 *            要添加的轮播数据
	 * @return 返回操作是否成功
	 */
	public boolean doCreate(LunBo lunbo);

	/**
	 * 根据ID移除一条数据
	 * 
	 * @param ID
	 *            要移除的数据ID
	 * @return 返回操作是否成功
	 */
	public boolean doRemove(int ID);

	/**
	 * 修改一条数据的Path值
	 * 
	 * @param ID
	 *            要修改的数据的ID编号
	 * @param newPath
	 *            新的Path值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdatePath(int ID, String newPath);

	/**
	 * 更新一条数据的Link值
	 * 
	 * @param ID
	 *            要更新Link值得ID编号
	 * @param link
	 *            新的link值
	 * @return 返回是否操作成功
	 */
	public boolean doUpdateLink(int ID, String link);

	/**
	 * 更新一条数据的content值
	 * 
	 * @param ID
	 *            要更新的数据的ID编号
	 * @param content
	 *            新的Content值
	 * @return 返回操作是否成功
	 */
	public boolean doUpdateContent(int ID, String content);

	/**
	 * 根据ID找到一条轮播数据
	 * 
	 * @param ID
	 *            要查询的数据的ID编号
	 * @return 返回找到的轮播数据,没找到返回null
	 */
	public LunBo findLunBo(int ID);

	/**
	 * 找到所有的轮播数据
	 * 
	 * @return 返回找到的轮播数据组成的list,没找到返回长度为0的List
	 */
	public List<LunBo> findLunBo();
}
