package com.rays.marksheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

		// testadd();
		// testupdate();
		// testdelete();
		// testsearch();
		// testfindByRollNo();
		// testfindByFiLaName();
		 testtotalPercentagePassFail();
		// testtop5merit();

	}

	private static void testtop5merit() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		List list = new ArrayList();

		list = model.top5merit(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();

			System.out.print(bean.getRollNo());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getTotal());
			System.out.print("\t" + bean.getPercentage());
			System.out.println("\t" + bean.getPassFail());
			
		}
		
	}

	private static void testtotalPercentagePassFail() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		List list = new ArrayList();

		list = model.totalPercentagePassFail(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();

			System.out.print(bean.getRollNo());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getTotal());
			System.out.print("\t" + bean.getPercentage());
			System.out.println("\t" + bean.getPassFail());

		}

	}

	private static void testfindByRollNo() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean = model.findByRollNo(118);

		if (bean != null) {

			System.out.print(bean.getRollNo());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		} else {

			System.out.println("No. Record Found......");
		}

	}

	private static void testfindByFiLaName() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean = model.findByFiLaName("Grace", "Hernandez");

		if (bean != null) {

			System.out.print(bean.getRollNo());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		} else {

			System.out.println("No. Record Found......");
		}

	}

	private static void testsearch() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		List list = new ArrayList();

		list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();

			System.out.print(bean.getRollNo());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		}

	}

	private static void testdelete() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean.setRollNo(126);
		model.delete(bean);

	}

	private static void testupdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean.setFirstName("Chetan");
		bean.setLastName("Patidar");
		bean.setPhysics(95);
		bean.setChemistry(96);
		bean.setMaths(97);
		bean.setRollNo(126);

		model.update(bean);
	}

	private static void testadd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean.setRollNo(126);
		bean.setFirstName("Chetu");
		bean.setLastName("Baba");
		bean.setPhysics(23);
		bean.setChemistry(96);
		bean.setMaths(97);

		model.add(bean);

	}

}
