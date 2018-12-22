package com.std.haofeng.dao;

import java.util.List;

import com.std.haofeng.vo.Article;

public interface IArticleDao {
	/**
	 * 添加一条数据到Article表中
	 * 
	 * @param article
	 *            要添加的数据
	 * @return 返回操作是否成功
	 */
	public boolean doCreate(Article article);

	/**
	 * 移除一条数据
	 * 
	 * @param ID
	 *            要移除的数据编号
	 * @return 返回操作是否成功
	 */
	public boolean doRemove(int ID);

	/**
	 * 找到一条Article数据
	 * 
	 * @param ID
	 *            要查询的数据的ID编号
	 * @return 返回找到的数据,没找到返回null
	 */
	public Article findArticle(int ID);

	/**
	 * 找到所有的Article数据
	 * 
	 * @return 返回找到的数据,没找到返回长度为0的List
	 */
	public List<Article> findArticle();
}
