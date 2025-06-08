package com.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class MarksheetModel {

	public void add(MarksheetBean bean) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");

			pstmt.setInt(1, bean.getRollNo());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setInt(4, bean.getPhysics());
			pstmt.setInt(5, bean.getChemistry());
			pstmt.setInt(6, bean.getMaths());

			int i = pstmt.executeUpdate();
			System.out.println("Data Inserted Successfully : " + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();

		}
	}

	public void update(MarksheetBean bean) throws Exception {

		Connection conn = null;

		try {
			
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update marksheet set firstName = ?, lastName = ?, physics = ?, chemistry = ?, maths = ? where rollNo = ?");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setInt(3, bean.getPhysics());
			pstmt.setInt(4, bean.getChemistry());
			pstmt.setInt(5, bean.getMaths());
			pstmt.setInt(6, bean.getRollNo());

			int i = pstmt.executeUpdate();

			System.out.println("Data Update Successfully....." + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();

		}

	}

	public void delete(MarksheetBean bean) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where rollNo = ?");

			pstmt.setInt(1, bean.getRollNo());

			int i = pstmt.executeUpdate();

			System.out.println("Data Deleted Successfully..." + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();

		}
	}

	public List search(MarksheetBean bean) throws Exception {

		Connection conn = null;

		List list = new ArrayList();

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				bean = new MarksheetBean();

				bean.setRollNo(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setPhysics(rs.getInt(4));
				bean.setChemistry(rs.getInt(5));
				bean.setMaths(rs.getInt(6));

				list.add(bean);

				conn.commit();
			}

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();

		}
		return list;

	}

	public MarksheetBean findByRollNo(int rollNo) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where rollNo = ?");

		pstmt.setInt(1, rollNo);

		ResultSet rs = pstmt.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {

			bean = new MarksheetBean();

			bean.setRollNo(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

		}
		return bean;
	}

	public MarksheetBean findByFiLaName(String firstName, String LastName) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where firstName = ? and LastName = ?");

		pstmt.setString(1, firstName);
		pstmt.setString(2, LastName);

		ResultSet rs = pstmt.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {

			bean = new MarksheetBean();

			bean.setRollNo(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

		}
		return bean;

	}

	public List totalPercentagePassFail(MarksheetBean bean) throws Exception {

		Connection conn = null;

		List list = new ArrayList();

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"select *, (physics + chemistry + maths) as total, ((physics + chemistry + maths)/3) as percentage, if(physics >= 33 and chemistry >= 33 and maths >=33, 'pass', 'fail') as result from marksheet");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				bean = new MarksheetBean();

				bean.setRollNo(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setPhysics(rs.getInt(4));
				bean.setChemistry(rs.getInt(5));
				bean.setMaths(rs.getInt(6));
				bean.setTotal(rs.getInt(7));
				bean.setPercentage(rs.getDouble(8));
				bean.setPassFail(rs.getString(9));

				list.add(bean);

				conn.commit();
			}

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();

		}
		return list;

	}
	
	public List top5merit(MarksheetBean bean) throws Exception {

		Connection conn = null;

		List list = new ArrayList();

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"select *, (physics + chemistry + maths) as total, ((physics + chemistry + maths)/3) as percentage, if(physics >= 33 and chemistry >= 33 and maths >=33, 'pass', 'fail') as result from marksheet order by total desc limit 0,5 ");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				bean = new MarksheetBean();

				bean.setRollNo(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setPhysics(rs.getInt(4));
				bean.setChemistry(rs.getInt(5));
				bean.setMaths(rs.getInt(6));
				bean.setTotal(rs.getInt(7));
				bean.setPercentage(rs.getDouble(8));
				bean.setPassFail(rs.getString(9));

				list.add(bean);

				conn.commit();
			}

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();

		}
		return list;

	}
}
