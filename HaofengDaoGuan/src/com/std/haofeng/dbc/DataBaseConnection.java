package com.std.haofeng.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.std.haofeng.common.Config;


public class DataBaseConnection {
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://"+Config.databaseUrl+":"+Config.port+"/"+Config.databaseChoose;
	public static final String DBUSER = Config.databaseUser;
	public static final String DBPASS = Config.databasePassword;

	private Connection conn = null;
	// 在构造方法里面进行了数据库连接

	public DataBaseConnection() throws Exception {
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e) {
			throw e;
		}
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void close() {
		if (this.conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
