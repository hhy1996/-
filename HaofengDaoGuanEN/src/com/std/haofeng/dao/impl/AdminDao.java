package com.std.haofeng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.std.haofeng.dao.IAdminDao;
import com.std.haofeng.vo.Admin;

public class AdminDao implements IAdminDao {
	private Connection conn = null;

	private PreparedStatement ps = null;

	public AdminDao(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Admin admin) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO admin (id,pwd) VALUES(?,?)";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, admin.getID());
			this.ps.setString(2, admin.getPwd());
			if (this.ps.executeUpdate() > 0)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public boolean doRemove(String id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Delete from admin where id = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, id);
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
	public boolean doUpdatePwd(String id, String newPwd) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update admin set pwd = ? where id = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, newPwd);
			this.ps.setString(2, id);
			if (this.ps.executeUpdate() > 0) {
				flag = true;
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
		return flag;
	}

	@Override
	public Admin findAdmin(String id) {
		// TODO Auto-generated method stub
		String sql = "Select id,pwd from admin where id = ?";
		Admin admin = null;
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, id);
			ResultSet rs = this.ps.executeQuery();

			if (rs.next()) {
				admin = new Admin();
				admin.setID(rs.getString(1));
				admin.setPwd(rs.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;

	}

	@Override
	public List<Admin> findAdmin() {
		// TODO Auto-generated method stub
		List<Admin> all = new ArrayList<Admin>();
		String sql = "Select id,pwd from admin";
		try {
			this.ps = this.conn.prepareStatement(sql);
			ResultSet rs = this.ps.executeQuery();
			Admin admin = null;
			while (rs.next()) {
				admin = new Admin();
				admin.setID(rs.getString(1));
				admin.setPwd(rs.getString(2));
				all.add(admin);
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
