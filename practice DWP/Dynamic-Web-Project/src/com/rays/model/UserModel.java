package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.UserBean;
import com.rays.util.JDBCDataSource;

public class UserModel {

	public int nextPk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(Id) from user");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

		}
		return pk + 1;
	}

	public void signUp(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		UserBean existBean = findByEmail(bean.getEmailId());

		if (existBean != null) {

			throw new Exception("Email Id Allready Exist...");

		}

		PreparedStatement pstmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?,?)");

		pstmt.setInt(1, nextPk());
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(5, bean.getGender());
		pstmt.setString(6, bean.getEmailId());
		pstmt.setString(7, bean.getUserName());
		pstmt.setString(8, bean.getPassword());
		pstmt.setString(9, bean.getAddress());
		pstmt.setString(10, bean.getMobileNo());

		int i = pstmt.executeUpdate();

		System.out.println("Data Added Successfully : " + i);
	}

	public void delete(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from user where id = ?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("Data Deleted Successfully : " + i);

	}

	public void update(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("update user set firstName = ? where id = ?");

		pstmt.setString(1, bean.getFirstName());
		pstmt.setInt(2, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("Data Update Succeccfully : " + i);

	}

	public List search(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from user");

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setEmailId(rs.getString(6));
			bean.setUserName(rs.getString(7));
			bean.setPassword(rs.getString(8));
			bean.setAddress(rs.getString(9));
			bean.setMobileNo(rs.getString(10));

			list.add(bean);
		}
		return list;
	}

	public UserBean findByPk(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from user where id = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setEmailId(rs.getString(6));
			bean.setUserName(rs.getString(7));
			bean.setPassword(rs.getString(8));
			bean.setAddress(rs.getString(9));
			bean.setMobileNo(rs.getString(10));

		}
		return bean;
	}

	public UserBean findByEmail(String emailId) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from user where emailId = ?");

		pstmt.setString(1, emailId);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setEmailId(rs.getString(6));
			bean.setUserName(rs.getString(7));
			bean.setPassword(rs.getString(8));
			bean.setAddress(rs.getString(9));
			bean.setMobileNo(rs.getString(10));

		}
		return bean;

	}

	public UserBean logIn(String emailId, String password) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from user where emailId = ? and password = ?");

		pstmt.setString(1, emailId);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setEmailId(rs.getString(6));
			bean.setUserName(rs.getString(7));
			bean.setPassword(rs.getString(8));
			bean.setAddress(rs.getString(9));
			bean.setMobileNo(rs.getString(10));

		}
		return bean;
	}

}
