package com.std.haofeng.dao.proxy;

import java.util.List;

import com.std.haofeng.dao.IArticleDao;
import com.std.haofeng.dao.impl.ArticleDao;
import com.std.haofeng.dbc.DataBaseConnection;
import com.std.haofeng.vo.Article;

public class ArticleDaoProxy implements IArticleDao {

	private DataBaseConnection dbc = null;

	private IArticleDao dao = null;

	public ArticleDaoProxy() {
		try {
			this.dbc = new DataBaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new ArticleDao(this.dbc.getConnection());
	}

	@Override
	public boolean doCreate(Article article) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findArticle(article.getID()) == null)
				flag = this.dao.doCreate(article);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doRemove(int ID) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			if (this.dao.findArticle(ID) != null)
				flag = this.dao.doRemove(ID);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public Article findArticle(int ID) {
		// TODO Auto-generated method stub
		Article article = null;
		try {
			article = this.dao.findArticle(ID);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return article;
	}

	@Override
	public List<Article> findArticle() {
		// TODO Auto-generated method stub
		List<Article> all = null;
		try {
			all = this.dao.findArticle();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}
}
