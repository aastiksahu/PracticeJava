package com.rays.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception {

		// testaddUser();
		// testupdate();
		// testdelete();
		// testsearch();
		 testauthenticate();
		// testfindById();
		// testfindByEmailUserName();

	}

	private static void testfindByEmailUserName() throws Exception {

		Userbean bean = new Userbean();
		UserModel model = new UserModel();

		bean = model.findByEmailUserName("chetanpatidar@gmail.com", "chetanpatidar");

		if (bean != null) {

			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmailId());
			System.out.print("\t" + bean.getUserName());
			System.out.println("\t" + bean.getPassword());

		} else {
			System.out.println("Invalid Id Email Id and User Name.......");
		}

	}

	private static void testfindById() throws Exception {

		Userbean bean = new Userbean();
		UserModel model = new UserModel();

		bean = model.findById(2);

		if (bean != null) {

			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmailId());
			System.out.print("\t" + bean.getUserName());
			System.out.println("\t" + bean.getPassword());

		} else {
			System.out.println("Invalid Id....");
		}
	}

	private static void testauthenticate() throws Exception {

		Userbean bean = new Userbean();
		UserModel model = new UserModel();

		List list = new ArrayList();

		// bean.setEmailId("chetanpatidar@gmail.com");
		bean.setUserName("chetanpatidar");
		bean.setPassword("Chetan@123");

		list = model.authenticate(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (Userbean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmailId());
			System.out.print("\t" + bean.getUserName());
			System.out.println("\t" + bean.getPassword());

		}
	}

	private static void testsearch() throws Exception {

		Userbean bean = new Userbean();
		UserModel model = new UserModel();

		List list = new ArrayList();

		bean.setFirstName("Chetan");
		bean.setLastName("patidar");

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (Userbean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmailId());
			System.out.print("\t" + bean.getUserName());
			System.out.println("\t" + bean.getPassword());

		}

	}

	private static void testdelete() throws Exception {

		Userbean bean = new Userbean();
		UserModel model = new UserModel();

		bean.setId(1);
		model.delete(bean);

	}

	private static void testaddUser() throws Exception {

		Userbean bean = new Userbean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setFirstName("Aastik");
		bean.setLastName("Sahu");
		bean.setGender("Male");
		bean.setDob(sdf.parse("1998-02-03"));
		bean.setAddress("Ujjain");
		bean.setMobileNo("9669866628");
		bean.setEmailId("aastiksahu8@gmail.com");
		bean.setUserName("aastiksahu");
		bean.setPassword("Aastik@123");

		model.addUser(bean);

	}

	private static void testupdate() throws Exception {

		Userbean bean = new Userbean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setFirstName("Akbar");
		bean.setLastName("Mansuri");
		bean.setGender("Male");
		bean.setDob(sdf.parse("2002-4-23"));
		bean.setAddress("Patna");
		bean.setMobileNo("9876543210");
		bean.setEmailId("akbarmansuri@gmail.com");
		bean.setUserName("akbarmansuri");
		bean.setPassword("Akbar@123");
		bean.setId(2);

		model.update(bean);
	}

}
