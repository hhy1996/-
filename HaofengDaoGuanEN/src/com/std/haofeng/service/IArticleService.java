package com.std.haofeng.service;

import java.util.List;

import com.std.haofeng.vo.*;

public interface IArticleService {
	/**
	 * 添加一条轮播数据
	 * 
	 * @param lunbo
	 *            要添加的轮播数据
	 * @return 返回操作是否成功
	 */
	public boolean AddLunBo(LunBo lunbo);

	/**
	 * 删除一条轮播数据
	 * 
	 * @param ID
	 *            要删除的数据ID
	 * @return 返回操作是否成功
	 */
	public boolean DeleteLunBo(int ID);

	/**
	 * 修改一条轮播数据
	 * 
	 * @param oldLunBo
	 *            旧的轮播数据
	 * @param newLunBo
	 *            新的轮播数据
	 * @return
	 */
	public boolean ChangeLunBo(LunBo oldLunBo, LunBo newLunBo);

	/**
	 * 获取所有的轮播数据
	 * 
	 * @return
	 */
	public List<LunBo> GetAllLunBo();

	/**
	 * 发布一个文章
	 * 
	 * @param article
	 *            文章内容
	 * @param FolderPath
	 *            要发布的文件夹路径
	 * @return
	 */
	public boolean PubLishArticle(String title, String textContent, String article, String FolderPath, String inner);

	/**
	 * 删除一条文章数据
	 * 
	 * @param article
	 *            要删除的文章数据内容
	 * @param FolderPath
	 *            要删除的文章数据文件夹路径
	 * @return
	 */
	public boolean DeleteArticle(int ID, String FolderPath);

	/**
	 * 获取所有的已发布文章列表
	 * 
	 * @return 返回找到的文章
	 */
	public List<Article> GetAllArticle();

}
