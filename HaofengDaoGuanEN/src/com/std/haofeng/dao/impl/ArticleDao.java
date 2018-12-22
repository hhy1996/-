package com.std.haofeng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.std.haofeng.dao.IArticleDao;
import com.std.haofeng.vo.Article;

public class ArticleDao implements IArticleDao {
	private Connection conn = null;

	private PreparedStatement ps = null;

	public ArticleDao(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Article article) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO Article (ID,Path,PubTime) VALUES(?,?,?)";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, article.getID());
			this.ps.setString(2, article.getPath());
			this.ps.setString(3, article.getPubTime());
			if (this.ps.executeUpdate() > 0)
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doRemove(int ID) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Delete from Article where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, ID);
			if (this.ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Article findArticle(int ID) {
		// TODO Auto-generated method stub
		String sql = "Select ID,Path,PubTime from Article where ID = ?";
		Article article = null;
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, ID);
			ResultSet rs = this.ps.executeQuery();

			if (rs.next()) {
				article = new Article();
				article.setID(rs.getInt(1));
				article.setPath(rs.getString(2));
				article.setPubTime(rs.getString(3));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public List<Article> findArticle() {
		// TODO Auto-generated method stub
		List<Article> all = new ArrayList<Article>();
		String sql = "Select ID,Path,PubTime from Article order by ID desc";
		try {
			this.ps = this.conn.prepareStatement(sql);
			ResultSet rs = this.ps.executeQuery();
			Article article = null;
			while (rs.next()) {
				article = new Article();
				article.setID(rs.getInt(1));
				article.setPath(rs.getString(2));
				article.setPubTime(rs.getString(3));
				all.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;
	}
}
