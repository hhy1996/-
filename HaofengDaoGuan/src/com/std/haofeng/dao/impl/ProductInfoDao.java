package com.std.haofeng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.std.haofeng.dao.IProductInfoDao;
import com.std.haofeng.vo.ProductInfo;

public class ProductInfoDao implements IProductInfoDao{
	private Connection conn = null;

	private PreparedStatement ps = null;

	public ProductInfoDao (Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO ProductInfo (ID,productName,productIntroduce,photoPath,threeWords,passage) VALUES(?,?,?,?,?,?)";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, productInfo.getID());
			this.ps.setString(2, productInfo.getProductName());
			this.ps.setString(3, productInfo.getProductIntroduce());
			this.ps.setString(4, productInfo.getPhotoPath());
			this.ps.setString(5, productInfo.getThreeWords());
			this.ps.setString(6, productInfo.getPassage());
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
	public boolean doRemove(int ID) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Delete from ProductInfo where ID = ?";
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
	public boolean doUpdateName(int ID, String newName) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update ProductInfo set productName = ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, newName);
			this.ps.setInt(2, ID);
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
	public boolean doUpdateIntroduce(int ID, String newIntroduce) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update ProductInfo set productIntroduce = ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, newIntroduce);
			this.ps.setInt(2, ID);
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
	public boolean doUpdatePhotoPath(int ID, String newPath) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update ProductInfo set photoPath= ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, newPath);
			this.ps.setInt(2, ID);
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
	public boolean doUpdatethreeWords(int ID, String newThreeWords) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update ProductInfo set threeWords= ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, newThreeWords);
			this.ps.setInt(2, ID);
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
	public boolean doUpdatePassage(int ID, String newPassage) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update ProductInfo set passage= ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, newPassage);
			this.ps.setInt(2, ID);
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
	public ProductInfo findProduct(int ID) {
		// TODO Auto-generated method stub
		String sql = "Select ID,productName,productIntroduce,photoPath,threeWords,passage from ProductInfo where ID = ?";
		ProductInfo productInfo = null;
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, ID);
			ResultSet rs = this.ps.executeQuery();

			if (rs.next()) {
				productInfo = new ProductInfo();
				productInfo.setID(rs.getInt(1));
				productInfo.setProductName(rs.getString(2));
				productInfo.setProductIntroduce(rs.getString(3));
				productInfo.setPhotoPath(rs.getString(4));
				productInfo.setThreeWords(rs.getString(5));
				productInfo.setPassage(rs.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productInfo;
	}

	@Override
	public List<ProductInfo> findProduct() {
		// TODO Auto-generated method stub
		List<ProductInfo> all = new ArrayList<ProductInfo>();
		String sql = "Select ID,productName,productIntroduce,photoPath,threeWords,passage from ProductInfo";
		try {
			this.ps = this.conn.prepareStatement(sql);
			ResultSet rs = this.ps.executeQuery();
			ProductInfo productInfo = null;
			while (rs.next()) {
				productInfo = new ProductInfo();
				productInfo.setID(rs.getInt(1));
				productInfo.setProductName(rs.getString(2));
				productInfo.setProductIntroduce(rs.getString(3));
				productInfo.setPhotoPath(rs.getString(4));
				productInfo.setThreeWords(rs.getString(5));
				productInfo.setPassage(rs.getString(6));
				all.add(productInfo);
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
