package com.donghui.smis.util;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JdbcUtil {
	private JdbcUtil() {
		// TODO Auto-generated constructor stub
	}
	private static Properties p = new Properties();
	
	static {
		try {
			InputStream inStream = Thread.currentThread().
					getContextClassLoader().
					getResourceAsStream("db.properties");
			p.load(inStream);
			System.out.println(p.getProperty("driverClassName"));
			Class.forName(p.getProperty("driverClassName"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {
		try {
			return (Connection) DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("password"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection conn, Statement st, ResultSet rs) throws SQLException {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e3) {
					// TODO: handle exception
					e3.printStackTrace();
				}
			}
		}
	 }
}
