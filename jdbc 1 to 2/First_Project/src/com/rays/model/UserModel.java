package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.UserBean;
import com.rays.util.JDBCDataSource;

public class UserModel {
	
	public int nextId() throws Exception {

		int Id = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(Id) from user");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			Id = rs.getInt(1);

		}
		return Id + 1;

	}

	public void addUser(UserBean bean) throws Exception {

		Connection conn = null;
		
		UserBean existBean = findByEmailUserName(bean.getEmailId(), bean.getUserName());

		if (existBean != null) {

			throw new Exception("User Allready Exists..........");
		}

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, nextId());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getGender());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(6, bean.getAddress());
			pstmt.setString(7, bean.getMobileNo());
			pstmt.setString(8, bean.getEmailId());
			pstmt.setString(9, bean.getUserName());
			pstmt.setString(10, bean.getPassword());

			int i = pstmt.executeUpdate();
			System.out.println("Data Inserted Successfully : " + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();

		}
	}

	public void update(UserBean bean) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update user set firstName = ?, lastName = ?, gender = ?, dob = ?, address = ?, mobileNo = ?, emailId = ?, userName = ?, password = ? where id = ?");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getGender());
			pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(5, bean.getAddress());
			pstmt.setString(6, bean.getMobileNo());
			pstmt.setString(7, bean.getEmailId());
			pstmt.setString(8, bean.getUserName());
			pstmt.setString(9, bean.getPassword());
			pstmt.setInt(10, bean.getId());

			int i = pstmt.executeUpdate();

			System.out.println("Data Update Successfully....." + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();

		}

	}

	public void delete(UserBean bean) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from user where id = ?");

			pstmt.setInt(1, bean.getId());

			int i = pstmt.executeUpdate();

			System.out.println("Data Deleted Successfully..." + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();

		}
	}

	public List search(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from user where 1 = 1");

		if (bean != null) {

			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {

				sql.append(" and firstName like '" + bean.getFirstName() + "%'");

			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {

				sql.append(" and lastName like '" + bean.getLastName() + "%'");

			}

		}

		System.out.println("sql: " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		List list = new ArrayList();

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setGender(rs.getString(4));
			bean.setDob(rs.getDate(5));
			bean.setAddress(rs.getString(6));
			bean.setMobileNo(rs.getString(7));
			bean.setEmailId(rs.getString(8));
			bean.setUserName(rs.getString(9));
			bean.setPassword(rs.getString(10));

			list.add(bean);

		}

		return list;

	}

	public List authenticate(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from user where 1 = 1");

		if (bean != null) {

			if (bean.getEmailId() != null && bean.getEmailId().length() > 0 && bean.getPassword() != null
					&& bean.getPassword().length() > 0) {

				sql.append(" and emailId like '" + bean.getEmailId() + "%'" + " and password like '"
						+ bean.getPassword() + "%'");

			}
			if (bean.getUserName() != null && bean.getUserName().length() > 0 && bean.getPassword() != null
					&& bean.getPassword().length() > 0) {

				sql.append(" and Username like '" + bean.getUserName() + "%'" + " and password like '"
						+ bean.getPassword() + "%'");

			}

		}

		System.out.println("sql: " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		List list = new ArrayList();

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setGender(rs.getString(4));
			bean.setDob(rs.getDate(5));
			bean.setAddress(rs.getString(6));
			bean.setMobileNo(rs.getString(7));
			bean.setEmailId(rs.getString(8));
			bean.setUserName(rs.getString(9));
			bean.setPassword(rs.getString(10));

			list.add(bean);

		}

		return list;

	}

	public UserBean findById(int id) throws Exception {

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
			bean.setGender(rs.getString(4));
			bean.setDob(rs.getDate(5));
			bean.setAddress(rs.getString(6));
			bean.setMobileNo(rs.getString(7));
			bean.setEmailId(rs.getString(8));
			bean.setUserName(rs.getString(9));
			bean.setPassword(rs.getString(10));
		}
		return bean;
	}

	public UserBean findByEmailUserName(String emailId, String userName) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from user where emailId = ? and userName = ? ");

		pstmt.setString(1, emailId);
		pstmt.setString(2, userName);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setGender(rs.getString(4));
			bean.setDob(rs.getDate(5));
			bean.setAddress(rs.getString(6));
			bean.setMobileNo(rs.getString(7));
			bean.setEmailId(rs.getString(8));
			bean.setUserName(rs.getString(9));
			bean.setPassword(rs.getString(10));
		}
		return bean;

	}

}
