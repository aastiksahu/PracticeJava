package com.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {

	public JDBCDataSource() {

	}

	private static JDBCDataSource datasource = null;
	private ComboPooledDataSource cpds = null;

	private static JDBCDataSource getInstance() {

		if (datasource == null) {

			datasource = new JDBCDataSource();
			datasource.cpds = new ComboPooledDataSource();
			ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");

			try {
				datasource.cpds.setDriverClass(rb.getString("driver"));
				datasource.cpds.setJdbcUrl(rb.getString("url"));
				datasource.cpds.setUser(rb.getString("username"));
				datasource.cpds.setPassword(rb.getString("password"));
				datasource.cpds.setMinPoolSize(Integer.parseInt(rb.getString("minpoolsize")));
				datasource.cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxpoolsize")));
				datasource.cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialpoolsize")));
				datasource.cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireincrement")));
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}

		}
		return datasource;

	}
	public static Connection getConnection() throws SQLException {
		
		return getInstance().cpds.getConnection();
		
	}
	
	public static void closeConnection(Connection connection) {
		
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void trnRollback(Connection connection) throws Exception {
		
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException ex) {
				throw new Exception(ex.toString());
			}
			
		}
		
	}

}
